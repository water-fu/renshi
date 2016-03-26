<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.group.renshi.cache.HospitalInfoCache"%>
<%@page import="com.group.renshi.bean.system.HospitalInfoBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.group.renshi.constant.SystemConstantType"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String headPath = SystemConstantType.HEAD_PATH;

	List<String> years = new ArrayList<String>();
	List<String> months = new ArrayList<String>();
	List<String> days = new ArrayList<String>();
	for(int i = 2015; i >= 1975; i--) {
		years.add(i+"");	
	}
	for(int i = 12; i >=1; i--) {
		months.add(i+"");	
	}
	for(int i = 31; i >= 1; i--) {
		days.add(i+"");	
	}
	
	request.setAttribute("years", years);
	request.setAttribute("months", months);
	request.setAttribute("days", days);

	String path = request.getContextPath();

	// CSS和JS的lib库
	String cssLib = path + "/lib/css";
	String jsLib = path + "/lib/js";
	
	// JS的自定义插件库
	String jsPlugin = path + "/plugin";
	
	// css
	String cssPath = path + "/css";
	//js
	String jsPath = path +"/js";
	
	// image
	String imagePath = path + "/images";
	
	request.setAttribute("path", path);
	request.setAttribute("cssLib", cssLib);
	request.setAttribute("jsLib", jsLib);
	request.setAttribute("jsPlugin", jsPlugin);
	request.setAttribute("cssPath", cssPath);
	request.setAttribute("jsPath",jsPath);
	request.setAttribute("imagePath", imagePath);
	
	List<HospitalInfoBean> hospitalList = HospitalInfoCache.getInstance().getSelectList();
	request.setAttribute("hospitalList", hospitalList);
%>

<!DOCTYPE html>

<html>
<head>
    <title>个人基本信息</title>
    <link href="${cssPath}/userAdmin/base.css" rel="stylesheet" />
    <link href="${cssPath}/userAdmin/center.css" rel="stylesheet" />
    <script type="text/javascript" src="${jsLib}/jquery-1.11.3.min.js"></script>
    <style type="text/css">
    	.inputSelect {
			border: 1px solid #cdcdcd;
			background-color: #fff;
			display: none;
			border-radius: 0 0 6px 6px;
			cursor: pointer;
		}
		
		.inputSelect li {
			padding-left: 20px;
			height: 40px;
			line-height: 40px;
		}
		
		.inputSelect li span{
			display: inline-block;
			width: 79px;
		}
		
		.inputSelect li span.selected {
			font-weight: bold;
		}
		
		.inputSelect li em{
			margin: 0 auto;
		}
    </style>
    <link rel="stylesheet" href="${cssPath}/doctor/user.css">
