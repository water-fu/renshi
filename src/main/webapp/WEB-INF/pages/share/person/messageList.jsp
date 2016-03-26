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
	<title>评论列表</title>
	<link rel="stylesheet" href="${cssPath}/person/messageList.css">
	<link rel="stylesheet" href="${cssPath}/common/common.css">
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
						<span class="color-green">收到的评论</span>
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
				
				<c:forEach items="${pageQueryResult.list}" var="discussInfo">
					<div class="message-list message-other">
						<div class="message-content">
						    <a href="${path}/blog/${discussInfo.createUser}">
							<div class="message-left">
							<img src="" link="${discussInfo.headUrl}" alt="">
							</div>
							</a>
							<div class="message-right"><a href="${path}/blog/${discussInfo.createUser}">
								<h3 class="user-name">${discussInfo.realName}</h3></a>
								<p class="user-and-other">
								<span><!--<em class="color-green"> @${discussInfo.accountName}</em> -->
								<c:if test="${discussInfo.discussType == 1}">
									评论了你的分享：
								</c:if>
								<c:if test="${discussInfo.discussType == 2}">
									评论了你的评论:
								</c:if>
								<c:if test="${discussInfo.discussType == 3}">
									评论了你的赞:
								</c:if>
								</span>
								
								<a  href="${path}/blog/content/${discussInfo.shareId}">
								<span class="other-topic-title color-green">
								<c:if test="${discussInfo.discussType != 2}">
									"${discussInfo.shareTitle}"
								</c:if>
								<c:if test="${discussInfo.discussType == 2}">
									"${discussInfo.parentContent}"
								</c:if>
								</span>
								</a></p>
								<p class="user-and-content bg-color-tint color-999 font-14">${discussInfo.discussContent}</p>
								<p class="user-time-operate color-999"><span class="com-time"><fmt:formatDate value="${discussInfo.createDate}" pattern="yyyy-MM-dd HH:mm"/></span><span class="com-operate">
								
								<c:if test="${param.searchType == 2}">
									<em class="button-small">删除</em>
								</c:if>
								</span></p>
							</div>
						</div>
						
						<c:if test="${param.searchType == 1}">
							<c:if test="${discussInfo.discussPath != ''}">
							<p class="operate-other">
								<a href="javascript:void(0);">查看对话</a>
							</c:if>
							<c:if test="${discussInfo.discussPath == ''}">
							<p class="operate-self">
							</c:if>
								<a href="javascript:void(0);">回复</a>
							</p>
						</c:if>

						<div class="operate-answer hidden">
							<div class="answer-content"><img class="headerimg" src="" link="${headUrl}">
								<textarea style="padding-top: 10px;" placeholder="回复@${discussInfo.realName}"></textarea>
							</div>
							<p class="answer-submit"><em>评论</em></p>
							
							<input type="hidden" value="${discussInfo.shareId}" />
							<input type="hidden" value="${discussInfo.realName}" />
							<input type="hidden" value="${discussInfo.createUser}" />
							<input type="hidden" value="${discussInfo.discussId}" />
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
		location.href = path + '/blog/' + accountId + '/messageList?searchType=1&pageNo=' + num;
	}
</script>
<script type="text/javascript" src="${jsPlugin}/widget.select.js"></script>
<script type="text/javascript" src="${jsPath}/share/messageList.js"></script>
</html>