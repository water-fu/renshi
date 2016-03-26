$(document).ready(function() {
	
	// 点击"确定"查找医生
	$('#searchButton').click(function(){
		$.ajax({
			type: 'post',
			url: path + '/doctor/searchDoctors',
			data: $('#searchForm').formSerialize(),
			dataType: 'html',
			success: function (result) {
				$('.doctor-list').html(result);
			}
		});
		return false;
	});
	// 触发查询按钮
	  $('#searchButton').trigger('click');
	
	// 加载头像
	$('.know-img img').each(function() {
		var $this = $(this);
		
		$this.attr('src', path + '/common/showImage?imageUrl=' + $this.attr('link'));
	});
	
	// 关注
	$('.r-follow').click(function() {
		var $this = $(this);
		if($this.text() == '关注') {
			$.ajaxRequest({
				url: path + '/share/followActive',
				type: 'post',
				data: {
					accountId : $this.attr('val')
				},
				success: function(data) {
					$this.text('取消关注');
				}
			});
		} else {
			$.ajaxRequest({
				url: path + '/share/unFollowActive',
				type: 'post',
				data: {
					accountId : $this.attr('val')
				},
				success: function(data) {
					$this.text('关注');
				}
			});
		}
	});
	
	// 个人空间
	$('.r-blog').click(function() {
		var $this = $(this);
		location.href = path + '/blog/' + $this.attr('val');
	});
//	// 查询医院
//	$.ajaxRequest({
//		url: path + '/doctor/getHospitalInfo',
//		data: {
//			hospitalId: 1
//		},
//		success: function(data) {
//			$('#hospitalInfo').html('');
//			data = data.obj;
//			var $optionQ=$("<option>全部</option>");
//			$optionQ.attr('value',"");
//			$('#hospitalInfo').append($optionQ);
//			for(var i = 0; i < data.length; i++) {
//				var $option=$('<option>' + data[i].hospitalName + '</option>');
//				$option.attr('value', data[i].hospitalName);
//				$('#hospitalInfo').append($option);
//			}
//		}
//	});
	// 查询科室
	$.ajaxRequest({
		url: path + '/doctor/getDeptInfo',
		data: {
			hospitalId: 1
		},
		success: function(data) {
			$('#deptInfo').html('');
			data = data.obj;
			var $optionQ=$("<option>全部</option>");
			$optionQ.attr('value',"");
			$('#deptInfo').append($optionQ);
			for(var i = 0; i < data.length; i++) {
				var $option=$('<option>' + data[i].deptName + '</option>');
				$option.attr('value', data[i].deptName);
				$('#deptInfo').append($option);
			}
		}
	});
});