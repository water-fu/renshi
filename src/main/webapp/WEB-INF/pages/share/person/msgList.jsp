<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@page import="com.group.webFramework.uitl.SessionControl"%>

<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/pages/common/include.jsp" %>

<%
	String headUrl = SessionControl.getOperInfo(request).getHeadUrl();
	request.setAttribute("headUrl", headUrl);
%>

<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>私信列表</title>
	<link rel="stylesheet" href="${cssPath}/person/messageList.css">
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
				<div class="intro-manager">
					<p><img src="${imagePath}/person/mana.png" alt=""><a href="${path}/doctor/toBasicInfo?id=${personInfoBean.accountId}">进入用户管理中心</a></p>
				</div>
				<div class="hot">
					<p class="title">我的热门分享</p>
					<div class="hot-list" id="hot-list">
					</div>
				</div>
				<div class="ad">
					广告推送
				</div>
			</div>
			<div class="con-right">
				
				<div class="status">
					<div class="status-select">
						<span class="color-green">私信列表</span>
						<span id="searchTypeInput" class="hidden">收到的评论</span>
						<input id="searchType" value="1" type="hidden" />
						<ul id="searchTypeSelect" style="display: none">
							<li value="1">收到的评论</li>
							<li value="2">回复的评论</li>
						</ul>
					</div>
					<div class="status-part hidden">
						<a href="#" class="mian-green-bg-color font-14"><i>#</i>我要发布</a>
					</div>
				</div>

				<!--- -->
				<div class="message">
				
				<c:forEach items="${pageQueryResult.list}" var="msgInfo">
					<div class="message-list message-other">
						<div class="message-content">
							<div class="message-left">
					    		<a href="${path}/blog/${msgInfo.createUser}">
									<img src="" link="${msgInfo.headUrl}" alt="">
								</a>
							</div>
							<div class="message-right">
								<h3 class="user-name">
									<a href="${path}/blog/msgDialog?msgId=${msgInfo.msgId}">
										${msgInfo.realName}
									</a>
								</h3>
								
								<p class="user-and-content bg-color-tint color-999 font-14">${msgInfo.msgContent}</p>
								<p class="user-time-operate color-999"><span class="com-time"><fmt:formatDate value="${msgInfo.createDate}" pattern="yyyy-MM-dd HH:mm"/></span><span class="com-operate">
								
								</span></p>
							</div>
						</div>
					</div>
				</c:forEach>
				<%@ include file="/WEB-INF/pages/common/page.jsp" %>
					
				</div>
				<!--  -->
			</div>
			
		</div>
		<!-- content end -->
		<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
</body>
<script type="text/javascript">
	var accountId = '${personInfoBean.accountId}';
	
	function getPageData(num) {
		location.href = path + '/blog/' + accountId + '/msgList?pageNo=' + num;
	}
</script>
<script type="text/javascript" src="${jsPlugin}/widget.select.js"></script>
<script type="text/javascript" src="${jsPath}/share/messageList.js"></script>
</html>