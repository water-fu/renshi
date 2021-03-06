<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<! DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/pages/common/include.jsp" %>

<html>
<head>
	<meta charset="GBK">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>个人主页</title>
	<link rel="stylesheet" href="${cssPath}/person/personspace.css">
</head>
<body>
		<%@ include file="/WEB-INF/pages/common/header.jsp" %>
		
		<!-- scroll start -->
		<div class="scroll">
			
		</div>
		<!-- scroll end -->
		
		<!-- content start -->
		<div class="content">
			<div class="con-left">
				<div class="intro-manager">
					<p><img src="${imagePath}/person/mana.png" alt=""><a href="${path}/doctor/toBasicInfo?id=${personInfoBean.accountId}">进入用户管理中心</a></p>
				</div>
				<div class="hot">
					<p class="title">我的热门作品</p>
					<div class="hot-list" id="hot-list">
						
					</div>
				</div>
			</div>
			<div class="con-right">
				<div class="con-nav">
					<p class="title">
						<em class="title-left">我的贡献</em>
						<em class="title-right">
							<a href="#"  val='-1' class="title-choice ">全部</a>
							<a href="#" val='1'>近一个月</a>
							<a href="#" val='2'>近一周</a>
						</em>
					</p>
					<ul>
						<li><a href="javascript:void(0);" class="nav-detail" val="1"><img src="${imagePath}/person/vedio.png" alt=""><span>视频(<em>${personInfoBean.videoNum}</em>)</span></a><a href="${path}/blog/publishVideo" class="nav-send">发布</a></li>
						<li><a href="javascript:void(0);" class="nav-detail" val="2"><img src="${imagePath}/person/point.png" alt=""><span>观点(<em>${personInfoBean.articleNum}</em>)</span></a><a href="${path}/blog/publishPoint" class="nav-send">发布</a></li>
						<li><a href="javascript:void(0);" class="nav-detail" val="3"><img src="${imagePath}/person/case.png" alt=""><span>病例(<em>${personInfoBean.caseNum}</em>)</span></a><a href="${path}/blog/publishCase" class="nav-send">发布</a></li>
						<li><a href="javascript:void(0);" class="nav-detail" val="4"><img src="${imagePath}/person/file.png" alt=""><span>文档(<em>${personInfoBean.courseNum}</em>)</span></a><a href="${path}/blog/publishLibrary" class="nav-send">发布</a></li>
						<li><a href="javascript:void(0);" class="nav-detail" val="5"><img src="${imagePath}/person/ask.png" alt=""><span>提问(<em>${personInfoBean.qaNum}</em>)</span></a><a href="${path}/blog/publishQuestion" class="nav-send">发布</a></li>
						<li class="hidden"><a href="#" class="nav-detail"><img src="${imagePath}/person/answer.png" alt=""><span>回答(<em></em>)</span></a><a href="#" class="nav-send">发布</a></li>
					</ul>
				</div>
				<div class="status">
					<div class="status-select">
						<span id="searchTypeInput">全部动态</span>
						<input id="searchType" value="1" type="hidden" />
						<ul id="searchTypeSelect" style="display: none">
							<li value="1">全部动态</li>
							<li value="2">我关注的动态</li>
							<li value="3">我的动态</li>
						</ul>
					</div>
					<div class="status-part">
						<span val="-1" class="choice">全部</span>
						<span val="1"><a>视频</a></span>
						<span val="2"><a>观点</a></span>
						<span val="3"><a>病例</a></span>
						<span val="4"><a>文档</a></span>
						<span val="5"><a>提问</a></span>
					</div>
				</div>

				<!--- -->
				<div class="infos" id="infos_Content">
				
				</div>
				<!--  -->
			</div>

		</div>
		<!-- content end -->
		
		<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
</body>
<script type="text/javascript">
	var accountId = '${personInfoBean.accountId}';
</script>
<script type="text/javascript" src="${jsPlugin}/widget.select.js"></script>
<script type="text/javascript" src="${jsPath}/share/person.js"></script>
</html>