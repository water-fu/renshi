<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<! DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/pages/common/include.jsp" %>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>找医友</title>
	<link rel="stylesheet" href="${cssPath}/doctor/doctor.css">
</head>
<body>
<%@ include file="/WEB-INF/pages/common/header.jsp" %>
		<!-- scroll start -->
		<div class="scroll">
			<div class="scroll-img">
				<img src="${imagePath}/find/banner.jpg" alt="">
			</div>
		</div>
		<!-- scroll end -->

		<!-- content start -->

		<div class="content">
			<div class="title">
				<h1><em>发现医友</em></h1>
				<p><span>师夷长技以制夷</span></p>
			</div>


			<div class="search">
				<form method="post" id="searchForm" action="">
					<p class="address"><input type="text" name="liveTown" placeholder="请输入城市"></p>
					<p class="hospital"> <input type="text" name="belongHospital" placeholder="请输入医院"></p>
					<p class="subject">
						<select name="belongDept" id="deptInfo">
						</select>
					</p>
					<p class="name"><input name="realName" type="text" placeholder="请输入医生姓名" value=""/></p>
					<p class="submit" id="searchButton"><button>确定</button></p>
				</form>
			</div>



			<div class="c-list">
				<div class="left-list">
					<div class="doctor-list">
						<p class="title">医友列表</p>

					</div>
				</div>
				<div class="right-list">
					<div class="know">
						<p class="title">你可能认识的人</p>
						<div class="know-list">
							<ul>
								<c:forEach items="${hashMap.knowBeanList}" var="userInfo">
									<li>
										<div class="know-img"><a href="${path}/blog/${userInfo.accountId}"><img src="" alt="" link="${userInfo.headUrl}"></a></div>
										<div class="know-intro">
											<p class="know-name"><a href="${path}/blog/${userInfo.accountId}"><em class="name">${userInfo.realName}</em></a><span>${userInfo.belongDept}</span></a></p>
											<p class="know-info">
												<a href="javascript:void(0);" class="r-follow" val="${userInfo.accountId}">关注</a><a href="javascript:void(0);" class="r-blog" val="${userInfo.accountId}">个人空间</a>
											</p>
										</div>
									</li>
								</c:forEach>
							</ul>
							<div class="search-more hidden"><a href="#">查看更多&gt;&gt;</a></div>
						</div>
					</div>



					<div class="know">
						<p class="title">对你有帮助的人</p>
						<div class="know-list">
							<ul>
								<c:if test="${!empty hashMap.helpBeanList}">
									<c:forEach items="${hashMap.helpBeanList}" var="userInfo">
										<li><div class="know-img">
										<a href="${path}/blog/${userInfo.accountId}">
										<img src="" alt="" link="${userInfo.headUrl}"></a></div>
											<div class="know-intro">
												<p class="know-name">
												<a href="${path}/blog/${userInfo.accountId}"><em class="name">${userInfo.realName}</em>
												</a><span>${userInfo.belongDept}</span></p>
												<p class="know-info">
													<a href="javascript:void(0);" class="r-follow" val="${userInfo.accountId}">关注</a><a href="javascript:void(0);" class="r-blog" val="${userInfo.accountId}">个人空间</a>
												</p>
											</div>
										</li>
									</c:forEach>
								</c:if>
							</ul>
							<div class="search-more hidden"><a href="#">查看更多&gt;&gt;</a></div>
						</div>
					</div>


					<div class="ad">
						广告推送
					</div>
				</div>
			</div>
		</div>
		
		<!-- content end -->

		<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
</body>
<script type="text/javascript" src="${jsPath}/doctor/findDoctor.js"></script>
</html>