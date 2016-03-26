<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.group.renshi.constant.SystemConstantType"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/pages/common/include.jsp" %>

<%
	String headPath = SystemConstantType.HEAD_PATH;
%>

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
		
			<input type="hidden" id="accountId" value="${accountInfoBean.accountId}">
			<div class="forget">
				<div class="intro">
					<p class="title">找回密码</p>
				</div>
				
				<div class="clear"></div>
				<div class="hr_dashed"></div>
				
				<div class="status">
					<img alt="" src="${imagePath}/register/forget2.png">
				</div>
				
				<div class="content">
					<p>为了你的账号安全，请完成身份验证</p>
					
					<p>邮箱验证</p>
					<p>邮箱: ${accountInfoBean.loginAccount}</p>
										
					<div class="clear"></div>
					
					<p class="get-sub" id="sendMail"><span>发送邮件</span></p>
				</div>
				
			</div>
			
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