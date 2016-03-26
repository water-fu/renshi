<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.group.webFramework.uitl.SessionControl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/pages/common/include.jsp" %>

<%
	String headUrl = SessionControl.getOperInfo(request).getHeadUrl();
	request.setAttribute("headUrl", headUrl);
%>

<!DOCTYPE html>

<c:forEach items="${pageQueryResult.list}" var="discussInfo">
	<div class="com-list-content">
		<div class="com-info">
			<p class="info-img f-left">
			<a href="${path}/blog/${discussInfo.createUser}"><img class="headerimg" src="" alt="" link="${discussInfo.headUrl}"></a>
			</p>
			<div class="info-left f-right">
			<h4><em><a href="${path}/blog/${discussInfo.createUser}">${discussInfo.realName}</a>
				<c:if test="${discussInfo.discussType == 2}">
					<font color="#000">回复</font><a href="${path}/blog/${discussInfo.accountId}">@${discussInfo.accountName}</a>：${discussInfo.parentContent}
				</c:if>
				<c:if test="${discussInfo.discussType == 3}">
					<font color="#000">回复</font><a href="${path}/blog/${discussInfo.accountId}">@${discussInfo.accountName}</a> 的赞
				</c:if>
				</em></h4>
				<p>${discussInfo.discussContent}</p>
				<p class="com-time"><em><fmt:formatDate value="${discussInfo.createDate}" pattern="MM-dd HH:mm"/> </em><span class="f-right"><a href="javascript:void(0);" class="commentDiv" style="cursor: pointer;"><em>评论</em></a></span></p>
			</div>
		</div>
		<div class="com-answer hidden">
			<p class="f-left"><img src="" alt="" link="${headUrl}"></p>
			<div class="f-right">
				<p class="com-input"><span>回复@${discussInfo.realName}</span><input type="text" ></p>
				<p class="com-btn"><em>评论</em></p>
				
				<input type="hidden" value="${discussInfo.shareId}" class="shareId" />
				<input type="hidden" value="${discussInfo.realName}" />
				<input type="hidden" value="${discussInfo.createUser}" />
				<input type="hidden" value="${discussInfo.discussId}" />
			</div>
		</div>
	</div>
</c:forEach>

<%@ include file="/WEB-INF/pages/common/page.jsp" %>

<script type="text/javascript">
function getPageData(pageNo) {
	// 加载医问医答评论
	$.ajaxRequest({
		url: path + '/blog/askComment',
		dataType: 'html',
		data: {
			id: $('#shareId').val(),
			pageNo: pageNo
		},
		success: function(data) {
			$('.com-list').html(data);
		}
	});
}

$(document).ready(function() {
	// 加载头像
	$('.com-answer img').each(function() {
		var $this = $(this);
		$this.attr('src', path + '/common/showImage?imageUrl=' + $this.attr('link'));
	});
	
	// 加载头像
	$('.info-img img').each(function() {
		var $this = $(this);
		$this.attr('src', path + '/common/showImage?imageUrl=' + $this.attr('link'));
	});
	
	// 点评论
	$('.commentDiv').click(function() {
		var $this = $(this);
		var $p = $this.parents('.com-info').next();
		if($p.hasClass('hidden')) {
			$this.parents('.com-info').next().removeClass('hidden');
		} else {
			$this.parents('.com-info').next().addClass('hidden');
		}
	});
	
	// 评论
	$('.com-btn').click(function() {
		var $this = $(this);
		var content = $this.prev().children('input').val();
		if(content == '') {
			alert('请填写评论');
			return;
		}
		
		var inputs = $this.nextAll('input');
		
		$.ajaxRequest({
			url: path + '/blog/addDiscuss',
			type: 'post',
			data: {
				shareId: $(inputs[0]).val(),
				accountName: $(inputs[1]).val(),
				accountId: $(inputs[2]).val(),
				parentId: $(inputs[3]).val(),
				discussContent: content,
				discussType: 2 // 表示评论
			},
			success: function() {
				// 加载医问医答评论
				$.ajaxRequest({
					url: path + '/blog/askComment',
					dataType: 'html',
					data: {
						id: $(inputs[0]).val()
					},
					success: function(data) {
						$('.com-list').html(data);
					}
				});
			}
		});
	});
});
</script>