<%@page import="com.group.renshi.bean.share.ShareInfoBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/pages/common/include.jsp" %>

<%
	String headUrl = SessionControl.getOperInfo(request).getHeadUrl();
	request.setAttribute("headUrl", headUrl);
	
	ShareInfoBean shareInfoBean = (ShareInfoBean) request.getAttribute("shareInfoBean");
	if(shareInfoBean.getShareTag() != null && !"".equals(shareInfoBean.getShareTag())) {
		String[] tags = shareInfoBean.getShareTag().split(",");
		request.setAttribute("tags", tags);
	}
%>

<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>文库-详情页</title>
	<link rel="stylesheet" href="${cssPath}/common/layout.css">
	<link rel="stylesheet" href="${cssPath}/common/font.css">
	<link rel="stylesheet" href="${cssPath}/common/color.css">
	<link rel="stylesheet" href="${cssPath}/library/librarydetail.css">
	<link rel="stylesheet" href="${cssPath}/common/common.css">
</head>
<body>
<%@ include file="/WEB-INF/pages/common/header.jsp" %>
		<!-- scroll start -->
		<div class="top hidden">
			<div class="nav"><img src="${imagePath}/answer/logo.jpg" alt=""> </div>
		</div>
		
		<div class="scroll">
		
		</div>
		<!-- scroll end -->
		<input type="hidden" id="shareId" value="${shareInfoBean.shareId}" />
		
		<div class="answ-detail">
			<div class="detail-title mar-com">
				<strong class="f-left">${shareInfoBean.shareTitle}</strong>
				<ul class="f-right">
					<li><span>${shareInfoBean.commentNum}</span><em>评论</em></li>
					<li><span>${shareInfoBean.readNum}</span><em>浏览</em></li>
				</ul>
			</div>
			<div class="detail-time mar-com">
				<p><a href="${path}/blog/${shareInfoBean.accountId}"><strong>${shareInfoBean.realName}</strong></a><span>发布于<em><fmt:formatDate value="${shareInfoBean.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></em>的文库</span></p>
			</div>
			<div class="detail-content mar-com">${shareInfoBean.shareDesc}</div>
			
			<ul class="detail-img attach1" val="${shareInfoBean.shareId}">
			</ul>
			
			<div class="line"></div>
			<div class="detai-fun mar-com">
				<div class="f-left fun-left">
					<div class="detail-left f-left">
						<a href="javascript:void(0);" num="${shareInfoBean.likeNum}" class="praise" title="点赞">
							<img id="praiseImg"src="${imagePath}/publish/zan.png" alt="点赞">
							<span id="praiseCount">${shareInfoBean.likeNum}</span>
						</a>
						<a href="javascript:void(0);" num="${shareInfoBean.collectionNum}" class="collection" title="收藏">
							<img src="${imagePath}/publish/shou.png" alt="收藏">
							<span id="collectionCount">${shareInfoBean.collectionNum}</span>
						</a>
						<a href="javascript:void(0)" title="转载" class="shareWith">
						<img src="${imagePath}/common/fenxiang.png" alt="">0</a>
					</div>
					
					<div class="detail-re f-right hidden"
					style="background:url(${imagePath}/common/fenxiangkuang.png) no-repeat;">
						<a href="javascript:void(0)"><img src="${imagePath}/publish/img1.png" alt=""></a>
						<a href="javascript:void(0)"><img src="${imagePath}/publish/img2.png" alt=""></a>
						<a href="javascript:void(0)"><img src="${imagePath}/publish/img3.png" alt=""></a>
						<a href="javascript:void(0)"><img src="${imagePath}/publish/img4.png" alt=""></a>
					</div>
				</div>
				<div class="f-right">
					<p>标签：
						<c:forEach items="${tags}" var="tag">
							<span>${tag}</span>
						</c:forEach>
					</p>
				</div>
			</div>
		</div>
		<!-- content start -->
		<div class="content">
			<div class="con-left f-left">
				<div class="detail-com">
					<div class="com-logo f-left"><img class="headerimg" src="" link="${headUrl}" alt=""></div>
					<div class="com-text">
						<textarea name="" id="commentTxt" cols="30" rows="5" maxlength="100" placeholder="回复@${shareInfoBean.realName}"></textarea>
						<p><span class="no-com hidden">取消</span><a href="javascript:void(0);" id="commentBtn"><span>发布</span></a></p>
					</div>
				</div>
				<div class="all-com">
					<div class="com-list">
					
					</div>
				</div>
			</div>
			<div class="con-right f-right">
				<div class="inter-case">
					<h4>您可能感兴趣的文库</h4>
					<div class="case-list">
					<div class="case-list" id="case_infos_Content"> 
					  <!--  <input type='hidden' id="searchType" value='1'/>所有 -->
					   <input type='hidden' id="shareType" value='4'/><!-- 视频-->
			        </div>
						<!-- <div class="case-list-content">
							<div class="f-left"><img src="#" alt=""></div>
							<div class="f-right">
								<p class="case-desc"><em>[骨科]</em>开放性骨折的治疗原则与方法</p>
								<p class="case-name"><span class="t-left">浏览:<em>233</em></span><span class="t-right">由<em>卡戴珊</em>发布</span></p>	
							</div>
						</div>
						<div class="case-list-content">
							<div class="f-left"><img src="#" alt=""></div>
							<div class="f-right">
								<p class="case-desc"><em>[骨科]</em>开放性骨折的治疗原则与方法</p>
								<p class="case-name"><span class="t-left">浏览:<em>233</em></span><span class="t-right">由<em>卡戴珊</em>发布</span></p>	
							</div>
						</div>

						<div class="case-list-content">
							<div class="f-left"><img src="#" alt=""></div>
							<div class="f-right">
								<p class="case-desc"><em>[骨科]</em>开放性骨折的治疗原则与方法</p>
								<p class="case-name"><span class="t-left">浏览:<em>233</em></span><span class="t-right">由<em>卡戴珊</em>发布</span></p>	
							</div>
						</div>

						<div class="case-list-content">
							<div class="f-left"><img src="#" alt=""></div>
							<div class="f-right">
								<p class="case-desc"><em>[骨科]</em>开放性骨折的治疗原则与方法</p>
								<p class="case-name"><span class="t-left">浏览:<em>233</em></span><span class="t-right">由<em>卡戴珊</em>发布</span></p>	
							</div>
						</div>
						<div class="case-list-content">
							<div class="f-left"><img src="#" alt=""></div>
							<div class="f-right">
								<p class="case-desc"><em>[骨科]</em>开放性骨折的治疗原则与方法</p>
								<p class="case-name"><span class="t-left">浏览:<em>233</em></span><span class="t-right">由<em>卡戴珊</em>发布</span></p>	
							</div>
						</div>

						<div class="case-list-content">
							<div class="f-left"><img src="#" alt=""></div>
							<div class="f-right">
								<p class="case-desc"><em>[骨科]</em>开放性骨折的治疗原则与方法</p>
								<p class="case-name"><span class="t-left">浏览:<em>233</em></span><span class="t-right">由<em>卡戴珊</em>发布</span></p>	
							</div>
						</div> -->

						
					</div>
				</div>
				<div class="a-meet hidden">
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
<script type="text/javascript">
	var belongDept = ' ${shareInfoBean.belongDept}';
