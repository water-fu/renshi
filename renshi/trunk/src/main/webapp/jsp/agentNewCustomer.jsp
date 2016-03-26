<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/common/include.jsp" %>
<html>
<head>
    <title>代理商新增客户</title>
</head>
<body>
<form id="agentNewCustomertForm">
  登录用户名:<input type="text" name="loginAccount" value=""><br><br>

  登录密码:<input type="text" name="loginPassword" value=""><br><br>

  邮箱:<input type="text" name="email" value=""><br><br>

  手机号:<input type="text" name="phone" value=""><br><br>

  <input type="button" value="提交" id="submitBtn" onclick="addAgentSubAccount();"/>
  <input type="reset" value="重置"/>
</form>
</body>
</html>