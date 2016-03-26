<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/pages/common/include.jsp" %>

<html>
<head>
	<title>医生资格认证</title>
	<meta http-equiv="Content-Type" content="text/html" charset="GBK" />
	
	<link rel="stylesheet" href="${cssPath}/system/forget.css">
</head>
<body>
	
	<%@ include file="/WEB-INF/pages/common/header.jsp" %>
	<!---->
	<div class="userInfo">
		<div class="userInfo-layout">
		
			<form method="post" id="forgetForm" action="">
				<div class="forget">
					<div class="intro">
						<p class="title">找回密码</p>
					</div>
					
					<div class="clear"></div>
					<div class="hr_dashed"></div>
					
					<div class="status">
						<img alt="" src="${imagePath}/register/forget1.png">
					</div>
					
					<div class="content">
						<p>请填写您需要找回的账号</p>
						<p><input type="text" name="accountName" id="accountName" placeholder="请输入邮箱、手机" /><span class="error accountName-error">请输入邮箱/手机！</span></p>
						
						<div id="validateDiv">
							<p><input class="validate" id="validate" type="text" placeholder="请输入验证码" /></p>
							<p style="margin-left: 0"><img id="validate-img" alt="" src=""></p>
							<p id="validateP"><span class="error validate-error">请输入验证码！</span></p>
						</div>
						
						<div class="clear"></div>
						
						<p class="get-sub" id="forgetPwd"><span>下一步</span></p>
					</div>
					
				</div>
			</form>
			
			<div style="height: 50px;"></div>
			<div class="clear"></div>
			<div class="hr"></div>
				
			<div class="forget">
				<div class="content">
					<p>找回密码常见问题</p>
					<p class="subCont">1.问：手机可正常使用，收不到验证码怎么办？</p>
					<p class="subCont">答：若您的手机可正常使用，无法接受到验证码短信，可能是由于通信网络异常造成的，请您稍后重新尝试操作。</p>
					<p class="subCont">2.问：邮箱可正常使用，收不到验证邮件怎么办？</p>
					<p class="subCont">答：若您的邮箱可正常使用，无法接受到验证码邮件，请仔细查找垃圾邮件。同时由于网络原因，可能会有延迟。如果您10分钟还没有收到邮件，请重新点击发送。</p>
					<p class="subCont">3.问：邮箱不能正常使用，收不到验证邮件怎么办？</p>
					<p class="subCont">答：若您的邮箱无法正常使用，建议您通过手机验证的方式找回密码。</p>
				</div>
			</div>
			
		</div>
	</div>
	
	<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
	
</body>

<script type="text/javascript" src="${jsPath}/system/forget.js"></script>
</html>