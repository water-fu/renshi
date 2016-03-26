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
			
			<input type="hidden" name="accountId" value="${accountInfoBean.accountId}">
			<div class="userInfo-con">
				<div class="top">
					<img alt="" src="${imagePath}/doctor/status3.png">
				</div>
				
				<div class="hr"></div>
				
				<div class="approve">
					<p class="info">认证申请已提交，请等待审核！</p>
					<p class="content">认仕网将会在24小时内审核您的申请，申请结果将以短信或邮件的方式通知你！</p>
					<p class="content">如有疑问，请联系客服 小青:<em>0571-11111111</em></p>
					<p class="content"><input type="hidden" value="模拟后台审核" id="mock_approve" /></p>
				</div>
			</div>
		</div>
	</div>
	<!---->
	
	<%@ include file="/WEB-INF/pages/common/footer1.jsp" %>
	
</body>
<script type="text/javascript">
/* 	$(document).ready(function() {
		
 		$('#mock_approve').click(function() {
			$.ajaxRequest({
				url: path + '/doctor/approve',
				type: 'post',
			data: {
				id: '${accountInfoBean.accountId}'
 				},
 				success: function(data) {
 					data = data.obj;
					
 					location.href = path + '/blog/' + data.accountId;
 				}
 			});
 		});
		
	}); */
</script>
</html>