</head>
<body>
    <!--#include file="/include/useradmin/header.inc"-->
	 <%@ include file="/WEB-INF/pages/doctor/userAdmin/head.jsp" %>
	
    <div class="mainContent">
  <!--#include file="/include/useradmin/leftmenu.inc"-->
		<%@ include file="/WEB-INF/pages/doctor/userAdmin/leftMenu.jsp" %>
		
        <div class="mainContent_right">
            <div class="basicInfo">
                <span class="basicInfoTit"><i></i>基本信息填写<b><em>*</em>号项为必填项</b></span>
                <div class="basicInfoContent">
                <form action="" method="post" id="form1">
                	<input value="${accountInfoBean.accountId}" type="hidden" name="accountId">
                
                    <table class="profInfoContent basicInfoContent_left ">
                        <tr>
                            <td class="title_type">真实姓名： </td>
                            <td><div class="basicInfoName"><input type="text" class="Tname" disabled="disabled" value="${userInfoBean.realName}" /></div><p class="basicInfoExplan">认证用户不允许修改姓名!</p></td>
                        </tr>
                        <tr>
                            <td class="title_type"><i>*</i>性别： </td>
                            <td>
                            	<select class="basicSex" val="${userInfoBean.accountSex}" name="accountSex">
                            		<option value="1">男</option>
                            		<option value="2">女</option>
                            	</select>
                            </td>
                        </tr>
                        <tr>
                            <td class="title_type">出生年月： </td>
                            <td><div class="basicInfoName">
                                <select class="basicBorn" id="year" >
                                    <c:forEach items="${years}" var="year">
										<option align="center" value="${year}">${year}年</option>
									</c:forEach>
                                </select>
                                <select class="basicBorn" id="month">
                                    <c:forEach items="${months}" var="month">
										<option align="center" value="${month}">${month}月</option>
									</c:forEach>
                                </select>
                                <select class="basicBorn" id="day">
                                    <c:forEach items="${days}" var="day">
										<option align="center" value="${day}">${day}日</option>
									</c:forEach>
                                </select>
                              </div>
                              <input type="hidden" name="birthDate" id="birthDate" />
                            </td>
                        </tr>
                        <tr>
                            <td class="title_type">现居城市： </td>
                            <td><div class="basicInfoName">
                                <select class="basicBorn" id="country" name="country">
                                    <option value="中国">中国</option>
                                </select>
                                <select class="basicBorn" id="province" name="province">
                                </select>
                                <select class="basicBorn" id="city" id="city">
                                </select>
                                <select style="display:none;" name="livearea" id="livearea"></select>
                              </div>
                              <input type="hidden" name="liveTown" id="liveTown" />
                            </td>
                        </tr>
                        <tr>
                        <td class="title_type"> </td>
                        <td><a class="infoBtn contactBtn" id="submit1">修改</a></td>
                    </tr> 
                    </table>
                    <div class="basicInfoContent_right">
                        <img src="" alt="" class="headerUrl" id="headerUrl" link="${accountInfoBean.headUrl}"/>
                        <a class="changeHeader" href="javascript:void(0);">修改头像</a>
                        <div class="upload">
                        	<input type="file" name="file" id="headFile" class="hidden"/>
                        </div>
                        
                        <input type="hidden" name="headUrl" id="headUrl" value="${accountInfoBean.headUrl}" />
                    </div>
                </form>
                </div>
            </div>
            <div class="basicInfo profInfo">
            <form action="" method="post" id="form2">
            	<input value="${accountInfoBean.accountId}" type="hidden" name="accountId">
            
                <span class="basicInfoTit"><i></i>专业信息<b><em>*</em>号项为必填项</b></span>
                <table class="profInfoContent">
                    <tr>
                        <td class="title_type"><i>*</i>职称： </td>
                        <td>
                        	<select class="positionSel" name="workProfess" id="work" val="${authenticInfoBean.workProfess}"> 
	                            <option>主任医师</option>
	                            <option>副主任医师</option>
		        				<option>主治医师</option>
	                         	<option>住院医师</option>
                            </select>
                            <select class="positionSel positionSel01" name="academicProfess" id="academic" val="${authenticInfoBean.academicProfess}">
	                            <option>教授</option>
	                            <option>副教授</option>
	                            <option>讲师</option>
                            </select>
                            <select class="positionSel positionSel02" name="educationProfess" id="education" val="${authenticInfoBean.educationProfess}">
	                            <option>博士生导师</option>
	                            <option>研究生导师</option> 
                            </select>
                    </tr>
                    <tr>
                        <td class="title_type"><i>*</i>医院： </td>
                        <td>
                        	<input type="text" class="hospital" id="inputHospital" name="belongHospital" 
                        	                placeholder="医院" value="${userInfoBean.belongHospital}"/>
                        	<i class="warning hidden" id="hospital_error">请选择您的医院！</i>
                        	
                        	<div id="selectHospital" class="inputSelect">
								<ul>
									<c:forEach items="${hospitalList}" var="hospital">
										<li val="${hospital.hospitalId}">${hospital.hospitalName}</li>
									</c:forEach>
								</ul>
							</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="title_type"><i>*</i>科室： </td>
                        <td>
                        	<select class="positionSel classType" name="belongDept" id="deptInfo">
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="title_type">所属医学会： </td>
                        <td><input type="text" class="hospital" maxlength="15" name="belongMedical" placeholder="所属医学会" value="${userInfoBean.belongMedical}" /></td>
                    </tr>
                    <tr>
                        <td class="title_type">擅长领域： </td>
                        <td>
                        	<textarea name="specilArea" rows="5" maxlength="150" cols="33" class="sp_area" placeholder="&nbsp;&nbsp;擅长领域">${userInfoBean.specilArea}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td class="title_type">个人简介： </td>
                        <td>
                        	<textarea name="personInfro" maxlength="150" rows="5" cols="33" class="sp_area" placeholder="&nbsp;&nbsp;个人简介">${userInfoBean.personInfro}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td class="title_type"> </td>
                        <td><a class="infoBtn" id="submit2">修改</a></td>
                    </tr>
                </table>
            </form>
            </div>
			
            <div class="basicInfo profInfo contactInfo">
            <form action="" method="post" id="form3">
            	<input value="${accountInfoBean.accountId}" type="hidden" name="accountId">
            
                <span class="basicInfoTit"><i></i>联系信息<b><em>*</em>号项为必填项</b></span>
                <table class="profInfoContent">
                    <tr>
                        <td class="title_type"><i>*</i>联系手机： </td>
                        <td>
                        	<input type="text" name="phoneNo" maxlength="15" id="phoneNo" placeholder="联系手机" class="hospital" value="${contactInfoBean.phoneNo}">
                        	<i class="warning hidden" id="phoneNo_error">请输入您的联系手机！</i>
                        </td>
                    </tr>
                    <tr>
                        <td class="title_type"><i>*</i>联系QQ： </td>
                        <td>
                        	<input type="text" name="qqNo" maxlength="20" id="qqNo" placeholder="联系QQ" class="hospital" value="${contactInfoBean.qqNo}">	
                        	<!-- <span class="warning hidden" id="qqNo_error">请输入您的联系QQ！</span> -->
                        	<i class="warning hidden" id="qqNo_error">请输入您的联系QQ！</i>
                        </td>
                    </tr> 
                     <tr>
                        <td class="title_type"> </td>
                        <td><a class="infoBtn contactBtn" id="submit3">修改</a></td>
                    </tr>                 
                </table>
            </form>
            </div>
        </div>

    </div>
    <!--#include file="/include/useradmin/footer.inc"-->
    <%@ include file="/WEB-INF/pages/common/footer.jsp" %>
