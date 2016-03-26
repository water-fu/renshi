<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<div class="centerTop">
        <div class="navContent">
            <span class="navContLeft">最权威的医生互动交流平台 !</span>
            <div class="navContRight">
                <a href="#" id="homePage">首页</a>
                <a href="${path}/doctor/findDoctor">找医友</a>
                <a href="${path}/system/askanswer">医问医答</a>
                <a href="${path}/blog/video">视频</a>
                <a href="${path}/blog/point">观点</a>
                <a href="${path}/blog/case">病例</a>
                <a href="${path}/blog/library">文库</a>
            </div>
        </div>
    </div>
    <div class="logoBpx">
        <div class="logoCotent">
            <a href="#" class="logoLeft">
                <img src="${imagePath}/userAdmin/logo.png" />
            </a>
        </div>
    </div>
</body>
<script type="text/javascript">

$('#homePage').click(function() {
	location.href = path + '/';
});
</script>
</html>