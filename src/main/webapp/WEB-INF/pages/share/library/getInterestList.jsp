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
<c:forEach items="${interestList}" var="shareInfo">
	<div class="list">
		<div class="list-left">
		  <ul id="attach_${shareInfo.shareId}" val="${shareInfo.shareId}">
		     <a href="${path}/blog/libraryDetail?id=${shareInfo.shareId}">
		     <img id="logoImgForLibrary${shareInfo.shareId}" src="" alt="" >
		    </a>
		  </ul>
		<%-- <img src="" link="${shareInfo.headUrl}" alt="${shareInfo.realName}"> --%>
		</div> 
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
		$('.list-left  ul[id^="attach"]').each(function() {
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
	});
</script>