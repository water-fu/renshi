<%@page import="com.group.webFramework.uitl.SessionControl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setAttribute("currentId", SessionControl.getOpId(request));
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<div class="mainContent_left">
            <span class="mianCon_left_top">
                <img src="" alt="" link="${accountInfoBean.headUrl}" class="headerUrl" />
                <p><a href="${path}/blog/${currentId}"><i>我的空间</i></a></p>
            </span>
            <div class="mainLeftList">
                <a href="${path}/doctor/toBasicInfo?id=${currentId}" ><i>·</i>个人基础信息<b></b></a>
                <a href="${path}/doctor/toEduWork?id=${currentId}" ><i>·</i>教育工作信息<b></b></a>
                <a href="${path}/doctor/toAchievement?id=${currentId}" ><i>·</i>我的成就<b></b></a>
                <a href="${path}/doctor/toCertifiCation?id=${currentId}"><i>·</i>认证资料<b></b></a>
                <a href="${path}/doctor/toSecurity?id=${currentId}"><i>·</i>账户安全<b></b></a>
            </div>
        </div>
</body>
</html>