<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8"/>
<title></title>
<style type="text/css">
.border {
	border:4px solid #000000;
	padding:30px 20px 90px 20px;
}

.ps {
	text-align:right;
	font-family:Arial Unicode MS;
}

body {
	margin-left: 45px;
	margin-right: 45px;
	margin-top: 45px;
	font-family: Arial Unicode MS;
}

.top {
	text-align: center;
	font-family:'SimSun';
}

.content{
	font-family:'SimSun';
	font-size:14pt;
	word-wrap: break-word; 
	word-break: normal; 
	letter-spacing:5px;
	line-height:30px;
}

.content2{
	text-align:right;
	font-family:'SimSun';
	font-size:14pt;
	word-wrap: break-word; 
	word-break: normal; 
	letter-spacing:5px;
	line-height:30px;
}
img{
width:100px;
height:80px;
}

</style>
</head>
<body>
	<div class="border">
		<div class="top">
			<dl>
			   <dt style="font-size:19pt" align="center">${QQRDWMC}</dt>
			   <dt style="font-size:20pt; font-weight:bold">协助查询财产通知书</dt>
			   <dt style="font-size:14pt">（回执）</dt>
			</dl>
	    </div>
	    <div class="ps">
	    	<p>${WSBH}</p>
	    </div>
	    <div class="content">
	    	<dl>
	    		<dt><u>${QQRDWMC}：		</u></dt>
	    		<#if (listAccountInfo ??) && (listAccountInfo?size>0)>
    				<#list listAccountInfo as li1>
    					<#if (li1['SUCCESS'] )>    					
	    					<#if (li1['ZTMC'] ??)>
	    						<dt>&nbsp;&nbsp;贵阳桂安阳，现将犯罪嫌疑人<u>${li1['ZTMC']}</u>财产的情况提供如下：<u>证件号码：${li1['ZZHM']}，证件类型：${li1['ZZDM']}的开户资料、交易流水明细及其他信息，详见附件。</u></dt>
	    					<#else>
	    						<dt>&nbsp;&nbsp;根据贵局通知，现将犯罪嫌疑人财产的情况提供如下：<u>银行帐卡号：${li1['ZH']}的开户资料、交易流水明细及其他信息，详见附件。</u></dt>
	    					</#if>
	    				<#else>
							<#if li1['ZTMC'] ??>
								<dt>&nbsp;&nbsp;根据贵局通知，现将犯罪嫌疑人<u>${li1['ZTMC']}</u>财产的情况提供如下：证件号码：${li1['ZZHM']}，证件类型：${li1['ZZDM']},查无开户信息。</dt>
							<#else>
								<dt>&nbsp;&nbsp;根据贵局通知，现将犯罪嫌疑人财产的情况提供如下：<u>银行帐卡号：${li1['ZH']}  </u>,查无开户信息。</dt>
							</#if>
			    		</#if>
    				</#list>
	    		</#if>
	    	</dl>
	    </div>
	    <br/><br/><br/><br/><br/>
	    <div class="content2">
	    	
		    <div align="right">
				<img src="${url}"/> 
			</div>
	    	<dl>
	    		<dt>协助查询单位（印）</dt>
	    		<dt>${date}</dt>
	    	</dl>
	    </div>
	</div>
	<div>
		<dl class="content">
			<dt>此联由协助查询单位填写退通知机关附卷</dt>
		</dl>
	</div>
</body>
</html>
