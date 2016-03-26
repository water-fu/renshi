$(document).ready(function(){
	
	var tip = {
		accnull: '您输入的账号为空!',
		accerror: '您输入的账号不正确!',
		
		passnull: '您输入的密码为空!',
	};
	
	// 记住密码默认不选中
	$('#checkUser').attr('checked', false);
	
	// 判断是否有cookie
	var accountCookie = $.cookie('/renshi');
	if(accountCookie) {
		$('#useraccount').val(accountCookie);
		$('#checkUser').attr('checked', true);
	}
	
	$('#checkUser').change(function() {
		if(!$(this).attr('checked')) {
			$('#checkUser').attr('checked', true);
		} else {
			$('#checkUser').attr('checked', false);
		}
	});
	

	// 验证邮箱
	function checkEmail(str){
		var reg = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/ ;
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
//			return "1" ;
		}else{
			return "0" ;
		}
		
		return "0";
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
			
			$('#useraccount-tiperror span').text(tip.accerror);
			
			$(this).parent('p').addClass('default-error');
			backImage($(this));
			
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
		}
	});
	
	// 密码获得焦点
	$("#password").focus(function() {
		$('#password-tiperror').addClass('hidden');
		$(this).parent('p').removeClass('default-error');
		
		rebackImage($(this));
	});
	
	$('#password').keypress(function(event) {
		if (event.keyCode == 13) {
			$('#login').trigger('click');
		}
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
	
	// 登录
	$('#login').click(function() {
		// 校验注册按钮是否可用
		var btnValid = $('p.get-sub-dis');
		if(btnValid.length > 0) {
			return;
		}
		
		// 校验所有输入框是否合法
		$('#useraccount').focus();
		$('#password').focus();
		
		$('#password').blur();
		
		// 错误信息，如果有错误信息，则不提交
		var errorInput = $("p[class='default default-error']");
		if(errorInput.length > 0) {
			return;
		} else {
			// 提交表单
			$('#loginForm').attr('action', path + '/system/login');
			
			var $this = $(this);
			// 设置按钮灰色
			$this.removeClass('get-sub');
			$this.addClass('get-sub-dis');
			
			$.ajaxFormSubmit({
				formId: 'loginForm',
				success: function(data) {
					// 把字符串解析称JSON格式
					var result = data;
					if(typeof data === 'string') {
						result = eval('(' + data + ')');
					}
					
					if(result.code == 0) {
						// 登录错误信息显示
						$('#useraccount-tiperror').css({
							'margin-top': '8px'
						}).removeClass('hidden');
						
						$('#useraccount-tiperror span').text(result.msg);
						
						$('#useraccount').parent('p').addClass('default-error');
						backImage($('#useraccount'));
						
						// 设置按钮灰色
						$this.addClass('get-sub');
						$this.removeClass('get-sub-dis');
						
						return;
					}
					
					// 设置记住用户名cookie
					var checkUser = $('#checkUser').attr('checked');
					// 记住
					if(checkUser) {
						// 有效期7天的cookie
						$.cookie('/renshi', data.obj.loginAccount, { expires: 7 });
					}
					// 不记住
					else {
						// 删除 cookie
						$.cookie('/renshi', '', { expires: -1 });
					}
					
					location.href = path + '/blog/' + data.obj.accountId;
					
//					var index = location.href.indexOf(path);
//					var realPath = location.href.substring(index);
//					if(path == '' || realPath == path || realPath == path + '/' 
//							|| realPath == path + '/system/logout' || realPath == path + '/system/logout/') {
//						location.href = path + '/blog/' + data.obj.accountId;
//					} else {
//						location.reload();
//					}
				}
			});
		}
	});
	
	// 设置所有tiperror的宽度
	$('.tiperror').each(function() {
		var id = $(this).attr('id');
		var inputId = id.split('-')[0];
		var $input = $('#'+inputId);
		$(this).css('width', $input.width()-4);
	});
	
	// 注册
	$('#toRegister').click(function() {
		location.href = path + '/system/registerPage';
	});
	
	// 忘记密码
	$('#forgetPwd').click(function() {
		location.href = path + '/system/toAccount';
	});
});
