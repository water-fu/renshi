<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/pages/common/include.jsp" %>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<!-- 我也不知道  为什么要调过来   但是结果是我所想要的 -->
	<%-- <c:if test="${accountId == accountIdForFans}">
	<title>我关注的人</title>
	</c:if>
	<c:if test="${accountId != accountIdForFans}">
	<title>他关注的人</title>
	</c:if> --%>
	<title>关注</title>
	
	<link rel="stylesheet" href="${cssPath}/person/interest.css">
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
				   <c:if test="${accountId == accountIdForInterest}">
					<p class="title">我的热门作品</p>
					</c:if>
					<c:if test="${accountId != accountIdForInterest}">
					<p class="title">他的热门作品</p>
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
					<div class="status-select">
					<c:if test="${accountId != accountIdForInterest}">
						<span style="color: #1fdcaa">他的关注</span>
					</c:if>
					<c:if test="${accountId == accountIdForInterest}">
						<span style="color: #1fdcaa">我的关注</span>
					</c:if>
						<!-- <select name="" id="" class="">
							<option value="">全部关注</option>
						</select> -->
					</div>
					<div class="status-part">
						<input type="text" placeholder="搜索" id="concern_value" name="concern_value"><img style="display:inline-block;vertical-align:middle;" src="${imagePath}/answer/search.jpg" alt="搜索" id="concern_search"/>
					</div>
				</div>
				<!--- -->
				
				<div class="message">
					<!-- <div class="filter"> -->
					   <!-- <a href="javascript:void(0);" class="hidden" id="queryByFollowTime"><i>up</i>按关注时间排序</a>
						<a href="javascript:void(0);" class="hidden" id="queryByFansNum"><i>up</i>按粉丝数量排序</a> -->
						<a href="javascript:void(0);" class="hidden" id="queryByFollowTime">按关注时间降序排序</a>
						<a href="javascript:void(0);" class="hidden" id="queryByFansNum">按粉丝数量降序排序</a>
						<form id="queryForm">
							<input type="hidden" name="queryCondition" id="queryCondition" value=""/>
							<input type="hidden" name="accountId" id="accountId" value="${accountIdForInterest}"/>
							<%--  <input type="hidden" name="accountId" id="accountId" value="${accountId}"/> --%> 
							<input type="hidden" name="concernName" id="concernName" value=""/>
						</form>
						<input type="hidden" id="isFanOrInterest" value="interests"/>
					<!-- </div> -->
					<div class="message-list">
					</div>
				</div>
				<!--  -->
			</div>
		</div>
		<!-- content end -->
		<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
</body>
<script type="text/javascript" src="${jsPath}/share/fansAndInterest.js"></script>
<script type="text/javascript">
	var accountId = '${accountIdForInterest}';
</script>
<script type="text/javascript">
	$(document).ready(function() {
		//
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