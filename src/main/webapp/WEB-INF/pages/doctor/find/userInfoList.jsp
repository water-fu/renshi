<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/pages/common/include.jsp" %>
<%@page import="com.group.renshi.bean.doctor.UserInfoBean" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="com.group.webFramework.entity.UserDetails" %>
<%@page import="com.group.renshi.constant.SystemConstantType" %>
<%@page import="com.group.webFramework.uitl.SessionControl" %>
<%
   UserDetails userDetails=(UserDetails)SessionControl.
                      getAttribute(request, SystemConstantType.USER_DETAILS);
if(userDetails!=null)
    request.setAttribute("curAccountId", userDetails.getAccountInfoBean().getAccountId());
else
	request.setAttribute("curAccountId", "");

%>
<!DOCTYPE html>
<p class="title">医友列表</p>
<c:if test="${!empty pageQueryResult.list}">
	<c:forEach items="${pageQueryResult.list}" var="userInfo" >
		<c:if test="${userInfo.accountId != curAccountId }">
		<div class="doc-content">
			<div class="doc-img"><a href="javascript:void(0);" class="blog" val="${userInfo.accountId}"><img src="" alt="" link="${userInfo.headUrl}"></a></div>
			<div class="doc-intro">
				<p class="doc-info"><a href="javascript:void(0);" class="blog" val="${userInfo.accountId}"><em class="doc-name">${userInfo.realName}</em></a><span>${userInfo.belongDept}</span><span>${userInfo.workProfess}</span></p>
				<p class="doc-detail"><em>个人简介：</em><span>${userInfo.personInfro}</span></p>
				<div class="doc-label">
<!-- 					<p class="label-name"><em>标签：</em><span>骨科</span></p> -->
					<p class="label-fun"><a href="javascript:void(0);" class="blog" val="${userInfo.accountId}">个人空间</a></p>
					     <p class="label-fun">
					     <c:if test="${userInfo.createUser==0}"><!-- 0表示未关注 -->
					        <a href="javascript:void(0);" id="follow" class="follow"
					             val="${userInfo.accountId}">关注</a>
					      </c:if>
					      <c:if test="${userInfo.createUser==1}"><!-- 1表示未关注 -->
				             <a href="javascript:void(0);" id="unfollow" class="follow"
				                 val="${userInfo.accountId}">取消关注</a>
				            </c:if>
					    <%--  <a href="javascript:void(0);" class="follow" 
					            val="${userInfo.accountId}">关注</a> --%>
					     </p> 
				</div>
			</div>
		</div>
		</c:if>
	</c:forEach>
</c:if>

<%@ include file="/WEB-INF/pages/common/page.jsp" %>

<script type="text/javascript">
	function getPageData(pageNo) {
		$.ajax({
			type: 'post',
			url: path + '/doctor/searchDoctors',
			data: $('#searchForm').formSerialize() + '&pageNo=' + pageNo,
			dataType: 'html',
			success: function (result) {
				$('.doctor-list').html(result);
			}
		});
	}
	
	$(document).ready(function() {
		// 显示头像
		$('.doc-img img').each(function() {
			var $this = $(this);
			$this.attr('src', path + '/common/showImage?imageUrl=' + $this.attr('link'));
		});
		
		// 关注
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
		
		// 个人空间
		$('.blog').click(function() {
			var $this = $(this);
			location.href = path + '/blog/' + $this.attr('val');
		});
	});
</script>