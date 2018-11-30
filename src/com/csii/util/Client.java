package com.csii.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

//import com.csii.af.util.SocketClient;

/**
 * @date：2016年12月8日
 * @time：上午11:47:42
 * @purpose：
 * @address：
 * @auth：Bob.jiang
 */
public class Client {
	
	private static String CHARSET = "UTF-8";
	/**
	 * 报文长度
	 */
	private static int MSG_LEN = 8;
	private static int BUFFER_SIZE = 1024;
	
	
	Socket client = null;
	
	/**
	 * 创建SOCKET
	 * 
	 * @param hostname
	 * @param port
	 * @throws Exception
	 */
	public Client(String hostname,int port) throws Exception{
		client  = new Socket(hostname, port);
		//TODO 设置超时时间
//		client.setSoTimeout(30*1000);
//		client.connect(new InetSocketAddress(hostname, port), timeout)
	}
	
	/**
	 * 发送制卡文件请求
	 * 
	 * 没有报文长度
	 * @param date
	 * @throws Exception
	 */
	public byte[] sendFileNotify(String date) throws Exception{
		String sendStr = "0001999"+date;
		OutputStream out = null;
		InputStream in = null;
		try{
			out = client.getOutputStream();
			in  = client.getInputStream();
			out.write(sendStr.getBytes(CHARSET));
			out.flush();
			
			byte[] respBuf = new byte[4];
			in.read(respBuf);
			return respBuf;
		}catch(Exception e){
			throw e;
		}finally{
			if(null != out)
				out.close();
			if(null != in)
				in.close();
		}
	}
	
	
	/**
	 * 发送请求
	 * 
	 * 发送格式为：
	 * 4个字节的ascii长度 + 实际发送的字节
	 * 
	 * @param sendBuf（实际发送的字节）
	 * @return
	 * @throws Exception
	 */
	public byte[] send(byte[] sendBuf) throws Exception{
		byte[] tempBuf = new byte[BUFFER_SIZE];
		OutputStream out = null;
		InputStream in = null;
		try{
			out = client.getOutputStream();
			in = client.getInputStream();
			//发送总长度，4个自己长度域 　+　实际发送的字节
			ByteBuffer totalBuf = ByteBuffer.allocate(sendBuf.length + MSG_LEN);
			//报文长度
			byte[] lenBuf = String.format("%0"+MSG_LEN+"d", sendBuf.length).getBytes();
			totalBuf.put(lenBuf);
			totalBuf.put(sendBuf);
			out.write(totalBuf.array());
			out.flush();
			
			//获取4位报文长度
			lenBuf = new byte[MSG_LEN];
			if((in.read(lenBuf)) != 8)
					throw new Exception("读取报文长度异常!");
			int len = Integer.parseInt(new String(lenBuf));
			
			
			byte[] respBuf = new byte[len];
			int num = 0,realLen = 0;
			while((num = in.read(tempBuf)) != -1  && (realLen < len)){
				System.arraycopy(tempBuf, 0, respBuf, realLen, num);
				realLen += num;
			};
			System.out.println(new String(respBuf,CHARSET));
			return respBuf;
		}catch(Exception e){
			throw e;
		}finally{
			if(null != out)
				out.close();
			if(null != in)
				in.close();
		}
	}
	
	/**
	 * 发送请求
	 * 
	 * 发送格式为：
	 * 4个字节的ascii长度 + 实际发送的字节
	 * 
	 * @param sendBuf（实际发送请求字符串）
	 * @return
	 * @throws Exception
	 */
	public byte[] send(String msg) throws Exception{
		return send(msg.getBytes(CHARSET));
	}
	
	public static void main(String[] args) throws Exception {
		//SocketClient c = new SocketClient("192.168.20.55",9234);
		//c.send("<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><TAXQUESTHEAD><tx_code>AFSM09</tx_code><tx_org>9999</tx_org><tx_teller>root</tx_teller><tx_date>20160512</tx_date><tx_time>163117</tx_time><tx_term>0000</tx_term><tx_serial>1605120000081001</tx_serial><u_file></u_file><mac></mac></TAXQUESTHEAD><plat_serial>1460510000001401</plat_serial><featurecode>3005</featurecode></root>");
	}
	
	public String getString(ByteBuffer buffer)
    {
        Charset charset = null;
        CharsetDecoder decoder = null;
        CharBuffer charBuffer = null;
        try
        {
            charset = Charset.forName("UTF-8");
            decoder = charset.newDecoder();
            // charBuffer = decoder.decode(buffer);//用这个的话，只能输出来一次结果，第二次显示为空
            charBuffer = decoder.decode(buffer.asReadOnlyBuffer());
            System.out.println(charBuffer.toString());
            return charBuffer.toString();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return "";
        }
    }
	
	public void close() {
		
		try {
			if(client != null){
				client.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
