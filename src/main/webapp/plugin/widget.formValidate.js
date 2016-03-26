;(function($) {
	
	// 表单校验
	$.fn.formValidate = function(opti) {
		
		var option = {
			focusInvalid: false,
			onkeyup: false,
			rules: {
				
			},
			messages: {
				
			},
			submitSuccess: function(data) { // 提交成功后，执行的方法
				
			},
			errorPlacement: function(error, element) {
				// 异常信息显示
				
				var _el = $(element[0]);
				var _lb = $(error[0]);
				
				var elName = _el.attr('name');
				$('#' + elName + '-mask').remove();
				
				if(_lb.html()) {
					var div = $('<div>'+ _lb.html() +'</div>');
					div.attr('id', elName + '-mask');
					div.addClass('mask');
					div.css('width', _el.width());
					div.css('height', _el.height());
					div.css('top', _el.position().top + 2);
					div.css('left', _el.position().left + 2);
					_el.after(div);
					
					div.click(function() {
						this.remove();
						_el.focus();
					});
				}
			}
//			success: function() {
//			}
		};
		
		$.extend(option, opti);
		
		var _this = this;
		
		// 分析异常处理
		option.submitSuccess = function(data) {
			// 把字符串解析称JSON格式
			var result = data;
			if(typeof data === 'string') {
				result = eval('(' + data + ')');
			}
			
			if(result.code == 0) {
				alert(result.msg);
				return;
			}
			
			// 如果有自定义的方法，则执行自定义方法
			if(opti.submitSuccess) {
				opti.submitSuccess(result);
			}
		};
		
		// 设置校验成功后提交的方法
		$.validator.setDefaults({
			submitHandler: function(form) {
				$.ajaxFormSubmit({
					formId: $(form).attr('id'),
					success: option.submitSuccess
				});
			}
		});
		
		// 表单提交
		var validation = _this.validate(option);
		
		return validation;
	};
	
	// 清除校验内容
	$.resetValidation = function(validation) {
		validation.resetForm();
		$('[id$=mask]').remove();
	};
})(jQuery);