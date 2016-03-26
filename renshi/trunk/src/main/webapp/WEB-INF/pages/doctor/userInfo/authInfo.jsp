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
	<title>医生资格认证</title>
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
				<p class="head"><em>医生资格认证</em></p>
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
							<p class="title"><span></span><em>上传证件照</em></p>
							<p class="desc"><em>通过医生身份的认证，将有助于认仕网更好地识别优秀的业内专家</em></p>
							<p class="tip"><span>*</span><em>号为必填</em></p>
						</div>
						
						<div class="clear"></div>
						<div class="hr_dashed"></div>
						
						<div class="area">
							<p>
								<label><em class="star">*</em>专业证明:</label>
								<select class="mf width254" name="certificateType">
									<option value="1">医师学历证</option>
									<option value="3">医师学位证</option>
									<option value="2">医师资格证</option>
								</select>
							</p>
							<p>
								<label><em class="star">*</em>证书编号:</label>
								<input type="text" name="certificateNo" id="certificateNo" maxlength="30" placeholder="证书编号" class="mf">
								<span class="error certificateNo-error">请输入您的证书编码!</span>
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
								<input type="hidden" name="certificateUrl" id="certificateUrl" />
								
								<span class="error certificateUrl-error mf ps">请上传您的证书!</span>
							</p>
							
							<p>
								<label><em class="star">*</em>身份证:</label>
								<input type="text" name="idCard" id="idCard" placeholder="身份证" maxlength="20" class="mf">
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
	
	<%@ include file="/WEB-INF/pages/common/footer1.jsp" %>
	
</body>
<script type="text/javascript">
	var idCardPath = '<%=idCardPath%>';
	var cretificatePath = '<%=cretificatePath%>';
	var imagePath = '<%=imagePath%>';
</script>
<script type="text/javascript" src="<%=jsPath %>/doctor/authInfo.js"></script>
<script type="text/javascript" src="${jsPlugin}/widget.ajaxFileUpload.js"></script>
</html>