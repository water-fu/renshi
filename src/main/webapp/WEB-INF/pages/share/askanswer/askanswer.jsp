<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@page import="com.group.webFramework.uitl.SessionControl"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/pages/common/include.jsp" %>

<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>医问医答</title>
	<link rel="stylesheet" href="${cssPath}/common/layout.css">
	<link rel="stylesheet" href="${cssPath}/common/font.css">
	<link rel="stylesheet" href="${cssPath}/common/color.css">
	<link rel="stylesheet" href="${cssPath}/askanswer/askanswer.css">
</head>
<body>
<%@ include file="/WEB-INF/pages/common/header.jsp" %>
		<!-- scroll start -->
		<div class="top">
			<div class="nav"><img src="${imagePath}/answer/logo.jpg" alt=""> </div>
		</div>
		<!-- scroll end -->
		
		<!-- content start -->
		<div class="content">
			<div class="con-left f-left">
				<div class="scroll">
					<p class="color-999"><em class="color-green">推荐医问</em><em></em>有问题？同行来帮您！</p>
					<div class="adimages" id="boxId" style="visibility:hidden">
						<div class="loading">
							<img src="" />
						</div>
						<div class="pic">
							<ul>
								<li>  
									<a href="" target="_bank"><img src="" alt="&nbsp;"/></a>
								</li>
								<li>  
									<a href="" target="_bank"><img src="" alt="&nbsp;"/></a>
								</li>
								<li>  
									<a href="" target="_bank"><img src="" alt="&nbsp;"/></a>
								</li>
								<li>  
									<a href="" target="_bank"><img src="" alt="&nbsp;"/></a>
								</li>
							</ul>
						</div>
					</div><!-- images结束 -->
				</div>
				<div class="con-list">
					<div class="con-head">
						<div class="f-left">
							<span class="title">医问列表</span>
<!-- 							<select> -->
<!-- 								<option>骨科</option> -->
<!-- 							</select> -->
						</div>
						<div class="f-right answer-choice">
							<a class="color-green" href="javascript:void(0);" val="1" id="newAsk">最新发表</a>
							<a href="javascript:void(0);" id="hotAsk" val="2">最热参与</a>
							<a href="javascript:void(0);" id="noAsk" val="3">未回答</a>
						</div>
					</div>
					<div class="list-answer">
						
					</div>
				</div>
			</div>
			<div class="con-right f-right">
				<form class="searchForm">
					<p class="a-search">
						<input id="searchCon" type="text" value="${searchCon}" placeholder="请输入标题搜索">
						<img class="s" src="${imagePath}/answer/search.jpg" alt="" style="cursor: pointer;">
					</p>
				</form>
				
				<p class="a-publish"><a href="${path}/blog/publishQuestion"><i>#</i>发布提问 </a> </p>
				<div class="a-new-attend hidden">
					<h4>最新参与</h4>
					<div class="new-list">
						<div class="new-list-content">
							<p class="new-com-title">
								<em class="new-name">大卫李</em>刚回答了<em>Maya</em>的问题:
							</p>
							<p class="new-com-content">[<em>骨科</em>]开放性骨折的治疗原则与方法原则与方法？</p>	
						</div>
						<div class="new-list-content">
							<p class="new-com-title">
								<em class="new-name">大卫李</em>刚回答了<em>Maya</em>的问题:
							</p>
							<p class="new-com-content">[<em>骨科</em>]开放性骨折的治疗原则与方法原则与方法？</p>	
						</div>
					</div>
				</div>

				<div class="a-expert">
					<h4>最权威的专家</h4>
					<div class="expert-list">
						<c:forEach items="${mostAnswerUser}" var="personInfo">
							<div class="expert-list-content">
								<div class="e-img f-left" style="cursor: pointer;" val="${personInfo.accountId}"><a href=''><img src="" alt="" link="${personInfo.userInfoBean.headUrl}"></a></div>
								<div class="e-desc">
									<p class="e-name" style="cursor: pointer;" val="${personInfo.accountId}"><em>${personInfo.userInfoBean.realName}</em><span>${personInfo.userInfoBean.belongDept}</span><span>${personInfo.userInfoBean.workProfess}</span></p>
									<p class="e-que"><span><em>${personInfo.qaNum}</em>问题</span><span><em>${personInfo.fansNum}</em>关注</span></p>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="a-topic hidden">
					<h4>最热门的话题</h4>
					<div class="topic-list">
						<div class="topic-list-content">
							<p class="topic-title"><em>互联网医疗</em></p>
							<p class="topic-desc"><span><em>1376</em>个问题</span><span><em>316</em>人关注</span></p>
						</div>
						<div class="topic-list-content">
							<p class="topic-title"><em>互联网医疗</em></p>
							<p class="topic-desc"><span><em>1376</em>个问题</span><span><em>316</em>人关注</span></p>
						</div>
					</div>
					<p class="topic-more">查看更多&gt;</p>
				</div>

				<div class="a-meet hidden">
					<img src="#" alt="">
				</div>
				<div class="a-ad">
					ad
				</div>
			</div>
		</div>
		<!-- content end -->
		<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
</body>
<script type="text/javascript">
</script>
<script type="text/javascript" src="<%=jsPath%>/focus/myfocus-2.0.1.min.js"></script>
<script type="text/javascript" src="<%=jsPath%>/focus/myfocus-plugin.js"></script>
<script type="text/javascript" src="${jsPath}/answer/askanswer.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('.searchList').click(function() {
			// 加载医问医答内容
			$.ajaxRequest({
				url: path + '/blog/newAskAnswer',
				type: 'post',
				dataType: 'html',
				data: {
					type : $('.answer-choice .color-green').attr('val'),
					searchCon: $('#searchCon').val()
				},
				success: function(data) {
					$('.list-answer').html(data);
				}
			});
		});
		
		$('#searchCon').keypress(function(event) {
			if(event.keyCode == 13) {
				// 加载医问医答内容
				$.ajaxRequest({
					url: path + '/blog/newAskAnswer',
					type: 'post',
					dataType: 'html',
					data: {
						type : $('.answer-choice .color-green').attr('val'),
						searchCon: $('#searchCon').val()
					},
					success: function(data) {
						$('.list-answer').html(data);
					}
				});
				return false;
			}
		});
	});
</script>
</html>