<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<%@page import="com.group.renshi.bean.doctor.UserInfoBean" %>
<%@page import="com.group.webFramework.entity.UserDetails" %>
<%@page import="com.group.renshi.constant.SystemConstantType" %>
<%@page import="com.group.webFramework.uitl.SessionControl" %>

<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/pages/common/include.jsp" %>
<%
    UserDetails userDetails2=(UserDetails)SessionControl.
                      getAttribute(request, SystemConstantType.USER_DETAILS); 
if(userDetails2!=null){
	if(userDetails2.getUserInfoBean() != null) {
	    request.setAttribute("curBelongDept", userDetails2.getUserInfoBean().getBelongDept());
	}
}
else
	 request.setAttribute("curBelongDept",null);

%>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>视频</title>
	<link rel="stylesheet" href="${cssPath}/common/layout.css">
	<link rel="stylesheet" href="${cssPath}/common/font.css">
	<link rel="stylesheet" href="${cssPath}/common/color.css">
	<link rel="stylesheet" href="${cssPath}/video/video.css">
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
					<p class="color-999"><em class="color-green">发现视频</em><em></em>精选当天最佳医学视频</p>
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
							<span class="title">热荐视频</span><em>由各医学会的权威专家投票推选，保证视频内容高质</em>
						</div>
						<div class="f-right answer-choice">
							<a class="more" href="javascript:void(0);" val="1">更多视频&gt;</a>
						</div>
					</div>
					<div class="list-answer">
					
						<c:forEach items="${pageQueryResult.list}" var="shareInfo">
							<div class="list-answer-content maxwidthsize">
								<div class="logo-img f-left"><a href="<%=path%>/blog/videoDetail?id=${shareInfo.shareId}"><img src="${imagePath}/person/play.jpg" alt=""></a></div>
								<div class="answer-con f-right">
									<h3><a href="<%=path%>/blog/videoDetail?id=${shareInfo.shareId}">[${shareInfo.belongProfess}]${shareInfo.shareTitle}</a></h3>
									<p class="c-name"><span class="f-left">由<a href="<%=path%>/blog/${shareInfo.accountId}"><em>${shareInfo.realName}</em></a>发布</span><span class="a-time f-right"><fmt:formatDate value="${shareInfo.createDate}" pattern="MM-dd HH:mm" /> </span></p>
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
				<form method="post" action="${path}/blog/video" class="searchForm">
					<p class="a-search">
						<input name="searchCon" type="text" value="${searchCon}" placeholder="请输入标题搜索">
						<img class="searchList" src="${imagePath}/answer/search.jpg" alt="" style="cursor: pointer;">
					</p>
				</form>
				<p class="a-publish"><a href="${path}/blog/publishVideo"><i>#</i>发布视频</a> </p>

				<div class="a-expert ">
					<h4>猜你喜欢</h4><!-- <span class="choice" data-tab="tab1">猜你喜欢</span>
					<span data-tab="tab2">观看记录</span> -->
					<div class="expert-list tab1">
					    <div class="expert-list tab1" id="video_like_list">
					      <input type='hidden' id="shareType" value='1'/><!-- 视频-->
					   </div>
						<!-- <div class="expert-list-content">
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
					</div> -->
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
				</div>
				<div class="a-topic ">
					<h4>最活跃的用户</h4>
					<div class="topic-list">
						<div class="expert-list-content">
							<div class="e-img f-left"><img src="#" alt=""></div>
							<div class="e-desc">
								<p class="e-que"><span class="f-left"><em>Maya</em></span><span class="f-right">活跃度:<em>90%</em></span></p>
								<p class="e-name"><a href="#">关注</a><a href="#">个人空间</a></p>
							</div>
						</div>
						<!-- <div class="expert-list-content">
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
						</div> -->
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
		<!-- content end -->
		<div class="point-content">
			<div class="point-list">
				<p><span><em class="f-left">骨科视频</em>各科室经典视频，保证视频内容高质</span><a href="javascript:void(0);" val="2" class="f-right more">更多&gt;</a></p>
				<div class="point-list-content">
					<ul>
						<c:forEach items="${pageQueryResult1.list}" var="shareInfo">
							<li><a href="<%=path%>/blog/videoDetail?id=${shareInfo.shareId}"><img src="${imagePath}/person/play.jpg" alt=""><em class="hidden"></em><span>${shareInfo.shareTitle}</span></a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="point-list">
				<p><span><em class="f-left">外科视频</em>各科室经典视频，保证视频内容高质</span><a href="javascript:void(0);" val="3" class="f-right more">更多&gt;</a></p>
				<div class="point-list-content">
					<ul>
						<c:forEach items="${pageQueryResult2.list}" var="shareInfo">
							<li><a href="<%=path%>/blog/videoDetail?id=${shareInfo.shareId}"><img src="${imagePath}/person/play.jpg" alt=""><em class="hidden"></em><span>${shareInfo.shareTitle}</span></a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="point-list">
				<p><span><em class="f-left">内科视频</em>各科室经典视频，保证视频内容高质</span><a href="javascript:void(0);" val="4" class="f-right more">更多&gt;</a></p>
				<div class="point-list-content">
					<ul>
						<c:forEach items="${pageQueryResult3.list}" var="shareInfo">
							<li><a href="<%=path%>/blog/videoDetail?id=${shareInfo.shareId}"><img src="${imagePath}/person/play.jpg" alt=""><em class="hidden"></em><span>${shareInfo.shareTitle}</span></a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="point-list">
				<p><span><em class="f-left">儿科视频</em>各科室经典视频，保证视频内容高质</span><a href="javascript:void(0);" val="5" class="f-right more">更多&gt;</a></p>
				<div class="point-list-content">
					<ul>
						<c:forEach items="${pageQueryResult4.list}" var="shareInfo">
							<li><a href="<%=path%>/blog/videoDetail?id=${shareInfo.shareId}"><img src="${imagePath}/person/play.jpg" alt=""><em class="hidden"></em><span>${shareInfo.shareTitle}</span></a></li>
						</c:forEach>
					</ul>
				</div>
			</div>

			<div class="point-list">
				<p><span><em class="f-left">神经科视频</em>各科室经典视频，保证视频内容高质</span><a href="javascript:void(0);" val="6" class="f-right more">更多&gt;</a></p>
				<div class="point-list-content">
					<ul>
						<c:forEach items="${pageQueryResult5.list}" var="shareInfo">
							<li><a href="<%=path%>/blog/videoDetail?id=${shareInfo.shareId}"><img src="${imagePath}/person/play.jpg" alt=""><em class="hidden"></em><span>${shareInfo.shareTitle}</span></a></li>
						</c:forEach>
					</ul>
				</div>
			</div> 
			<div class="point-list">
				<p><span><em class="f-left">妇科视频</em>各科室经典视频，保证视频内容高质</span><a href="javascript:void(0);" val="7" class="f-right more">更多&gt;</a></p>
				<div class="point-list-content">
					<ul>
						<c:forEach items="${pageQueryResult6.list}" var="shareInfo">
							<li><a href="<%=path%>/blog/videoDetail?id=${shareInfo.shareId}"><img src="${imagePath}/person/play.jpg" alt=""><em class="hidden"></em><span>${shareInfo.shareTitle}</span></a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>

