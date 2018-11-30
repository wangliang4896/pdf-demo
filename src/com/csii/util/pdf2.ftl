<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<style type="text/css">

table{
	width:100%;
	border-collapse:collapse;
	border-spacing:0;
	border-left:1px solid #000000;
	border-top:1px solid #000000;
}

td{
	text-align:left;
	heigth:100px;
	font-size:9pt;
	border-right:1px solid #000000;
	border-bottom:1px solid #000000;
	padding:0px;
}

th{
	text-align:center;
	border-right:1px solid #000000;
	border-bottom:1px solid #000000;
	padding:5px 15px;
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


</style>
</head>
<body>
	<div>
		<div align="left">
			<p>附：查询结果信息一览表</p>
		</div>
		<#if (listMaininfoCard ??) && (listMaininfoCard?size>0)>
			<#list listMaininfoCard as li1>
				<div>
					<table>
						<tr>
							<th colspan="4">自贡市商业银行查询结果信息一览表</th>
						</tr>
						<tr>
							<th colspan="4">查询主体信息</th>
						</tr>
						<tr>
							<td>查询主体名称</td>
							<#if li1['ZTMC'] ??>
								<td>${li1['ZTMC']}</td>
							<#else>
								<td></td>
							</#if>
							<td>查询账卡号</td>
							<#if li1['CXZH'] ??>
								<td>${li1['CXZH']}</td>
							<#else>
								<td></td>
							</#if>
						</tr>
						<tr>
							<td>证照类型</td>							
							<td>${li1['ZZLX']}</td>
							<td>证照号码</td>
							<#if li1['ZZHM'] ??>
								<td>${li1['ZZHM']}</td>
							<#else>
								<td></td>
							</#if>
						</tr>
						<tr>
							<td>查询内容</td>
							<#if li1['CXNR'] == "01">
								<td>账户信息</td>
							<#elseif li1['CXNR'] == "02">
								<td>账户交易明细</td>
							<#else>
								<td>账户信息+交易明细</td>
							</#if>
							<td>明细时段类型</td>
							<#if li1['MXSDLX'] ??>
								<#if li1['MXSDLX'] == "01">
									<td>开户至今</td>
								<#elseif li1['MXSDLX'] == "02">
									<td>当年数据</td>
								<#else>
									<td>自定义时段</td>
								</#if>
							<#else>
								<td></td>
							</#if>
						</tr>
						<tr>
							<td>明细起始时间</td>
							<#if li1['MXQSSJ'] ??>
								<td>${li1['MXQSSJ']}</td>
							<#else>
								<td></td>
							</#if>
							<td>明细截止时间号</td>
							<#if li1['MXJZSJ'] ??>
								<td>${li1['MXJZSJ']}</td>
							<#else>
								<td></td>
							</#if>
						</tr>
					</table>
				</div>
				<div>
				<#if (li1['CXNR']=="01") || (li1['CXNR']=="03")>
					<#if (listCustomerInfo ??) && (listCustomerInfo?size>0)>
						<#list listCustomerInfo as li2>
							<table>
								<tr>
									<th colspan="6">客户基本信息</th>
								</tr>
								<tr>
									<td>客户名称</td>
									<#if li2['KHMC'] ??>
										<td>${li2['KHMC']}</td>
									<#else>
										<td></td>
									</#if>
									<td>证照类型</td>														
									<td>${li2['ZZLX']}</td>
									<td>证照号码</td>
									<#if li2['ZZHM'] ??>
										<td>${li2['ZZHM']}</td>
									<#else>
										<td></td>
									</#if>
								</tr>
								<tr>
									<td>联系电话</td>
									<#if li2['LXDH'] ??>
										<td>${li2['LXDH']}</td>
									<#else>
										<td></td>
									</#if>
									<td>联系手机</td>
									<#if li2['LXSJ'] ??>
										<td>${li2['LXSJ']}</td>
									<#else>
										<td></td>
									</#if>
									<td>住宅电话</td>
									<#if li2['ZZDH'] ??>
										<td>${li2['ZZDH']}</td>
									<#else>
										<td></td>
									</#if>
								</tr>
								<tr>
									<td>住宅地址</td>
									<#if li2['ZZDZ'] ??>
										<td colspan="5">${li2['ZZDZ']}</td>
									<#else>
										<td colspan="5"></td>
									</#if>
								</tr>
								<tr>
									<td>工作单位</td>
									<#if li2['GZDW'] ??>
										<td colspan="3">${li2['GZDW']}</td>
									<#else>
										<td colspan="3"></td>
									</#if>
									<td>单位电话</td>
									<#if li2['DWDH'] ??>
										<td>${li2['DWDH']}</td>
									<#else>
										<td></td>
									</#if>
								</tr>
								<tr>
									<td>单位地址</td>
									<#if li2['DWDZ'] ??>
										<td colspan="3">${li2['DWDZ']}</td>
									<#else>
										<td colspan="3"></td>
									</#if>
									<td>邮箱地址</td>
									<td></td>
								</tr>
								<tr>
									<td>代办人姓名</td>
									<#if li2['DBRXM'] ??>
										<td>${li2['DBRXM']}</td>
									<#else>
										<td></td>
									</#if>
									<td>代办人证件类型</td>
									<#if li2['DBRZJLX'] ??>
										<td>${li2['DBRZJLX']}</td>
									<#else>
										<td></td>
									</#if>
									<td>代办人证件号码</td>
									<#if li2['DBRZJHM'] ??>
										<td>${li2['DBRZJHM']}</td>
									<#else>
										<td></td>
									</#if>
								</tr>
								<tr>
									<td>法人代表姓名</td>
									<#if li2['FRDB'] ??>
										<td>${li2['FRDB']}</td>
									<#else>
										<td></td>
									</#if>
									<td>法人代表证件类型</td>
									<#if li2['FRDBZJLX'] ??>
										<td>${li2['FRDBZJLX']}</td>
									<#else>
										<td></td>
									</#if>
									<td>法人代表证件号码</td>
									<td></td>
								</tr>
								<tr>
									<td>工商执照号码</td>
									<#if li2['KHGSZZHM'] ??>
										<td>${li2['KHGSZZHM']}</td>
									<#else>
										<td></td>
									</#if>
									<td>国税纳税号</td>
									<td></td>
									<td>地税纳税号</td>
									<td></td>
								</tr>
							</table>
						</#list>
					</#if>
				</#if>
				</div>
			</#list>
		</#if>
		<div>
			<table>
				<#if (listAccountInfo ??) && (listAccountInfo?size>0)>
					<tr>
						<th colspan="7">账户信息</th>
					</tr>
					<tr>
						<td rowspan="${listAccountInfo?size*7}">账户基本信息</td>
					</tr>
					<#list listAccountInfo as li3>
						<tr>
							<td>账号</td>
							<#if li3['ZH'] ??>
								<td>${li3['ZH']}</td>
							<#else>
								<td></td>
							</#if>
							<td>卡号</td>
							<#if li3['KH'] ??>
								<td>${li3['KH']}</td>
							<#else>
								<td></td>
							</#if>
							<td>帐号类别</td>
							<td>${li3['ZHLB']}</td>
						</tr>
						<tr>
							<td>账号状态</td>
							<td>${li3['ZHZT']}</td>
							<td>开户网点</td>
							<td colspan="3">${li3['KHWD']}</td>
						</tr>
						<tr>
							<td>开户网点代码</td>
							<td>${li3['KHWDDM']}</td>
							<td>开户日期</td>
							<td>${li3['KHRQ']}</td>
							<td>钞汇标志</td>
							<#if li3['CHBZ'] ??>
								<td>${li3['CHBZ']}</td>
							<#else>
								<td></td>
							</#if>
						</tr>
						<tr>
							<td>销户日期</td>
							<#if li3['XHRQ'] ??>
								<td>${li3['XHRQ']}</td>
							<#else>
								<td></td>
							</#if>
							<td>销户网点</td>
							<#if li3['XHWD'] ??>
								<td colspan="3">${li3['XHWD']}</td>
							<#else>
								<td colspan="3"></td>
							</#if>
						</tr>
						<tr>
							<td>币种</td>
							<#if li3['BZ'] ??>
								<td>人民币</td>
							<#else>
								<td></td>
							</#if>
							<td>账户余额</td>
							<#if li3['ZHYE'] ??>
								<td>${li3['ZHYE']}</td>
							<#else>
								<td></td>
							</#if>
							<td>可用余额</td>
							<#if li3['KYYE'] ??>
								<td>${li3['KYYE']}</td>
							<#else>
								<td></td>
							</#if>
						</tr>
						<tr>
							<td>最后交易时间</td>
							<#if li3['ZHJYSJ'] ??>
								<td>${li3['ZHJYSJ']}</td>
							<#else>
								<td></td>
							</#if>
							<td>备注</td>
							<#if li3['BEIZ'] ??>
								<td colspan="3">${li3['BEIZ']}</td>
							<#else>
								<td colspan="3"></td>
							</#if>
						</tr>
						<tr>
							<td colspan="7">&nbsp;</td>
						</tr>
					</#list>
					<#if (listQzcsInfo ??) && (listQzcsInfo?size>0)>
						<tr>
							<td rowspan="${listQzcsInfo?size*4}">强制措施信息</td>
						</tr>
						<#list listQzcsInfo as li4>
							<tr>
								<td>措施序号</td>
								<#if li4['CSXH'] ??>
									<td>${li4['CSXH']}</td>
								<#else>
									<td></td>
								</#if>
								<td>帐号</td>
								<td colspan="3">${li4['ZH']}</td>
							</tr>
							<tr>
								<td>冻结金额</td>
								<td>${li4['DJJE']}</td>
								<td>冻结机关名称</td>
								<#if li4['DJJGMC'] ??>
									<td colspan="3">${li4['DJJGMC']}</td>
								<#else>
									<td colspan="3"></td>
								</#if>
							</tr>
							<tr>
								<td>冻结措施类型</td>
								<#if li4['DJCSLX'] ??>
									<td>${li4['DJCSLX']}</td>
								<#else>
									<td></td>
								</#if>
								<td>冻结开始日</td>
								<td>${li4['DJKSRQ']}</td>
								<td>冻结截止日</td>
								<td>${li4['DJJZRQ']}</td>
							</tr>
							<tr>
								<td colspan="7">&nbsp;</td>
							</tr>
						</#list>
					</#if>
					<#if (listQlxxInfo ??) && (listQlxxInfo?size>0)>
						<tr>
							<td rowspan="${listQlxxInfo?size*5}">共有/优先信息</td>
						</tr>
						<#list listQlxxInfo as li5>
							<tr>
								<td>权利序号</td>
								<td>${li5['XH']}</td>
								<td>帐号</td>
								<td colspan="3">${li5['ZH']}</td>
							</tr>
							<tr>
								<td>权利类型</td>
								<td>${li5['QLLX']}</td>
								<td>权利人姓名</td>
								<td>${li5['QLRXM']}</td>
								<td>权利金额</td>
								<td>${li5['QLJE']}</td>
							</tr>
							<tr>
								<td>权利人证件类型</td>
								<td></td>
								<td>权利人证件号码</td>
								<td>${li5['ZZLXDM']}</td>
								<td>权利人联系方式</td>
								<td>${li5['QLRLXFS']}</td>
							</tr>
							<tr>
								<td>权利人通信地址</td>
								<td colspan="5">${li5['QLRDZ']}</td>
							</tr>
							<tr>
								<td colspan="7">&nbsp;</td>
							</tr>
						</#list>
					</#if>
					<#if (listGlzhInfo ??) && (listGlzhInfo?size>0)>
						<tr>
							<td rowspan="${listGlzhInfo?size*4}">关联子账户信息</td>
						</tr>
						<#list listGlzhInfo as li6>
							<tr>
								<td>子账户序号</td>
								<td>${li6['ZZHXH']}</td>
								<td>帐卡号</td>
								<td>${li6['ZH']}</td>
								<td>子账户帐号</td>
								<td>${li6['ZZHZH']}</td>
							</tr>
							<tr>
								<td>子账户类别</td>
								<td>${li6['ZZHLB']}</td>
								<td>币种</td>
								<td>${li6['BZ']}</td>
								<td>账户余额</td>
								<td>${li6['ZHYE']}</td>
							</tr>
							<tr>
								<td>账户 状态</td>
								<td>${li6['ZHZT']}</td>
								<td>钞汇标志</td>
								<td>${li6['CHBZ']}</td>
								<td>可用余额</td>
								<td>${li6['KYYE']}</td>
							</tr>
							<tr>
								<td colspan="7">&nbsp;</td>
							</tr>
						</#list>
					</#if>
				</#if>
			</table>
			<#if (listTrandetilsInfo ??) && (listTrandetilsInfo?size>0)>
				<table>
					<tr>
						<th colspan="6">交易明细信息</th>
					</tr>
					<#list listTrandetilsInfo as li7>
						<tr>
							<td>帐卡号</td>
							<#if li7['CXKH'] ??>
								<td>${li7['CXKH']}</td>
							<#else>
								<td></td>
							</#if>
							<td>交易类型</td>
							<td></td>
							<td>借贷标志</td>
							<#if li7['JDBZ'] ??>
								<td>${li7['JDBZ']}</td>
							<#else>
								<td></td>
							</#if>
						</tr>
						<tr>
							<td>币种</td>
							<#if li7['BZ'] ??>
								<td>人民币</td>
							<#else>
								<td></td>
							</#if>
							<td>交易金额</td>
							<#if li7['JE'] ??>
								<td>${li7['JE']}</td>
							<#else>
								<td></td>
							</#if>
							<td>交易余额</td>
							<#if li7['YE'] ??>
								<td>${li7['YE']}</td>
							<#else>
								<td></td>
							</#if>
						</tr>
						<tr>
							<td>交易时间</td>
							<#if li7['JYSJ'] ??>
								<td>${li7['JYSJ']}</td>
							<#else>
								<td></td>
							</#if>
							<td>交易流水号</td>
							<#if li7['JYLSH'] ??>
								<td colspan="3">${li7['JYLSH']}</td>
							<#else>
								<td colspan="3"></td>
							</#if>
						</tr>
						<tr>
							<td>交易对方名称</td>
							<#if li7['JYDFXM'] ??>
								<td colspan="3">${li7['JYDFXM']}</td>
							<#else>
								<td colspan="3"></td>
							</#if>
							<td>交易对方帐号</td>
							<#if li7['JYDFZKH'] ??>
								<td>${li7['JYDFZKH']}</td>
							<#else>
								<td></td>
							</#if>
						</tr>
						<tr>
							<td>交易对方卡号</td>
							<#if li7['JYDFZKH'] ??>
								<td>${li7['JYDFZKH']}</td>
							<#else>
								<td></td>
							</#if>
							<td>交易对方证件号码</td>
							<#if li7['JYDFZJHM'] ??>
								<td>${li7['JYDFZJHM']}</td>
							<#else>
								<td></td>
							</#if>
							<td>交易对手余额</td>
							<#if li7['JYDSYE'] ??>
								<td>${li7['JYDSYE']}</td>
							<#else>
								<td></td>
							</#if>
						</tr>
						<tr>
							<td>交易对方帐号开户行</td>
							<#if li7['JYDFZHKHH'] ??>
								<td colspan="5">${li7['JYDFZHKHH']}</td>
							<#else>
								<td colspan="5"></td>
							</#if>
						</tr>
						<tr>
							<td>交易网点名称</td>
							<#if li7['JYWDMC'] ??>
								<td colspan="3">${li7['JYWDMC']}</td>
							<#else>
								<td colspan="3"></td>
							</#if>
							<td>交易网点代码</td>
							<#if li7['JYWDDM'] ??>
								<td>${li7['JYWDDM']}</td>
							<#else>
								<td></td>
							</#if>
						</tr>
						<tr>
							<td>是否交易成功</td>
							<#if li7['JYSFCG'] ??>
								<#if li7['JYSFCG'] == "01">
									<td>成功</td>
								<#else>
									<td>失败</td>
								</#if>
							<#else>
								<td></td>
							</#if>
							<td>交易发生地</td>
							<#if li7['JYFSD'] ??>
								<td colspan="3">${li7['JYFSD']}</td>
							<#else>
								<td colspan="3"></td>
							</#if>
						</tr>
						<tr>
							<td>现金标志</td>
							<#if li7['XJBZ'] ??>
								<#if li7['XJBZ'] == "01">
									<td>现金交易</td>
								<#else>
									<td>其他</td>
								</#if>
							<#else>
								<td></td>
							</#if>
							<td>交易摘要</td>
							<#if li7['JYZY'] ??>
								<td colspan="3">${li7['JYZY']}</td>
							<#else>
								<td colspan="3"></td>
							</#if>
						</tr>
						<tr>
							<td>备注</td>
							<#if li7['BEIZ'] ??>
								<td colspan="5">${li7['BEIZ']}</td>
							<#else>
								<td colspan="5"></td>
							</#if>
						</tr>
						<tr>
							<td colspan="6">&nbsp;</td>
						</tr>
					</#list>
				</table>
			</#if>
		</div>
		<div>
			<div style="width:50%;float:left;">
				<p>制表单位：自贡市商业银行</p>
			</div>
			<div style="width:50%;float:right;">
				<p>制表时间：${date}</p>
			</div>
		</div>
	</div>
	<br/><br/><br/>
	<div align="right">
		<img src="./logo.png"/> 
	</div>
</body>
</html>
