<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html>
<html>
<head>
	<title>register</title>
	
	

	<!--  <link rel="stylesheet" href="../lib/css/reset.css">
	<link rel="stylesheet" href="../css/register/register.css">-->
</head>
<body>
	
	<%@ include file="/WEB-INF/pages/common/header.jsp" %>
	<link rel="stylesheet" href="${cssPath}/register/register.css">
	<!---->
	<div class="register">
		<div class="reg-layout">
			<div class="reg-left">
				<img src="../images/register/title.png" alt="">
			</div>
			<div class="reg-right">
				<div class="reg-con">
					<p class="title"><span></span><em>用户注册</em></p>
					<div class="tiperror hidden"><img src="../images/register/error.png" alt=""><span></span></div>
					<p class="default"><img src="../images/register/user.png" alt=""><input type="text" id="useraccount" placeholder="邮箱/手机号"></p>
					<p class="default"><img src="../images/register/pass.png" alt=""><input type="password" placeholder="请输入您的密码"></p>
					<p class="default"><img src="../images/register/pass.png" alt=""><input type="password" placeholder="请确认您的密码"></p>
					<div class="default row-valiate">
						<p class="default default-valiate"><img src="../images/register/vali.png" alt=""><input type="text" placeholder="请输入验证码"></p><img src="../images/register/valiate.png" id="valiate-img" alt=""><span class="get-valiate"><img src="../images/register/reflush.png" alt=""></span>
					</div>
					<div class="default row-message hidden">
						<p class="default default-message"><img src="../images/register/vali.png" alt=""><input type="text" placeholder="请输入验证码"></p><span class="get-message">获取激活短信</span>
					</div>
					<p class="get-sub"><span>注册</span></p>
					<p class="get-login"><span>已有账号，</span><a href="#">直接登录&gt;&gt;</a></p>
				</div>
			</div>
		</div>
	</div>
	<!---->
	
	<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
	<!-- 
	<script src="../lib/js/jquery.js"></script> -->
	<script src="${jsPath}/register/register.js"></script>
</body>
</html>