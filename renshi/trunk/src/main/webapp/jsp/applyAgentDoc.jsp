<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/common/include.jsp" %>
<html>
<head>
	<title>申请医生代理</title>
</head>
<body>
<table id="applayAgentDatagrid" class="easyui-datagrid" style="width:100%;height:100%" url="path+ '/agent/getProxyInfo'"
	   toolbar="#applyAgentDocTb" rownumbers="true" pagination="true">
	<thead>
	<tr>
		<th field="itemid" width="80">Item ID</th>
		<th field="productid" width="80">Product ID</th>
		<th field="listprice" width="80" align="right">List Price</th>
		<th field="unitcost" width="80" align="right">Unit Cost</th>
		<th field="attr1" width="150">Attribute</th>
		<th field="status" width="60" align="center">Stauts</th>
	</tr>
	</thead>
</table>

<div id="applyAgentDocTb" style="padding:3px">
	<span>医生姓名:</span><input id="itemid" >
	<span>所在医院:</span><input id="productid" >
	<a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()"> 查找</a>
</div>
</body>
<script type="text/javascript">
	$(function(){


	});

	function doSearch() {
		$('#applayAgentDatagrid').datagrid('load', {
			itemid: $('#itemid').val(),
			productid: $('#productid').val()
		});
	}
</script>
</html>