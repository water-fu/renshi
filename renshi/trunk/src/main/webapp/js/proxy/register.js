
$(document).ready(function(){

	var tip = {
		accnull: '您输入的账号为空!',
		accerror: '您输入的账号已经注册!',
		emailerror: '您输入的邮箱不正确!',
		phoneerror: '您输入的电话号码不正确!',
		
		valnull: '输入验证码',
		valerror: '验证码错误',
		
		passnull: '您输入的密码为空!',
		passneq: '您输入的密码错误!'
	};

	// 验证邮箱
	function checkEmail(str){
		// 域名小写
		var reg = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([a-z\d]+[-.])+[a-z]{2,5}$/;
		if(reg.test(str)){
			return "1";
		}else{
			return "0";
		}
	}

	// 验证电话
	function checkPhone(str){
		var reg = /^1\d{10}$/ ;

		if(reg.test(str)){
			return "1" ;
		}else{
			return "0" ;
		}
	}

	// 单击错误DIV触发事件
	$('div.tiperror').on('click', function() {
		var tipId = $(this).attr('id');
		var inputId = tipId.split('-')[0];
		
		var $input = $('#'+inputId);
		
		$(this).addClass('hidden');
		$input.focus();
		
		$input.parent('p').removeClass('default-error');
		
		rebackImage($input);
	});
	
	// 用户名失去焦点
	$('#useraccount').blur(function(){
		var useraccount = $(this).val();

		// 要见邮箱或手机
		var emailtest = checkEmail(useraccount);
		var phonetest = checkPhone(useraccount);

		// 标记用户名是否输入正确
		var flag = false;
		
		if(useraccount === null || useraccount === ''){
			
			$('#useraccount-tiperror').css({
				'margin-top': '8px'
			}).removeClass('hidden');
			
			$('#useraccount-tiperror span').text(tip.accnull);
			
			$(this).parent('p').addClass('default-error');
			backImage($(this));
			
		} else if(emailtest === '0' && phonetest === '0') {
			
			$('#useraccount-tiperror').css({
				'margin-top': '8px'
			}).removeClass('hidden');
			
			$('#useraccount-tiperror span').text(tip.emailerror);
			
			$(this).parent('p').addClass('default-error');
			backImage($(this));
			
		} else if(emailtest === '0' &&  phonetest === '1') {
			// 电话
			$('#valiate-img').addClass('hidden');
			$('.get-valiate').addClass('hidden');
			
			$('.get-message').removeClass('hidden');
			
			flag = true;
			
		} else if(emailtest === '1' && phonetest === '0') {
			// 邮箱
			$('#valiate-img').removeClass('hidden');
			$('.get-valiate').removeClass('hidden');
			
			$('.get-message').addClass('hidden');
			
			flag = true;
		}
		
		if(flag) {
			// 异步校验用户是否存在
			$.ajaxRequest({
				url: path + '/system/validAccName',
				data: {
					name: useraccount
				},
				success: function(data) {
					if(data.obj == false) {
						$('#useraccount-tiperror').css({
							'margin-top': '8px'
						}).removeClass('hidden');
						
						$('#useraccount-tiperror span').text(tip.accerror);
						
						$('#useraccount').parent('p').addClass('default-error');
						
						backImage($('#useraccount'));
					}
				}
			});
		}
	});
	
	// 用户名获得焦点
	$('#useraccount').focus(function(){
		$('#useraccount-tiperror').addClass('hidden');
		$(this).parent('p').removeClass('default-error');
		rebackImage($(this));
	});
	
	// 校验密码
	$('#password').blur(function() {
		var pwd = $(this).val();
		
		if(pwd === null || pwd === '') {
			$('#password-tiperror').css({
				'margin-top': '8px'
			}).removeClass('hidden');
			
			$('#password-tiperror span').text(tip.passnull);
			
			$(this).parent('p').addClass('default-error');

			backImage($(this));
		} else {
			$('#password-tiperror').addClass('hidden');
			
			// 密码重新输入后，校验确认密码是否相同
			var comfirmPwd = $('#comfirmPwd').val();
			if(pwd === comfirmPwd) {
				$('#comfirmPwd-tiperror').addClass('hidden');
				$('#comfirmPwd').parent('p').removeClass('default-error');
				
				rebackImage($(this));
			}
		}
	});
	
	// 密码获得焦点
	$("#password").focus(function() {
		$('#password-tiperror').addClass('hidden');
		$(this).parent('p').removeClass('default-error');
		
		rebackImage($(this));
	});
	
	// 校验密码
	$('#comfirmPwd').blur(function() {
		var comfirmPwd = $(this).val();
		var pwd = $('#password').val();
		
		if(comfirmPwd === null || comfirmPwd === '') {
			$('#comfirmPwd-tiperror').css({
				'margin-top': '8px'
			}).removeClass('hidden');
			
			$('#comfirmPwd-tiperror span').text(tip.passnull);
			
			$(this).parent('p').addClass('default-error');

			backImage($(this));
		} else if (comfirmPwd != pwd) {
			$('#comfirmPwd-tiperror').css({
				'margin-top': '8px'
			}).removeClass('hidden');
			
			$('#comfirmPwd-tiperror span').text(tip.passneq);
			
			$(this).parent('p').addClass('default-error');

			backImage($(this));
		} else {
			$('#password-tiperror').addClass('hidden');
		}
	});
	
	// 密码获得焦点
	$("#comfirmPwd").focus(function() {
		$('#comfirmPwd-tiperror').addClass('hidden');
		$(this).parent('p').removeClass('default-error');
		
		rebackImage($(this));
	});
	
	// 校验密码
	$('#validate').blur(function() {
		var validate = $(this).val();
		
		if(validate === null || validate === '') {
			$('#validate-tiperror').css({
				'margin-top': '8px'
			}).removeClass('hidden');
			
			$('#validate-tiperror span').text(tip.valnull);
			
			$(this).parent('p').addClass('default-error');

			backImage($(this));
		} else {
			$('#validate-tiperror').addClass('hidden');
			
			$.ajaxRequest({
				url: path + '/common/checkCode',
				data: {
					checkCode: validate
				},
				success: function(data) {
					if(!data.obj) {
						$('#validate-tiperror').css({
							'margin-top': '8px'
						}).removeClass('hidden');
						
						$('#validate-tiperror span').text(tip.valerror);
						
						$('#validate').parent('p').addClass('default-error');

						backImage($('#validate'));
					}
				}
			});
		}
	});
	
	// 密码获得焦点
	$("#validate").focus(function() {
		$('#validate-tiperror').addClass('hidden');
		$(this).parent('p').removeClass('default-error');
		
		rebackImage($(this));
	});

	// 恢复输入框小图标
	function rebackImage(el){
		var imgsrc = $(el).siblings("img").attr("src");
		var imgarr = imgsrc.split("/");
		var imgname = (imgarr[imgarr.length-1]).split(".");

		if(imgname[0].indexOf("error") > 0){
			imgname = imgname[0].substr(0,4);
		}else{
			return false;
		}
		var newimgname = imgname+".png";
		var newpath = "";
		for(var i=0;i<imgarr.length-1;i++){
			newpath = newpath + imgarr[i]+"/";
		}
		newpath = newpath+newimgname;
		$(el).siblings("img").attr("src",newpath);
	}
	
	// 输入框小图标变成错误图标
	function backImage(el) {
		var imgsrc = $(el).siblings("img").attr("src");
		var imgarr = imgsrc.split("/");
		var imgname = (imgarr[imgarr.length-1]).split(".");
		var newimgname = imgname[0]+"error."+imgname[1];
		var newpath = "";

		for(var i=0;i<imgarr.length-1;i++){
			newpath = newpath + imgarr[i]+"/";
		}
		newpath = newpath+newimgname;
		$(el).siblings("img").attr("src",newpath);
	}
	
	// 注册
	$('#register').click(function() {
		// 校验注册按钮是否可用
		var btnValid = $('p.get-sub-dis');
		if(btnValid.length > 0) {
			return;
		}
		
		// 校验所有输入框是否合法
		$('#useraccount').focus();
		$('#password').focus();
		$('#comfirmPwd').focus();
		$('#validate').focus();
		
		$('#validate').blur();
		
		// 错误信息，如果有错误信息，则不提交
		var errorInput = $("p[class='default default-error']");
		if(errorInput.length > 0) {
			return;
		} else {
			// 提交表单
			$('#registerForm').attr('action', path + '/proxy/register');
			
			var $this = $(this);
			// 设置按钮灰色
			$this.removeClass('get-sub');
			$this.addClass('get-sub-dis');
			
			$.ajaxFormSubmit({
				formId: 'registerForm',
				success: function(data) {
					// 把字符串解析称JSON格式
					var result = data;
					if(typeof data === 'string') {
						result = eval('(' + data + ')');
					}
					
					if(result.code == 0) {
						alert(result.msg);
						// 设置按钮灰色
						$this.addClass('get-sub');
						$this.removeClass('get-sub-dis');
						return;
					}
					
					location.href = path + '/system/activePage?id=' + data.obj.accountId;
				}
			});
		}
	});
	
	// 加载验证码
	loadValidate();
	
	// 重新加载验证码
	$('.get-valiate').click(function() {
		loadValidate();
	});
	
	function loadValidate() {
		$('#valiate-img').attr('src', path + '/common/createCode?'+new Date().getTime());
	}
	
	// 设置所有tiperror的宽度
	$('.tiperror').each(function() {
		var id = $(this).attr('id');
		var inputId = id.split('-')[0];
		var $input = $('#'+inputId);
		$(this).css('width', $input.width()-4);
	});
	
	// 跳转登录界面
	$('#toLogin').click(function() {
		location.href = path;
	});
});
