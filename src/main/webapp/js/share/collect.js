$(document).ready(function() {
	//点击  收藏加载的首页显示。
	query();
	
	
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
	
	
	//按下回车键 触发搜索收藏记录   事件
    $('#collect_value').keypress(function(event) {
		if (event.keyCode == 13) {
			$('#collect_search').trigger('click');
		}
	});
    //根据标题模糊搜索收藏记录  事件
    $('#collect_search').click(function(){ 
        var title = $('#collect_value').val().trim();
        $('#collectTitle').val(title);
         query();
        return false;
    });
    function query() {
    	 var param = $('#queryForm').formSerialize() + '&pageNo=1';
    	  var url=path+"/blog/collectionForSearch";
          $.ajax({
              type: 'post',
              url: url,
              data:param,
              dataType: 'html',
              success: function (result) {
                  $('.infos').html(result);
              }
          });
    	
    };
});