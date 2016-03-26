$(document).ready(function() {

    // 按关注时间排序
    $('#queryByFollowTime').click(function(){
        $("#queryCondition").val("queryByFollowTime");
        //出发首次加载
        firstQuery();
        return false;
    });

    // 按粉丝数量排序
    $('#queryByFansNum').click(function(){
        $('#queryCondition').val('queryByFansNum');
        //出发首次加载
        firstQuery();
        return false;
    });

    // 触发按关注时间排序
    $('#queryByFollowTime').trigger('click');

    //按下回车键 触发查找粉丝事件
    $('#search_value').keypress(function(event) {
		if (event.keyCode == 13) {
			$('#fans_search').trigger('click');
		}
	});
	
    //根据粉丝姓名进行精确查找
    $('#fans_search').click(function(){ 
        var name = $('#search_value').val().trim();
        //alert("searchFanName");
        $('#fansName').val(name);
        queryWitnName();
        return false;
    });
    //按下回车键 触发查找关注的人事件
    $('#concern_value').keypress(function(event) {
		if (event.keyCode == 13) {
			$('#concern_search').trigger('click');
		}
	});
    //根据姓名精确查找关注的人
    $('#concern_search').click(function(){ 
        var name = $('#concern_value').val().trim();
        //alert("searchConName");
        $('#concernName').val(name);
        queryWitnName();
        return false;
    });
    function queryWitnName(){
        var param = $('#queryForm').formSerialize() + '&pageNo=1';
        var isFanOrInterest = $('#isFanOrInterest').val();
        var url = path + '';
        if(isFanOrInterest == 'fans'){
            url = url + '/blog/pagefansWithName';
        }else if(isFanOrInterest == 'interests'){
            url = url + '/blog/pageInteWithName';
        }
        $.ajax({
            type: 'post',
            url: url,
            data: param,
            dataType: 'html',
            success: function (result) {
                $('.message-list').html(result);
            }
        });
    }
    

    
    function firstQuery(){
        var param = $('#queryForm').formSerialize() + '&pageNo=1';
        var isFanOrInterest = $('#isFanOrInterest').val();
        var url = path + '';
        if(isFanOrInterest == 'fans'){
            url = url + '/blog/pagefans';
        }else if(isFanOrInterest == 'interests'){
            url = url + '/blog/pageInterests';
        }
        $.ajax({
            type: 'get',
            url: url,
            data: param,
            dataType: 'html',
            success: function (result) {
                $('.message-list').html(result);
            }
        });
    }
});