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
	
	// 加载内容
	loadContent(accountId);
	
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
		css: {'min-width': '110px', 'margin-left' : '-20px'},
		choose: function(el) {
			$('#searchTypeInput').text(el.html());
			$('#searchType').val(el.attr('value'));
			
			$('#infos_Content').html('');
			// 异步加载分享内容
			loadContent(accountId);
		}
	});
	
	// 分享类型切换
	$('.status-part span').click(function() {
		// 移除所有span的class=choice
		$('.status-part span').removeClass('choice');
		$(this).addClass('choice');
		//alert($('.title-right a.title-choice').attr('val'));
		// 切换数据
		loadContent(accountId, $(this).attr('val'),$('.title-right a.title-choice').attr('val'));
	});
	//
	$('.title-right a').click(function(){
		$('.title-right a').removeClass('title-choice');
		$(this).addClass('title-choice');
		//alert('title:'+$('.status-part span.choice').attr("val"));
		loadContent(accountId, $('.status-part span.choice').attr('val'),$(this).attr('val'));
	});
	// 分享类型筛选
	$('.nav-detail').click(function() {
		// 切换数据   时间上设置为全部  没有限制 
		//alert("detail---"+$(this).attr('val'));
		loadContent(accountId, $(this).attr('val'));
	});
	function loadContent(accountId, shareType,shareTime) {
		//alert(shareTime);
		shareType = shareType || -1;
		shareTime = shareTime || -1;
		// 异步加载分享内容
		$.ajaxRequest({
			url: path + '/blog/getContent',
			dataType: 'html',
			data: {
				accountId : accountId,
				searchType: $('#searchType').val(),
				shareType: shareType,
				shareTime: shareTime
			},
			success: function(data) {
				$('#infos_Content').html(data);
			}
		});
	}
});