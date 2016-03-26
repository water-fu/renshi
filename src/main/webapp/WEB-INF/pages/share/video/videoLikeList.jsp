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
<c:forEach items="${LikeList}" var="shareInfo">
	<div class="list">
		<div class="list-left">
		<a href="${path}/blog/${shareInfo.accountId}">
		<img src="" link="${shareInfo.headUrl}" alt="${shareInfo.realName}">
		</a></div> 
		<div class="list-right">
			<em>[<span>${shareInfo.belongProfess}</span>]</em>
			<h4><a href="${path}/blog/content/${shareInfo.shareId}">${shareInfo.shareTitle}</a></h4>
			<div class="clearfix"></div>
			<span class="total">浏览：<em>${shareInfo.readNum}</em></span>
			<span class="share">由<a href="${path}/blog/${shareInfo.accountId}">${shareInfo.realName}</a>分享</span>
		</div>
	</div>
</c:forEach>

<script type="text/javascript">
	$(document).ready(function() {
		$('.list-left img').each(function() {
			var $this = $(this);
			$this.attr('src', path + '/common/showImage?imageUrl=' + $this.attr('link'));
		});
	});
</script>