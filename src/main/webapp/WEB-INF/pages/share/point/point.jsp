<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/pages/common/include.jsp" %>
<%@page import="com.group.renshi.bean.doctor.UserInfoBean" %>
<%@page import="com.group.webFramework.entity.UserDetails" %>
<%@page import="com.group.renshi.constant.SystemConstantType" %>
<%@page import="com.group.webFramework.uitl.SessionControl" %>
<%
    UserDetails userDetailsPoint=(UserDetails)SessionControl.
                      getAttribute(request, SystemConstantType.USER_DETAILS); 
if(userDetailsPoint!=null) {
	if(userDetailsPoint.getUserInfoBean() != null) {
	    request.setAttribute("curBelongDept", userDetailsPoint.getUserInfoBean().getBelongDept());
	}
}
else
	 request.setAttribute("curBelongDept",null);

%>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>观点</title>
	<link rel="stylesheet" href="${cssPath}/common/layout.css">
	<link rel="stylesheet" href="${cssPath}/common/font.css">
	<link rel="stylesheet" href="${cssPath}/common/color.css">
	<link rel="stylesheet" href="${cssPath}/point/point.css">
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
					<p class="color-999"><em class="color-green">热议观点</em><em></em>当下最新医学观点互动讨论</p>
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
							<span class="title">观点列表</span>
							<select class="hidden">
								<option>骨科</option>
							</select>
							<div class="f-right answer-choice hidden">
								<a class="more" href="javascript:void(0);" val="1">更多视频&gt;</a>
							</div>
						</div>
						<div class="f-right answer-choice hidden">
							<a class="color-green" href="#">推荐</a>
							<a href="#">最新</a>
							<a href="#">最热</a>
							<a href="#">评论数</a>
						</div>
					</div>
					<div class="list-answer">
					
						<c:forEach items="${pageQueryResult.list}" var="shareInfo">
							<div class="list-answer-content">
								<div class="logo-img f-left">
								<a href="${path}/blog/pointDetail?id=${shareInfo.shareId}">
								<img src="" alt="" val="${shareInfo.shareId}" ></a>
								</div>
								<div class="answer-con f-right">
									<h3><a href="${path}/blog/pointDetail?id=${shareInfo.shareId}">[${shareInfo.belongProfess}]${shareInfo.shareTitle}</a></h3>
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
						
						<%@ include file="/WEB-INF/pages/common/page.jsp" %>
					</div>
				</div>
			</div>
			<div class="con-right f-right">
				<form method="post" action="${path}/blog/point" class="searchForm">
					<p class="a-search">
						<input name="searchCon" type="text" value="${searchCon}" placeholder="请输入标题搜索">
						<img class="searchList" src="${imagePath}/answer/search.jpg" alt="" style="cursor: pointer;">
					</p>
				</form>
				<p class="a-publish"><a href="${path}/blog/publishPoint"><i>#</i>发布观点</a> </p>

				<div class="a-expert ">
					<h4>您可能感兴趣的观点</h4>
					<div class="expert-list">
					<div class="expert-list-content" id="point_like_list">
					    <input type='hidden' id="shareType" value='2'/><!-- 视频-->
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
						</div> -->
					</div>
				</div>
				<div class="a-topic">
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
		<div class="point-content hidden">
			<div class="point-list">
				<div class="point-list-content third-point">
					<p><em class="f-left">骨科观点</em><a href="#" class="f-right">更多&gt;</a></p>
					<div>
						<a href="#"><img src="#"></a>
						<span class="point-desc">[骨科]全国骨科科学高峰论坛在上海举行卡萨丁减肥卡</span>
					</div>
					<ul>
						<li><a href="#">[骨科]发送到款福克斯的房间卡萨丁减卡萨丁减肥卡肥卡萨丁</a></li>
						<li><a href="#">[骨科]发送到款福克斯的房间卡萨丁减肥卡萨丁</a></li>
						<li><a href="#">[骨科]发送到款福克斯的房间卡萨丁减肥卡萨丁</a></li>
					</ul>
				</div>
				<div class="point-list-content">
					<p><em class="f-left">外科观点</em><a href="#" class="f-right">更多&gt;</a></p>
					<div>
						<a href="#"><img src="#"></a>
						<span class="point-desc">[骨科]全国骨科科学高峰论坛在上海举行卡萨丁减肥卡</span>
					</div>
					<ul>
						<li><a href="#">[骨科]发送到款福克斯的房间卡萨丁减卡萨丁减肥卡肥卡萨丁</a></li>
						<li><a href="#">[骨科]发送到款福克斯的房间卡萨丁减肥卡萨丁</a></li>
						<li><a href="#">[骨科]发送到款福克斯的房间卡萨丁减肥卡萨丁</a></li>
					</ul>
				</div>
				<div class="point-list-content">
					<p><em class="f-left">内科观点</em><a href="#" class="f-right">更多&gt;</a></p>
					<div>
						<a href="#"><img src="#"></a>
						<span class="point-desc">[骨科]全国骨科科学高峰论坛在上海举行卡萨丁减肥卡</span>
					</div>
					<ul>
						<li><a href="#">[骨科]发送到款福克斯的房间卡萨丁减卡萨丁减肥卡肥卡萨丁</a></li>
						<li><a href="#">[骨科]发送到款福克斯的房间卡萨丁减肥卡萨丁</a></li>
						<li><a href="#">[骨科]发送到款福克斯的房间卡萨丁减肥卡萨丁</a></li>
					</ul>
				</div>
				<div class="point-list-content third-point">
					<p><em class="f-left">儿科观点</em><a href="#" class="f-right">更多&gt;</a></p>
					<div>
						<a href="#"><img src="#"></a>
						<span class="point-desc">[骨科]全国骨科科学高峰论坛在上海举行卡萨丁减肥卡</span>
					</div>
					<ul>
						<li><a href="#">[骨科]发送到款福克斯的房间卡萨丁减卡萨丁减肥卡肥卡萨丁</a></li>
						<li><a href="#">[骨科]发送到款福克斯的房间卡萨丁减肥卡萨丁</a></li>
						<li><a href="#">[骨科]发送到款福克斯的房间卡萨丁减肥卡萨丁</a></li>
					</ul>
				</div>
				<div class="point-list-content">
					<p><em class="f-left">神经科观点</em><a href="#" class="f-right">更多&gt;</a></p>
					<div>
						<a href="#"><img src="#"></a>
						<span class="point-desc">[骨科]全国骨科科学高峰论坛在上海举行卡萨丁减肥卡</span>
					</div>
					<ul>
						<li><a href="#">[骨科]发送到款福克斯的房间卡萨丁减卡萨丁减肥卡肥卡萨丁</a></li>
						<li><a href="#">[骨科]发送到款福克斯的房间卡萨丁减肥卡萨丁</a></li>
						<li><a href="#">[骨科]发送到款福克斯的房间卡萨丁减肥卡萨丁</a></li>
					</ul>
				</div>
				<div class="point-list-content">
					<p><em class="f-left">妇科观点</em><a href="#" class="f-right">更多&gt;</a></p>
					<div>
						<a href="#"><img src="#"></a>
						<span class="point-desc">[骨科]全国骨科科学高峰论坛在上海举行卡萨丁减肥卡</span>
					</div>
					<ul>
						<li><a href="#">[骨科]发送到款福克斯的房间卡萨丁减卡萨丁减肥卡肥卡萨丁</a></li>
						<li><a href="#">[骨科]发送到款福克斯的房间卡萨丁减肥卡萨丁</a></li>
						<li><a href="#">[骨科]发送到款福克斯的房间卡萨丁减肥卡萨丁</a></li>
					</ul>
				</div>
			</div>	
		</div>
		
		<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
