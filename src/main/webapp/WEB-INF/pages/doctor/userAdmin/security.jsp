<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
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
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>账号安全</title>
    <link href="${cssPath}/userAdmin/base.css" rel="stylesheet" />
    <link href="${cssPath}/userAdmin/center.css" rel="stylesheet" />
    <script type="text/javascript" src="${jsLib}/jquery-1.11.3.min.js"></script>
</head>
<body>
    <%@ include file="/WEB-INF/pages/doctor/userAdmin/head.jsp" %>
    
    <div class="mainContent">
    	<%@ include file="/WEB-INF/pages/doctor/userAdmin/leftMenu.jsp" %>
        <div class="mainContent_right">
            <!--账号安全开始-->
            <!-- <div class="basicInfo profInfo contactInfo">
                <span class="basicInfoTit"><i></i>账号安全</span>
                 <div class="countSafety">
                     <div class="safetyCount"><i>安全等级：</i><span class="safetyLeavel"><b></b></span><i>中</i></div>
                     <p>为了更好的保护您的信息、账号的安全，认仕网通推荐您使用以下保护措施：</p>
                 </div>暂不开发此部分-->
                <div class="countPassword">
                    <h1></i>登录密码</h1>
                    <span class="pwLength hidden">
                        <p>密码强度：中</p>
                        <p>上次登录时间：2015年05月16日 15:30:45</p>
                    </span>
                    <a id="a1" class="changePw" onclick="check(1)" href="#pw1">修改</a>
                </div>
                <div class="countPassword hidden">
                    <h1>手机绑定</h1>
                    <span class="pwLength">
                        <p>您绑定的手机：155****2812</p>
                        <p>用于登录，找回登录密码，最新活动及最新动态即时邮件通知您</p>
                    </span>
                    <a class="changePw" onclick="check(2)" href="#pw2">修改</a>
                </div>
                <div class="countPassword">
                    <h1>邮箱绑定</h1>
                    <span class="pwLength">
                        <p>您绑定的邮箱：${accountInfoBean.loginAccount}</p>
                        <p>用于登录，找回登录密码，最新活动及最新动态即时邮件通知您</p>
                    </span>
                    <a class="changePw" onclick="check(3)" href="#pw3">修改</a>
                </div>
               
                <div class="countPassword">
                    <h1></i>空间状态</h1>
                    <span class="pwLength">
                        <p>您当前的空间状态为
                        	<c:if test="${personInfoBean.personStatus == 1}">
	                        	<a>开启中</a>
                        	</c:if>
                        	<c:if test="${personInfoBean.personStatus == 0}">
	                        	<a>关闭中</a>
                        	</c:if>
                        </p>
                        <p>开启空间：所有人都可以访问您的空间。</p>
                        <p>关闭空间：所有人都不能访问您的空间。</p>
                    </span>
                    <c:if test="${personInfoBean.personStatus == 1}">
	                    <a class="changePw closeSpace" id="closeSpace">关闭空间</a>
                   	</c:if>
                   	<c:if test="${personInfoBean.personStatus == 0}">
                     	<a class="changePw closeSpace" id="openSpace">开启空间</a>
                   	</c:if>
                </div> 
                <!--修改密码开始-->
               <div class="securityContent"><a id="pw1" name="pw1"></a>
                <div id="changePW01" class="changePWContent" style="display:none">
                    <div class="basicInfo profInfo contactInfo" >
                    <span class="basicInfoTit changeBox"><i></i>修改密码</span>
                    
                    <form action="" method="post" id="passwordForm">
                    <input name="id" value="${accountInfoBean.accountId}" type="hidden">
                    
                    <table class="profInfoContent">
                        <tr>
                            <td class="title_type changeTitle">当前密码：</td>
                            <td><input type="password" class="hospital" name="oldPassword" id="oldPassword"/></td>
                        </tr>
                        <tr>
                            <td class="title_type changeTitle">新密码： </td>
                            <td><input type="password" class="hospital" name="password" id="password" /></td>
                        </tr>
                        <tr>
                            <td class="title_type changeTitle">确认新密码： </td>
                            <td><input type="password" class="hospital" id="confirmPassword"  /></td>
                        </tr> 
                         <tr>
                            <td class="title_type"> </td>
                            <td><a class="infoBtn contactBtn changePwBtn" id="modifyPassword">确认修改</a></td>
                        </tr>                 
                    </table>
                    </form>
                 </div>
                </div>
                 <!--修改密码结束--> 

                 <!--修改手机号码开始-->
                <div id="changePW02" class="changePWContent" style="display:none" ><a id="pw2" name="pw2"></a>
                    <div class="basicInfo profInfo contactInfo" >
                    <span class="basicInfoTit changeBox"><i></i>修改绑定手机</span>
                    <table class="profInfoContent">
                        <tr>
                            <td class="title_type changeTitle">当前号码：</td>
                            <td class="contentRight">155***2812</td>
                        </tr>
                        <tr>
                            <td class="title_type changeTitle">新号码： </td>
                            <td><input type="text" class="hospital"/></td>
                        </tr> 
                        <tr>
                            <td class="title_type changeTitle">短信验证码： </td>
                            <td><div class="codeContent"><input type="text" class="hospital codeMsg"/><a class="codeBtn">发送验证码</a></div></td>
                        </tr> 
                         <tr>
                            <td class="title_type"> </td>
                            <td><div class="codeContent"><a class="codePhone">验证手机</a><a class="codePhone" id="cancelNum">取消</a></div></td>
                        </tr>                 
                    </table>
                    <div class="phoneProblem">
                    <h1>常见问题</h1>
                       <span>手机收不到校验码？</span>
                        <p>答：网络通讯异常可能会造成短信丢失，或者您会延时收到短信，请您耐心等待一下。等待1分钟后，仍没收到，您可以尝试”重新发送验证码“。</p>
                        <span>原手机号已丢失或停用，怎么修改绑定的手机号？</span>
                        <p>答：如果您之前绑定的手机号已经丢失或停用，请联系我们客服400-008-2828 完成手机号绑定修改！</p>
                    </div>

                 </div>
                </div>
                 <!--修改手机号码结束-->   

                 <!--修改邮箱开始-->
                <div id="changePW03" class="changePWContent" style="display:none" ><a id="pw3" name="pw3"></a>
                    <div class="basicInfo profInfo contactInfo" >
                    <span class="basicInfoTit changeBox"><i></i>修改绑定邮箱</span>
                    <form action="" method="post" id="mailForm">
                    <input name="id" value="${accountInfoBean.accountId}" type="hidden">
                    <table class="profInfoContent">
                        <tr>
                            <td class="title_type changeTitle">当前邮箱：</td>
                            <td class="contentRight">${accountInfoBean.loginAccount}</td>
                        </tr>
                        <tr>
                            <td class="title_type changeTitle">新邮箱： </td>
                            <td><input type="text" class="hospital" id="newEmail" name="newEmail"onblur="checkbefore('${accountInfoBean.loginAccount}',1)" /><span class="error null-error" style="color:red;display:none;">请输入新邮箱！</span><span class="error right-error" style="color:red;display:none;">请正确的邮箱！</span><span class="error exist-error" style="color:red;display:none;">该邮箱已被注册！</span>
                            </td>
                        </tr> 
                        <tr>
                            <td class="title_type changeTitle">确认新邮箱： </td>
                            <td><input type="text" class="hospital" id="comfirmEmail" onblur="checkbefore('${accountInfoBean.loginAccount}',2)" /><span class="error comfirm-error" style="color:red;display:none;">邮箱不一致！</span></td>
                        </tr>
                         <tr>
                            <td class="title_type"> </td>
                            <td><div class="codeContent"><a class="codePhone emailCotent" id="sendResetMail" onclick="checkbefore('${accountInfoBean.loginAccount}',3)">发送验证邮箱</a><a class="codePhone" id="cancelEmail">取消</a></div></td>
                        </tr> 
                        <tr style="display:none;" id="tip">
                            <td></td>
                            <td><div class="emailLogin">
                            <p>已发送验证邮件至：<label id="tempMailShow"></label>
                            </p>
                            <p>请尽快登录您的邮箱点击验证链接完成验证，
                            <p class="get-sub" id="toMail" style="cursor: pointer;">
                            <a target="_blank"></a>
                            <span>登录邮箱>></span>
                            </p>
                            <p class="title-con" style="color: red">${failMsg}</p>

                            </p></div></td>
                        </tr>                
                    </table>
                </form>
                    <div class="emailNotice">
                        <h1>没收到邮件？</h1>
                        <p>请检查您的垃圾箱或广告箱，邮件有可能被误认为垃圾或广告邮件；</p>
                        <p>或选择<a>重新发送邮件</a></p>
                    </div>

                 </div>
                </div>
                </div>
                 <!--邮箱结束-->   
            </div>
         
            

            <!--账号安全结束-->
        </div>

    </div>
    <%@ include file="/WEB-INF/pages/common/footer.jsp" %>
