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
<meta charset="GBK">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />

<link rel="stylesheet" type="text/css" href="<%=cssLib %>/reset.css" />
<link rel="stylesheet" type="text/css" href="<%=cssPath %>/common/util.css" />

<!-- jQuery Library-->
<script type="text/javascript" src="<%=jsLib %>/jquery.js"></script>
<script type="text/javascript" src="<%=jsLib %>/jquery.form.js"></script>
<script type="text/javascript" src="<%=jsLib %>/jquery.ajaxfileupload.js"></script>
<script type="text/javascript" src="<%=jsLib %>/jquery.validate.js"></script>

<script type="text/javascript" src="<%=jsPlugin %>/widget.ajaxFormSubmit.js"></script>
<script type="text/javascript" src="<%=jsPlugin %>/widget.formValidate.js"></script>
<script type="text/javascript" src="<%=jsPlugin %>/widget.ajaxRequest.js"></script>
<script type="text/javascript" src="<%=jsPlugin %>/additional-methods.js"></script>

<script type="text/javascript">
	var path = '<%=path%>';
	var jsPlugin = '<%=jsPlugin%>';
</script>