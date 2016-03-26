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
	
	// 搜索类型下拉列表
	$('#searchTypeInput').select({
		targetId: 'searchTypeSelect',
		css: {'min-width': '110px', 'margin-left' : '-25px'},
		choose: function(el) {
			$('#searchTypeInput').text(el.html());
			$('#searchType').val(el.attr('value'));
			
			// 异步加载评论信息
		}
	});
	
	// 加载头像
	$('.message-left img').each(function() {
		var $this = $(this);
		$this.attr('src', path + '/common/showImage?imageUrl=' + $this.attr('link'));
	});
	
	// 加载头像
	$('.answer-content img').each(function() {
		var $this = $(this);
		$this.attr('src', path + '/common/showImage?imageUrl=' + $this.attr('link'));
	});
	
	// 点击回复
	$('.operate-self a, .operate-other a').click(function() {
		var $this = $(this), answerDiv = $this.parent().next('.operate-answer');
		if(answerDiv.hasClass('hidden')) {
			answerDiv.removeClass('hidden');
		} else {
			answerDiv.addClass('hidden');
		}
	});
	
	// 点击评论
	$('.answer-submit em').click(function() {
		var $this = $(this).parent();
		var content = $this.prev('.answer-content').children('textarea').val();
		
		var inputs = $this.nextAll('input');
		
		$.ajaxRequest({
			url: path + '/blog/addDiscuss',
			type: 'post',
			data: {
				shareId: $(inputs[0]).val(),
				accountName: $(inputs[1]).val(),
				accountId: $(inputs[2]).val(),
				parentId: $(inputs[3]).val(),
				discussContent: content,
				discussType: 2 // 表示评论
			},
			success: function(data) {
				$this.parent().addClass('hidden');
				alert("回复成功");
				$this.prev('.answer-content').children('textarea').val('');
			}
		});
	});
});