;(function($) {
	
	// 统一Ajax请求调用
	$.ajaxRequest = function(opti) {
		var option = {
			url: '',
			type: 'get',
			async: true,
			dataType: 'json',
			data: {
				
			},
			success: function(data, textStatus, jqXHR) {
				
			},
			error: function(jqXHR, textStatus, errorThrown) {
				if(jqXHR.readyState == 4 && jqXHR.responseText && textStatus == 'parsererror') {
					location.href = path;
				} else {
					alert('系统异常,请联系系统管理员');
				}
			}
		};
		
		$.extend(option, opti);
		
		// 调用返回处理
		option.success = function(data, textStatus, jqXHR) {
			if(option.dataType == 'json') {
				try{
					if(typeof data === 'string') {
						data = eval('(' + data + ')');
					}
					
					if(data.code == 0) {
						alert(data.msg);
					}
					else if(data.code == 1) {
						if(opti.success) {
							opti.success(data);
						}
					}
				} catch(e) {
					alert(data);
				}
			} else if(option.dataType == 'html') {
				if(opti.success) {
					try{
						if(typeof data === 'string') {
							data = eval('(' + data + ')');
						}
						
						if(data.code == 0) {
							alert(data.msg);
						}
					} catch(e) {
						opti.success(data);
					}
				}
			}
		};
		
		// ajax请求
		$.ajax(option);
	};
	
})(jQuery);