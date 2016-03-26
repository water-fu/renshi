<%@page import="com.group.renshi.bean.share.ShareInfoBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--<%@ include file="/WEB-INF/pages/common/include.jsp" %>--%>

<%
	request.setAttribute("path", request.getContextPath());
	request.setAttribute("cssLib", request.getContextPath() + "/lib/css");
	request.setAttribute("jsLib", request.getContextPath() + "/lib/js");
	request.setAttribute("jsPlugin", request.getContextPath() + "/plugin");
	request.setAttribute("cssPath", request.getContextPath() + "/css");
	request.setAttribute("jsPath", request.getContextPath() +"/js");
	request.setAttribute("imagePath", request.getContextPath() + "/images");

	ShareInfoBean shareInfoBean = (ShareInfoBean) request.getAttribute("shareInfoBean");
	if(shareInfoBean.getShareTag() != null && !"".equals(shareInfoBean.getShareTag())) {
		String[] tags = shareInfoBean.getShareTag().split(",");
		request.setAttribute("tags", tags);
	}
%>

<title>视频-详情页</title>
<link rel="stylesheet" href="${cssPath}/common/layout.css">
<link rel="stylesheet" href="${cssPath}/common/font.css">
<link rel="stylesheet" href="${cssPath}/common/color.css">
<link rel="stylesheet" href="${cssPath}/video/videodetail.css">
<link href="${jsPlugin}/videoplayer/theme/maccaco/style.css" rel="stylesheet" />
<script src="${jsPlugin}/videoplayer/projekktor.min.js"></script>
	<!-- scroll start -->
	<div class="scroll">
	</div>
	<div class="top hidden">
		<div class="nav"><img src="${imagePath}/answer/logo.jpg" alt=""> </div>
	</div>
	<!-- scroll end -->

	<input type="hidden" id="shareId" value="${shareInfoBean.shareId}" />

	<div class="answ-detail">
		<div class="detail-title mar-com">
			<strong class="f-left">${shareInfoBean.shareTitle}</strong>
			<%--<ul class="f-right">
				<li><span>${shareInfoBean.commentNum}</span><em>评论</em></li>
				<li><span>${shareInfoBean.readNum}</span><em>浏览</em></li>
			</ul>--%>
		</div>
		<div class="detail-time mar-com">
			<p><a href="${path}/blog/${shareInfoBean.accountId}"><strong>${shareInfoBean.realName}</strong></a>
				<span>发布于<em><fmt:formatDate value="${shareInfoBean.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/> </em>的视频</span></p>
		</div>
		<div class="detail-content">
			<div class="video-play">
				<video id="player_a" class="projekktor" title="" width="600" height="390">
					<script type="text/javascript">
						$(document).ready(function () {
							projekktor('#player_a', {
								controls: true, volume: 0.5, autoplay: false,
								playlist: [
								{
									0: { src: '${path}/common/showVideo?videoUrl=${videoInfoBean.videoUrl}', type: 'video/mp4' }
								}],
								playerFlashMP4: 'http://www.yourdomain.com/StrobeMediaPlayback.swf',
								playerFlashMP3: 'http://www.yourdomain.com/StrobeMediaPlayback.swf'
							});
							//poster="images/jb.jpg"  加载图片
							//autoplay: false 是否自动播放
							//src: 'video/intro.mp4' 视频地址
						});
					</script>
				</video>
			</div>
		</div>
		<div class="line"></div>
		<div class="detai-fun mar-com">
			<div class="f-left fun-left">

				<div class="detail-re f-right hidden">
					<a href="#"><img src="#" alt=""></a>
					<a href="#"><img src="#" alt=""></a>
					<a href="#"><img src="#" alt=""></a>
					<a href="#"><img src="#" alt=""></a>
				</div>
			</div>
			<div class="f-right">
				<p>
					标签：
					<c:forEach items="${tags}" var="tag">
						<span>${tag}</span>
					</c:forEach>
				</p>
			</div>
		</div>
	</div>
<script type="text/javascript" src="${jsPath}/video/checklowie9.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		// 加载头像
		$('.com-logo img').each(function() {
			var $this = $(this);
			$this.attr('src', path + '/common/showImage?imageUrl=' + $this.attr('link'));
		});
		
		// 加载头部信息
		$.ajaxRequest({
			url: path + '/blog/getScroll',
			dataType: 'html',
			data: {
				accountId : '${shareInfoBean.accountId}'
			},
			success: function(data) {
				$('.scroll').html(data);
			}
		});
	});
</script>