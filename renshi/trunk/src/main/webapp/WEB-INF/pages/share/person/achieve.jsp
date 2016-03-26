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
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>成就</title>
	<link rel="stylesheet" href="${cssPath}/person/achieve.css">
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
					<p class="title">您可能感兴趣的分享</p>
					<div class="hot-list">
					</div>
				</div>
				<div class="ad">
					
				</div>
			</div>
			
			<div class="con-right">
				<!-- -->
				<div class="con-attend">
					<p class="title">
						<em class="title-left">参加过的会议</em>
					</p>
					<div class="list-attend">

						<c:forEach items="${meetingList}" var="meetingInfo">
							<div class="attend-content">
								<div class="attend-time"><em>[${meetingInfo.meetingDate}]</em></div>
								<div class="attend-left">
									<ul class="attend-intro">
										<li><span class="attend-title">${meetingInfo.meetingName}</span></li>
										<li>出席身份：<span class="attend-part">${meetingInfo.meetingType}</span></li>
										<li>会议地点：<span class="attend-address">${meetingInfo.meetingAddress}</span></li>
									</ul>
								</div>
								<div class="attend-right hidden">
									<a href="#" class="attend-delete">删除</a>
									<a href="#" class="attend-update">修改</a>
								</div>
							</div>
						</c:forEach>
						
					</div>
				</div>
				<!-- -->

				<!---->
				<div class="con-send">
					<p class="title">
						<em class="title-left">发布过的论文</em>
					</p>
					<div class="list-send">
					
						<c:forEach items="${bookList}" var="bookInfo">
							<div class="send-content">
								<div class="send-time"><em>[${bookInfo.publishDate}]</em></div>
								<div class="send-left">
									<h2 class="send-title">《${bookInfo.bookName}》</h2>
									<p class="send-intro">${bookInfo.bookDesc}</p>
								</div>
								<div class="send-right hidden">
									<a class="send-detail">详情</a>
								</div>
							</div>
						</c:forEach>
						
					</div>
				</div>
				<!---->

				<!-- 所获奖项 start -->
				<div class="con-attend">
					<p class="title">
						<em class="title-left">所获奖项</em>
					</p>
					<div class="list-attend">
					
						<c:forEach items="${prizeList}" var="prizeInfo">
							<div class="get-content">
								<div class="attend-time"><em>[${prizeInfo.prizeDate}]</em></div>
								<div class="attend-left">
									<ul class="attend-intro">
										<li><span class="attend-title">${prizeInfo.prizeName}</span></li>
										<li>颁发机构：<span class="attend-part">${prizeInfo.awardDept}</span></li>
									</ul>
								</div>
								<div class="attend-right hidden">
									<a href="#" class="attend-delete">删除</a>
									<a href="#" class="attend-update">修改</a>
								</div>
							</div>
						</c:forEach>
						
					</div>
				</div>
				<!-- 所获奖项 end -->
				
				<!-- 患者评价 start-->
				<div class="con-attend">
					<p class="title">
						<em class="title-left">专利信息</em>
					</p>
					<div class="list-attend">
					
						<c:forEach items="${patentList}" var="patentInfo">
							<div class="judge-content">
								<div class="attend-time"><em>[${patentInfo.patentDate}]</em></div>
								<div class="attend-left">
									<ul class="attend-intro">
										<li><span class="attend-title">${patentInfo.patentName}</span></li>
										<li>专利编号：<span class="attend-part">${patentInfo.patentCode}, ${patentInfo.patentCountry}</span></li>
									</ul>
								</div>
								<div class="attend-right hidden">
									<a href="#" class="attend-delete">删除</a>
								</div>
							</div>
						</c:forEach>
						
					</div>
				</div>
				<!-- 患者评价 end -->

			</div>
			
		</div>
		<!-- content end -->
		
		<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
</body>
<script type="text/javascript">
	var accountId = '${personInfoBean.accountId}';
</script>
<script type="text/javascript" src="${jsPath}/share/achieve.js"></script>
</html>