</body>
	<script type="text/javascript" src="<%=jsLib %>/jquery.form.js"></script>
	<script type="text/javascript" src="<%=jsPlugin %>/widget.ajaxFormSubmit.js"></script>
	<script type="text/javascript" src="<%=jsPlugin %>/widget.ajaxRequest.js"></script>
	
    <script>
    	var path = '<%=path%>';
    	
        function check(val) {
            if (val == 1) {
                $("#changePW02").hide();
                $("#changePW03").hide();
                $("#changePW01").show();

            }else if(val == 2){
                $("#changePW02").show();
                $("#changePW03").hide();
                $("#changePW01").hide();
            } else if (val == 3) {
                $("#changePW02").hide();
                $("#changePW03").show();
                $("#changePW01").hide();
            }else {
                $("#changePW02").hide();
                $("#changePW03").hide();
                $("#changePW01").hide();
            }

        }    
 </script>
    <script >
        $(function () {

            $(".mainLeftList a").eq(4).addClass("leftCurrent");
            
         	// 加载头像
            $('.headerUrl').attr('src', path + '/common/showImage?imageUrl=' + $('.headerUrl').attr('link'));
         	
         	$('#modifyPassword').click(function() {
         		
         		if($('#oldPassword').val() == '') {
         			alert('请填写旧密码');
         			return;
         		}
         		
         		if($('#password').val() == '') {
         			alert('请填写密码');
         			return;
         		}
         		
				if($('#confirmPassword').val() == '') {
					alert('请填写确认密码');
         			return;  			
				}
				         		
				if($('#password').val() != $('#confirmPassword').val()) {
					alert('密码和确认密码不一致');
         			return;
				}
         		
         		$('#passwordForm').attr('action', path + '/doctor/changePassword');
         		
         		$.ajaxFormSubmit({
        			formId: 'passwordForm',
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
        				
        				location.reload();
        			}
        		});
         	});

         	$('#closeSpace').click(function() {
         		$.ajaxRequest({
         			url: path + '/doctor/closeSpace',
         			data: {
         				id : '${personInfoBean.personId}'
         			},
         			success: function() {
         				location.reload();
         			}
         		});
         	});
         	
         	$('#openSpace').click(function() {
         		$.ajaxRequest({
         			url: path + '/doctor/openSpace',
         			data: {
         				id : '${personInfoBean.personId}'
         			},
         			success: function() {
         				location.reload();
         			}
         		});
         	});
        });
        
        $(function () {
            $("#cancelNum").click(function () {
                $("#changePW02").hide();
            });
            $(function () {
                $("#cancelEmail").click(function () {
                    $("#changePW03").hide();
                });
            });
        })
