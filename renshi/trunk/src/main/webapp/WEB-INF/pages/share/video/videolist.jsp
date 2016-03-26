<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/pages/common/include.jsp" %>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>视频-列表页</title>
	<link rel="stylesheet" href="${cssPath}/common/layout.css">
	<link rel="stylesheet" href="${cssPath}/common/font.css">
	<link rel="stylesheet" href="${cssPath}/common/color.css">
	<link rel="stylesheet" href="${cssPath}/video/videolist.css">
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
				<div class="con-list">
					<div class="con-head">
						<div class="f-left">
							<span class="title">视频列表</span>
							<select name="" id="" class="hidden">
								<option value="">骨科</option>
							</select>
						</div>
						<div class="f-right answer-choice hidden">
							<p class="search"><input type="text"><img src="#" alt=""></p>
						</div>
					</div>
					<div class="list-answer">
					
						<c:forEach items="${pageQueryResult.list}" var="shareInfo">
							<div class="list-answer-content maxwidthsize">
								<div class="logo-img f-left"><a href="<%=path%>/blog/videoDetail?id=${shareInfo.shareId}"><img src="${imagePath}/person/play.jpg" alt=""></a></div>
								<div class="answer-con f-right">
									<h3><a href="<%=path%>/blog/videoDetail?id=${shareInfo.shareId}">[${shareInfo.belongProfess}]${shareInfo.shareTitle}</a></h3>
									<p class="c-name"><span class="f-left">由<a href="${path}/blog/${shareInfo.accountId}"><em>${shareInfo.realName}</em></a>发布</span><span class="a-time f-right"><fmt:formatDate value="${shareInfo.createDate}" pattern="MM-dd HH:mm"/> </span></p>
									<p class="a-answer"><em>${shareInfo.shareDesc}</em></p>
									<p class="a-fun">
										<span class="f-right a-fun-list"> 
											<em><i>赞 </i>${shareInfo.likeNum}</em> 
											<em><i>评论 </i>${shareInfo.commentNum}</em>
											<em><i>收藏 </i>${shareInfo.collectionNum}</em>
										</span>
									</p>
								</div>
							</div>
						</c:forEach>
						
					</div>
				</div>
			</div>
			<div class="con-right f-right">
				

				<div class="a-expert hidden">
					<h4 id="tabEvent"><span class="choice" data-tab="tab1">猜你喜欢</span><span data-tab="tab2">观看记录</span></h4>
					<div class="expert-list tab1">
						<div class="expert-list-content">
							<div class="e-img f-left"><img src="#" alt=""></div>
							<div class="e-desc">
								<p class="e-name">[骨科]开放性骨折的治疗原则与方法</p>
								<p class="e-que"><span class="f-left">浏览:<em>17777</em></span><span class="f-right">由<em>222</em>发布</span></p>
							</div>
						</div>
						<div class="expert-list-content">
							<div class="e-img f-left"><img src="#" alt=""></div>
							<div class="e-desc">
								<p class="e-name">[骨科]开放性骨折的治疗原则与方法</p>
								<p class="e-que"><span class="f-left">浏览:<em>17777</em></span><span class="f-right">由<em>222</em>发布</span></p>
							</div>
						</div>
						<div class="expert-list-content">
							<div class="e-img f-left"><img src="#" alt=""></div>
							<div class="e-desc">
								<p class="e-name">[骨科]开放性骨折的治疗原则与方法</p>
								<p class="e-que"><span class="f-left">浏览:<em>17777</em></span><span class="f-right">由<em>222</em>发布</span></p>
							</div>
						</div>
						<div class="expert-list-content">
							<div class="e-img f-left"><img src="#" alt=""></div>
							<div class="e-desc">
								<p class="e-name">[骨科]开放性骨折的治疗原则与方法</p>
								<p class="e-que"><span class="f-left">浏览:<em>17777</em></span><span class="f-right">由<em>222</em>发布</span></p>
							</div>
						</div>
						<div class="expert-list-content">
							<div class="e-img f-left"><img src="#" alt=""></div>
							<div class="e-desc">
								<p class="e-name">[骨科]开放性骨折的治疗原则与方法</p>
								<p class="e-que"><span class="f-left">浏览:<em>17777</em></span><span class="f-right">由<em>222</em>发布</span></p>
							</div>
						</div>
					</div>
					<div class="expert-list tab2 hidden">
						<div class="expert-list-content">
							<div class="e-img f-left"><img src="#" alt=""></div>
							<div class="e-desc">
								<p class="e-name">[骨科]开放性骨折的治疗原则与方法</p>
								<p class="e-que"><span class="f-left">浏览:<em>17777</em></span><span class="f-right">由<em>111</em>发布</span></p>
							</div>
						</div>
						<div class="expert-list-content">
							<div class="e-img f-left"><img src="#" alt=""></div>
							<div class="e-desc">
								<p class="e-name">[骨科]开放性骨折的治疗原则与方法</p>
								<p class="e-que"><span class="f-left">浏览:<em>17777</em></span><span class="f-right">由<em>111</em>发布</span></p>
							</div>
						</div>
						<div class="expert-list-content">
							<div class="e-img f-left"><img src="#" alt=""></div>
							<div class="e-desc">
								<p class="e-name">[骨科]开放性骨折的治疗原则与方法</p>
								<p class="e-que"><span class="f-left">浏览:<em>17777</em></span><span class="f-right">由<em>111</em>发布</span></p>
							</div>
						</div>
						<div class="expert-list-content">
							<div class="e-img f-left"><img src="#" alt=""></div>
							<div class="e-desc">
								<p class="e-name">[骨科]开放性骨折的治疗原则与方法</p>
								<p class="e-que"><span class="f-left">浏览:<em>17777</em></span><span class="f-right">由<em>333</em>发布</span></p>
							</div>
						</div>
						<div class="expert-list-content">
							<div class="e-img f-left"><img src="#" alt=""></div>
							<div class="e-desc">
								<p class="e-name">[骨科]开放性骨折的治疗原则与方法</p>
								<p class="e-que"><span class="f-left">浏览:<em>17777</em></span><span class="f-right">由<em>555</em>发布</span></p>
							</div>
						</div>
					</div>
				</div>
				<div class="a-topic hidden">
					<h4>最活跃的用户</h4>
					<div class="topic-list">
						<div class="expert-list-content">
							<div class="e-img f-left"><img src="#" alt=""></div>
							<div class="e-desc">
								<p class="e-que"><span class="f-left"><em>Maya</em></span><span class="f-right">活跃度:<em>90%</em></span></p>
								<p class="e-name"><a href="#">关注</a><a href="#">个人空间</a></p>
							</div>
						</div>
						<div class="expert-list-content">
							<div class="e-img f-left"><img src="#" alt=""></div>
							<div class="e-desc">
								<p class="e-que"><span class="f-left"><em>Maya</em></span><span class="f-right">活跃度:<em>90%</em></span></p>
								<p class="e-name"><a href="#">关注</a><a href="#">个人空间</a></p>
							</div>
						</div>
						<div class="expert-list-content">
							<div class="e-img f-left"><img src="#" alt=""></div>
							<div class="e-desc">
								<p class="e-que"><span class="f-left"><em>Maya</em></span><span class="f-right">活跃度:<em>90%</em></span></p>
								<p class="e-name"><a href="#">关注</a><a href="#">个人空间</a></p>
							</div>
						</div>
						<div class="expert-list-content">
							<div class="e-img f-left"><img src="#" alt=""></div>
							<div class="e-desc">
								<p class="e-que"><span class="f-left"><em>Maya</em></span><span class="f-right">活跃度:<em>90%</em></span></p>
								<p class="e-name"><a href="#">关注</a><a href="#">个人空间</a></p>
							</div>
						</div>
						<div class="expert-list-content">
							<div class="e-img f-left"><img src="#" alt=""></div>
							<div class="e-desc">
								<p class="e-que"><span class="f-left"><em>Maya</em></span><span class="f-right">活跃度:<em>90%</em></span></p>
								<p class="e-name"><a href="#">关注</a><a href="#">个人空间</a></p>
							</div>
						</div>
					</div>
				</div>
				<div class="a-meet hidden">
					<img src="#" alt="">
				</div>
				<div class="a-ad">
					ad
				</div>
			</div>
		</div>
		<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
		

<script type="text/javascript" src="${jsLib}/jquery.js"></script>
<script type="text/javascript" src="${jsPath}/video/tab.js"></script>
</body>
</html>