<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>关于我</title>
	<link rel="stylesheet" href="${cssPath}/person/aboutme.css">
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
			
				<c:if test="${userInfoBean.accountId == userId}">
					<div class="intro-manager">
						<p><img src="${imagePath}/person/mana.png" alt=""><a href="${path}/doctor/toBasicInfo?id=${userInfoBean.accountId}">进入用户管理中心</a></p>
					</div>
				</c:if>
				
				<div class="hot">
				<c:if test="${userInfoBean.accountId == userId}">
					<p class="title">我的热门列表</p>
					</c:if>
					<c:if test="${userInfoBean.accountId != userId}">
					<p class="title">他的热门列表</p>
					</c:if>
					<div class="hot-list" id="hot-list">
					
					</div>
				</div>
				<div class="ad">
					广告推送
				</div>
			</div>
			<div class="con-right">
				<!-- -->
				<div class="con-attend">
					<p class="title">
						<em class="title-left">自我介绍</em>
						<em class="title-right hidden">编辑</em>
					</p>
					<div class="list-attend">

						<div class="attend-content">
							<p><em class="p-left">真实姓名</em>：<span>${userInfoBean.realName}</span></p>
							<p><em class="p-left">性别</em>：<span>
								<c:if test="${userInfoBean.accountSex == 1}">男</c:if>
								<c:if test="${userInfoBean.accountSex == 2}">女</c:if></span></p>
							<p><em class="p-left">年龄</em>：<span>
								<jsp:useBean id="nowDate" class="java.util.Date"/>
								<fmt:parseDate var="birthDate" value="${userInfoBean.birthDate}" pattern="yyyy-MM-dd"/>
								<c:set var="age" value="${nowDate.year - birthDate.year}"/>
								${age}
							</span></p>
							<p><em class="p-left">医院</em>：<span>${userInfoBean.belongHospital}</span></p>
							<p><em class="p-left">专业领域</em>：<span>${userInfoBean.belongDept}</span></p>
							<p><em class="p-left">教学职称</em>：<span>${authenticInfoBean.educationProfess}</span></p>
							<p><em class="p-left">行政职务</em>：<span>${authenticInfoBean.workProfess}</span></p>
							<p><em class="p-left">学术任职</em>：<span>${authenticInfoBean.academicProfess}</span></p>
							<p><em class="p-left">注册日期</em>：<span><fmt:formatDate value="${accountInfoBean.createDate}" pattern="yyyy-MM-dd"/></span></p>
							<p style="height: 70px"><em class="p-left">擅长</em>：<span>${userInfoBean.specilArea}</span></p>
							<p style="height: 70px"><em class="p-left">简介</em>：<span>${userInfoBean.personInfro}</span></p>
						</div>
					</div>
				</div>
				<!-- -->

				<!-- 所获奖项 start -->
				<div class="con-attend">
					<p class="title">
						<em class="title-left">工作经历</em>
					</p>
					<div class="list-attend">
						<c:forEach items="${workInfoBeanList}" var="workInfo">
							<div class="get-content">
								<div class="attend-time"><span>[<em>${workInfo.startDate}</em>至
									<em>${workInfo.endDate}</em>]</span></div>
								<div class="attend-left">
									<ul class="attend-intro">
										<li><span class="attend-title">${workInfo.companyName}</span><span>${workInfo.inCity}</span></li>
										<li><span class="attend-part">${workInfo.belongDept} | ${workInfo.prefessName}</span></li>
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
				
				<!-- 所获奖项 start -->
				<div class="con-attend">
					<p class="title">
						<em class="title-left">教育背景</em>
					</p>
					<div class="list-attend">
						<c:forEach items="${educationInfoBeanList}" var="educationInfo">
							<div class="get-content">
								<div class="attend-time"><span>[<em>${educationInfo.startDate}</em>至
									<em>${educationInfo.endDate}</em>]</span></div>
								<div class="attend-left">
									<ul class="attend-intro">
										<li><span class="attend-title">${educationInfo.schoolName}</span><span>${educationInfo.inCity}</span></li>
										<li><span class="attend-part">${educationInfo.majorName} | ${educationInfo.degreeName}</span></li>
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
			</div>
		</div>
		<!-- content end -->
		
		<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
</body>
<script type="text/javascript">
	var accountId = '${userInfoBean.accountId}';
</script>
<script type="text/javascript">
	$(document).ready(function() {
		// 加载头部信息
		$.ajaxRequest({
			url: path + '/blog/getScroll',
			dataType: 'html',
			data: {
				accountId : accountId
			},
			success: function(data) {
				$('.scroll').html(data);
			}
		});
		
		// 加载左侧个人信息
		$.ajaxRequest({
			url: path + '/blog/getPersonLeftCon',
			dataType: 'html',
			data: {
				accountId : accountId
			},
			success: function(data) {
				$('.con-left').prepend(data);
			}
		});
		
		// 加载热门作品
		$.ajaxRequest({
			url: path + '/blog/getHotList',
			dataType: 'html',
			data: {
				accountId : accountId
			},
			success: function(data) {
				$('#hot-list').html(data);
			}
		});
	});
</script>
</html>