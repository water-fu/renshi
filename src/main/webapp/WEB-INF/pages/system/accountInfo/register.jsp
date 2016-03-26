<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/pages/common/include.jsp" %>

<html>
<head>
	<title>用户注册</title>
	
	<link rel="stylesheet" href="${cssPath}/system/register.css">
</head>
<body>
	
	<%@ include file="/WEB-INF/pages/common/header.jsp" %>
	<!---->
	<div class="register">
		<div class="reg-layout">
			<div class="reg-left">
				<img src="${imagePath}/register/title.png" alt="">
			</div>
			<div class="reg-right">
				<div class="reg-con">
					<form action="" method="post" id="registerForm">
						<p class="title"><span></span><em>用户注册</em></p>
						
						<div class="tiperror hidden" id="useraccount-tiperror">
							<img src="${imagePath}/register/error.png" alt="">
							<span></span>
						</div>
						
						<p class="default">
							<img src="${imagePath}/register/user.png" alt="">
							<input type="text" name="loginAccount" id="useraccount" placeholder="邮箱">
						</p>
						
						<div class="tiperror hidden" id="password-tiperror">
							<img src="${imagePath}/register/error.png" alt="">
							<span></span>
						</div>
						
						<p class="default">
							<img src="${imagePath}/register/pass.png" alt="">
							<input type="password" name="loginPassword" id="password" placeholder="请输入您的密码">
						</p>
						
						<div class="tiperror hidden" id="comfirmPwd-tiperror">
							<img src="${imagePath}/register/error.png" alt="">
							<span></span>
						</div>
						
						<p class="default">
							<img src="${imagePath}/register/pass.png" alt="">
							<input type="password" id="comfirmPwd" placeholder="请确认您的密码">
						</p>
						
						<div class="tiperror hidden" id="validate-tiperror">
							<img src="${imagePath}/register/error.png" alt="">
							<span></span>
						</div>
						
						<div class="default row-valiate">
							<p class="default default-valiate">
								<img src="${imagePath}/register/vali.png" alt="">
								<input type="text" id="validate" placeholder="请输入验证码">
							</p>
							
							<img id="valiate-img" alt="">
							<span class="get-valiate">
								<img src="${imagePath}/register/reflush.png" alt="">
							</span>
							
							<span class="get-message hidden">获取激活短信</span>
						</div>
						
						<p class="get-sub" id="register"><span>注册</span></p>
						<p class="get-login"><span>已有账号，</span><a href="javascript:void(0);" id="toLogin">直接登录&gt;&gt;</a></p>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!---->
	
	<%@ include file="/WEB-INF/pages/common/footer1.jsp" %>
	
	<script src="${jsPath}/system/register.js"></script>
</body>
</html>