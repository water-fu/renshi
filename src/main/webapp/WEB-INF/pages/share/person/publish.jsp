<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/pages/common/include.jsp" %>

<%
	UserDetails userDetails1 = SessionControl.getCurUserDetail(request);
	if(userDetails1 != null) {
		request.setAttribute("userId", userDetails1.getAccountInfoBean().getAccountId());
	} else {
		request.setAttribute("userId", -1);
	}
%>

<html>
<head>
	<meta charset="GBK">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<c:if test="${userId == personInfoBean.accountId}">
		<title>我的作品</title>
	</c:if>
	<c:if test="${userId != personInfoBean.accountId}">
		<title>他的作品</title>
	</c:if>
	<link rel="stylesheet" href="${cssPath}/person/publish.css">
</head>

<body>
<%@ include file="/WEB-INF/pages/common/header.jsp" %>
		<!-- scroll start -->
		<div class="scroll">
		</div>
		<!-- scroll end -->
		
		<!-- content start -->
		<div class="content">
			<div class="con-left">
			
				<c:if test="${personInfoBean.accountId == userId}">
					<div class="intro-manager">
						<p><img src="${imagePath}/person/mana.png" alt=""><a href="${path}/doctor/toBasicInfo?id=${personInfoBean.accountId}">进入用户管理中心</a></p>
					</div>
				</c:if>
				
				<div class="hot">
				    <c:if test="${userId == personInfoBean.accountId}">
					   <p class="title">我的热门分享</p>
					</c:if>
					<c:if test="${userId != personInfoBean.accountId}">
					   <p class="title">他的热门分享</p>
					</c:if>
					<div class="hot-list" id="hot-list">
					
					</div>
				</div>
				<div class="ad">
					广告推送
				</div>
			</div>
			<div class="con-right">
				
				<div class="status">
				
					<c:if test="${userId == personInfoBean.accountId}">
						<div class="status-select">
							<span id="searchTypeInput">我的作品</span>
						</div>
						<div class="status-part">
							<a href="${path}/blog/publishPoint" class="mian-green-bg-color font-14 "><i>#</i>我要发布</a>
						</div>
					</c:if>
					<c:if test="${userId != personInfoBean.accountId}">
						<div class="status-select">
							<span style="color: #1fdcaa">他的作品</span>
						</div>
					</c:if>
				</div>

				<!--- -->
				<div class="infos" id="infos_Content">
				</div>
				<!--  -->
			</div>
			<input type="hidden" name="searchType" value="3" id="searchType" />
		</div>
		<!-- content end -->
		<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
</body>
<script type="text/javascript">
	var accountId = '${personInfoBean.accountId}';
</script>
<script type="text/javascript" src="${jsPath}/share/publish.js"></script>
</html>