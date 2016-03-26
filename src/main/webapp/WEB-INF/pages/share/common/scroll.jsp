<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<! DOCTYPE html>
<%@page import="com.group.webFramework.entity.UserDetails"%>
<%@page import="com.group.webFramework.uitl.SessionControl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	UserDetails userDetails = SessionControl.getCurUserDetail(request);
	if(userDetails == null) {
		request.setAttribute("userId", "-1");
	} else {
		request.setAttribute("userId", userDetails.getAccountInfoBean().getAccountId());
	}
%>

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

<link rel="stylesheet" type="text/css" href="${cssLib}/reset.css" />
<link rel="stylesheet" type="text/css" href="${cssPath}/common/util.css" />
<link rel="stylesheet" href="${cssPath}/common/scroll.css">
<link rel="stylesheet" href="${cssPath}/common/common.css">
<div class="info">
	<div class="info-layout">
	<table style="margin-left: 18px;">
		<tr>
			<td>
				<div class="icon" style="text-align: center;"><a  href="${path}/blog/${userInfoBean.accountId}"><img class="headerimg" src="" link="${accountInfoBean.headUrl}" id="person-icon" alt=""></a></div>	</td>
		</tr>
		<tr>
			<td style="text-align: center;">
				<div class="title"><a href="${path}/blog/${userInfoBean.accountId}"><em class="name">${userInfoBean.realName}</em></a><span class="post" style="color:#fff">${authenticInfoBean.workProfess}</span><span class="profession" style="color:#fff">${authenticInfoBean.academicProfess}</span></div>
			</td>
		</tr>
		<tr>
			<td style="text-align: center;">
				<div class="company"><a href="<%=path%>/doctor/findDoctor" id="findDoctor" class="hosp">${userInfoBean.belongHospital}</a><a href="<%=path%>/doctor/findDoctor" id="findDoctor" class="medi">${userInfoBean.belongDept}</a></div>				</td>
		</tr>
	    </table>	
		<div class="mess">
		<c:if test="${userId == accountInfoBean.accountId}">
				<a href="javascript:void(0);" id="home"><img src="${imagePath}/person/my_space.png" alt=""><span>我的空间</span></a>
				<a href="javascript:void(0);" id="manager"><img src="${imagePath}/person/my_mana.png" alt=""><span>管理中心</span></a>
			</c:if>
			<c:if test="${userId != accountInfoBean.accountId}">
			<!-- +表示未关注 -->
				<a href="javascript:void(0);" id="follow" style="display: none;"><img src="${imagePath}/person/my_space.png" alt=""><span>关注</span></a>
				<a href="javascript:void(0);" id="unfollow" style="display: none;"><img src="${imagePath}/person/my_space.png" alt=""><span>取消关注</span></a>
				<a href="javascript:void(0);" id="msgInfo"><img src="${imagePath}/person/my_mana.png" alt=""><span>私信</span></a>
			</c:if>
		</div>
	</div>
</div>
<script type="text/javascript">
$(document).ready(function() {
	if('${isFollow}' == 'true') {
		$('#unfollow').show();
	} else {
		$('#follow').show();
	}
	
	// 加载头像
	$('#person-icon').attr('src', path + '/common/showImage?imageUrl=' + $('#person-icon').attr('link'));
	
	// 关注
	$('#follow').click(function() {
		var $this = $(this);
		$.ajaxRequest({
			url: path + '/share/followActive',
			type: 'post',
			data: {
				accountId : '${accountInfoBean.accountId}'
			},
			success: function(data) {
				$this.hide();
				$('#unfollow').show();
				
				reloadLeft();
			}
		});
	});
	
	// 取消关注
	$('#unfollow').click(function() {
		var $this = $(this);
		$.ajaxRequest({
			url: path + '/share/unFollowActive',
			type: 'post',
			data: {
				accountId : '${accountInfoBean.accountId}'
			},
			success: function(data) {
				$this.hide();
				$('#follow').show();
				
				reloadLeft();
			}
		});
	});
	
	// 首页
	$('#home').click(function() {
		location.href = path + '/blog/${accountInfoBean.accountId}';
	});
	
	$('#manager').click(function() {
		location.href = path + '/doctor/toBasicInfo?id=${accountInfoBean.accountId}';
	});
	
	$('#msgInfo').click(function() {
		$.ajaxRequest({
			url: path + '/blog/addMsg',
			type: 'post',
			data: {
				accountedId : '${accountInfoBean.accountId}'
			},
			success: function(data) {
				location.href = path + '/blog/msgDialog?msgId=' + data.obj.msgId;
			}
		});
	});
});

function reloadLeft() {
	$('#left-div').remove();
	
	// 加载左侧个人信息
	$.ajaxRequest({
		url: path + '/blog/getPersonLeftCon',
		dataType: 'html',
		data: {
			accountId : '${accountInfoBean.accountId}'
		},
		success: function(data) {
			$('.con-left').prepend(data);
		}
	});
}
</script>
