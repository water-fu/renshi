<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@page import="com.group.webFramework.uitl.SessionControl" %>
<%@page import="com.group.webFramework.entity.UserDetails" %>
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

<! DOCTYPE html>

<%
	UserDetails userDetails = SessionControl.getCurUserDetail(request);
	if(userDetails != null) {
		request.setAttribute("userId", userDetails.getAccountInfoBean().getAccountId());
	} else {
		request.setAttribute("userId", -1);
	}
%>

<style>
	.info-mess em {
		cursor: pointer;
	}
</style>

<div id="left-div">
	<div class="left-head">
		<ul>
			<li class="firstchild"><a href="${path}/blog/${personInfoBean.accountId}/interest.htm"><em>${personInfoBean.followNum}</em><span>关注</span></a></li>
			<li><a href="${path}/blog/${personInfoBean.accountId}/fans.htm"><em>${personInfoBean.fansNum}</em><span>粉丝</span></a></li>
			<li><a><em>${personInfoBean.browerNum}</em><span>浏览数</span></a></li>
		</ul>
	</div>
	<div class="con">
		<ul>
			<c:if test="${userId == personInfoBean.accountId}">
				<li id="home"><a href="javascript:void(0);" link="#"><img src="${imagePath}/person/c_page.png" alt=""><span>我的主页</span><em>&gt;</em></a></li>
				<li id="qa"><a href="javascript:void(0);" link="qa.htm"><img src="${imagePath}/person/c_hos.png" alt=""><span>我的医问</span><em>&gt;</em></a></li>
				<li id="share"><a href="javascript:void(0);" link="share.htm"><img src="${imagePath}/person/c_send.png" alt=""><span>我的作品</span><em>&gt;</em></a></li>
				<li id="achievement"><a href="javascript:void(0);" link="achievement.htm"><img src="${imagePath}/person/c_con.png" alt=""><span>我的成就</span><em>&gt;</em></a></li>
				<li id="about"><a href="javascript:void(0);" link="about.htm"><img src="${imagePath}/person/c_me.png" alt=""><span>关于我</span><em>&gt;</em></a></li>
			</c:if>
			<c:if test="${userId != personInfoBean.accountId}">
				<li id="home"><a href="javascript:void(0);" link="#"><img src="${imagePath}/person/c_page.png" alt=""><span>他的主页</span><em>&gt;</em></a></li>
				<li id="qa"><a href="javascript:void(0);" link="qa.htm"><img src="${imagePath}/person/c_hos.png" alt=""><span>他的医问</span><em>&gt;</em></a></li>
				<li id="share"><a href="javascript:void(0);" link="share.htm"><img src="${imagePath}/person/c_send.png" alt=""><span>他的作品</span><em>&gt;</em></a></li>
				<li id="achievement"><a href="javascript:void(0);" link="achievement.htm"><img src="${imagePath}/person/c_con.png" alt=""><span>他的成就</span><em>&gt;</em></a></li>
				<li id="about"><a href="javascript:void(0);" link="about.htm"><img src="${imagePath}/person/c_me.png" alt=""><span>关于他</span><em>&gt;</em></a></li>
			</c:if>
		</ul>
	</div>
	<c:if test="${userId == personInfoBean.accountId}">
		<div class="info-mess">
			<ul>
				<li>
					<img src="${imagePath}/person/dot.png" alt="">
					<a href="javascript:void(0);" class="msgList">私信</a>
					<em class="new-mess hidden"></em>
				</li>
				<li class="no-right">
					<img src="${imagePath}/person/dot.png" alt="">
					<a href="javascript:void(0);" class="messageList">评论</a>
					<em class="messageList hidden"></em>
				</li>
				<li>
					<img src="${imagePath}/person/dot.png" alt="">
					<a href="javascript:void(0);" class="collectList">收藏</a>
					<em class="collectList hidden"></em>
				</li>
				<li class="no-right">
					<img src="${imagePath}/person/dot.png" alt="">
					<a href="javascript:void(0);" class="praiseList">点赞</a>
					<em class="praiseList hidden"></em>
				</li>
				<li class="">
					<img src="${imagePath}/person/dot.png" alt="">
					<a href="javascript:void(0);" class="relatemeList">与我相关</a>
					<em class="relatemeList hidden"></em>
				</li>
			</ul>
		</div>
	</c:if>
</div>


<script type="text/javascript">
	$(document).ready(function() {
		var urlList = ['achievement', 'share', 'qa', 'about'];
		var tipList = ['messageList', 'collection', 'relateme', 'praise'];
		var urlPath = location.href;
		
		// 左侧菜单设置未选择
		$('.con li').removeClass('con-choice');
		
		var flag = true;
		
		for(var i = 0; i < urlList.length; i++) {
			if(urlPath.indexOf(urlList[i]) > 0) {
				$('li#' + urlList[i]).addClass('con-choice');
				var src = $('li#' + urlList[i] + ' img').attr('src');
				src = src.replace('c_', 'u_');
				$('li#' + urlList[i] + ' img').attr('src', src);
				
				flag = false;
				break;
			}
		}
		
		for(var i = 0; i < tipList.length; i++) {
			if(urlPath.indexOf(tipList[i]) > 0) {
				
				flag = false;
				break;
			}
		}
		
		if(flag) {
			// 默认选中我的空间
			$('li#home').addClass('con-choice');
			var src = $('li#home img').attr('src');
			src = src.replace('c_', 'u_');
			$('li#home img').attr('src', src);
		}
		
		// 左侧菜单单击事件
		$('.con li').each(function() {
			var $this = $(this);
			if($this.attr('id')) {
				$this.children('a').click(function() {
					location.href = path + '/blog/${personInfoBean.accountId}/' + $this.children('a').attr('link');
				});
			} else {
				$this.children('a').click(function() {
					alert('正在开发ing...');
				});
			}
		});
		
		$('.msgList').click(function() {
			location.href = path + '/blog/${personInfoBean.accountId}/msgList';
		});
		
		// 评论列表
		$('.messageList').click(function() {
			location.href = path + '/blog/${personInfoBean.accountId}/messageList?searchType=1';
		});
		
		// 收藏列表
		$('.collectList').click(function() {
			location.href = path + '/blog/${personInfoBean.accountId}/collection';
		});
		
		// 与我相关
		$('.relatemeList').click(function() {
			location.href = path + '/blog/${personInfoBean.accountId}/relateme';
		});
		
		// 赞
		$('.praiseList').click(function() {
			location.href = path + '/blog/${personInfoBean.accountId}/praise';
		});
	});
</script>