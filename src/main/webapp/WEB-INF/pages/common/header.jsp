<%@page import="com.group.webFramework.entity.UserDetails"%>
<%@page import="com.group.webFramework.uitl.SessionControl"%>
<%@page import="com.group.renshi.bean.system.AccountInfoBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	UserDetails userDetails = SessionControl.getCurUserDetail(request);
   
	if(null == userDetails) {
		request.setAttribute("isLogin", "0");
	}
	else {
		
		request.setAttribute("isLogin", "1");
		if(userDetails.getAccountInfoBean() != null) {
			request.setAttribute("Status", userDetails.getAccountInfoBean().getAccountStatus());
			request.setAttribute("accountId", userDetails.getAccountInfoBean().getAccountId());
			request.setAttribute("headUrl", userDetails.getAccountInfoBean().getHeadUrl());
			request.setAttribute("realName", userDetails.getAccountInfoBean().getLoginAccount());
		}
		if(userDetails.getUserInfoBean() != null) {
			request.setAttribute("realName", userDetails.getUserInfoBean().getRealName());
		}
	}
%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html" charset="UTF-8" />	
		<meta name="author" content="认仕网" />
		<meta name="copyright" content="杭州岐黄信息技术有限公司" />
		<title>E帮护</title>
		<meta name='keywords' content='找医友 - 认仕医生' />
		<meta name='description' content='找医友 - 认仕医生' />
		
		<link rel="stylesheet" type="text/css" href="${cssPath}/common/header.css" />
	</head>
	<body>
		<div id="topNav">
			<div class="width1000 clear">
				<div class="floatLeft">最权威的E帮护平台</div>
				<div class="floatRight regdiv hidden">前往&nbsp;<a href="#">E帮护</a>&nbsp;网&nbsp;&nbsp;<span class="topRegister">注册</span></div>
				<div class="floatRight welcome hidden">欢迎您，<a href="javascript:void(0);" class="home">${realName}</a> 医生</div>
			</div>
		</div>
		<div id="header" class="clear width1000">
			<div class="siteLogo"><a class="logout" href="${path}/">
			<img src="${imagePath}/header/logo1.jpg" style="height:68px;width:181px;" /></a></div>
			<div class="siteMenu" >
				<ul><!-- class="current"  -->
					<li><a href="javascript:void(0)" id="homePage">首页</a></li>
					<li><a href="javascript:void(0);" id="findDoctor" class="findDoctor">我们的服务</a></li>
					<li><a href="javascript:void(0);" id="askanswer" class="askanswer askDetail">质量管理</a></li>
					<li><a href="javascript:void(0);" id="video" class="video videolist videoDetail">护理学堂</a></li>
					<li><a href="javascript:void(0);" id="point" class="point pointDetail">关于我们</a></li>
					<li><a href="javascript:void(0);" id="case" class="case caseDetail">联系我们</a></li>
					<%--<li><a href="javascript:void(0);" id="library" class="library libraryDetail">护士/护理员招募</a></li>--%>
				</ul>
			</div>
			<div class="loginStatus">
				<a id="hrefLogin" href=""><img id="headImg" src="${imagePath}/header/noLoginHead.png" width="45" height="45" /></a>
				<a class="userName tologin" href="javascript:void(0)">请登录</a>
				<a class="userName nameHover hidden" href="javascript:void(0);">${realName}</a>
				<div class="userLinks hidden">
					<span class="tri"></span>
					<a href="javascript:void(0);" id="myMessage">我的私信 <i></i></a>
					<a href="javascript:void(0);" id="myDiscuss">评论 <i></i></a>
					<a href="javascript:void(0);" id="myPraise">赞 <i></i></a>
					<a class="logout" href="javascript:void(0);">退出登录</a>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript">
		$(document).ready(function() {
			var urlPaths = ['findDoctor', 'askanswer', 'askDetail', 'video', 'videolist', 'videoDetail', 'point', 'pointDetail', 'case', 'caseDetail', 'library', 'libraryDetail'];
			
			$('.siteMenu a').removeClass('current');
			
			var realPath = location.href;
			for(var i = 0; i < urlPaths.length; i++) {
				if(realPath.indexOf(urlPaths[i]) >= 0) {
					$('.' + urlPaths[i]).addClass('current');
					break;
				}
			}
			
			// 找医友
			$('#findDoctor').click(function() {
//				location.href = path + '/doctor/findDoctor';
				location.href = path + '/blog/video';
			});
			
			$('#askanswer').click(function() {
				location.href = path + '/system/askanswer';
			});
			
			// 视频
			$('.video').click(function() {
				location.href = path + '/blog/video';
			});
			
			$('.point').click(function() {
				location.href = path + '/blog/point';
			});
			
			$('.case').click(function() {
				location.href = path + '/blog/case';
			});
			
			$('.library').click(function() {
				location.href = path + '/blog/library';
			});
			
			$('#homePage').click(function() {
				location.href = path + '/';
			});
			
			// 注册
			$('.topRegister').click(function() {
				location.href = path + '/system/registerPage';
			});
			
			// 登录
			$('.tologin').click(function() {
				location.href = path + "/system/loginPage";
			});
			if('${isLogin == 1}' == 'true' &&'${Status != 0}'=='true') {
				$('.welcome').removeClass('hidden');
				$('.regdiv').addClass('hidden');
				//点击自己姓名
				$('.welcome a').click(function() {
					location.href = path + '/blog/${accountId}';
				});
				//点击自己头像  添加超链接
				$('#hrefLogin').attr('href',path + '/blog/${accountId}');
				//$('#headImg').click(function() {
				//	location.href = path + '/blog/${accountId}';
				//});
				$('.tologin').addClass('hidden');
				$('.nameHover').removeClass('hidden');
				$('#headImg').attr('src', path + '/common/showImage?imageUrl=${headUrl}');
			} 
			else if('${isLogin == 1}' == 'true') {
				$('.welcome').removeClass('hidden');
				$('.regdiv').addClass('hidden');
			}
			else {
				$('.welcome').addClass('hidden');
				$('.regdiv').removeClass('hidden');
			}
			
			// 显示下拉
			/*$('.nameHover').click(function() {
				if($('.userLinks').hasClass('hidden')) {
					$('.userLinks').removeClass('hidden');
				} else {
					$('.userLinks').addClass('hidden');				
				}
			});*/
			//jty--start
			$('.nameHover').hover(function(){
				if($('.userLinks').hasClass('hidden')) {
					$('.userLinks').removeClass('hidden');
				}
			});
			$('.userLinks').hover(null,function(){
				if(!$('.userLinks').hasClass('hidden'))
					$('.userLinks').addClass('hidden');	
			});
			$('body').click(function(){
				if(!$('.userLinks').hasClass('hidden'))
					$('.userLinks').addClass('hidden');	
			});
			//jty--end
			
			// 评论列表
			$('#myDiscuss').click(function() {
				location.href = path + '/blog/${accountId}/messageList?searchType=1';
			});
			
			// 赞
			$('#myPraise').click(function() {
				location.href = path + '/blog/${accountId}/praise';
			});
			
			// 个人首页
			$('.home').click(function() {
				location.href = path + '/blog/${accountId}';
			});
			
			// 退出登录
			$('.logout').click(function() {
// 				location.href = path;
				location.href = path + '/system/logout';
			});
			
			$('#myMessage').click(function() {
				location.href = path + '/blog/${accountId}/msgList';
			});
		});
	</script>
</html>