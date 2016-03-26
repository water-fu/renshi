<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/pages/common/include.jsp" %>

<%
	String headUrl = SessionControl.getCurUserDetail(request).getAccountInfoBean().getHeadUrl();
	request.setAttribute("headUrl", headUrl);
	request.setAttribute("selfId", SessionControl.getOpId(request));
%>

<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>私信展开对话</title>
	<link rel="stylesheet" href="${cssPath}/person/messageDialog.css">
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
				<div class="ad">
					广告推送
				</div>
			</div>
			<div class="con-right">
				
				<div class="status">
					<div class="status-select hidden">
						<a href="#">&lt;-</a>
					</div>
					<div class="mess-who"><span>与<em>${userInfoBean.realName}</em>对话中</span></div>
					<div class="status-part hidden">
						<select class="font-14">
							<option>私信设置</option>
						</select>
					</div>
				</div>

				<!--- -->
				<div class="message">
					<p class="message-more"><span class="color-green font-12 hidden">查看更多消息</span></p>
					<div class="message-dialog">
					
						<c:forEach items="${list}" var="msgContent">
							<c:if test="${msgContent.accountId == selfId}">
								<div class="dialog-self dialog-common">
									<div class="dialog-message">
										<p class="d-mess">${msgContent.msgContent}</p>
										<p class="d-img"><img src="" link="${headUrl}"></p>
									</div>
									<div class="dialog-time">
										<p><span><fmt:formatDate value="${msgContent.sendDate}" pattern="MM月dd HH:mm"/></span></p>
										<div class="dotted-line"></div>
									</div>
								</div>
							</c:if>
							
							<c:if test="${msgContent.accountId != selfId}">
								<div class="dialog-other dialog-common">
									<div class="dialog-message">
										<p class="d-img"><img src="" link="${accountInfoBean.headUrl}"></p>
										<p class="d-mess">${msgContent.msgContent}</p>
									</div>
									<div class="dialog-time">
										<p><span><fmt:formatDate value="${msgContent.sendDate}" pattern="MM月dd HH:mm"/></span></p>
										<div class="dotted-line"></div>
									</div>
								</div>
							</c:if>
						</c:forEach>

					</div>

					<div class="message-answer">
						<div class="answer-text"><textarea placeholder="请输入内容" maxlength="100" id="content"></textarea></div>
						<p class="submit" id="sendMsg" style="cursor: pointer;"><span>发送</span></p>
					</div>
					
				</div>
				<!--  -->
			</div>
			
		</div>
		<!-- content end -->
		<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
</body>
<script type="text/javascript">
	var accountId = '${personInfoBean.accountId}';

	$(document).ready(function() {
		// 加载头部信息
		$.ajaxRequest({
			url: path + '/blog/getScroll',
			dataType: 'html',
			data: {
				accountId : accountId
			},
			success: function(data) {
				$('.scroll').html(data);
			}
		});
		
		// 加载左侧个人信息
		$.ajaxRequest({
			url: path + '/blog/getPersonLeftCon',
			dataType: 'html',
			data: {
				accountId : accountId
			},
			success: function(data) {
				$('.con-left').prepend(data);
			}
		});
		
		// 加载热门作品
		$.ajaxRequest({
			url: path + '/blog/getHotList',
			dataType: 'html',
			data: {
				accountId : accountId
			},
			success: function(data) {
				$('#hot-list').html(data);
			}
		});
		
		// 加载头像
		$('.d-img img').each(function() {
			$(this).attr('src', path + '/common/showImage?imageUrl=' + $(this).attr('link'));
		});
		
		$('#sendMsg').click(function() {
			// 加载热门作品
			$.ajaxRequest({
				url: path + '/blog/addMsgContent',
				type: 'post',
				data: {
					accountId : accountId,
					msgId: '${msgInfoBean.msgId}',
					msgContent: $('#content').val()
				},
				success: function(data) {
					location.reload();
				}
			});
		});
	});
</script>
</html>