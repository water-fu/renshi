$(document).ready(function() {
	
	// 设置出生日期
	var year = $('#year').val(), month = $('#month').val(), day = $('#day').val();
	$('#personBirth').val(year + '-' + month + '-' + day);
	
	// 设置现居地址
	var country = $('#country').val(), province = $('#province').val(), city = $('#city').val();
	$('#liveTown').val(country + ',' + province + ',' + city);
	
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
			},
			failed: function(data) {
				$('.backUrl-error').show();
				$('.backUrl-error').text(data.msg);
			}
		});
	});
	
	// 代理商身份切换
	$('input:radio[name="proxyType"]').change(function() {
		var $this = $(this);
		// 企业
		if($this.val() == 1) {
			$('#companyBaseDiv').removeClass('hidden');
			$('#personBaseDiv').addClass('hidden');
			
			$('#companyDiv').removeClass('hidden');
			$('#personDiv').addClass('hidden');
		} 
		// 个人
		else if ($this.val() == 2) {
			$('#personBaseDiv').removeClass('hidden');
			$('#companyBaseDiv').addClass('hidden');
			
			$('#personDiv').removeClass('hidden');
			$('#companyDiv').addClass('hidden');
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
		
		var proxyType = $('input:radio[name=proxyType]:checked').val();
		
		// 第一个错误标签
		var $error = '';
		
		// 公司名称
		var proxyTarget = '';
		$('input[name=proxyTarget]:checked').each(function() {
			proxyTarget = $(this).val();
		});
		if(proxyTarget == '') {
			// 显示错误信息
			$('.proxyTarget-error').show();
			
			if($error == '') {
				$error = $('#check1');
			}
		}
		
		// 公司
		if(proxyType == 1) {
			
			// 公司名称
			var companyName = $('#companyName').val();
			if(companyName == '') {
				// 显示错误信息
				$('.companyName-error').show();
				
				if($error == '') {
					$error = $('#companyName');
				}
			}
			
			// 公司简介
			var companyInfro = $('#companyInfro').val();
			if(companyInfro == '') {
				// 显示错误信息
				$('.companyInfro-error').show();
				
				if($error == '') {
					$error = $('#companyInfro');
				}
			}
			
			// 联系人姓名
			var realName1 = $('#realName1').val();
			if(realName1 == '') {
				// 显示错误信息
				$('.realName1-error').show();
				
				if($error == '') {
					$error = $('#realName1');
				}
			}
			
			// 证书编号
			var certificateNo = $('#certificateNo').val();
			if(certificateNo == '') {
				// 显示错误信息
				$('.certificateNo-error').show();
				
				if($error == '') {
					$error = $('#certificateNo');
				}
			}
			
			// 证书URL
			var certificateUrl = $('#certificateUrl').val();
			if(certificateUrl == '') {
				// 显示错误信息
				$('.certificateUrl-error').show();
				$('.certificateUrl-error').text('请上传您的证书!');
				
				if($error == '') {
					$error = $('.certificateCamera');
				}
			}
		}
		// 个人
		else if (proxyType == 2) {
			// 个人真实姓名
			var realName2 = $('#realName2').val();
			if(realName2 == '') {
				// 显示错误信息
				$('.realName2-error').show();
				
				if($error == '') {
					$error = $('#realName2');
				}
			}
			
			// 公司简介
			var personInfro = $('#personInfro').val();
			if(personInfro == '') {
				// 显示错误信息
				$('.personInfro-error').show();
				
				if($error == '') {
					$error = $('#personInfro');
				}
			}
			
			// 身份证编号
			var idCard = $('#idCard').val();
			if(idCard == '') {
				// 显示错误信息
				$('.idCard-error').show();
				$('.idCard-error').text('请输入您的身份证号码!');
				
				if($error == '') {
					$error = $('#idCard');
				}
			} else if (!checkIdCard(idCard)) {
				// 显示错误信息
				$('.idCard-error').show();
				$('.idCard-error').text('请输入正确格式的身份证号码!');
				
				if($error == '') {
					$error = $('#idCard');
				}
			}
			
			// 身份证正面
			var frontUrl = $('#frontUrl').val();
			if(frontUrl == '') {
				// 显示错误信息
				$('.frontUrl-error').show();
				$('.frontUrl-error').text('请上传您的身份证正面照!');
				
				if($error == '') {
					$error = $('#frontCamera');
				}
			}
			
			// 身份证反面
			var backUrl = $('#backUrl').val();
			if(backUrl == '') {
				// 显示错误信息
				$('.backUrl-error').show();
				$('.backUrl-error').text('请上传您的身份证反面照!');
				
				if($error == '') {
					$error = $('#backCamera');
				}
			}
		}
		
		// 手机号码
		var phoneNo = $('#phoneNo').val();
		if(phoneNo == '') {
			// 显示错误信息
			$('.phoneNo-error').show();
			
			if($error == '') {
				$error = $('#phoneNo');
			}
		}
		
		// 有错误
		if($error != '') {
			// 定位
			var height = ($error.position().top - 15) > 0 ? ($error.position().top - 15) : 0;
			$('body').scrollTop(height);
			return;
		}
		
		// 提交
		
		$('#authInfoForm').attr('action', path + '/proxy/authInfo');
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
				
				location.href = path + '/proxy/toApprove?id=' + data.obj.accountId;
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