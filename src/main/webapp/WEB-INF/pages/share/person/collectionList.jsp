<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/pages/common/include.jsp"%>
<!DOCTYPE html>
<c:forEach items="${pageQueryResult.list}" var="shareInfo">
	<div class="infos-list">
		<div class="send-list">
			<div class="list-logo">
				<a href="${path}/blog/${shareInfo.accountId}">
				<img class="headerimg" src="" link="${shareInfo.headUrl}" 
				              alt="${shareInfo.realName}"></a>
			</div>
			<div class="list-content">
				<h3 class="doc-intro">
				  <a href="${path}/blog/${shareInfo.accountId}">
				         <em class="name">${shareInfo.realName}</em></a>
				  <span class="sci">${shareInfo.belongDept}</span>
				  <span class="doc">${shareInfo.workProfess}</span>
				</h3>
				<h3 class="title">
				   <a href="${path}/blog/content/${shareInfo.shareId}">"
				            <em>${shareInfo.shareTitle}</em>"</a>
				</h3>
				<p>${shareInfo.shareDesc}</p>
								
				<ul id="attach_${shareInfo.shareId}" val="${shareInfo.shareId}"></ul>
								
			    <div class="time">
				  <span class="time-left"><span class="send-time">${shareInfo.publicDate}</span>发布的<em class="point">${shareInfo.shareTypeName}</em></span>
			      <span class="time-right">收藏于<span class="collect-time"><fmt:formatDate value="${shareInfo.collectionDate}" pattern="MM-dd HH:mm" /> </span></span>
			   </div>
		  </div>
		</div>
		<ul class="fun">
			<li><a href="${path}/blog/content/${shareInfo.shareId}">浏览(<em>${shareInfo.readNum}</em>)</a></li>
				<%-- isPraise：1为未收藏，0为收藏 --%>
							<c:if test="${shareInfo.isPraise == 1}">
								<li><a href="javascript:void(0);" val="${shareInfo.shareId}" type="1" num="${shareInfo.likeNum}" class="praise">赞(<em>${shareInfo.likeNum}</em>)</a></li>
							</c:if>
							<c:if test="${shareInfo.isPraise == 0}">
								<li><a href="javascript:void(0);" val="${shareInfo.shareId}" type="-1" num="${shareInfo.likeNum}" class="praise">赞(<em>${shareInfo.likeNum}</em>)</a></li>
							</c:if>
							
							<li><a href="${path}/blog/content/${shareInfo.shareId}">评论(<em>${shareInfo.commentNum}</em>)</a></li>
							
							<%-- type：1为收藏，-1为取消收藏 --%>
							<li><a href="javascript:void(0);" val="${shareInfo.shareId}" type="-1" class="collection">取消收藏(<em>${shareInfo.collectionNum}</em>)</a></li>
						</ul>
					</div>
				</c:forEach>
	<%@ include file="/WEB-INF/pages/common/page.jsp" %>
<script type="text/javascript">
    var accountId = '${personInfoBean.accountId}';
	function getPageData(pageNo) {
		var params = $('#queryForm').formSerialize() + '&pageNo=' + pageNo;
		var url=path+"/blog/collectionForSearch";
		$.ajax({
			type : 'post',
			url : url,
			data : params,
			dataType : 'html',
			success : function(result) {
				$('.infos').html(result);
			}
		});
	}
	$(document).ready(function(){
		// 加载头像
		$('.list-logo img').each(function() {
			var $this = $(this);
			$this.attr('src', path + '/common/showImage?imageUrl=' + $this.attr('link'));
		});
		// 加载附件
		$('.list-content ul[id^="attach"]').each(function() {
			var $this = $(this);
			$.ajaxRequest({
				url: path + '/blog/getShareAttach',
				data: {
					shareId: $this.attr('val')
				},
				success: function(data) {
					data = data.obj;
					for(var i = 0; i < data.length; i++) {
						var $li = $('<li>'), $a = $('<a>'), $img = $('<img>');
						$img.attr('alt', '');
						if(data[i].attachType == 1) {
							$img.attr('src', path + '/common/showImage?imageUrl=' + data[i].attachUrl);
							$a.append($img);
						} else if (data[i].attachType == 2) {
							$a.html(data[i].attachName);
							$a.attr('href', path + '/common/downFile?fileUrl=' + data[i].attachUrl + '&fileName=' + data[i].attachName);
							$li.css({'width': 500, 'height': 20});
						} else if (data[i].attachType == 3) {
							$img.attr('src', path + '/images/person/play.jpg');
							$a.append($img);
						}
						$li.append($a);
					}
					
					
					$this.append($li);
				}
			});
		});
		// 收藏按钮点击
		$('.collection').click(function() {
			var $this = $(this);
			// 取消收藏
			$.ajaxRequest({
				url: path + '/blog/delCollection',
				type: 'post',
				data: {
					shareId: $this.attr('val')
				},
				success: function() {
					// 隐藏取消收藏的分享
					$this.parents('.infos-list').hide();
					//重新加载   收藏的 记录 
					//保留  当搜索框里 有数据时   点击 取消收藏 ，
					//假如这是搜索出的记录中的最后一条  此时 应该 重新加载所有？还是保持原样 ？  
					// $('#collectTitle').val('');
					var params = $('#queryForm').formSerialize() + '&pageNo=1';
					var url=path+"/blog/collectionForSearch";
					$.ajax({
						type : 'post',
						url : url,
						data : params,
						dataType : 'html',
						success : function(result) {
							$('.infos').html(result);
						}
					});
				}
			});
		});
		
		// 点赞
		$('.praise').click(function() {
			var $this = $(this);
			
			if($this.attr('type') == 1) {
				$.ajaxRequest({
					url: path + '/blog/addPraise',
					type: 'post',
					data: {
						shareId: $this.attr('val')
					},
					success: function() {
						var num = parseInt($this.attr('num'));
						$this.text('\u8D5E(' + (num + 1) + ')');
						$this.attr('type', -1);
						$this.attr('num', num + 1);
					}
				});
			} else {
				$.ajaxRequest({
					url: path + '/blog/delPraise',
					type: 'post',
					data: {
						shareId: $this.attr('val')
					},
					success: function() {
						var num = parseInt($this.attr('num'));
						$this.text('\u8D5E(' + (num - 1) + ')');
						$this.attr('type', 1);
						$this.attr('num', num - 1);
					}
				});
			}
		});
	});
</script>
