<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/pages/common/include.jsp" %>

<html>
<head>
	<title>邮箱重置</title>
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
						<p class="title">邮箱重置</p>
					</div>
					
					<div class="clear"></div>
					<div class="hr_dashed"></div>
					
					<div class="content">
						<div class="left-con">
							<img alt="thank you" src="${imagePath}/register/thankyou.png">
						</div>
						<div class="right-con">
							<p class="title-con">邮箱重置成功!</p>
						</div>
						
						<div class="clear"></div>
						<div class="hr-con">
							<img alt="" src="${imagePath}/register/hr-jb.png">
						</div>
						
						<div class="bottom-con">
							<p class="get-sub" id="toLogin" style="cursor:pointer;"><a target="_blank"></a><span>点击登录</span></p>
						</div>
					</div>
				</div>
			</form>
			
			<div class="clear"></div>
			<div class="hr"></div>
			
		</div>
	</div>
	
	<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
	
</body>
<script type="text/javascript">
	$('#toLogin').click(function() {
		location.href = path + '/system/loginPage';
	});
</script>
</html>