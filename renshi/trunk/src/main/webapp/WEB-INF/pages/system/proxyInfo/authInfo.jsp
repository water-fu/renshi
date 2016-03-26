<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.group.renshi.constant.SystemConstantType"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/pages/common/include.jsp" %>

<%
	String idCardPath = SystemConstantType.ID_CARD;
	String cretificatePath = SystemConstantType.CRETIFICATE_PATH;
%>

<html>
<head>
	<title>代理商认证</title>
	<meta http-equiv="Content-Type" content="text/html" charset="UTF-8" />
	
	<link rel="stylesheet" href="${cssPath}/doctor/user.css">
</head>
<body>
	
	<%@ include file="/WEB-INF/pages/common/header.jsp" %>
	<!---->
	<div class="userInfo">
		<div class="userInfo-layout">
		
			<div class="userInfo-top">
				<p class="image"><img src="${imagePath}/doctor/reglogo.png" alt="" /></p>
				<p class="head"><em>代理商认证</em></p>
			</div>
			
			<form method="post" action="" id="authInfoForm">
				<input type="hidden" name="accountId" value="${accountInfoBean.accountId}">
				<div class="userInfo-con">
					<div class="top">
						<img alt="" src="${imagePath}/doctor/status2.png">
					</div>
					
					<div class="hr"></div>
					
					<div class="photo">
						<div class="intro">
							<p class="title"><span></span><em>代理商信息</em></p>
							<p class="tip"><em class="star">*</em><em>号为必填</em></p>
						</div>
						
						<div class="clear"></div>
						<div class="hr_dashed"></div>
						
						<div class="area">
							<p>
								<label><em class="star">*</em>代理项目:</label>
								<input type="checkbox" value="1" name="proxyTarget" id="check1" class="mf"/><label for="check1" style="width: 35px;">医生</label>
								<input type="checkbox" value="2" name="proxyTarget" id="check2" /><label for="check2" style="width: 35px;">医院</label>
								<input type="checkbox" value="3" name="proxyTarget" id="check3" /><label for="check3" style="width: 35px;">厂商</label>
								<span class="error proxyTarget-error">请选择代理项目！</span>
							</p>
							<p>
								<label><em class="star">*</em>代理商身份:</label>
								<input type="radio" value="1" name="proxyType" id="radio1" class="mf" checked="checked"/><label for="radio1" style="width: 35px;">公司</label>
								<input type="radio" value="2" name="proxyType" id="radio2" /><label for="radio2" style="width: 35px;">个人</label>
							</p>
							
							<div id="companyBaseDiv">
								<p>
									<label><em class="star">*</em>公司名称:</label>
									<input type="text" name="companyName" id="companyName" placeholder="公司名称" class="mf" />
									<span class="error companyName-error">请输入公司名称！</span>
								</p>
								<p>
									<label><em class="star">*</em>公司类型:</label>
									<select class="mf" name="companyType">
										<option value="1">股份制</option>
										<option value="2">私有制</option>
									</select>
								</p>
								<p>
									<label>法人姓名:</label>
									<input type="text" name="legalName" id="legalName" placeholder="法人姓名" class="mf">
								</p>
								<p>
									<label><em class="star">*</em>公司简介:</label>
									<textarea name="companyInfro" id="companyInfro" rows="5" cols="33" class="mf" placeholder="&nbsp;&nbsp;公司简介"></textarea>
									<span class="error companyInfro-error">请输入公司简介！</span>
								</p>
								<p>
									<label><em class="star">*</em>联系人姓名:</label>
									<input type="text" name="realName1" id="realName1" placeholder="联系人姓名" class="mf">
									<span class="error realName1-error">请输入联系人姓名！</span>
								</p>
							</div>
							
							<div id="personBaseDiv" class="hidden">
								<p>
									<label><em class="star">*</em>个人真实姓名:</label>
									<input type="text" name="realName2" id="realName2" placeholder="联系人姓名" class="mf">
									<span class="error realName2-error">请输入个人真实姓名！</span>
								</p>
								<p>
									<label><em class="star">*</em>性别:</label>
									<select class="mf" name="personSex">
										<option value="1">男</option>
										<option value="2">女</option>
									</select>
								</p>
								<p>
									<label>出生年月:</label>
									<select class="mf" id="year">
										<option value="2001">2001年</option>
										<option value="2002">2002年</option>
									</select>
									<select id="month">
										<option value="01">01月</option>
										<option value="02">02月</option>
									</select>
									<select id="day">
										<option value="01">01日</option>
										<option value="02">02日</option>
									</select>
									<input type="hidden" name="personBirth" id="personBirth" />
								</p>
								<p>
									<label>现居城市:</label>
									<select class="mf" id="country">
										<option>中国</option>
									</select>
									<select id="province">
										<option>浙江省</option>
										<option>上海省</option>
									</select>
									<select id="city">
										<option>杭州市</option>
										<option>金华市</option>
									</select>
									<input type="hidden" name="liveTown" id="liveTown" />
								</p>
								<p>
									<label><em class="star">*</em>个人简介:</label>
									<textarea name="personInfro" id="personInfro" rows="5" cols="33" class="mf" placeholder="&nbsp;&nbsp;个人简介"></textarea>
									<span class="error personInfro-error">请输入公司简介！</span>
								</p>
							</div>
							
							<p>
								<label><em class="star">*</em>手机号码:</label>
								<input type="text" name="phoneNo" id="phoneNo" placeholder="手机号码" class="mf">
								<span class="error phoneNo-error">请输入手机号码！</span>
							</p>
							<p>
								<label>固定电话：</label>
								<input type="text" name="telNo" id="telNo" placeholder="固定电话" class="mf">
							</p>
							<p>
								<label>邮箱：</label>
								<input type="text" name="emailNo" id="emailNo" placeholder="邮箱" class="mf">
							</p>
							<p>
								<label>QQ：</label>
								<input type="text" name="qqNo" id="qqNo" placeholder="QQ号码" class="mf">
							</p>
						</div>
					
						<div class="intro">
							<p class="title"><span></span><em>上传证件照</em></p>
							<p class="tip"><span>*</span><em>号为必填</em></p>
						</div>
						
						<div class="clear"></div>
						<div class="hr_dashed"></div>
						
						<div class="area">
							<div id="companyDiv">
								<p>
									<label>营业执照:</label>
									<input type="text" name="licenseNo" id="certificateNo" placeholder="营业执照" class="mf">
									<span class="error certificateNo-error">请输入您的营业执照!</span>
								</p>
								
								<div id="header" style="min-height: 200px !important;">
									<label></label>
									<div id="upload" class="mf">
										<div id="camera" class="certificateCamera">
											<input type="file" id="certificateFile" name="certificate" style="display: none" />
										</div>
										
										<div id="desc">
											<p class="success hide" id="certificateSuc">上传成功</p>
											<p class="viewimg hide" id="certificateImg"><a target="_blank">预览图片&gt;&gt;</a></p>
										</div>
										
									</div>
									
									<div class="clear"></div>
								</div>
								<p class="lh30">
									<input type="hidden" name="licenseUrl" id="certificateUrl" />
									
									<span class="error certificateUrl-error mf ps">请上传营业执照!</span>
								</p>
							</div>
							
							<div id="personDiv" class="hidden">
								<p>
									<label><em class="star">*</em>身份证:</label>
									<input type="text" name="idCard" id="idCard" placeholder="身份证" class="mf">
									<span class="error idCard-error">请输入您的身份证号码!</span>
								</p>
								
								<div id="header" class="idcardHead">
									<label></label>
									<div id="upload" class="mf">
										<div id="camera" class="frontCamera">
											<input type="file" id="frontFile" name="front" style="display: none" />
										</div>
										
										<div id="desc" class="idcardDesc">
											<p class="success hide" id="frontSuc"><img alt="" src="${imagePath}/doctor/success.png"> 上传成功</p>
											<p class="viewimg hide" id="frontImg"><a target="_blank">预览图片&gt;&gt;</a></p>
										</div>
									</div>
									
									<div class="clear"></div>
								</div>
								<p class="lh30">
									<input type="hidden" name="frontUrl" id="frontUrl" />
									
									<span class="error frontUrl-error mf ps">请上传您的身份证正面照!</span>
								</p>
								
								<div id="header" class="idcardHead">
									<label></label>
									<div id="upload" class="mf">
										<div id="camera" class="backCamera">
											<input type="file" id="backFile" name="back" style="display: none" />
										</div>
										
										<div id="desc" class="idcardDesc">
											<p class="success hide" id="backSuc"><img alt="" src="${imagePath}/doctor/success.png"> 上传成功</p>
											<p class="viewimg hide" id="backImg"><a target="_blank">预览图片&gt;&gt;</a></p>
										</div>
									</div>
									
									<div class="clear"></div>
								</div>
								<p class="lh30">
									<input type="hidden" name="backUrl" id="backUrl" />
									
									<span class="error backUrl-error mf ps">请上传您的身份证反面照!</span>
								</p>
							</div>
							
							<div>
								<label></label>
								<div class="agree mf">
									<h1>用户协议:</h1>
									<p>
										1、用户应当同意本协议的条款并按照页面上的提示完成全部的注册程序。用户在进行注册程序过程中点击"同意"按钮即表示用户与百度公司达成协议，完全接受本协议项下的全部条款。
									</p>
									<p>
										2、用户注册成功后，百度将给予每个用户一个用户帐号及相应的密码，该用户帐号和密码由用户负责保管；用户应当对以其用户帐号进行的所有活动和事件负法律责任。
									</p>
									<p>
										3、用户应当同意本协议的条款并按照页面上的提示完成全部的注册程序。用户在进行注册程序过程中点击"同意"按钮即表示用户与百度公司达成协议，完全接受本协议项下的全部条款。
									</p>
									<p>
										4、用户注册成功后，百度将给予每个用户一个用户帐号及相应的密码，该用户帐号和密码由用户负责保管；用户应当对以其用户帐号进行的所有活动和事件负法律责任。
									</p>
									<p>
										5、用户应当同意本协议的条款并按照页面上的提示完成全部的注册程序。用户在进行注册程序过程中点击"同意"按钮即表示用户与百度公司达成协议，完全接受本协议项下的全部条款。
									</p>
									<p>
										6、用户注册成功后，百度将给予每个用户一个用户帐号及相应的密码，该用户帐号和密码由用户负责保管；用户应当对以其用户帐号进行的所有活动和事件负法律责任。
									</p>
								</div>
							</div>
							
							<p>
								<label></label>
								<input type="checkbox" id="agree" class="mf"><label for="agree">我已阅读并接受以上协议</label>
							</p>
						</div>
					</div>
					
					<div class="hr"></div>
					
					<div class="operater">
						<div>
							<p class="get-sub-dis" id="second-btn">确认提交</p>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!---->
	
	<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
	
</body>
<script type="text/javascript">
	var idCardPath = '<%=idCardPath%>';
	var cretificatePath = '<%=cretificatePath%>';
	var imagePath = '<%=imagePath%>';
</script>
<script type="text/javascript" src="<%=jsPath %>/proxy/authInfo.js"></script>
<script type="text/javascript" src="${jsPlugin}/widget.ajaxFileUpload.js"></script>
</html>