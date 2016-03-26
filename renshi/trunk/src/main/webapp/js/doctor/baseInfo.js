$().ready(function() {
	//年月日下拉表 以及联动
	 //获取系统当前年月日
	 //初始化
	$('#year').val(new Date().getFullYear());
	$('#month').val(new Date().getMonth()+1);
	$('#day').val(new Date().getDate());
	var days;
	var bigMonth=new Array('1','3','5','7','8','10','12');
	var smlMonth=new Array('4','6','9','11');
	var yearBool=0;//判断是否是闰年
	  //在jsp中的初始化为1900年，在这里初始化后触发了年的change事件
	  //年改变
	  $('#year').change(function(){
		  var year=$('#year').val();
		   //闰年
		   if((year%400==0 )||(year%4==0 && year%100!=0)){
				yearBool=1;
		   }
		   else
		     	yearBool=0;
		   //此时重新加载月和日
		   $('#month').change();
		
	  });
	  //月改变
	  $('#month').change(function(){
		  //清空原来的日
		  $('#day').empty();
         var month=$('#month').val();
         if($.inArray(month,bigMonth)!=(-1)){
   	      days=31;}
         else  if($.inArray(month,smlMonth)!=(-1)){
   	      days=30;}
         else if(yearBool==1){
   	      days=29;}
         else if(yearBool==0)
   	     days=28;
         for(var i=1;i<=days;i++){
         	  var option=$('<option>').val(i).text(""+i+"日");
         	   $('#day').append(option);
         }
     });
	
	// 职称下拉列表
	$('#inputProfess').select({
		targetId: 'selectProfess',
		css: {'margin-left': '42px', 'min-width': '350px'},
		multi: true,
		choose: function(_this, $span) {
			//隐藏错误的提示信息
			$('.profess-error').hide();
			// 选择的加粗
			$span.parent('li').children('span').each(function() {
				$(this).removeClass('selected');
			});
			$span.addClass('selected');
			
			// 选择后更新显示的值
			var value = '';
			console.log($('#selectProfess ul').children('li'));
			$('#selectProfess ul').children('li').each(function() {
				$(this).children('span.selected').each(function() {
					if(value != '') {
						value += ' , ';
					}
					value += $(this).html();
				});
			});
			
			// 输入框设置值
			_this.val(value);
		}
	});
	
	// 医院下拉列表  修改为输入框
	$('#inputHospital').select({
		targetId: 'selectHospital',
		css: {'margin-left': '42px'},
	    choose: function(el) {
		$('#inputHospital').val(el.html());
		//隐藏错误
		$('.hospital-error').hide();
	   }
	});
	//科室下拉列表   直接获取，去掉与医院的关联
		$.ajaxRequest({
			url: path + '/doctor/getDeptInfo',
			success: function(data){
				$('#deptInfo').html('');
				data = data.obj;
				for(var i = 0; i < data.length; i++) {
					var $option = $('<option>' + data[i].deptName + '</option>');
					$option.attr('value', data[i].deptName);
					$('#deptInfo').append($option);
				}
			}
		});
	
	
	// 点击上传头像
	$('#camera').click(function() {
		$('#headFile')[0].click();
	});
	
	// 头像上传  使用事件冒泡注册事件
	$('#upload').on('change', '#headFile', function() {
		$.fileUpload({
			fileElementId: 'headFile',
			data: {
				storePath : headPath
			},
			success: function(data) {
				var obj = data.obj[0];
				//隐藏错误
				$('.head-error').hide();
				
				// 把头像路径设置到提交的input中
				$('#headUrl').val(obj);
				
				// 头像展示图片
				$('.preImg').show();
				$('.preImg').attr('src', path + '/common/showImage?imageUrl=' + obj);
				// 隐藏文字
				$('.preImg').siblings('p').hide();
			},
			failed: function(data) {
				$('.head-sub-error').show();
				$('.head-sub-error').text(data.msg);
			}
		});
	});
	//真实姓名失去焦点进行验证
	$('#realName').blur(function(){
		var  name=$.trim($('#realName').val());
		if(name=='')
			$('.realName-error').show();
		else
			$('.realName-error').hide();
	});
//	//头像 失去焦点进行验证    不起作用
//	$('#headUrl').blur(function(){
//		alert("heaf");
//		var headUrl = $('#headUrl').val();
//		if(headUrl == '') {
//			// 显示错误信息
//			alert("hah");
//			$('.head-error').show();
//		}else{
//			$('.head-error').hide();			
//		}
//	});
	//职称 失去焦点 进行 验证
    $('#inputProfess').blur(function(){
    	var inputProfess = $.trim($('#inputProfess').val());
		if(inputProfess == '') {
			// 显示错误信息
			$('.profess-error').show();
		} 
		else {
			$('.profess-error').hide();
		}
		//隐藏提示  在choose之后执行
	});
    //医院失去焦点
    $('#inputHospital').blur(function(){
    	var inputHospital = $.trim($('#inputHospital').val());
		if(inputHospital == '') {
			// 显示错误信息
			$('.hospital-error').show();
		} 
		//隐藏提示  在choose之后执行
		else{
			$('.hospital-error').hide();
		}
	});
    //手机  失去焦点进行验证
    $('#phoneNo').blur(function(){
    	var phoneNo=$.trim($('#phoneNo').val());
    	if(phoneNo == '') {
			// 显示错误信息
			$('.phoneNo-error').show();
			$('.phoneNo-error').text('请输入您的联系手机！');
		} else if(!checkPhone(phoneNo)) {
				// 显示错误信息
				$('.phoneNo-error').text('您输入的电话号码不正确!');
				$('.phoneNo-error').show();
	    }else 
			$('.phoneNo-error').hide();
    });
    //QQ失去焦点  进行验证
    $('#qqNo').blur(function(){
    	 var qqNo =$.trim($('#qqNo').val());
    		if(qqNo == '') {
    			// 显示错误信息
    			$('.qqNo-error').text('请输入您的联系QQ！');
    			$('.qqNo-error').show();
    		} else if(!checkNum(qqNo)) {
    				// 显示错误信息
    				$('.qqNo-error').text('QQ请输入数字!');
    				$('.qqNo-error').show();
    		}else
    			$('.qqNo-error').hide();
    });
   
	// 表单提交
	$('#first-btn').click(function() {
		
		// 设置出生日期
		var year = $('#year').val(), month = $('#month').val(), day = $('#day').val();
		$('#birthDate').val(year + '-' + month + '-' + day);
		
		// 设置现居地址
		var country = $('#country').val(), province = $('#province').val(), city = $('#city').val();
		$('#liveTown').val(country + ',' + province + ',' + city);
		
		// 隐藏所有的错误信息
		$('.error').hide();
		
		// 校验注册按钮是否可用
		var btnValid = $('p.get-sub-dis');
		if(btnValid.length > 0) {
			return;
		}
		
		// 第一个错误标签
		var $error = '';
		
		// 真实姓名
		var realName = $.trim($('#realName').val());
		if(realName == '') {
			// 显示错误信息
			$('.realName-error').show();
			
			if($error == '') {
				$error = $('.realName-error');
			}
		}
		
		// 真实头像
		var headUrl =  $.trim($('#headUrl').val());
		if(headUrl == '') {
			// 显示错误信息
			$('.head-error').show();
			
			if($error == '') {
				$error = $('.head-error');
			}
		}
		
		// 职称
		var profess = $.trim( $('#inputProfess').val());
		if(profess == '') {
			// 显示错误信息
			$('.profess-error').show();
			
			if($error == '') {
				$error = $('.profess-error');
			}
		}
		
		// 医院
		var hospital =  $.trim($('#inputHospital').val());
		if(hospital == '') {
			// 显示错误信息
			$('.hospital-error').show();
			
			if($error == '') {
				$error = $('.hospital-error');
			}
		}
		
		// 联系手机
		var phoneNo = $.trim( $('#phoneNo').val());
		if(phoneNo == '') {
			// 显示错误信息
			$('.phoneNo-error').show();
			$('.phoneNo-error').text('请输入您的联系手机！');
			
			if($error == '') {
				$error = $('.phoneNo-error');
			}
		} else {
			if(!checkPhone(phoneNo)) {
				// 显示错误信息
				$('.phoneNo-error').text('您输入的电话号码不正确!');
				$('.phoneNo-error').show();
				
				if($error == '') {
					$error = $('.phoneNo-error');
				}
			}
		}
		
		// QQ号码
		var qqNo =  $.trim($('#qqNo').val());
		if(qqNo == '') {
			// 显示错误信息
			$('.qqNo-error').text('请输入您的联系QQ！');
			$('.qqNo-error').show();
			
			if($error == '') {
				$error = $('.qqNo-error');
			}
		} else {
			if(!checkNum(qqNo)) {
				// 显示错误信息
				$('.qqNo-error').text('QQ请输入数字!');
				$('.qqNo-error').show();
				
				if($error == '') {
					$error = $('.qqNo-error');
				}
			}
		}
		
		// 有错误
		if($error != '') {
			// 定位
			var height = ($error.position().top - 15) > 0 ? ($error.position().top - 15) : 0;
			$('body').scrollTop(height);
			return;
		}
		
		$('#baseInfoForm').attr('action', path+'/doctor/baseInfo');
		// 设置按钮不可用
		$this = $(this);
		
		$this.removeClass('get-sub');
		$this.addClass('get-sub-dis');
		
		// 表单提交
		$.ajaxFormSubmit({
			formId: 'baseInfoForm',
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
				
				location.href = path + '/doctor/toAuthInfo?id=' + data.obj.accountId;
			}
		});
	});//表单提交结束
});

//验证电话 （手机）
function checkPhone(str){
	//验证11位   且 第一位为1
	var reg = /^1\d{10}$/ ;
	//验证前三位是否是手机号
   var  phoneNum=new Array('130','131','132','133','134','135','136','137','138','139',
		                    '150','151','152','153','154','155','156','157','158','159',
		                   '180','181','182','183','185','186','187','188','189',
		                   '170','177','178');
   var threePhone=str.substring(0,3);
   if($.inArray(threePhone,phoneNum)==(-1)){
	  return false;
   }else if(!reg.test(str)){
		return false;
	} else {
		return true;
	}
}

// 验证数字
function checkNum(str) {
	var reg = /^\d+$/;
	
	if(reg.test(str)) {
		return true;
	} else {
		return false;
	}
}