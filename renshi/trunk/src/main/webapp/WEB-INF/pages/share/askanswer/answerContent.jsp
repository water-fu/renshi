<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/pages/common/include.jsp" %>

<!DOCTYPE html>

<c:forEach items="${pageQueryResult.list}" var="shareInfo">
	<div class="list-answer-content">
		<div class="logo-img f-left" style="cursor: pointer;"><img src="" alt="" link="${shareInfo.headUrl}" val="${shareInfo.accountId}"></div>
		<div class="answer-con f-right">
			<h3><span class="u-name" style="cursor: pointer;" val="${shareInfo.accountId}">${shareInfo.realName}</span><span class="u-post"><em>${shareInfo.belongDept}</em><em>${shareInfo.workProfess}</em></span></h3>
			<p class="a-title"><a href="<%=path %>/blog/askDetail?id=${shareInfo.shareId}">${shareInfo.shareTitle}</a></p>
<!-- 			<p class="a-answer">答:<em>恢复期间不要太着急，冠军啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦克萨咖啡就开始啦放假啦撒。</em></p> -->
			<p class="a-fun">
				<span class="a-fun-list"> 
					<em><i>赞 </i>(${shareInfo.likeNum})</em> 
					<em><i>收藏 </i>(${shareInfo.collectionNum})</em>
					<em><i>评论 </i>(${shareInfo.commentNum})</em>
				</span>
				<span class="a-mark">
<!-- 					标签: <em>骨科</em><em>骨质疏松</em> -->
				</span>
				<span class="a-time f-right"><fmt:formatDate value="${shareInfo.createDate}" pattern="MM-dd HH:mm" /> </span>
			</p>
		</div>
	</div>
</c:forEach>

<%@ include file="/WEB-INF/pages/common/page.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
	// 加载头像
	$('.logo-img img').each(function() {
		var $this = $(this);
		$this.attr('src', path + '/common/showImage?imageUrl=' + $this.attr('link'));
	});
	
	$('.logo-img img, .u-name').click(function() {
		location.href = path + '/blog/' + $(this).attr('val');
	});
});

function getPageData(pageNo) {
	var type = ${param.type};
	var url = '';
	if(type == 1) {
		url = '/blog/newAskAnswer';
	} else if (type == 2) {
		url = '/blog/hotAskAnswer';
	} else if (type == 3) {
		url = '/blog/noAskAnswer';
	}
	
	$.ajax({
		url: path + url,
		dataType: 'html',
		data: {
			pageNo : pageNo,
			type : type
		},
		success: function(data) {
			$('.list-answer').html(data);
		}
	});
}
</script>