</body>
<script type="text/javascript" src="<%=jsPath%>/focus/myfocus-2.0.1.min.js"></script>
<script type="text/javascript" src="<%=jsPath%>/focus/myfocus-plugin.js"></script>

<script type="text/javascript">
	function getPageData(pageNo) {
		location.href = path + '/blog/point?pageNo=' + pageNo;
	}
	
	$(document).ready(function() {
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
				$('#point_like_list').html(data);
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
		// 加载首页图片
		$('.logo-img img').each(function() {
			var $img = $(this);
			$.ajaxRequest({
				url: path + '/blog/getShareAttach',
				data: {
					shareId: $img.attr('val')
				},
				success: function(data) {
					data = data.obj;
			
					if(data.length > 0) {
						//有图片
						$img.attr('src', path + '/common/showImage?imageUrl=' + data[0].attachUrl);
					}else{
						//无图片
						
						//调整父亲节点的下一个兄弟节点的宽度为98%  即原来的右边的文字
						  $img.parents(".logo-img").next().attr('style',"width:98%;");
						  //隐藏父亲节点  即原来的左边
						  $img.parents(".logo-img").addClass("hidden");
						  //
						}
				}
			});
		});
		
		$('.searchList').click(function() {
			$('.searchForm').submit();
		});
	});
</script>
</html>