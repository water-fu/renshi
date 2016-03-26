<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/WEB-INF/pages/common/include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理登录页面</title>
<link rel="stylesheet" type="text/css" href="<%=jsLib %>/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=jsLib %>/easyui/themes/icon.css">
<script type="text/javascript" src="<%=jsLib %>/easyui/jquery.easyui.min.js"></script>
  <style>
    .container{
      margin: 0 auto;
      width: 400px;
      height: 600px;
      text-align: center;
    }
  </style>
</head>
<body>
<div class="container">
<h1>后台登录</h1>
<div class="easyui-panel" title="后台系统登录" style="width:400px;padding:30px 70px 20px 70px">
  <form id="loginForm">
    <div style="margin-bottom:10px">登录帐号：
      <input name="loginAccount" class="easyui-textbox" style="width:100%;height:40px;padding:12px"
             data-options="prompt:'登录帐号',iconCls:'icon-man',iconWidth:38">
    </div>
    <div style="margin-bottom:20px">密码：
      <input name="loginPassword" class="easyui-textbox" type="password" style="width:100%;height:40px;padding:12px"
             data-options="prompt:'登录密码',iconCls:'icon-lock',iconWidth:38">
    </div>
  </form>
  <%--<div style="margin-bottom:20px">
    <input type="checkbox" checked="checked">
    <span>Remember me</span>
  </div>--%>
    <%--<input type="submit" value="登录" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="padding:5px 0px;width:100%;"/>--%>
    <a href="javascript:void(0);"  class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="submitForm();" style="padding:5px 0px;width:100%;">
      <span style="font-size:14px;">登录</span>
    </a>
  </div>
</div>
</body>
<script type="text/javascript">
  $(function(){

  });

  function submitForm() {
    $.ajax({
      async: false,
      type: 'get',
      url: 'admin/login',
      data: $('#loginForm').formSerialize(),
      dataType: 'json',
      success: function (data) {
        if(data.code == 1){
          showMsg('登录成功！4秒后自动跳转到后台首页。');
          setTimeout(function(){window.location = path +'/admin/manage';}, 4001);
        }
        if(data.code == 0){
          showMsg(data.msg);
        }
      },
      error:function(){
        showMsg('用户名或密码错误，登录失败！');
      }
    });
  }


  function showMsg(msg){
    $.messager.show({
      title: '提示',
      msg: msg,
      showType: 'show',
      style:{right:'', bottom:''}
    });
  }
</script>
</html>