$(document).ready(function() {
	
	// 同意协议切换
	$('#agree').attr('checked', false);
	$('#agree').change(function() {
		if(!$(this).attr('checked')) {
			$('#second-btn').addClass('get-sub');
			$('#second-btn').removeClass('get-sub-dis');
			$('#agree').attr('checked', true);
		} else {
			$('#second-btn').addClass('get-sub-dis');
			$('#second-btn').removeClass('get-sub');
			$('#agree').attr('checked', false);
		}
	});
	
	// 点击上传证书
	$('.certificateCamera').click(function() {
		$('#certificateFile')[0].click();
	});
	
	// 证书上传  使用事件冒泡注册事件
	$('.certificateCamera').on('change', '#certificateFile', function() {
		$('#certificateSuc').show();
		$('#certificateSuc').text('上传中...');
		$('#certificateImg').hide();
		
		$.fileUpload({
			fileElementId: 'certificateFile',
			data: {
				storePath : cretificatePath
			},
			success: function(data) {
				var obj = data.obj[0];
				
				// 把头像路径设置到提交的input中
				$('#certificateUrl').val(obj);
				
				$('#certificateSuc').show();
				$('#certificateSuc').html('<img alt="" src="' + imagePath + '/doctor/success.png">上传成功');
				
				$('#certificateImg').show();
				$('#certificateImg a').attr('href', path + '/common/showImage?imageUrl=' + obj);
				
				//上传成功 隐藏错误
				$('.certificateUrl-error').hide();
			},
			failed: function(data) {
				$('.certificateUrl-error').show();
				$('.certificateUrl-error').text(data.msg);
			}
		});
	});
	
	// 点击上传身份证正面
	$('.frontCamera').click(function() {
		$('#frontFile')[0].click();
	});
	
	// 身份这个正面上传  使用事件冒泡注册事件
	$('.frontCamera').on('change', '#frontFile', function() {
		$('#frontSuc').text('上传中...');
		$('#frontSuc').show();
		$('#frontImg').hide();
		
		$.fileUpload({
			fileElementId: 'frontFile',
			data: {
				storePath : idCardPath
			},
			success: function(data) {
				var obj = data.obj[0];
				
				// 把头像路径设置到提交的input中
				$('#frontUrl').val(obj);
				
				$('#frontSuc').show();
				$('#frontSuc').html('<img alt="" src="' + imagePath + '/doctor/success.png">上传成功');
				
				$('#frontImg').show();
				$('#frontImg a').attr('href', path + '/common/showImage?imageUrl=' + obj);
				//上传成功  隐藏错误
				$('.frontUrl-error').hide();
			},
			failed: function(data) {
				$('.frontUrl-error').show();
				$('.frontUrl-error').text(data.msg);
			}
		});
	});
	
	// 点击上传身份证反面
	$('.backCamera').click(function() {
		$('#backFile')[0].click();
	});
	
	// 身份证反面上传  使用事件冒泡注册事件
	$('.backCamera').on('change', '#backFile', function() {
		$('#backSuc').text('上传中...');
		$('#backSuc').show();
		$('#backImg').hide();
		
		$.fileUpload({
			fileElementId: 'backFile',
			data: {
				storePath : idCardPath
			},
			success: function(data) {
				var obj = data.obj[0];
				
				// 把头像路径设置到提交的input中
				$('#backUrl').val(obj);
				
				$('#backSuc').html('<img alt="" src="' + imagePath + '/doctor/success.png">上传成功');
				$('#backSuc').show();
				
				$('#backImg').show();
				$('#backImg a').attr('href', path + '/common/showImage?imageUrl=' + obj);
				//上传成功  隐藏错误  如果第一次上传就成功 不会有错误显示 
				$('.backUrl-error').hide();
				
			},
			failed: function(data) {
				$('.backUrl-error').show();
				$('.backUrl-error').text(data.msg);
			}
		});
	});
	//证书编号失去焦点 进行验证
	$('#certificateNo').blur(function(){
		// 证书编号
		var certificateNo =$.trim( $('#certificateNo').val());
		if(certificateNo == '') {
			// 显示错误信息
			$('.certificateNo-error').show();
		}
		else
			$('.certificateNo-error').hide();
//		else if($.trim(certificateNo).length >= 50){
//			$('.certificateNo-error').show();
//			$('.certificateNo-error').text("证书编号超过长度");
//		}
	});
	//身份证号 失去焦点 进行 验证
    $('#idCard').blur(function(){
    	var idCard = $.trim($('#idCard').val());
		if(idCard == '') {
			// 显示错误信息
			$('.idCard-error').show();
			$('.idCard-error').text('请输入您的身份证号码!');
		} else if (!checkIdCard(idCard)) {
			// 显示错误信息
			$('.idCard-error').show();
			$('.idCard-error').text('请输入正确格式的身份证号码!');
		} else {
			$('.idCard-error').hide();
		}
	});
	
	// 提交按钮
	$('#second-btn').click(function() {
		// 隐藏所有的错误信息
		$('.error').hide();
		
		// 校验注册按钮是否可用
		var btnValid = $('p.get-sub-dis');
		if(btnValid.length > 0) {
			return;
		}
		
		// 第一个错误标签
		var $error = '';
		
		// 证书编号
		var certificateNo = $('#certificateNo').val();
		if(certificateNo == '') {
			// 显示错误信息
			$('.certificateNo-error').show();
			
			if($error == '') {
				$error = $('.certificateNo-error');
			}
		}
		
		// 证书URL
		var certificateUrl = $('#certificateUrl').val();
		if(certificateUrl == '') {
			// 显示错误信息
			$('.certificateUrl-error').show();
			$('.certificateUrl-error').text('请上传您的证书!');
			
			if($error == '') {
				$error = $('.certificateUrl-error');
			}
		}
		
		// 身份证编号
		var idCard = $('#idCard').val();
		if(idCard == '') {
			// 显示错误信息
			$('.idCard-error').show();
			$('.idCard-error').text('请输入您的身份证号码!');
			
			if($error == '') {
				$error = $('.idCard-error');
			}
		} else if (!checkIdCard(idCard)) {
			// 显示错误信息
			$('.idCard-error').show();
			$('.idCard-error').text('请输入正确格式的身份证号码!');
			
			if($error == '') {
				$error = $('.idCard-error');
			}
		}
		
		// 身份证正面
		var frontUrl = $('#frontUrl').val();
		if(frontUrl == '') {
			// 显示错误信息
			$('.frontUrl-error').show();
			$('.frontUrl-error').text('请上传您的身份证正面照!');
			
			if($error == '') {
				$error = $('.frontUrl-error');
			}
		}
		
		// 身份证反面
		var backUrl = $('#backUrl').val();
		if(backUrl == '') {
			// 显示错误信息
			$('.backUrl-error').show();
			$('.backUrl-error').text('请上传您的身份证反面照!');
			
			if($error == '') {
				$error = $('.backUrl-error');
			}
		}
		
		// 有错误
		if($error != '') {
			// 定位
			var height = ($error.position().top - 15) > 0 ? ($error.position().top - 15) : 0;
			//$('body').scrollTop(height);//不是标准写法
			$(document).scrollTop(height);//或者为$(window).scrollTop(height);
			return;
		}
		
		// 提交
		
		$('#authInfoForm').attr('action', path+'/doctor/authInfo');
		// 设置按钮不可用
		$this = $(this);
		
		$this.removeClass('get-sub');
		$this.addClass('get-sub-dis');
		
		// 表单提交
		$.ajaxFormSubmit({
			formId: 'authInfoForm',
			success: function(data) {
				// 把字符串解析称JSON格式
				var result = data;
				if(typeof data === 'string') {
					result = eval('(' + data + ')');
				}
				
				if(result.code == 0) {
					alert(result.msg);
					
					// 设置按钮可用
					$this.addClass('get-sub');
					$this.removeClass('get-sub-dis');
					return;
				}
				
				location.href = path + '/doctor/toApprove?id=' + data.obj.accountId;
			}
		});
	});
});

function checkIdCard(str) {
	var reg = /^(\d{15}$|^\d{18}$|^\d{17}(\d|X|x))$/;
	
	if(reg.test(str)) {
		return true;
	} else {
		return false;
	}
}