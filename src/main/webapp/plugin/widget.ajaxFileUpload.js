;(function($) {
	// 异步上传文件
	$.fileUpload = function(opti) {
		var option = {
			url: path + '/common/ajaxFileUpload', //用于文件上传的服务器端请求地址
			secureuri: false, //是否需要安全协议，一般设置为false
			fileElementId: '', //文件上传域的ID
			dataType: 'json', //返回值类型 一般设置为json
			data: { // storePath必填参数
				storePath : ''
			},    // 传递到后台的参数
			allowExt : ['.PNG', '.GIF', '.JPG', '.JPEG'], // 上传文件允许的格式, 必须要大写,默认允许图片
			success: function(data, status) { // 服务器响应成功处理函数
				
			},
			error: function (data, status, e) //服务器响应失败处理函数 
	        {
	            alert(e);
	        }
		};
		
		$.extend(option, opti);
		
		if(option.fileElementId == null || option.fileElementId == '') {
			alert('请选择关联文件上传域');
			return;
		}
		
		var uploadEle = $('#' + option.fileElementId);
		
		// 校验是否有文件
		if(!uploadEle.val()) {
			alert('请选择文件');
			return;
		}
		
		// 校验文件后缀是否合法
		var allowed = uploadEle.fileExtendVal({'extArr': option.allowExt});
		if(!allowed) {
			alert('上传的文件不合法,请上传[' + option.allowExt + ']的文件');
			return;
		}
		
		// 上传成功后执行成功回调函数
		option.success = function(data, status) {
			if(typeof data === 'string') {
				data = eval('(' + data + ')');
			}
			
			if(data.code == 0) {
				if(opti.failed) {
					opti.failed(data, status);
				}
				return;
			} else if (data.code == 1) {
				if(opti.success) {
					opti.success(data, status);
				}
			}
		};
		
		// 上传文件
		$.ajaxFileUpload(option);
	};
	
	// 校验后缀是否允许
	$.fn.fileExtendVal = function(opti) {
		var option = {
			extArr: []
		};
		var $this = this, this_ = $this[0];
		var filepath = $this.val();
		var extStart = filepath.lastIndexOf(".");
		var ext = filepath.substring(extStart,filepath.length).toUpperCase();

		$.extend(option, opti);
		
		if(ext != '' && $.inArray(ext, option.extArr) == -1){
			$this.val('');
			return false;
		}
		return true;
	};
})(jQuery);