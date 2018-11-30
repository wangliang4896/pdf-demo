package com.csii.util;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;

public class PsdckPdfUtils {

	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("QQRDWMC", "泸州市公安厅");
		List<Map<String, Object>> listAccountInfo = new ArrayList<Map<String, Object>>(); 

		Map<String, Object> map1 = new HashMap<String, Object>();

//		map1.put("ZTMC", "ZTMC");
		map1.put("ZZHM", "ZZHM");
		map1.put("ZZDM", "ZZDM");
		map1.put("SUCCESS", true);		
		map1.put("ZH", "ZH");
		listAccountInfo.add(map1);
		
		map.put("listAccountInfo", listAccountInfo);
		map.put("date", "date");
		map.put("WSBH", "WSBH");
		
		String path = PdfHelper.getPsdckPath();
		String imgPath = "http://172.22.5.51:80/img/3CF1B6F963FBFAC6D1EB9DC562CDB0EF/0.8/23E132E805DB65FBCDC3BFA1262D1F98.PNG";
		String imgPath1 = "E:/pdf-test/123.png";
		map.put("url", imgPath);
		try {
//			generatePdf(path, "pdf1.ftl", path + "logo.png", map, "E:\\pdf-test\\pdf2.pdf");
//			String[] files = {"E:\\pdf-test\\pdf2.pdf","E:\\pdf-test\\pdf1.pdf"};
//			mergePdfs(files, "E:\\pdf-test\\pdf3.pdf");
//			
			String str = generateHtml(path, "pdf1.ftl", imgPath, map, "E:/pdf-test/wl3.html");
			htmlToPdf(str, imgPath, "E:/pdf-test/wl123.pdf");
			System.out.println("生成回执成功...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
    /**
	 * 生成Html文件
	 * @param ftlPath
	 * @param ftlName		模版文件
	 * @param imageDiskPath 电子印章
	 * @param data 			反馈数据
	 * @param outputFile	pdf路径
	 * @throws Exception
	 */
	public static String generateHtml(String ftlPath,String ftlName,
			String imageDiskPath,Object data,String outputFile) throws Exception {
		String html = PdfHelper.getPdfContent(ftlPath, ftlName, data);
		FileOutputStream fileoutputstream = new FileOutputStream(outputFile);
		System.out.println(outputFile);
		byte htmlBytes[] = html.getBytes();
	    fileoutputstream.write(htmlBytes);
	    fileoutputstream.close();
		return html;
	   
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
	public static void generatePdf(String ftlPath,String ftlName,
			String imageDiskPath,Object data,String outputFile) throws Exception {
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
	 * html转pdf文件
	 * @param ftlPath
	 * @param ftlName		模版文件
	 * @param imageDiskPath 电子印章
	 * @param data 			反馈数据
	 * @param outputFile	pdf路径
	 * @throws Exception
	 */
	public static void htmlToPdf(String html, String imageDiskPath, String outputFile) throws Exception {
//		String html = PdfHelper.getPdfContent(ftlPath, ftlName, data);
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