<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
<script type="text/javascript" src="${jsLib}/jquery.js"></script>
<%-- <script type="text/javascript" src="${jsPath}/video/tab.js"></script> --%>

<script type="text/javascript" src="<%=jsPath%>/focus/myfocus-2.0.1.min.js"></script>
<script type="text/javascript" src="<%=jsPath%>/focus/myfocus-plugin.js"></script>

<script type="text/javascript" src="<%=jsPlugin %>/widget.ajaxRequest.js"></script>
<script type="text/javascript">
	$(document).ready(function() {//
		var belongDept = ' ${curBelongDept}';
		 // //加载  【猜你喜欢】的 视频列表 
		$.ajaxRequest({
			url: path + '/blog/getContentForVideoLike',
			dataType: 'html',
			type:'post',
			data: {
				belongDept : belongDept.trim(),
				shareType:  $('#shareType').val()
			},
			success: function(data) {
				$('#video_like_list').html(data);
			}
		});
		 
		 // 加载  【最活跃用户 】的 列表 
		$.ajaxRequest({
			url: path + '/blog/getMostActPerson',
			dataType: 'html',
			// type:'post',
			data: {
				shareType:  $('#shareType').val()
			},
			success: function(data) {
				$('.topic-list').html(data);
			}
		});
		 
		$('.more').click(function() {
			location.href = path + '/blog/videolist?type=' + $(this).attr('val');
		});
		
		$('.searchList').click(function() {
			$('.searchForm').submit();
		});
	});
</script>
</html>