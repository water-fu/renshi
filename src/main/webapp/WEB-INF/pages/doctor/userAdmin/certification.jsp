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
<html>
<head>
    <title>认证资料</title>
    <link href="${cssPath}/userAdmin/base.css" rel="stylesheet" />
    <link href="${cssPath}/userAdmin/center.css" rel="stylesheet" />
    <script type="text/javascript" src="${jsLib}/jquery-1.11.3.min.js"></script>
    <style type="text/css" media="screen">
        .black_overlay {
            display: none;
            position: absolute;
            top: 0%;
            left: 0%;
            width: 100%;
            height: 100%;
            background-color: black;
            z-index: 1001;
            -moz-opacity: 0.8;
            opacity: .80;
            filter: alpha(opacity=80);
        }
        .white_content_small {
            display: none;
            position: absolute;
            top: 20%;
            left: 30%;
            width: 50%;
            height: 20%;
            border: 16px solid #555;
            background-color: white;
            z-index: 1002;
            overflow: auto;
        }
        .close-button{
            position:absolute;font-size: 20px;display:block;font-weight: 900;cursor: pointer;
            width: 100%;
            height: 25px;
            line-height: 25px;
            right: 50px;
            text-align: right;
            z-index: 19;
        }
    </style>
</head>
<body>
    <%@ include file="/WEB-INF/pages/doctor/userAdmin/head.jsp" %>
    
    <div class="mainContent">
      	<%@ include file="/WEB-INF/pages/doctor/userAdmin/leftMenu.jsp" %>
        <div class="mainContent_right">
            <!--医生个人身份证开始-->
            <div class="basicInfo profInfo contactInfo">
                <span class="basicInfoTit"><i></i>医生个人身份证</span>
                 <table class="profInfoContent">
                    <tr>
                        <td class="title_type">真实姓名：</td>
                        <td class="contentRight">${userInfoBean.realName}</td>
                    </tr>
                    <tr>
                        <td class="title_type">身份证号：</td>
                        <td class="contentRight">${authenticInfoBean.idCard}</td>
                    </tr>
                    <tr>
                        <td class="title_type">身份证正面： </td>
                        <td class="contentRight"><img style="height: 200px;" src="" alt="" link="${authenticInfoBean.frontUrl}" onclick="showPic(this)"/></td>
                    </tr>
                    <tr>
                        <td class="title_type">身份证反面：</td>
                        <td class="contentRight"><img style="height: 200px;" src="" alt="" link="${authenticInfoBean.backUrl}" onclick="showPic(this)"/></td>
                    </tr>
                </table>
           
            </div>
         
            <div class="basicInfo profInfo contactInfo">
                <span class="basicInfoTit"><i></i>医师资格认证</span>
                <table class="profInfoContent">
                    <tr>
                        <td class="title_type">证书类型：</td>
                        <td class="contentRight">
							<c:if test="${authenticInfoBean.certificateType == 1}">
								医师学历证
							</c:if>
							<c:if test="${authenticInfoBean.certificateType == 2}">
								医师资格证
							</c:if>
							<c:if test="${authenticInfoBean.certificateType == 3}">
								医师学位证
							</c:if>
						</td>
                    </tr>
                    <tr>
                        <td class="title_type">编号：</td>
                        <td class="contentRight">${authenticInfoBean.certificateNo}</td>
                    </tr> 
                     <tr>
                        <td class="title_type">证书扫描件：</td>
                        <td class="contentRight"><img style="height: 200px;" src="" alt="" link="${authenticInfoBean.certificateUrl}" onclick="showPic(this)"/></td>
                    </tr>               
                </table>
            </div>

            <!--医生个人身份证结束-->
        </div>

    </div>
     <!--#include file="/include/useradmin/footer.inc"-->
</body>
<script >
	var path = '<%=path%>';

    $(function () {
        $(".mainLeftList a").eq(3).addClass("leftCurrent");
        
     // 加载头像
        $('.headerUrl').attr('src', path + '/common/showImage?imageUrl=' + $('.headerUrl').attr('link'));
        
        $('.contentRight img').each(function() {
        	var $el = $(this);
        	$el.attr('src', path + '/common/showImage?imageUrl=' + $el.attr('link'));
        });
    });

     function showPic(source){
      $('#fade').css("display",'block');
      $('#showPict').css("display",'block');
       $('#img-holder').attr("src",source.src);
    }

    function CloseDiv(show_div,bg_div){
      document.getElementById(show_div).style.display='none';
      document.getElementById(bg_div).style.display='none';
    }
</script>

<div id="fade" class="black_overlay"></div>
<div id="showPict" class="white_content_small" style="width: 60%; height: 80%; top: 10%;left:20%;display: none;overflow:hidden;">
    <div style="position:absolute;top:0;left:0;width: 100%;height:25px;">
    <span id="close-button"class="close-button"onclick="CloseDiv('showPict','fade')">X</span>
    </div>
  <div style="width: 100%;height:100%;position:absolute;left:0;top: 0;overflow-y: scroll;">
    <img id = "img-holder" width="100%" style="position:relative;dispaly:block;-webkit-transform-origin:50% 50%;" src="" alt="">
  </div>
</div>
</html>
