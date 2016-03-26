<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/pages/common/include.jsp" %>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>医问医答-话题列表页</title>
	<link rel="stylesheet" href="${cssPath}/common/layout.css">
	<link rel="stylesheet" href="${cssPath}/common/font.css">
	<link rel="stylesheet" href="${cssPath}/common/color.css">
	<link rel="stylesheet" href="${cssPath}/askanswer/asklist.css">
</head>
<body> 
<%@ include file="/WEB-INF/pages/common/header.jsp" %>
		<!-- scroll start -->
		<div class="top">
			<div class="nav"><img src="#" alt=""> </div>
		</div>
		<!-- scroll end -->
		
		<!-- content start -->
		<div class="content">
			<div class="con-left f-left">
				<!-- <div class="scroll">
					<p class="color-999"><em class="color-green">推荐医问</em><em></em>有问题？同行来帮您！</p>
					<div class="scroll-layout">
						<img src="#" alt="">
					</div>
				</div> -->
				<div class="con-list">
					<div class="con-head">
						<div class="f-left">
							<span class="title">医问列表</span>
							<select>
								<option>骨科</option>
							</select>
						</div>
						<div class="f-right answer-choice">
							<a class="color-green" href="#">最新发表</a>
							<a href="#">最热参与</a>
							<a href="#">未回答</a>
						</div>
					</div>
					<div class="list-answer">
						<div class="list-answer-content">
							<p class="list-title"><em>互联网医疗</em></p>
							<ul>
								<li><a href="#">骨质疏松性椎体压缩骨折椎体成形术有成形术有年龄年龄...?</a></li>
								<li><a href="#">骨质疏松性椎体压缩骨折椎体成形术成形术有年龄有年龄...?</a></li>
								<li><a href="#">骨质疏松性椎体压缩骨折椎体成形术成形术有年龄有年龄...?</a></li>
								<li><a href="#">骨质疏松性椎体压缩骨折椎体成形成形术有年龄术有年龄...?</a></li>
							</ul>
							<p class="list-topic"><em>关注话题</em></p>
						</div>
						<div class="list-answer-content">
							<p class="list-title"><em>互联网医疗</em></p>
							<ul>
								<li><a href="#">骨质疏松性椎体压缩骨折椎体成形术有年龄成形术有年龄...?</a></li>
								<li><a href="#">骨质疏松性椎体压缩骨折椎体成成形术有年龄形术有年龄...?</a></li>
								<li><a href="#">骨质疏松性椎体压缩骨折椎体成成形术有年龄形术有年龄...?</a></li>
								<li><a href="#">骨质疏松性椎体压缩骨折椎体成成形术有年龄形术有年龄...?</a></li>
							</ul>
							<p class="list-topic"><em>关注话题</em></p>
						</div>
						<div class="list-answer-content">
							<p class="list-title"><em>互联网医疗</em></p>
							<ul>
								<li><a href="#">骨质疏松性椎体压缩骨折椎体成形术有年龄成形术有年龄...?</a></li>
								<li><a href="#">骨质疏松性椎体压缩骨折椎体成成形术有年龄形术有年龄...?</a></li>
								<li><a href="#">骨质疏松性椎体压缩骨折椎体成成形术有年龄形术有年龄...?</a></li>
								<li><a href="#">骨质疏松性椎体压缩骨折椎体成成形术有年龄形术有年龄...?</a></li>
							</ul>
							<p class="list-topic"><em>关注话题</em></p>
						</div>
						<div class="list-answer-content">
							<p class="list-title"><em>互联网医疗</em></p>
							<ul>
								<li><a href="#">骨质疏松性椎体压缩骨折椎体成形术有年龄成形术有年龄...?</a></li>
								<li><a href="#">骨质疏松性椎体压缩骨折椎体成成形术有年龄形术有年龄...?</a></li>
								<li><a href="#">骨质疏松性椎体压缩骨折椎体成成形术有年龄形术有年龄...?</a></li>
								<li><a href="#">骨质疏松性椎体压缩骨折椎体成成形术有年龄形术有年龄...?</a></li>
							</ul>
							<p class="list-topic"><em>关注话题</em></p>
						</div>
						<div class="list-answer-content">
							<p class="list-title"><em>互联网医疗</em></p>
							<ul>
								<li><a href="#">骨质疏松性椎体压缩骨折椎体成形术有年龄成形术有年龄...?</a></li>
								<li><a href="#">骨质疏松性椎体压缩骨折椎体成成形术有年龄形术有年龄...?</a></li>
								<li><a href="#">骨质疏松性椎体压缩骨折椎体成成形术有年龄形术有年龄...?</a></li>
								<li><a href="#">骨质疏松性椎体压缩骨折椎体成成形术有年龄形术有年龄...?</a></li>
							</ul>
							<p class="list-topic"><em>关注话题</em></p>
						</div>
					</div>
				</div>
			</div>
			<div class="con-right f-right">
				<p class="a-search"><input type="text" value="" placeholder="搜索"><img src="#" alt=""></p>
				<!-- <p class="a-publish"><a href="#"><i>#</i>发布提问 </a> </p> -->
				<div class="a-new-attend">
					<h4>最新参与</h4>
					<div class="new-list">
						<div class="new-list-content">
							<p class="new-com-title">
								<em class="new-name">大卫李</em>刚回答了<em>Maya</em>的问题:
							</p>
							<p class="new-com-content">[<em>骨科</em>]开放性骨折的治疗原则与方法原则与方法？</p>	
						</div>
						<div class="new-list-content">
							<p class="new-com-title">
								<em class="new-name">大卫李</em>刚回答了<em>Maya</em>的问题:
							</p>
							<p class="new-com-content">[<em>骨科</em>]开放性骨折的治疗原则与方法原则与方法？</p>	
						</div>
					</div>
				</div>

				<div class="a-expert">
					<h4>最权威的专家</h4>
					<div class="expert-list">
						<div class="expert-list-content">
							<div class="e-img f-left"><img src="#" alt=""></div>
							<div class="e-desc">
								<p class="e-name"><em>Maya</em><span>骨科</span><span>主任医师</span></p>
								<p class="e-que"><span><em>17777</em>问题</span><span><em>222</em>关注</span></p>
							</div>
						</div>
						<div class="expert-list-content">
							<div class="e-img f-left"><img src="#" alt=""></div>
							<div class="e-desc">
								<p class="e-name"><em>Maya</em><span>骨科</span><span>主任医师</span></p>
								<p class="e-que"><span><em>17777</em>问题</span><span><em>222</em>关注</span></p>
							</div>
						</div>
					</div>
				</div>
				<div class="a-topic">
					<h4>最热门的话题</h4>
					<div class="topic-list">
						<div class="topic-list-content">
							<p class="topic-title"><em>互联网医疗</em></p>
							<p class="topic-desc"><span><em>1376</em>个问题</span><span><em>316</em>人关注</span></p>
						</div>
						<div class="topic-list-content">
							<p class="topic-title"><em>互联网医疗</em></p>
							<p class="topic-desc"><span><em>1376</em>个问题</span><span><em>316</em>人关注</span></p>
						</div>
					</div>
					<p class="topic-more">查看更多&gt;</p>
				</div>

				<div class="a-meet">
					<img src="#" alt="">
				</div>
				<div class="a-ad">
					ad
				</div>
			</div>
		</div>
		<!-- content end -->
		<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
</body>
</html>