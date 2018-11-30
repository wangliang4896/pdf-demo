package com.csii.util;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;

public class PdfDemo {

	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("QQRDWMC", "泸州市公安厅");
		List<Map<String, Object>> listAccountInfo = new ArrayList<Map<String, Object>>(); 

		Map<String, Object> map1 = new HashMap<String, Object>();
		listAccountInfo.add(map1);

		map1.put("ZTMC", "ZTMC");
		map1.put("ZZHM", "ZZHM");
		map1.put("ZZDM", "ZZDM");
		map1.put("SUCCESS", true);		
		map1.put("ZH", "ZH");
		
		map.put("listAccountInfo", listAccountInfo);
		map.put("date", "date");
		map.put("WSBH", "WSBH");
		
		String path = PdfHelper.getPsdckPath();
		try {
			
			generatePdf(path, "pdf2.ftl", path + "logo.png", mapgetdata(), "E:\\pdf-tes\\ll.pdf");
//			String[] files = {"C:\\Bob Data\\pdf2.pdf","C:\\Bob Data\\pdf1.pdf"};
//
//			generatePdf(path, "pdf1.ftl", 
//					path + "logo.png", map, "C:\\Bob Data\\pdf2.pdf");
//			mergePdfs(files, "C:\\Bob Data\\pdf3.pdf");
			System.out.println("生成回执成功...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 */
	private static Map<String,Object> mapgetdata() {
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Map<String,Object> map = new HashMap<String, Object>();
		
		List<Map<String,Object>> listMaininfoCard = new ArrayList<Map<String,Object>>();
		map.put("listMaininfoCard", listMaininfoCard);
		Map<String,Object> mapMain = new HashMap<String, Object>();
		//
		mapMain.put("ZTMC", "主体名称");//主体名称
		mapMain.put("CXZH", "账卡");//账卡号	
		mapMain.put("ZZLX", "证件类型");//证件类型  翻译
		mapMain.put("ZZHM", "证照号码");//证照号码
		mapMain.put("CXNR", "查询内容");//查询内容
		mapMain.put("MXSDLX", "明细时段类型");//明细时段类型
		mapMain.put("MXQSSJ", "明细起始时间");//明细起始时间
		mapMain.put("MXJZSJ", "明细截止时间");//明细截止时间
		
		listMaininfoCard.add(mapMain);
		
		
		pacAcctData(map);
		packTransDetail(map);	

		map.put("date", sdf.format(new Date()));
		
		return map;

	}
	
	private static void packTransDetail(Map<String,Object> map){
		
		
		List<Map<String,Object>> listTrandetilsInfo = new ArrayList<Map<String,Object>>();
		map.put("listTrandetilsInfo", listTrandetilsInfo);
		Map<String,Object> mapTrandetilsInfo = null;
		for(int j = 0 ; j < 20 ; j++ ){
			
			
			mapTrandetilsInfo = new HashMap<String, Object>();
			
			mapTrandetilsInfo.put("CXKH", "");//帐卡号
			mapTrandetilsInfo.put("JYLX", "");//交易类型
			mapTrandetilsInfo.put("JDBZ", "");//借贷标志
			mapTrandetilsInfo.put("BZ", "");//币种
			mapTrandetilsInfo.put("JE", "");//交易金额
			mapTrandetilsInfo.put("YE", "");//交易余额
			mapTrandetilsInfo.put("JYSJ", "");//交易时间
			mapTrandetilsInfo.put("JYLSH", "");//交易流水号
			mapTrandetilsInfo.put("JYDFXM", "");//交易对方名称
			mapTrandetilsInfo.put("JYDFZKH", "");//交易对方帐号
			mapTrandetilsInfo.put("JYDFZKH", "");//交易对方卡号
			mapTrandetilsInfo.put("JYDFZJHM", "");//交易对方证件号码
			mapTrandetilsInfo.put("JYDSYE", "");//交易对手余额
			mapTrandetilsInfo.put("JYDFZHKHH", "");//交易对方帐号开户行
			mapTrandetilsInfo.put("JYWDMC", "");//交易网点名称
			mapTrandetilsInfo.put("JYWDDM", "");//交易网点代码
			mapTrandetilsInfo.put("JYSFCG", "");//是否交易成功
			mapTrandetilsInfo.put("JYFSD", "");//交易发生地 
			mapTrandetilsInfo.put("XJBZ", "");//现金标志
			mapTrandetilsInfo.put("JYZY", "");//交易摘要
			mapTrandetilsInfo.put("BEIZ", "");//备注
			
			listTrandetilsInfo.add(mapTrandetilsInfo);
		}	
		
	}

	
	/**
	 * 
	 */
	private static void pacAcctData(Map<String,Object> map) {



		List<Map<String,Object>> listCustomerInfo = new ArrayList<Map<String,Object>>();
		map.put("listCustomerInfo", listCustomerInfo);
		Map<String,Object> mapCustomer = new HashMap<String, Object>();
		mapCustomer.put("KHMC", "客户名称");//客户名称
		mapCustomer.put("ZZLX", "证照类型");//证照类型 翻译
		mapCustomer.put("ZZHM", "证照号码");//证照号码
		mapCustomer.put("LXDH", "联系电话");//联系电话
		mapCustomer.put("LXSJ", "联系手机");//联系手机
		mapCustomer.put("ZZDH", "住宅电话");//住宅电话
		mapCustomer.put("ZZDZ", "住宅地址");//住宅地址
		mapCustomer.put("GZDW", "工作单位");//工作单位
		mapCustomer.put("DWDH", "单位电话");//单位电话
		mapCustomer.put("DWDZ", "单位地址");//单位地址
		mapCustomer.put("YXDZ", "邮箱地址");//邮箱地址
		mapCustomer.put("DBRXM", "代办人姓名");//代办人姓名
		mapCustomer.put("DBRZJLX", "代办人证件类型 翻译");//代办人证件类型 翻译
		mapCustomer.put("DBRZJHM", "代办人证件号码");//代办人证件号码
		mapCustomer.put("FRDB", "法人代表姓名");//法人代表姓名
			
		mapCustomer.put("FRDBZJLX", "法人代表证件类型 翻译");//法人代表证件类型 翻译
		mapCustomer.put("FRDBZJHM", "法人代表证件号码");//法人代表证件号码
		mapCustomer.put("KHGSZZHM", "工商执照号码");//工商执照号码
		mapCustomer.put("GSH", "国税纳税号");//国税纳税号
		mapCustomer.put("DSH", "地税纳税号");//地税纳税号
		listCustomerInfo.add(mapCustomer);
		
		List<Map<String,Object>> listAccountInfo = new ArrayList<Map<String,Object>>();
		map.put("listAccountInfo", listAccountInfo);
		Map<String,Object> mapAccount = null;
		for(int i = 0 ; i < 5; i++ ){//账户信息可能会循环
			mapAccount = new HashMap<String, Object>();
			mapAccount.put("ZH", "账号");//账号
			mapAccount.put("KH", "");//卡号
			mapAccount.put("ZHLB", "");//帐号类别
			mapAccount.put("ZHZT", "");//账号状态
			mapAccount.put("KHWD", "");//开户网点
			mapAccount.put("KHWDDM", "");//开户网点代码
			mapAccount.put("KHRQ", "");//开户日期
			mapAccount.put("CHBZ", "");//钞汇标志
			mapAccount.put("XHRQ", "");//销户日期
			mapAccount.put("XHWD", "");//销户网点
			mapAccount.put("BZ", "");//币种
			mapAccount.put("ZHYE", "");//账户余额
			mapAccount.put("KYYE", "");//可用余额
			mapAccount.put("ZHJYSJ", "");//最后交易时间
			mapAccount.put("BEIZ", "");//备注
			
			listAccountInfo.add(mapAccount);
			
		}
		
		List<Map<String,Object>> listQzcsInfo = new ArrayList<Map<String,Object>>();
		map.put("listQzcsInfo", listQzcsInfo);
		Map<String,Object> mapQzcsInfo = null;
		for(int i = 0 ; i < 5; i++ ){
			mapQzcsInfo = new HashMap<String, Object>();
			
			mapQzcsInfo.put("CSXH", "");//措施序号
			mapQzcsInfo.put("ZH", "");//帐号
			mapQzcsInfo.put("DJJE", "");//冻结金额
			mapQzcsInfo.put("DJJGMC", "");//冻结机关名称
			mapQzcsInfo.put("DJCSLX", "");//冻结措施类型
			mapQzcsInfo.put("DJKSRQ", "");//冻结开始日
			mapQzcsInfo.put("DJJZRQ", "");//冻结截止日
			
			listQzcsInfo.add(mapQzcsInfo);				
				
		}
		
		
		List<Map<String,Object>> listQlxxInfo = new ArrayList<Map<String,Object>>();
		map.put("listQlxxInfo", listQlxxInfo);
		Map<String,Object> mapQlxxInfo = null;
		for(int i = 0 ; i < 5; i++ ){
				mapQlxxInfo = new HashMap<String, Object>();
				
				mapQlxxInfo.put("XH", "");//权利序号
				mapQlxxInfo.put("ZH", "");//帐号
				mapQlxxInfo.put("QLLX", "");//权利类型
				mapQlxxInfo.put("QLRXM", "");//权利人姓名
				mapQlxxInfo.put("QLJE", "");//权利金额
				mapQlxxInfo.put("ZZLX", "");//权利人证件类型
				mapQlxxInfo.put("ZZLXDM", "");//权利人证件号码
				mapQlxxInfo.put("QLRLXFS", "");//权利人联系方式
				mapQlxxInfo.put("QLRDZ", "");//权利人通信地址			
				
				listQlxxInfo.add(mapQlxxInfo);			
		}
		
		List<Map<String,Object>> listGlzhInfo = new ArrayList<Map<String,Object>>();
		map.put("listGlzhInfo", listGlzhInfo);

		Map<String,Object> mapGlzhInfo = null;
		for(int i = 0 ; i < 5; i++ ){
			mapGlzhInfo = new HashMap<String, Object>();
			
			mapGlzhInfo.put("ZZHXH", "");//子账户序号
			mapGlzhInfo.put("ZH", "");//帐号
			mapGlzhInfo.put("ZZHZH",  "");//子账户帐号
			mapGlzhInfo.put("ZZHLB",  "");//子账户类别
			mapGlzhInfo.put("BZ",  "");//币种
			mapGlzhInfo.put("ZHYE",  "");//账户余额
			mapGlzhInfo.put("ZHZT",  "");//账户状态
			mapGlzhInfo.put("CHBZ",  "");//钞汇标志
			mapGlzhInfo.put("KYYE",  "");//可用余额			
			
			listGlzhInfo.add(mapGlzhInfo);
		}	

	}
	
	/**
	 * 生成pdf文件
	 * @param ftlPath
	 * @param ftlName		模版文件
	 * @param imageDiskPath 电子印章
	 * @param data 			反馈数据
	 * @param outputFile	pdf路径
	 * @throws Exception
	 */
	public static void generatePdf(String ftlPath, String ftlName, String imageDiskPath, Object data, String outputFile) throws Exception {
		String html = PdfHelper.getPdfContent(ftlPath, ftlName, data);
		OutputStream out = null;
		ITextRenderer render = null;
		out = new FileOutputStream(outputFile);
		render = PdfHelper.getRender();
		render.setDocumentFromString(html);
		if(imageDiskPath != null && !imageDiskPath.equals("")){
			render.getSharedContext().setBaseURL("file:"+imageDiskPath);		
		}
		render.layout();
		render.createPDF(out);
		render.finishPDF();
		render = null;
		out.close();
	}
	
	/**
	 * 合并pdf
	 * @param files 目标文件
	 * @param newfile 合并后文件
	 */
	public static void mergePdfs(String[] files,String newfile) {
		Document document = null;
		try {
			document = new Document(new PdfReader(files[0]).getPageSize(1));
			PdfCopy copy = new PdfCopy(document, new FileOutputStream(newfile));
			document.open();
			for(int i = 0; i < files.length; i++){
				PdfReader reader = new PdfReader(files[i]);
				int n = reader.getNumberOfPages();
				for(int j = 1; j <= n; j++){
					document.newPage();
					PdfImportedPage page = copy.getImportedPage(reader, j);
					copy.addPage(page);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			document.close();
		}
	}
	
}
