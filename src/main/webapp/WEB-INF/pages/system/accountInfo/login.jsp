<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.group.renshi.constant.SystemConstantType"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/pages/common/include.jsp" %>

<%
	SessionControl.removeAttribute(request, SystemConstantType.USER_DETAILS);
%>

<html>
<head>
	<title>用户登录</title>
	
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
					<form action="" method="post" id="loginForm">
						<p class="title"><span></span><em>用户登录</em></p>
						
						<br />
						
						<div class="tiperror hidden" id="useraccount-tiperror">
							<img src="${imagePath}/register/error.png" alt="">
							<span></span>
						</div>
						
						<p class="default">
							<img src="${imagePath}/register/user.png" alt="">
							<input type="text" name="loginAccount" id="useraccount" placeholder="邮箱">
						</p>
						
						<br/>
						
						<div class="tiperror hidden" id="password-tiperror">
							<img src="${imagePath}/register/error.png" alt="">
							<span></span>
						</div>
						
						<p class="default">
							<img src="${imagePath}/register/pass.png" alt="">
							<input type="password" name="loginPassword" id="password" placeholder="请输入您的密码">
						</p>
						
						<br />
						
						<p class="get-sub" id="login"><span>登录</span></p>
						<p class="get-forget">
							<input type="checkbox" name="checkUser" id="checkUser" /><label for="checkUser">记住用户名</label>
							<span><a href="javascript:void(0)" id="forgetPwd" >忘记密码?</a></span>
						</p>
						<p class="get-register"><span>尚未注册认仕医生账号?</span><a href="javascript:void(0)" id="toRegister">请先注册&gt;&gt;</a></p>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!---->
	
	<%@ include file="/WEB-INF/pages/common/footer1.jsp" %>
	
	<script src="${jsLib}/jquery.cookie.js"></script>
	<script src="${jsPath}/system/login.js"></script>
</body>
</html>