</body>
	<script type="text/javascript" src="<%=jsLib %>/jquery.ajaxfileupload.js"></script>
	<script type="text/javascript" src="<%=jsLib %>/jquery.form.js"></script>
	<script type="text/javascript" src="${jsPlugin}/widget.ajaxFileUpload.js"></script>
	<script type="text/javascript" src="<%=jsPlugin %>/widget.ajaxFormSubmit.js"></script>
	<script type="text/javascript" src="${jsPlugin}/widget.select.js"></script>
	<script type="text/javascript" src="<%=jsPlugin %>/widget.ajaxRequest.js"></script>
    <script >
   	 	var path = '<%=path%>';
   	 	var headPath = '<%=headPath%>';
   	    $().ready(function() {
   	       //年月日下拉表 以及联动
   		   //获取系统当前年月日
   		   var days;
   		   var bigMonth=new Array('1','3','5','7','8','10','12');
   		   var smlMonth=new Array('4','6','9','11');
   		   var yearBool=0;//判断是否是闰年
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
   	 });
        $(function () {
            $(".mainLeftList a").eq(0).addClass("leftCurrent");
            
            // 性别
            $('.basicSex').val($('.basicSex').attr('val'));
            
            // 出生年月
            var birthDate = '${userInfoBean.birthDate}';
            var year = birthDate.split('-')[0];
            var month = birthDate.split('-')[1];
            var day = birthDate.split('-')[2];
            
            $('#year').val(year);
            $('#month').val(month);
            $('#day').val(day);
            
            // 加载头像
            $('.headerUrl').attr('src', path + '/common/showImage?imageUrl=' + $('.headerUrl').attr('link'));
            
            // 点击上传头像
            $('.changeHeader').click(function() {
            	$('#headFile')[0].click();
            });
            
         	// 头像上传  使用事件冒泡注册事件
        	$('.upload').on('change', '#headFile', function() {
        		$.fileUpload({
        			fileElementId: 'headFile',
        			data: {
        				storePath : headPath
        			},
        			success: function(data) {
        				var obj = data.obj[0];
        				
        				// 把头像路径设置到提交的input中
        				$('#headUrl').val(obj);
        				
        				// 头像展示图片
        				$('#headerUrl').attr('src', path + '/common/showImage?imageUrl=' + obj);
        			},
        			failed: function(data) {
        				$('.head-sub-error').show();
        				$('.head-sub-error').text(data.msg);
        			}
        		});
        	});
         	
         	// 表单1提交
         	$('#submit1').click(function() {
	         	$('#form1').attr('action', path + '/doctor/saveForm1');
	         	
	         	// 设置出生日期
	    		var year = $('#year').val(), month = $('#month').val(), day = $('#day').val();
	    		$('#birthDate').val(year + '-' + month + '-' + day);
	    		
	    		// 设置现居地址
	    		var country = $('#country').val(), province = $('#province').val(), city = $('#city').val();
	    		$('#liveTown').val(country + ',' + province + ',' + city);
	    		
         		$.ajaxFormSubmit({
        			formId: 'form1',
        			success: function(data) {
        				// 把字符串解析称JSON格式
        				var result = data;
        				if(typeof data === 'string') {
        					result = eval('(' + data + ')');
        				}
        				
        				if(result.code == 0) {
        					alert(result.msg);
        					
        					return;
        				}
        				
        				alert('保存成功');
        			}
        		});
         	});
         	
         	$('#work').val($('#work').attr('val'));
         	$('#academic').val($('#academic').attr('val'));
         	$('#education').val($('#education').attr('val'));
         	
         	// 医院下拉列表
        	$('#inputHospital').select({
        		targetId: 'selectHospital',
        		choose: function(el) {
        			$('#inputHospital').val(el.html());
        			$.ajaxRequest({
        				url: path + '/doctor/getDeptInfo',
        				data: {
        					hospitalId: el.attr('val')
        				},
        				success: function(data) {
        					$('#deptInfo').html('');
        					data = data.obj;
        					for(var i = 0; i < data.length; i++) {
        						var $option = $('<option>' + data[i].deptName + '</option>');
        						$option.attr('value', data[i].deptName);
        						
        						$('#deptInfo').append($option);
        					}
        					
        					$('#deptInfo').val('${userInfoBean.belongDept}');
        				}
        			});
        		}
        	});
         	
         	// 加载科室
			$.ajaxRequest({
				url: path + '/doctor/getDeptInfo',
				data: {
					hospitalId: -1
				},
				success: function(data) {
					$('#deptInfo').html('');
					data = data.obj;
					for(var i = 0; i < data.length; i++) {
						var $option = $('<option>' + data[i].deptName + '</option>');
						$option.attr('value', data[i].deptName);
						
						$('#deptInfo').append($option);
					}
					
		         	$('#deptInfo').val('${userInfoBean.belongDept}');
				}
			});
         	
         	//表单2提交
         	$('#submit2').click(function() {
         		$('#form2').attr('action', path + '/doctor/saveForm2');
         		
         		$('#hospital_error').hide();
         		var  hospital=$.trim($('#inputHospital').val());
         		if( hospital== '') {
         			$('#hospital_error').removeClass("hidden");
         			$('#hospital_error').show();
         			return;
         		}
         		
         		$.ajaxFormSubmit({
        			formId: 'form2',
        			success: function(data) {
        				// 把字符串解析称JSON格式
        				var result = data;
        				if(typeof data === 'string') {
        					result = eval('(' + data + ')');
        				}
        				
        				if(result.code == 0) {
        					alert(result.msg);
        					
        					return;
        				}
        				
        				alert('保存成功');
        			}
        		});
         	});
         	
         	//表单3提交
         	$('#submit3').click(function() {
         		$('#form3').attr('action', path + '/doctor/saveForm3');
         		
         		$('#phoneNo_error').hide();
         		$('#phoneNo_error').removeClass("hidden");
         		var phoneNo=$.trim($('#phoneNo').val());
         		if(phoneNo == '') {
         			$('#phoneNo_error').show();
         			return;
         		}else {
        			if(!checkPhone(phoneNo)) {
        				// 显示错误信息
        				$('.phoneNo_error').text('您输入的电话号码不正确!');
        				$('.phoneNo_error').show();
        				return;
        			}
        		}
         		
         		var qqNo=$.trim($('#qqNo').val());
         		$('#qqNo_error').hide();
         		$('#qqNo_error').removeClass('hidden');
         		if(qqNo == '') {
         			$('#qqNo_error').show();
         			return;
         		}else {
        			if(!checkNum(qqNo)) {
        				// 显示错误信息
        				$('.qqNo_error').text('QQ请输入数字，或者数字之间存在空格');
        				$('.qqNo_error').show();
        				return;
        			}
        		}
         		
         		$.ajaxFormSubmit({
        			formId: 'form3',
        			success: function(data) {
        				// 把字符串解析称JSON格式
        				var result = data;
        				if(typeof data === 'string') {
        					result = eval('(' + data + ')');
        				}
        				
        				if(result.code == 0) {
        					alert(result.msg);
        					
        					return;
        				}
        				alert('保存成功');
        				$('.error').hide();
        			}
        		});
         	});
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
</script>
    <script type="text/javascript" src="${jsPath}/system/zone.js"></script>
    <script type="text/javascript">
    $('document').ready(function(){
       //加载现居地
        var addressStr = '${userInfoBean.liveTown}';
        var countryStr = addressStr.split(',')[0];
        var provinceStr = addressStr.split(',')[1];
        var cityStr = addressStr.split(',')[2];

        $('#country').val(countryStr);
        $('#province').val(provinceStr); 
        $('#city').val(cityStr);

         addressInit('province','city','livearea',provinceStr,cityStr,'');
    })
   
    </script>
</html>
