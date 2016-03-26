$(document).ready(function() {
	// 显示验证码
	function loadValidate() {
		$('#validate-img').attr('src', path + '/common/createCode?'+new Date().getTime());
	}
	
	loadValidate();
	
	// 刷新验证码
	$('#validate-img').click(function() {
		loadValidate();
	});
	
	// 校验验证码
	$('#validate').change(function() {
		var validate = $(this).val();
		if(validate.length >= 4) {
			$('.validate-error').hide();
			
			$.ajaxRequest({
				url: path + '/common/checkCode',
				async: false,
				data: {
					checkCode: validate
				},
				success: function(data) {
					if(!data.obj) {
						// 显示错误信息
						$('.validate-error').text('验证码错误!');
						$('.validate-error').show();
					}
				}
			});
		}
	});
	
	// 提交
	$('#forgetPwd').click(function() {
		// 隐藏所有的错误信息
		$('.error').hide();
		
		// 校验注册按钮是否可用
		var btnValid = $('p.get-sub-dis');
		if(btnValid.length > 0) {
			return;
		}
		
		var flag = false;
		
		// 校验账户
		var accountName = $('#accountName').val();
		if(accountName == null || accountName == '') {
			// 显示错误信息
			$('.accountName-error').text('请输入用户名/邮箱/手机！');
			$('.accountName-error').show();
			
			flag = true;
		}
		
		// 校验验证码
		var validate = $('#validate').val();
		if(validate == null || validate == '') {
			// 显示错误信息
			$('.validate-error').text('请输入验证码！');
			$('.validate-error').show();
			
			flag = true;
		} else {
			$.ajaxRequest({
				url: path + '/common/checkCode',
				async: false,
				data: {
					checkCode: validate
				},
				success: function(data) {
					if(!data.obj) {
						// 显示错误信息
						$('.validate-error').text('验证码错误!');
						$('.validate-error').show();
						
						flag = true;
					}
				}
			});
		}
		
		if(flag) {
			return;
		}
		
		var $this = $(this);
		$this.removeClass('get-sub');
		$this.addClass('get-sub-dis');
		
		$('#forgetForm').attr('action', path + '/system/account');
		
		// 表单提交
		$.ajaxFormSubmit({
			formId: 'forgetForm',
			success: function(data) {
				// 把字符串解析称JSON格式
				var result = data;
				if(typeof data === 'string') {
					result = eval('(' + data + ')');
				}
				
				if(result.code == 0) {
					// 显示错误信息
					$('.accountName-error').text(result.msg);
					$('.accountName-error').show();
					
					// 设置按钮可用
					$this.addClass('get-sub');
					$this.removeClass('get-sub-dis');
					
					loadValidate();
					return;
				}
				
				location.href = path + '/system/toValidate?id=' + result.obj.accountId;
			}
		});
	});
	
	// 发送邮件
	$('#sendMail').click(function() {
		$this = $(this);
		
		// 设置按钮可用
		$this.removeClass('get-sub');
		$this.addClass('get-sub-dis');
		
		$.ajaxRequest({
			url: path + '/system/sendValidateMail',
			type: 'post',
			data: {
				id: $('#accountId').val()
			},
			success: function(data) {
				alert('邮件发送成功!');
			}
		});
		
		time = 20;
		$this.html('<span>20秒后重新发送</span>');
		time--;
		
		interval =  setInterval("sendMailInterval()", 1000);
	});
	
	// 重置密码提交
	$('#resetPwd').click(function() {
		
		// 隐藏所有的错误信息
		$('.error').hide();
		
		// 校验注册按钮是否可用
		var btnValid = $('p.get-sub-dis');
		if(btnValid.length > 0) {
			return;
		}
		
		var flag = false;
		
		// 校验新密码
		var loginPassword = $('#loginPassword').val();
		if(loginPassword == null || loginPassword == '') {
			// 显示错误信息
			$('.loginPassword-error').text('请输入新密码!');
			$('.loginPassword-error').show();
			
			flag = true;
		}
		
		// 校验新密码
		var confirmPassword = $('#confirmPassword').val();
		if(confirmPassword == null || confirmPassword == '') {
			// 显示错误信息
			$('.confirmPassword-error').text('请输入确认新密码!');
			$('.confirmPassword-error').show();
			
			flag = true;
		} else {
			if(loginPassword != confirmPassword) {
				// 显示错误信息
				$('.confirmPassword-error').text('确认新密码与新密码不一致!');
				$('.confirmPassword-error').show();
				
				flag = true;
			}
		}
		
		if(flag) {
			return;
		}
		
		$this = $(this);
		
		// 设置按钮可用
		$this.removeClass('get-sub');
		$this.addClass('get-sub-dis');
		
		$('#resetPwdForm').attr('action', path + '/system/resetPwd');
		
		// 表单提交
		$.ajaxFormSubmit({
			formId: 'resetPwdForm',
			success: function(data) {
				// 把字符串解析称JSON格式
				var result = data;
				if(typeof data === 'string') {
					result = eval('(' + data + ')');
				}
				
				if(result.code == 0) {
					// 显示错误信息
					$('.loginPassword-error').text(result.msg);
					$('.loginPassword-error').show();
					
					// 设置按钮可用
					$this.addClass('get-sub');
					$this.removeClass('get-sub-dis');
					
					return;
				}
				
				location.href = path;
			}
		});
		
	});
});

var time = 20;
var interval = null;

function sendMailInterval() {
	$('#sendMail').html('<span>' + time + '秒后重新发送</span>');
	if(time == 0 && interval != null) {
		clearInterval(interval);
		$('#sendMail').addClass('get-sub');
		$('#sendMail').removeClass('get-sub-dis');
		$('#sendMail').html('<span>发送邮件</span>');
	}
	time--;
}