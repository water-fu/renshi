<%@ page import="com.group.webFramework.entity.AdminDetails" %>
<%@ page import="com.group.renshi.bean.admin.UserBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/WEB-INF/pages/common/include.jsp" %>
<html>
<%
  String loginMsg = "";
  AdminDetails adminDetails = (AdminDetails) request.getSession().getAttribute("ADMIN_DETAILS");
  UserBean userBean = adminDetails.getUserBean();
  String type = userBean.getUserType();
  if("1".equals(type)){
    loginMsg = "认仕网管理员：" + userBean.getLoginAccount();
  }
  if("2".equals(type)){
    loginMsg = "认仕网代理商："+ userBean.getLoginAccount();
  }
  if("3".equals(type)){
    loginMsg = "认仕网代理商子账号用户："+ userBean.getLoginAccount();
  }
%>
<style>
  A:link {
    color: black; text-decoration: none
  }
  A:visited {
    color: red; text-decoration: underline
  }
  A:hover {
    color: #128005; text-decoration: none
  }
  A:active {
    color: #ff7744;
    text-decoration: underline;
  }
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理首页</title>
<link rel="stylesheet" type="text/css" href="<%=jsLib %>/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=jsLib %>/easyui/themes/icon.css">
<script type="text/javascript" src="<%=jsLib %>/easyui/jquery.easyui.min.js"></script>
</head>
<body class="easyui-layout">
<div data-options="region:'north',border:false" style="height:80px;background:rgba(241, 236, 250, 0);padding:10px">
<div><%=loginMsg%> --欢迎您!<br/><br/>
  <a href="javascript:void(0);" onclick="exitSystem();">退出系统</a>&nbsp;&nbsp;&nbsp;<a href="javascript:void(0);" onclick="modifyAdminPwd();">修改管理员密码</a></div>
  <h1 align="center">认仕网后台管理首页</h1>
  <input type="hidden" id="userId" value="<%=userBean.getUserId()%>"/>
</div>
<div data-options="region:'west',split:true,title:'功能列表',collapsible:false" style="width:150px;">
    <ul id="tt"></ul>
</div>
<%--<div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">east region</div>--%>
<%--<div data-options="region:'south',border:false" style="height:50px;background:rgba(169, 250, 205, 0);padding:10px;">south region</div>--%>
<div data-options="region:'center'">
  <div class="easyui-tabs" fit="true" border="false" id="tabs">
    <div title="首页">这里是后台管理系统</div>
  </div>
</div>
  <div id="tabsMenu" class="easyui-menu" style="width:120px;">
    <div name="close">关闭</div>
    <div name="Other">关闭其他</div>
    <div name="All">关闭所有</div>
  </div>
</body>

<script type="text/javascript">
$(function(){
});


  function initData(){
    //1:后台管理员 2:代理商 3:子账号
    var userData = new Object();
    userData.userType = ${userBean.userType};
    userData.status = ${userBean.status};
    return userData;
  }

  /**
  * 添加子帐号
   */
  function addAgentSubAccount(){
    var flag = false;
    var param = $('#agentSubAccountForm').serialize();
    $.ajax({
      type: 'post',
      url: path + '/admin/addAgentSubAccountInfo',
      data: param,
      dataType: 'json',
      success: function (data) {}
    });
    //关闭dialog
    $('#agentSubAccountDialog').dialog('close');
    //刷新datagrid
    $('#子账号管理').datagrid('reload');
  }

  function exitSystem(){
    //删除session，跳转到登录页面
    $.ajax({
      type: 'get',
      url: path + '/admin/logout',
      success: function (data) {
        console.log('clean session success.');
      }
    });
    window.location = path +'/admin';
  }

  function modifyAdminPwd(){
    var len = $('#window_AdminModifyPwd').length;
    if(len <= 0){//添加window div元素
      $('body').append('<div id="window_AdminModifyPwd"></div>');
      $('#window_AdminModifyPwd').window({
        draggable: false,
        modal: true,
        minimizable: false,
        closed: true,
        width: 400,
        height: 250,
        title: '修改管理员密码',
        href: path+ '/jsp/adminModifyPwd.jsp'
      });
      $('#window_AdminModifyPwd').window('open');
    }else{
      $('#window_AdminModifyPwd').window('open');
    }
  }
</script>
<script type="text/javascript" src="<%=jsPath %>/admin/adminDatagrid.js"></script>
<script type="text/javascript" src="<%=jsPath %>/admin/agentDatagrid.js"></script>
<script type="text/javascript" src="<%=jsPath %>/admin/tree.js"></script>
<script type="text/javascript" src="<%=jsPath %>/admin/adminCommmon.js"></script>
<%--<script type="text/javascript" src="<%=jsLib %>/json2.js"></script>--%>
</html>