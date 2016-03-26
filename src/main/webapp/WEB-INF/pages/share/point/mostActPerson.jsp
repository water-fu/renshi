<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String path = request.getContextPath();

	// CSS和JS的lib库
	String cssLib = path + "/lib/css";
	String jsLib = path + "/lib/js";
	
	// JS的自定义插件库
	String jsPlugin = path + "/plugin";
	
	// css
	String cssPath = path + "/css";
	//js
	String jsPath = path +"/js";
	
	// image
	String imagePath = path + "/images";
	
	request.setAttribute("path", path);
	request.setAttribute("cssLib", cssLib);
	request.setAttribute("jsLib", jsLib);
	request.setAttribute("jsPlugin", jsPlugin);
	request.setAttribute("cssPath", cssPath);
	request.setAttribute("jsPath",jsPath);
	request.setAttribute("imagePath", imagePath);
	
%>

<!DOCTYPE html>
	<c:forEach items="${mostActPerson}" var="personInfo">
			<div class="expert-list-content">
				<div class="e-img f-left" style="cursor: pointer;" val="${personInfo.accountId}">
					<img src="" alt="" link="${personInfo.userInfoBean.headUrl}">
				</div>
				<div class="e-desc">
					<p class="e-que" val="${personInfo.accountId}" style="cursor: pointer;" >
					<span class="f-left" ><em>${personInfo.userInfoBean.realName}</em></span>
					<span class="f-right ">观点数:<em>${personInfo.articleNum}</em></span></p>
				   
					<p class="e-name">
					  <c:if test="${loginTrue != 1}"><!-- 已经登录 -->
					  <c:if test="${personInfo.personActive == 0}">
					     <a href="javascript:void(0);" class="r-follow"  val="${personInfo.accountId}">关注</a>
					  </c:if>
					  <c:if test="${personInfo.personActive == 1}">
					     <a href="javascript:void(0);" class="r-follow"  val="${personInfo.accountId}">取消关注</a>
					  </c:if>
					  <a href="${path}/blog/${personInfo.accountId}">个人空间</a>
					</c:if>
					</p>
				  
				</div>
			</div>
	</c:forEach>
<script type="text/javascript">
$(document).ready(function() {		
	
	$('.e-img img').each(function() {
		var $this = $(this);
		$this.attr('src', path + '/common/showImage?imageUrl=' + $this.attr('link'));
	});
	
	 $('.e-img, .e-que').click(function() {
              location.href = path + '/blog/' + $(this).attr('val');
     });
     
	// 关注
		$('.r-follow').click(function() {
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
});
</script>
