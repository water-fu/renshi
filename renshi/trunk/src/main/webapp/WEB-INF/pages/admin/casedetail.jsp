<%@page import="com.group.renshi.bean.share.ShareInfoBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--<%@ include file="/WEB-INF/pages/common/include.jsp" %>--%>

<%

	ShareInfoBean shareInfoBean = (ShareInfoBean) request.getAttribute("shareInfoBean");
	if(shareInfoBean.getShareTag() != null && !"".equals(shareInfoBean.getShareTag())) {
		String[] tags = shareInfoBean.getShareTag().split(",");
		request.setAttribute("tags", tags);
	}
%>

<title>病例-详情页</title>
<link rel="stylesheet" href="${cssPath}/common/layout.css">
<link rel="stylesheet" href="${cssPath}/common/font.css">
<link rel="stylesheet" href="${cssPath}/common/color.css">
<link rel="stylesheet" href="${cssPath}/case/casedetail.css">
	<div class="top hidden">
		<div class="nav"><img src="${imagePath}/answer/logo.jpg" alt=""> </div>
	</div>
	<div class="scroll">
	</div>

	<!-- scroll end -->
	<input type="hidden" id="shareId" value="${shareInfoBean.shareId}" />

	<div class="answ-detail">
		<div class="detail-title mar-com">
			<strong class="f-left">${shareInfoBean.shareTitle}</strong>
		</div>
		<div class="detail-time mar-com">
			<p><a href="${path}/blog/${shareInfoBean.accountId}"><strong>${shareInfoBean.realName}</strong></a>
				<span>发布于<em><fmt:formatDate value="${shareInfoBean.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></em>的病例</span></p>
		</div>
		<p class="detail-content mar-com">${shareInfoBean.shareDesc}</p>

		<ul class="detail-img attach" val="${shareInfoBean.shareId}">
		</ul>

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
			<div class="f-right hidden">
				<p>标签：
					<c:forEach items="${tags}" var="tag">
						<span>${tag}</span>
					</c:forEach>
				</p>
			</div>
		</div>
	</div>
<script type="text/javascript">
	$(document).ready(function() {
		// 加载附件
		$('.attach').each(function() {
			var $this = $(this);
			$.ajaxRequest({
				url: path + '/blog/getShareAttach',
				data: {
					shareId: $this.attr('val')
				},
				success: function(data) {
					data = data.obj;
					for(var i = 0; i < data.length; i++) {
						var $li = $('<li>'), $a = $('<a>'), $img = $('<img>');
						$img.attr('alt', '');
						$img.attr('src', path + '/common/showImage?imageUrl=' + data[i].attachUrl);
						$a.append($img);
						$li.append($a);
						
						$this.append($li);
					}
				}
			});
		});
		
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