<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="com.group.renshi.bean.share.ShareInfoBean" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="com.group.webFramework.entity.UserDetails" %>
<%@page import="com.group.renshi.constant.SystemConstantType" %>
<%@page import="com.group.webFramework.uitl.SessionControl" %>
<%@ include file="/WEB-INF/pages/common/include.jsp" %>
<%
    UserDetails userDetailsLibrary=(UserDetails)SessionControl.
                      getAttribute(request, SystemConstantType.USER_DETAILS); 
if(userDetailsLibrary!=null) {
	if(userDetailsLibrary.getUserInfoBean() != null) {
	    request.setAttribute("curBelongDept", userDetailsLibrary.getUserInfoBean().getBelongDept());
	}
}
else
	 request.setAttribute("curBelongDept",null);

%>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>文库</title>
	<link rel="stylesheet" href="${cssPath}/common/layout.css">
	<link rel="stylesheet" href="${cssPath}/common/font.css">
	<link rel="stylesheet" href="${cssPath}/common/color.css">
	<link rel="stylesheet" href="${cssPath}/library/library.css">
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
					<p class="color-999"><em class="color-green">推荐文库</em><em></em>不断帮您提升自己！</p>
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
							<span class="title">文库列表</span>
							<select name="" id="" class="hidden">
								<option value="骨科">骨科</option>
							</select>
						</div>
						<div class="f-right answer-choice hidden">
							<a class="choice" href="#">推荐</a>
							<a href="#">最新</a>
							<a href="#">下载数</a>
							<a href="#">评论数</a>
						</div>
					</div>
					<div class="list-answer">
						<c:forEach items="${pageQueryResult.list}" var="shareInfo">
							<div class="list-answer-content maxwidthsize">
								<div class="logo-img f-left">
								<ul id="attach_${shareInfo.shareId}" val="${shareInfo.shareId}">
								   <a href="${path}/blog/libraryDetail?id=${shareInfo.shareId}">
								   <img id="logoImgForLibrary${shareInfo.shareId}" src="" alt="" ></a><!-- ${imagePath}/publish/${rex} -->
								</ul>
								</div>
								<div class="answer-con f-right">
									<h3><a href="${path}/blog/libraryDetail?id=${shareInfo.shareId}">[${shareInfo.belongProfess}]${shareInfo.shareTitle}</a></h3>
									<p class="c-name"><span class="f-left">由<a href="${path}/blog/${shareInfo.accountId}"><em>${shareInfo.realName}</em></a>发布</span><span class="a-time f-right"><fmt:formatDate value="${shareInfo.createDate}" pattern="MM-dd HH:mm "/> </span></p>
									<p class="a-answer"><em>${shareInfo.shareDesc}</em></p>
									<p class="a-fun">
										<span class="f-left hidden"><em>26</em>次下载</span>
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
				<form method="post" action="${path}/blog/library" class="searchForm">
					<p class="a-search">
						<input name="searchCon" type="text" value="${searchCon}" placeholder="请输入标题搜索">
						<img class="searchList" src="${imagePath}/answer/search.jpg" alt="" style="cursor: pointer;">
					</p>
				</form>
				<p class="a-publish"><a href="${path}/blog/publishLibrary"><i>#</i>上传文档</a> </p>

				<div class="a-expert ">
					<h4>您可能感兴趣的文库</h4>
					<div class="expert-list tab1">
					   <div class="expert-list-content" id="library_like_list">
					    <input type='hidden' id="shareType" value='4'/><!-- 视频-->
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
						</div> -->
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
				<p><span><em class="f-left">骨科视频</em>各科室经典视频，保证视频内容高质</span><a href="#" class="f-right">更多&gt;</a></p>
				<div class="point-list-content">
					<ul>
						<li><a href="#"><img src="#" alt=""><em>00:07:22</em><span>经过路全脊椎切除术治疗严重脊柱畸形</span></a></li>
						<li><a href="#"><img src="#" alt=""><em>00:07:22</em><span>经过路全脊椎切除术治疗严重脊柱畸形</span></a></li>
						<li><a href="#"><img src="#" alt=""><em>00:07:22</em><span>经过路全脊椎切除术治疗严重脊柱畸形</span></a></li>
						<li><a href="#"><img src="#" alt=""><em>00:07:22</em><span>经过路全脊椎切除术治疗严重脊柱畸形</span></a></li>
						<li><a href="#"><img src="#" alt=""><em>00:07:22</em><span>经过路全脊椎切除术治疗严重脊柱畸形</span></a></li>
					</ul>
				</div>
			</div>
			<div class="point-list">
				<p><span><em class="f-left">外科视频</em>各科室经典视频，保证视频内容高质</span><a href="#" class="f-right">更多&gt;</a></p>
				<div class="point-list-content">
					<ul>
						<li><a href="#"><img src="#" alt=""><em>00:07:22</em><span>经过路全脊椎切除术治疗严重脊柱畸形</span></a></li>
						<li><a href="#"><img src="#" alt=""><em>00:07:22</em><span>经过路全脊椎切除术治疗严重脊柱畸形</span></a></li>
						<li><a href="#"><img src="#" alt=""><em>00:07:22</em><span>经过路全脊椎切除术治疗严重脊柱畸形</span></a></li>
						<li><a href="#"><img src="#" alt=""><em>00:07:22</em><span>经过路全脊椎切除术治疗严重脊柱畸形</span></a></li>
						<li><a href="#"><img src="#" alt=""><em>00:07:22</em><span>经过路全脊椎切除术治疗严重脊柱畸形</span></a></li>
					</ul>
				</div>
			</div>
			<div class="point-list">
				<p><span><em class="f-left">内科视频</em>各科室经典视频，保证视频内容高质</span><a href="#" class="f-right">更多&gt;</a></p>
				<div class="point-list-content">
					<ul>
						<li><a href="#"><img src="#" alt=""><em>00:07:22</em><span>经过路全脊椎切除术治疗严重脊柱畸形</span></a></li>
						<li><a href="#"><img src="#" alt=""><em>00:07:22</em><span>经过路全脊椎切除术治疗严重脊柱畸形</span></a></li>
						<li><a href="#"><img src="#" alt=""><em>00:07:22</em><span>经过路全脊椎切除术治疗严重脊柱畸形</span></a></li>
						<li><a href="#"><img src="#" alt=""><em>00:07:22</em><span>经过路全脊椎切除术治疗严重脊柱畸形</span></a></li>
						<li><a href="#"><img src="#" alt=""><em>00:07:22</em><span>经过路全脊椎切除术治疗严重脊柱畸形</span></a></li>
					</ul>
				</div>
			</div>
			<div class="point-list">
				<p><span><em class="f-left">儿科视频</em>各科室经典视频，保证视频内容高质</span><a href="#" class="f-right">更多&gt;</a></p>
				<div class="point-list-content">
					<ul>
						<li><a href="#"><img src="#" alt=""><em>00:07:22</em><span>经过路全脊椎切除术治疗严重脊柱畸形</span></a></li>
						<li><a href="#"><img src="#" alt=""><em>00:07:22</em><span>经过路全脊椎切除术治疗严重脊柱畸形</span></a></li>
						<li><a href="#"><img src="#" alt=""><em>00:07:22</em><span>经过路全脊椎切除术治疗严重脊柱畸形</span></a></li>
						<li><a href="#"><img src="#" alt=""><em>00:07:22</em><span>经过路全脊椎切除术治疗严重脊柱畸形</span></a></li>
						<li><a href="#"><img src="#" alt=""><em>00:07:22</em><span>经过路全脊椎切除术治疗严重脊柱畸形</span></a></li>
					</ul>
				</div>
			</div>
			<div class="point-list">
				<p><span><em class="f-left">神经科视频</em>各科室经典视频，保证视频内容高质</span><a href="#" class="f-right">更多&gt;</a></p>
				<div class="point-list-content">
					<ul>
						<li><a href="#"><img src="#" alt=""><em>00:07:22</em><span>经过路全脊椎切除术治疗严重脊柱畸形</span></a></li>
						<li><a href="#"><img src="#" alt=""><em>00:07:22</em><span>经过路全脊椎切除术治疗严重脊柱畸形</span></a></li>
						<li><a href="#"><img src="#" alt=""><em>00:07:22</em><span>经过路全脊椎切除术治疗严重脊柱畸形</span></a></li>
						<li><a href="#"><img src="#" alt=""><em>00:07:22</em><span>经过路全脊椎切除术治疗严重脊柱畸形</span></a></li>
						<li><a href="#"><img src="#" alt=""><em>00:07:22</em><span>经过路全脊椎切除术治疗严重脊柱畸形</span></a></li>
					</ul>
				</div>
			</div>
			<div class="point-list">
				<p><span><em class="f-left">妇科视频</em>各科室经典视频，保证视频内容高质</span><a href="#" class="f-right">更多&gt;</a></p>
				<div class="point-list-content">
					<ul>
						<li><a href="#"><img src="#" alt=""><em>00:07:22</em><span>经过路全脊椎切除术治疗严重脊柱畸形</span></a></li>
						<li><a href="#"><img src="#" alt=""><em>00:07:22</em><span>经过路全脊椎切除术治疗严重脊柱畸形</span></a></li>
						<li><a href="#"><img src="#" alt=""><em>00:07:22</em><span>经过路全脊椎切除术治疗严重脊柱畸形</span></a></li>
						<li><a href="#"><img src="#" alt=""><em>00:07:22</em><span>经过路全脊椎切除术治疗严重脊柱畸形</span></a></li>
						<li><a href="#"><img src="#" alt=""><em>00:07:22</em><span>经过路全脊椎切除术治疗严重脊柱畸形</span></a></li>
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
		location.href = path + '/blog/library?pageNo=' + pageNo;
	}

	$().ready(function(){
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
				$('#library_like_list').html(data);
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
		// 加载附件
		$('.logo-img.f-left ul[id^="attach"]').each(function() {
			var $this = $(this);
			$.ajaxRequest({
				url: path + '/blog/getShareAttach',
				data: {
					shareId: $this.attr('val')
				},
				success: function(data) {
					data = data.obj;
					
					for(var i = 0; i < data.length; i++) {
						var $li = $('<li>');
						if (data[i].attachType == 2) {
							$('#logoImgForLibrary'+data[i].shareId).attr('src','${imagePath}/library/'
									+data[i].attachName.substring(data[i].attachName.lastIndexOf(".")+1,
											data[i].attachName.length).toLocaleUpperCase()+'.png');
						} 
						$this.append($li);
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