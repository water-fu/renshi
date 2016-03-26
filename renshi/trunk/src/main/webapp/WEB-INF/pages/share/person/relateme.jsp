<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/pages/common/include.jsp" %>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>与我相关</title>
	<link rel="stylesheet" href="${cssPath}/person/relateme.css">
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
					<p class="title">我的热门作品</p>
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
						<span style="color: #1fdcaa">提醒我的微博</span>
						<select name="" id="" disabled="disabled" class="hidden">
							<option value="">提醒我的微博</option>
							<option value="">对我的评论</option>
							<option value="">我回复的评论</option>
						</select>
					</div>
					<div class="status-part">
						<a href="#" class="color-green font-14 color-choice hidden">全部</a>
						<a href="#" class="color-green font-14 hidden">我提醒别人</a>
						<a class="color-green font-14 color-choice hidden">别人提醒我</a>
					</div>
				</div>

				<!--- -->
				<div class="message">
				
					<c:forEach items="${pageQueryResult.list}" var="shareInfo">
						<div class="message-list message-self">
							<div class="message-content">
								<div class="message-left">
								<a href="/renshi/blog/${shareInfo.accountId}">
								<img class="headerimg" src="" alt="" link="${shareInfo.headUrl}">
							    </a></div>
								<div class="message-right">
									<h3 class="user-name color-666">
									<a href="/renshi/blog/${shareInfo.accountId}">${shareInfo.realName}
									</a></h3>
									<p class="user-and-other color-999"><span>提醒我看<em class="">${shareInfo.shareTypeName}</em>：</span>
									<span class="other-topic-title color-green">
									<a href="/renshi/blog/content/${shareInfo.shareId}">"${shareInfo.shareTitle}"</a>
									</span></p>
									<p class="user-and-content bg-color-tint color-999 font-14">${shareInfo.shareDesc}</p>
									<p class="user-time-operate color-999"><span class="com-time"> <fmt:formatDate value="${shareInfo.createDate}" pattern="yyyy-MM-dd HH:mm:ss" /> </span><span class="com-operate"><em class=""></em></span></p>						
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
</script>
<script type="text/javascript" src="${jsPath}/share/relateme.js"></script>
<script>
	$(document).ready(function() {
		$('.message-left img').attr('src', path + '/common/showImage?imageUrl=' + $('.message-left img').attr('link'));
	});
	
	function getPageData(num) {
		location.href = path + '/blog/' + accountId + '/relateme?pageNo=' + num;
	}
</script>
</html>