package com.csii.util;

//import com.csii.bpf.omini.sfcx.comm.util.AdpUtil;

/**
 * @date：2016年12月8日
 * @time：上午11:33:46
 * @purpose：
 * @address：
 * @auth：Bob.jiang
 */
public class Test {

public static void main(String[] args) {
		String str = "abcdefg";
		String ss = str.substring(1, str.length());
		System.out.println(ss);
		
		try {

			//System.out.println(AdpUtil.DesEncode("201503", "root", 10));
			
		//	System.out.println(AdpUtil.DesDecode("Y1VUIed59zwTKDERspo8kQ=="));
			
			//System.out.println(AdpUtil.dateBeforeDays("20170616", 200));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static void main1(String[] args) {
		
		
		
		System.out.println("20161227".replaceAll("/", ""));
		
		String ip = "172.16.7.125";
		String port = "9234";
		
		Client client = null;
		
		try {
//			String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><AFSREQUESTHEAD><tx_code>AFSM03</tx_code><tx_org>123</tx_org><tx_teller>123</tx_teller><tx_date>213123</tx_date><tx_time>123</tx_time><tx_term/><tx_serial/><u_file/><mac/></AFSREQUESTHEAD><tx_chnl>1</tx_chnl><chnl_txcode>12</chnl_txcode><tx_type>1</tx_type><check_factor>1</check_factor><organizationID>123123</organizationID><AccountNumber>123123132</AccountNumber><AccountName>ASD</AccountName><organizationID2>3123</organizationID2><AccountNumber2>123123132</AccountNumber2><AccountName2>123</AccountName2><IDType>1</IDType><IDNumber>123123123</IDNumber><IDName>13213</IDName><idtype2>123</idtype2><idnumber2>123</idnumber2><idname2>123123</idname2></root>";
//			
//			client = new Client(ip, Integer.parseInt(port));
//			
//			byte[] rcvBuf = client.send(str);
			
		}catch (Throwable e) {
			e.printStackTrace();
		}finally{
			if(client!=null){
				client.close();
			}
		}
		
		/*		

		for(int i = 0 ; i < 600 ; i++){
			
			Runnable t = new Runnable() {				
				@Override
				public void run() {


					String ip = "172.16.7.50";
					String port = "9234";
					
					Client client = null;
					
					try {
						String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><AFSREQUESTHEAD><tx_code>AFSM03</tx_code><tx_org>123</tx_org><tx_teller>123</tx_teller><tx_date>213123</tx_date><tx_time>123</tx_time><tx_term/><tx_serial/><u_file/><mac/></AFSREQUESTHEAD><tx_chnl>1</tx_chnl><chnl_txcode>12</chnl_txcode><tx_type>1</tx_type><check_factor>1</check_factor><organizationID>123123</organizationID><AccountNumber>123123132</AccountNumber><AccountName>ASD</AccountName><organizationID2>3123</organizationID2><AccountNumber2>123123132</AccountNumber2><AccountName2>123</AccountName2><IDType>1</IDType><IDNumber>123123123</IDNumber><IDName>13213</IDName><idtype2>123</idtype2><idnumber2>123</idnumber2><idname2>123123</idname2></root>";
						
						client = new Client(ip, Integer.parseInt(port));
						
						byte[] rcvBuf = client.send(str);
						
					}catch (Throwable e) {
						e.printStackTrace();
					}finally{
						if(client!=null){
							client.close();
						}
					}
					
				}
			};
			
			Thread thread = new Thread(t);
			thread.start();
			
		}*/
		
	}
}
