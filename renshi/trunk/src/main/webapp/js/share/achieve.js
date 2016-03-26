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
});