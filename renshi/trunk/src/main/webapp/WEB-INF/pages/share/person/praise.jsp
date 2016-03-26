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
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>个人空间-赞</title>
	<link rel="stylesheet" href="${cssPath}/person/praise.css">
	
	<style type="text/css">
		#searchTypeSelect {
			background-color: white;
			border: 1px solid #dedede;
			cursor: pointer;
			line-height: 40px;
			text-align: center;
		}
		
		#searchTypeInput {
			font-size: 14px;
			color: #1fdcaa;
			border: 0px solid #cdcdcd;
			cursor: pointer;
		}
	</style>
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
						<span class="color-green">收到的赞</span>
					</div>
					<div class="status-select">
						<span class="color-green" id="searchTypeInput">全部</span>
						<input id="searchType" value="-1" type="hidden" />
						<ul id="searchTypeSelect" style="display: none">
							<li value="-1">全部</li>
							<li value="1">视频</li>
							<li value="2">观点</li>
							<li value="3">病例</li>
							<li value="4">文档</li>
							<li value="5">提问</li>
						</ul>
					</div>
				</div>

				<!--- -->
				<div class="message">
					
					<c:forEach items="${pageQueryResult.list}" var="shareInfo">
					<div class="message-list message-other">
						<div class="message-content">
							<div class="message-left">
								<a  href="${path}/blog/${shareInfo.accountId}">
								<img src="" link="${shareInfo.headUrl}" alt="${shareInfo.realName}">
								</a>
							</div>
							<div class="message-right">
							  <h3 class="user-name">
								<a  href="${path}/blog/${shareInfo.accountId}">${shareInfo.realName}</a>
							 </h3>
								
								<p class="user-and-other color-999"><span>赞我的<em class="">${shareInfo.shareTypeName}</em>：</span>
								<a  href="${path}/blog/content/${shareInfo.shareId}"><span class="other-topic-title color-green">"${shareInfo.shareTitle}"</span></a></p>
								<p class="user-and-content bg-color-tint color-999 font-14">${shareInfo.shareDesc}</p>
								<p class="user-time-operate color-999"><span class="com-time"><fmt:formatDate value="${shareInfo.praiseDate}" pattern="yyyy-MM-dd HH:mm" /></span><span class="com-operate"><em class=""></em></span></p>
							</div>	
						</div>
						
						<p class="operate-self"><a href="javascript:void(0);">回复</a></p>

						<div class="operate-answer hidden">
							<div class="answer-content"><img src="" link="${headUrl}">
								<textarea style="padding-top: 10px;" placeholder="回复@${shareInfo.realName}"></textarea>
							</div>
							<p class="answer-submit"><em>评论</em></p>
							
							<input type="hidden" value="${shareInfo.shareId}" />
							<input type="hidden" value="${shareInfo.realName}" />
							<input type="hidden" value="${shareInfo.accountId}" />
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
	var searchType = '${searchType}';
	function getPageData(num) {
		if($('#searchType').val() != -1) {
			location.href = path + '/blog/' + accountId + '/praise?searchType=' + $('#searchType').val() + '&pageNo=' + num;
		} else {
			location.href = path + '/blog/' + accountId + '/praise?pageNo=' + num;
		}
	}
</script>
<script type="text/javascript" src="${jsPlugin}/widget.select.js"></script>
<script type="text/javascript" src="${jsPath}/share/praise.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		// 搜索类型下拉列表
		$('#searchTypeInput').select({
			targetId: 'searchTypeSelect',
			css: {'min-width': '110px', 'margin-left' : '-20px'},
			choose: function(el) {
				$('#searchTypeInput').text(el.html());
				$('#searchType').val(el.attr('value'));
				
				if(el.attr('value') != -1) {
					// 异步加载分享内容
					location.href = path + '/blog/' + accountId + '/praise?searchType=' + el.attr('value');
				} else {
					location.href = path + '/blog/' + accountId + '/praise';
				}
			}
		});
		
		if(searchType == 1) {
			$('#searchTypeInput').text('视频');
			$('#searchType').val(1);
		}
		else if(searchType == 2) {
			$('#searchTypeInput').text('观点');
			$('#searchType').val(2);
		}
		else if(searchType == 3) {
			$('#searchTypeInput').text('病例');
			$('#searchType').val(3);
		}
		else if(searchType == 4) {
			$('#searchTypeInput').text('文档');
			$('#searchType').val(4);
		}
		else if(searchType == 5) {
			$('#searchTypeInput').text('提问');
			$('#searchType').val(5);
		}
		else {
			$('#searchTypeInput').text('全部');
			$('#searchType').val(-1);
		} 
		
	});
</script>
</html>