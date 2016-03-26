<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ include file="/WEB-INF/pages/common/include.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="" method="post" id="login">
		<table>
			<tr>
				<td>用户名</td>
				<td><input name="name" id="name" type="text" /></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input name="pass" id="pass" type="password"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="登录" /></td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
	$().ready(function(){
		$('#login').formValidate({
			rules: {
				name: 'required',
				pass: 'required'
			},
			messages: {
				name: '请输入姓名',
				pass: '请输入密码'
			},
			submitSuccess: function(data) {
				alert('success');
			}
		});
	});
</script>
</html>