</script>
<script type="text/javascript">
	$(document).ready(function() {
		//鼠标经过 【转载】 显示微信等的图标 
		  $('.shareWith').hover(function(){
			   $('.detail-re').removeClass("hidden");
		   });
		//鼠标离开微信等图标  微信等图标就消失 
		   $('.detail-re img').hover(null,function(){
			   $('.detail-re').addClass("hidden");
		   });
		 //单击任何空白的部分  都会让微信等图标消失 
			$('body').click(function(){
				$('.detail-re').addClass("hidden");
			});
		//加载  你可能感兴趣的文库
		$.ajaxRequest({
			url: path + '/blog/getContentForDetail',
			dataType: 'html',
			type:'post',
			data: {
				belongDept : belongDept,
				shareType:  $('#shareType').val()
			},
			success: function(data) {
				$('#case_infos_Content').html(data);
			}
		});
		
		// 加载附件
		$('.attach1').each(function() {
			var $this = $(this);
			$.ajaxRequest({
				url: path + '/blog/getShareAttach',
				data: {
					shareId: $this.attr('val')
				},
				success: function(data) {
					data = data.obj;
					for(var i = 0; i < data.length; i++) {
						var $li = $('<li>'), $a = $('<a>');
						$a.html(data[i].attachName);
						$a.attr('href', path + '/common/downFile?fileUrl=' + data[i].attachUrl + '&fileName=' + data[i].attachName);
						$li.append($a);
						
						$this.append($li);
					}
				}
			});
		});
		
		// 加载头像
		$('.com-logo img').each(function() {
			var $this = $(this);
			$this.attr('src', path + '/common/showImage?imageUrl=' + $this.attr('link'));
		});
		
		// 加载医问医答评论
		$.ajaxRequest({
			url: path + '/blog/askComment',
			dataType: 'html',
			data: {
				id: '${shareInfoBean.shareId}'
			},
			success: function(data) {
				$('.com-list').html(data);
			}
		});
		
		// 加载头部信息
		$.ajaxRequest({
			url: path + '/blog/getScroll',
			dataType: 'html',
			data: {
				accountId : '${shareInfoBean.accountId}'	
			},
			success: function(data) {
				$('.scroll').html(data);
			}
		});
		
		$('#commentBtn').click(function() {
			var content = $('#commentTxt').val();
			if(content == '') {
				alert('请填写评论');
				return;
			}
			
			$.ajaxRequest({
				url: path + '/blog/addDiscuss',
				type: 'post',
				data: {
					shareId: '${shareInfoBean.shareId}',
					accountName: '${shareInfoBean.realName}',
					accountId: '${shareInfoBean.accountId}',
					parentId: 0,
					discussContent: content,
					discussType: 1 // 表示评论
				},
				success: function() {
					// 加载医问医答评论
					$.ajaxRequest({
						url: path + '/blog/askComment',
						dataType: 'html',
						data: {
							id: '${shareInfoBean.shareId}'
						},
						success: function(data) {
							$('.com-list').html(data);
						}
					});
					
					$('#commentTxt').val('');
				}
			});
		});
		
		// 收藏按钮点击
		$('.collection').click(function() {
			var $this = $(this);
			// 收藏
			$.ajaxRequest({
				url: path + '/blog/addCollection2',
				type: 'post',
				data: {
					shareId: '${shareInfoBean.shareId}'
				},
				success: function(data) {
					var num = parseInt($this.attr('num'));
					
					if(data.obj == 1) {
						$('#collectionCount').text(num+1);
						$this.attr('num', num + 1);
					} else if (data.obj == -1) {
						$('#collectionCount').text(num-1);
						$this.attr('num', num - 1);
					}
				}
			});
		});
		
		 //初始化是否 图片   已经点赞则显示 取消赞的图片  
		$.ajaxRequest({
			url: path + '/blog/addPraise3',
			type: 'post',
			data: {
				shareId: '${shareInfoBean.shareId}'
			},
			success: function(data) {
				if(data.obj == (-1)) {
					//未点赞
					$('#praiseImg').attr('src',"${imagePath}/publish/cczan.png");
					$('#praiseImg').attr('alt',"取消赞");
				}
			}
		});
		// 点赞
		$('.praise').click(function() {
			var $this = $(this);
			
			$.ajaxRequest({
				url: path + '/blog/addPraise2',
				type: 'post',
				data: {
					shareId: '${shareInfoBean.shareId}'
				},
				success: function(data) {
					var num = parseInt($this.attr('num'));
					
					if(data.obj == 1) {
						$('#praiseImg').attr('src',"${imagePath}/publish/cczan.png");
						$('#praiseImg').attr('alt',"取消赞");
						$('#praiseCount').text(num+1);
						$this.attr('num', num + 1);
						
					} else {
						$('#praiseImg').attr('src',"${imagePath}/publish/zan.png");
						$('#praiseImg').attr('alt',"点赞");
						$('#praiseCount').text(num-1);
						$this.attr('num', num - 1);
					}
				}
			});
		});
	});
</script>
</html>