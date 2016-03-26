$(document).ready(function() {
	// 加载医问医答内容
	$.ajaxRequest({
		url: path + '/blog/newAskAnswer',
		dataType: 'html',
		data: {
			type : 1
		},
		success: function(data) {
			$('.list-answer').html(data);
		}
	});
	
	$('#newAsk').click(function() {
		$('.answer-choice a').removeClass('color-green');
		$(this).addClass('color-green');
		
		// 加载医问医答内容
		$.ajaxRequest({
			url: path + '/blog/newAskAnswer',
			dataType: 'html',
			data: {
				type : 1
			},
			success: function(data) {
				$('.list-answer').html(data);
			}
		});
	});
	
	$('#hotAsk').click(function() {
		$('.answer-choice a').removeClass('color-green');
		$(this).addClass('color-green');
		
		// 加载医问医答内容
		$.ajaxRequest({
			url: path + '/blog/hotAskAnswer',
			dataType: 'html',
			data: {
				type : 2
			},
			success: function(data) {
				$('.list-answer').html(data);
			}
		});
	});
	
	$('#noAsk').click(function() {
		$('.answer-choice a').removeClass('color-green');
		$(this).addClass('color-green');
		
		// 加载医问医答内容
		$.ajaxRequest({
			url: path + '/blog/noAskAnswer',
			dataType: 'html',
			data: {
				type : 3
			},
			success: function(data) {
				$('.list-answer').html(data);
			}
		});
	});
	
	// 加载头像
	$('.e-img img').each(function() {
		var $this = $(this);
		$this.attr('src', path + '/common/showImage?imageUrl=' + $this.attr('link'));
	});
	
	$('.e-img, .e-name').click(function() {
		location.href = path + '/blog/' + $(this).attr('val');
	});
});
