<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/pages/common/include.jsp"%>
<!DOCTYPE html>

<c:if test="${!empty pageQueryResult.list}">
	<c:forEach items="${pageQueryResult.list}" var="map">
		<div class="message-content">
			<div class="message-left"><!--  -->
				<a  href="${path}/blog/${map.FOLLOW_ACCOUNT}"><img src="${path}/common/showImage?imageUrl=${map.HEAD_URL}" alt=""
					link="${map.HEAD_URL}"></a>
			</div>
			<div class="message-right">
				<div class="m-r-l">
					<p class="user-name color-666 font-14">
						<a href="${path}/blog/${map.FOLLOW_ACCOUNT}"><em
							class="u-name font-16">${map.REAL_NAME}</em></a><span>${map.BELONG_DEPT}</span><span>${map.WORK_PROFESS}</span>
					</p>
					<p class="interest color-666">
						<a href="${path}/blog/${map.FOLLOW_ACCOUNT}">
						<span>关注
						<em>${map.FOLLOW_NUM}</em>
						</span></a>
						|
						<a href="${path}/blog/${map.FOLLOW_ACCOUNT}">
						<span>粉丝
						<em>${map.FANS_NUM}</em>
						</span>
						</a>
						|<a href="${path}/blog/${map.FOLLOW_ACCOUNT}">
						<span>人气
						<em>${map.BROWER_NUM}</em>
						</span>
						</a>
					</p>
					<p class="user-intro color-333">
						<span>简介：</span><a href="${path}/blog/${map.FOLLOW_ACCOUNT}"><em>${map.PERSON_INFRO}</em>
						</a>
					</p>
					<p class="user-achieve color-666">
						<strong>成就：</strong>
						<a href="${path}/blog/${map.FOLLOW_ACCOUNT}"><span class="video">视频<em>${map.VIDEO_NUM}</em></span></a>
						|
						<a href="${path}/blog/${map.FOLLOW_ACCOUNT}"><span>文章<em>${map.ARTICLE_NUM}</em></span></a>
						|
						<a href="${path}/blog/${map.FOLLOW_ACCOUNT}"><span>病例<em>${map.CASE_NUM}</em></span>
						</a>|
						<a href="${path}/blog/${map.FOLLOW_ACCOUNT}"><span>文件<em>${map.COURSE_NUM}</em></span></a>
					</p>
				</div>
				<div class="m-r-r">
				    <div class="inter-status">
				    <c:if test="${map.isFollow==1}">
				    <p class="label-fun">
				       <a href="javascript:void(0);" id="unfollow" class="follow"
				                 val="${map.FOLLOW_ACCOUNT}">取消关注</a>
				    </p>
				    </c:if>
				    <c:if test="${map.isFollow==0}">
				    <p class="label-fun">
				       <a href="javascript:void(0);" id="unfollow" class="follow"
				                 val="${map.FOLLOW_ACCOUNT}">关注</a>
				    </p>
				    </c:if>
				    </div> 
					<div class="inter-status hidden">
						<img src="../images/person/interest.png" alt=""> <select
							name="" id="">
							<option value="">更多</option>
						</select>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</c:if>

<%@ include file="/WEB-INF/pages/common/page.jsp"%>

<script type="text/javascript">
	function getPageData(pageNo) {
		var params = $('#queryForm').formSerialize() + '&pageNo=' + pageNo;
		//alert(params);
		var isFanOrInterest = $('#isFanOrInterest').val();
		var url = path + '';
		if (isFanOrInterest == 'fans') {
			url = url + '/blog/pagefansWithName';
		} else if (isFanOrInterest == 'interests') {
			url = url + '/blog/pageInteWithName';
		}
		$.ajax({
			type : 'post',
			url : url,
			data : params,
			dataType : 'html',
			success : function(result) {
				$('.message-list').html(result);
			}
		});
	}
	
	$(document).ready(function() {
		// 取消关注
		$('.follow').click(function() {
			var $this = $(this);
			if($this.text() == '关注') {
				$.ajaxRequest({
					url: path + '/share/followActive',
					type: 'post',
					data: {
						accountId : $this.attr('val')
					},
					success: function(data) {
						$this.text('取消关注');
					}
				});
			} else {
				$.ajaxRequest({
					url: path + '/share/unFollowActive',
					type: 'post',
					data: {
						accountId : $this.attr('val')
					},
					success: function(data) {
						$this.text('关注');
					}
				});
			}
		});
		//$('.message-left img').attr('src', path + '/common/showImage?imageUrl=' + $('.message-left img').attr('link'));
	});
</script>