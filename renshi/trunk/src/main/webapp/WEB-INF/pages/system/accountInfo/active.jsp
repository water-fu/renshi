<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/pages/common/include.jsp" %>

<html>
<head>
	<title>账号激活</title>
	<meta http-equiv="Content-Type" content="text/html" charset="GBK" />
	
	<link rel="stylesheet" href="${cssPath}/system/active.css">
</head>
<body>
	
	<%@ include file="/WEB-INF/pages/common/header.jsp" %>
	<!---->
	<div class="userInfo">
		<div class="userInfo-layout">
		
			<form method="post" id="forgetForm" action="">
				<div class="forget">
					<div class="intro">
						<p class="title">账号激活</p>
					</div>
					
					<div class="clear"></div>
					<div class="hr_dashed"></div>
					
					<div class="content">
						<div class="left-con">
							<img alt="thank you" src="${imagePath}/register/thankyou.png">
						</div>
						<div class="right-con">
							<p class="title-con">感谢你的注册!</p>
							<p>激活邮件已发送到您的邮箱：<span class="mail">${accountInfoBean.loginAccount}</span></p>
							<p>进入邮箱激活，即可完成注册</p>
						</div>
						
						<div class="clear"></div>
						<div class="hr-con">
							<img alt="" src="${imagePath}/register/hr-jb.png">
						</div>
						
						<div class="bottom-con">
							<p class="get-sub" id="toMail"><a target="_blank"></a><span>立即查收邮件</span></p>
							<p class="title-con" style="color: red">${failMsg}</p>
						</div>
					</div>
				</div>
			</form>
			
			<div class="clear"></div>
			<div class="hr"></div>
				
			<div class="forget">
				<div class="content">
					<p>没有收到验证邮件？</p>
					<p class="subCont">1.尝试到广告邮件和垃圾邮件里找找看，gmail请到左侧导航“其他n个标签”查垃圾邮件</p>
					<p class="subCont">2.再次发送验证邮件<input type="button" id="sendMail" value="重新发送" /></p>
					<p class="subCont">3.如果重发验证邮件任没收到，请重新注册</p>
				</div>
			</div>
			
		</div>
	</div>
	
	<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
	
</body>
<script type="text/javascript">
	$(document).ready(function() {
		// 点击查收邮件
		$('#toMail').click(function() {
			var mail = '${accountInfoBean.loginAccount}';
			var url = mail.split('@')[1];
			url = 'http://mail.' + url;
			
			var a = $(this).children('a')[0];
			var $a = $(a);
			$a.attr('href', url);
			
			a.click();
		});
		
		// 重新发送邮件
		$('#sendMail').click(function() {
			$.ajaxRequest({
				url: path + '/system/sendRegisterMail',
				success: function(data) {
					alert('邮件发送成功');
				}
			});
		});
	});
</script>
</html>