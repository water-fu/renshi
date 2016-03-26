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
	
	// 异步加载分享内容
	$.ajaxRequest({
		url: path + '/blog/getContent',
		dataType: 'html',
		data: {
			accountId : accountId,
			searchType: 3, // 代表医问
			shareType: 5
		},
		success: function(data) {
			$('#infos_Content').html(data);
		}
	});
});