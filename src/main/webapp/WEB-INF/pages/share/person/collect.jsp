<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/pages/common/include.jsp" %>

<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>我的收藏</title>
	<link rel="stylesheet" href="${cssPath}/person/collect.css">
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
						<span style="color: #1fdcaa">我的收藏</span>
						<select name="" id="" class="hidden">
							<option value="">全部动态</option>
							<option value="">我关注的动态</option>
							<option value="">我的动态</option>
						</select>
					</div>
					<div class="status-part ">
						<input type="text" placeholder="输入标题，搜索收藏记录" id="collect_value" name="collect_value">
						<img style="display:inline-block;vertical-align:middle;" 
						       src="${imagePath}/answer/search.jpg" 
						       alt="搜索" id="collect_search"/>
					</div>
				</div>
                <form id="queryForm">
					<input type="hidden" name="queryCondition" id="queryCondition" value=""/>
					<input type="hidden" name="accountId" id="accountId" value="${personInfoBean.accountId}"/>
					<input type="hidden" name="collectTitle" id="collectTitle" value=""/>
				</form>
				<!--- -->
				<div class="infos">
				<%-- 遍历循环 --%>
				<%-- <c:forEach items="${pageQueryResult.list}" var="shareInfo">
					<div class="infos-list">
						<div class="send-list">
							<div class="list-logo">
						<a href="${path}/blog/${shareInfo.accountId}"><img class="headerimg" src="" link="${shareInfo.headUrl}" alt="${shareInfo.realName}"></a>
												</div>
							<div class="list-content">
								<h3 class="doc-intro"><a href="${path}/blog/${shareInfo.accountId}"><em class="name">${shareInfo.realName}</em></a><span class="sci">${shareInfo.belongDept}</span><span class="doc">${shareInfo.workProfess}</span></h3>
								<h3 class="title"><a href="${path}/blog/content/${shareInfo.shareId}">"<em>${shareInfo.shareTitle}</em>"</a></h3>
								<p>${shareInfo.shareDesc}</p>
								
								<ul id="attach_${shareInfo.shareId}" val="${shareInfo.shareId}">
								</ul>
								
								<div class="time">
									<span class="time-left"><span class="send-time">${shareInfo.publicDate}</span>发布的<em class="point">${shareInfo.shareTypeName}</em></span>
									<span class="time-right">收藏于<span class="collect-time"><fmt:formatDate value="${shareInfo.collectionDate}" pattern="MM-dd HH:mm" /> </span></span>
								</div>
							</div>
						</div>
						<ul class="fun">
							<li><a href="${path}/blog/content/${shareInfo.shareId}">浏览(<em>${shareInfo.readNum}</em>)</a></li>
							
							isPraise：1为未收藏，0为收藏
							<c:if test="${shareInfo.isPraise == 1}">
								<li><a href="javascript:void(0);" val="${shareInfo.shareId}" type="1" num="${shareInfo.likeNum}" class="praise">赞(<em>${shareInfo.likeNum}</em>)</a></li>
							</c:if>
							<c:if test="${shareInfo.isPraise == 0}">
								<li><a href="javascript:void(0);" val="${shareInfo.shareId}" type="-1" num="${shareInfo.likeNum}" class="praise">赞(<em>${shareInfo.likeNum}</em>)</a></li>
							</c:if>
							
							<li><a href="${path}/blog/content/${shareInfo.shareId}">评论(<em>${shareInfo.commentNum}</em>)</a></li>
							
							type：1为收藏，-1为取消收藏
							<li><a href="javascript:void(0);" val="${shareInfo.shareId}" type="-1" class="collection">取消收藏(<em>${shareInfo.collectionNum}</em>)</a></li>
						</ul>
					</div> 
				</c:forEach>--%>
					
				<%-- <%@ include file="/WEB-INF/pages/common/page.jsp" %> --%>
				</div>
			</div>


			
		</div>
		<!-- content end -->
</body>
<script type="text/javascript">
	 var accountId = '${personInfoBean.accountId}';
	/*function getPageData(num) {
		location.href = path + '/blog/' + accountId + '/collection?pageNo=' + num;
	} */
</script>
<script type="text/javascript" src="${jsPath}/share/collect.js"></script>
</html>