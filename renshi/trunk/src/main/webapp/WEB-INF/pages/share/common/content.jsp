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
<%@page import="com.group.webFramework.entity.UserDetails"%>
<%@page import="com.group.webFramework.uitl.SessionControl"%>
<%
	UserDetails userDetails3 = SessionControl.getCurUserDetail(request);
	if(userDetails3 != null) {
		request.setAttribute("userIdForDelete", userDetails3.getAccountInfoBean().getAccountId());
	} else {
		request.setAttribute("userIdForDelete", -1);
	}
%>
<!DOCTYPE html>

<link rel="stylesheet" href="${cssPath}/common/common.css">
<c:forEach items="${pageQueryResult.list}" var="shareInfo">
	<div class="infos-list">
		<div class="send-list">
			<div class="list-logo">
				<a href="${path}/blog/${shareInfo.accountId}"><img class="headerimg" src="" link="${shareInfo.headUrl}" alt="${shareInfo.realName}"></a>
			</div>
			<div class="list-content">
			    <c:if test="${shareInfo.accountId==userIdForDelete}">
				<div class="m-r-r">
				    <div class="inter-status"> 
				    <p class="label-fun">
				       <a href="javascript:void(0);" id="deleteContent" class="deleteContent"
				                 val="${shareInfo.shareId}">删除</a>
				    </p>
				 </div>
				</div>
				</c:if>
				<h3 class="doc-intro"><a href="${path}/blog/${shareInfo.accountId}"><em class="name">${shareInfo.realName}</em></a><span class="sci">${shareInfo.belongDept}</span><span class="doc">${shareInfo.workProfess}</span></h3>
				 
				<h3 class="title"><a href="${path}/blog/content/${shareInfo.shareId}">"<em>${shareInfo.shareTitle}</em>"</a></h3>
				
				<p id="showContent">${shareInfo.shareDesc}</p>
				
				<ul id="attach_${shareInfo.shareId}" val="${shareInfo.shareId}">
				</ul>
				
				<div class="time"><span class="send-time">${shareInfo.publicDate}</span>发布的<em class="point">${shareInfo.shareTypeName}</em></div>
			</div>
		</div>
		<ul class="fun">
			<li><a href="${path}/blog/content/${shareInfo.shareId}">浏览(<em>${shareInfo.readNum}</em>)</a></li>
			
			<%-- isPraise：1为未收藏，0为收藏 --%>
			<c:if test="${shareInfo.isPraise == 1}">
				<li><a href="javascript:void(0);" val="${shareInfo.shareId}" type="1" num="${shareInfo.likeNum}" class="praise">赞(<em>${shareInfo.likeNum}</em>)</a></li>
			</c:if>
			<c:if test="${shareInfo.isPraise == 0}">
				<li><a href="javascript:void(0);" val="${shareInfo.shareId}" type="-1" num="${shareInfo.likeNum}" class="praise">取消赞(<em>${shareInfo.likeNum}</em>)</a></li>
			</c:if>
			
			<li><a href="${path}/blog/content/${shareInfo.shareId}">评论(<em>${shareInfo.commentNum}</em>)</a></li>
			
			<%-- isCollection：1为未收藏，0为收藏 --%>
			<c:if test="${shareInfo.isCollection == 1}">
				<%-- type：1为收藏，-1为取消收藏 --%>
				<li><a href="javascript:void(0);" val="${shareInfo.shareId}" type="1" num="${shareInfo.collectionNum}" class="collection">收藏(<em>${shareInfo.collectionNum}</em>)</a></li>
			</c:if>
			<c:if test="${shareInfo.isCollection == 0}">
								<%-- type：1为收藏，-1为取消收藏 --%>
				<li><a href="javascript:void(0);" val="${shareInfo.shareId}" type="-1" num="${shareInfo.collectionNum}" class="collection">取消收藏(<em>${shareInfo.collectionNum}</em>)</a></li>
			</c:if>
		</ul>
	</div>
</c:forEach>

<%@ include file="/WEB-INF/pages/common/page.jsp" %>
<script type="text/javascript">
$(document).ready(function(){
	//异步删除自己的分享信息
	$(".deleteContent").click(function(){
		var $this=$(this);
		 var sure=confirm('确定要删除吗?');
		if(!sure){
		  return false;
		}
		$.ajaxRequest({
			url: path + '/blog/delContent',
			//type:'post',
			data: {
				shareId : $this.attr('val'),
				},
		   success: function(data) {
			     data = data.obj;
			     if(data.shareId == (-1) )
			       //删除失败 
			       alert(data.msg);
			     else
			       //删除后隐藏 
				   $this.parents(".infos-list").addClass("hidden");
			}
		     
		});
	});
});

</script>
<script type="text/javascript" src="${jsPath}/share/content.js"></script>
<script>
	function getPageData(pageNo) {
		loadContent(pageNo);
	}
	
	function loadContent(pageNo) {
		//alert("content.jsp");
		// 异步加载分享内容
		$.ajaxRequest({
			url: path + '/blog/getContent',
			dataType: 'html',
			data: {
				accountId : accountId,
				searchType: $('#searchType').val(),
				shareType: $('.status-part span.choice').attr('val'),
				shareTime:$('.title-right a.title-choice').attr('val'),
				pageNo: pageNo
			},
			success: function(data) {
				$('#infos_Content').html(data);
			}
		});
	}
	$(document).ready(function(){
		
	});
</script>