</script>

    <script>

        // 验证邮箱
    function checkEmail(str){
        // 域名小写
        var reg = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([a-z\d]+[-.])+[a-z]{2,5}$/;
        if(reg.test(str)){
            return true;
        }else{
            return false;
        }
    }

    //输入新邮箱验证
    function checkbefore(str,state){
        $('.error').hide();
        var newmail = $("#newEmail").val();
        var confirmEmail = $("#comfirmEmail").val();
        if(newmail==""){
            $('.null-error').show();
            return ;
        }else{
            if(!checkEmail(newmail)){
                $('.right-error').show();
                return ;
            }else{
            if(newmail==str){
                $('.null-error').show();
                return ;
            }else{
                $.ajaxRequest({
                url: path + '/system/validAccName',
                data: {
                    name: newmail
                },
                success: function(data) {
                    if(data.obj == false) {
                       $('.exist-error').show();
                       return ;
                    }
                }
            });
        }
        }
    }
        if(2==state){
            if(newmail!=confirmEmail){
                $('.comfirm-error').show();
                return;
            }
        }
        if(3==state){
            $('.error').hide();
            $('#mailForm').attr('action', path + '/system/sendResetMail');
                $.ajaxFormSubmit({
                    formId: 'mailForm',
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
                        $('#tempMailShow').html(newmail);
                        $('#tip').show();
                    }
                });
        }
    }

// 点击查收邮件
        $('#toMail').click(function() {
            var mail = $("#newEmail").val();
            var url = mail.split('@')[1];
            url = 'http://mail.' + url;
            
            var a = $(this).children('a')[0];
            var $a = $(a);
            $a.attr('href', url);
            
            a.click();
        });
    
    </script>
</html>
