<%@page import="com.group.renshi.cache.DeptInfoCache"%>
<%@page import="com.group.renshi.bean.system.DeptInfoBean"%>
<%@page import="com.group.renshi.bean.system.HospitalInfoBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.group.renshi.constant.SystemConstantType"%>
<%@page import="com.group.renshi.cache.HospitalInfoCache"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/pages/common/include.jsp" %>

<%
	String headPath = SystemConstantType.HEAD_PATH;

	List<String> years = new ArrayList<String>();
	List<String> months = new ArrayList<String>();
	List<String> days = new ArrayList<String>();
	for(int i = 2015; i >=1900 ; i--) {
		years.add(i+"");	
	}
	for(int i = 1; i <= 12; i++) {
		months.add(i+"");	
	}
	for(int i = 1; i <= 31; i++) {
		days.add(i+"");	
	}
	
	request.setAttribute("years", years);
	request.setAttribute("months", months);
	request.setAttribute("days", days);
	
	List<HospitalInfoBean> hospitalList = HospitalInfoCache.getInstance().getSelectList();
	request.setAttribute("hospitalList", hospitalList);
%>

<html>
<head>
	<title>医生资格认证</title>
	<meta http-equiv="Content-Type" content="text/html" charset="UTF-8" />
	
	<link rel="stylesheet" href="${cssPath}/doctor/user.css">
</head>
<body>
	
	<%@ include file="/WEB-INF/pages/common/header.jsp" %>
	<!---->
	<div class="userInfo">
		<div class="userInfo-layout">
		
			<div class="userInfo-top">
				<p class="image"><img src="${imagePath}/doctor/reglogo.png" alt="" /></p>
				<p class="head"><em>医生资格认证</em></p>
			</div>
			
			<form method="post" action="" id="baseInfoForm">
				<input type="hidden" name="accountId" value="${accountInfoBean.accountId}" />
				<div class="userInfo-con">
					<div class="top">
						<img alt="" src="${imagePath}/doctor/status1.png">
					</div>
					
					<div class="hr"></div>
					
					<div class="base">
						<div class="intro">
							<p class="title"><span></span><em>基本信息填写</em></p>
							<p class="desc"><em>完善您的个人信息，将有助于其他医友更好的发现您</em></p>
							<p class="tip"><em class="star">*</em><em>号为必填</em></p>
						</div>
						
						<div class="clear"></div>
						<div class="hr_dashed"></div>
						
						<div class="area">
							<p>
								<label>认仕账号:</label>
								<span class="mf">${accountInfoBean.loginAccount}</span>
							</p>
							<p>
								<label>注册时间:</label>
								<span class="mf"><fmt:formatDate value="${accountInfoBean.createDate}" pattern="yyyy-MM-dd" /></span>
							</p>
							<p>
								<label><em class="star">*</em>真实姓名:</label>
								<input type="text" name="realName" id="realName" placeholder="真实姓名" class="mf">
								<span class="error realName-error">请输入您的真实姓名！</span>
							</p>
							<p>
								<label><em class="star">*</em>性别:</label>
								<select class="mf" name="accountSex">
									<option value="1">男</option>
									<option value="2">女</option>
								</select>
							</p>
							<p>
								<label>出生年月:</label>
								<select class="mf" id="year">
									<c:forEach items="${years}" var="year">
										<option value="${year}">${year}年</option>
									</c:forEach>
								</select>
								<select id="month">
									<c:forEach items="${months}" var="month">
										<option value="${month}">${month}月</option>
									</c:forEach>
								</select>
								<select id="day">
									<c:forEach items="${days}" var="day">
										<option value="${day}">${day}日</option>
									</c:forEach>
								</select>
								
								<input type="hidden" name="birthDate" id="birthDate" />
							</p>
							<p>
								<label>现居城市:</label>
								<select class="mf" id="country">
									<option>中国</option>
								</select>
								<select id="province">
									<option>浙江省</option>
									<option>上海省</option>
								</select>
								<select id="city">
									<option>杭州市</option>
									<option>金华市</option>
								</select>
								<input type="hidden" name="liveTown" id="liveTown" />
							</p>
							<div id="header">
								<label><em class="star">*</em>真实头像:</label>
								<div id="upload" class="mf">
									<div id="camera" class="headCamera">
										<input type="file" id="headFile" name="head" style="display: none" />
									</div>
									
									<div class="hr_vertical"></div>
									
									<div id="view">
										<img id="headImg" alt="" src="">
										<p>头像预览</p>
									</div>
									
									<div id="desc">
										<p>建议上传凸显您专业气质的真实照片底色需为浅色</p>
									</div>
									
								</div>
								<div class="clear"></div>
							</div>
							<p class="lh30">
								<input type="hidden" name="headUrl" id="headUrl" />
								
								<span class="error head-error mf ps">请上传您的真实头像</span>
								<span class="error head-sub-error mf ps"></span>
								<span class="mf ps">
									注：仅支持.jpg .jpeg .png .gif的图片格式，图片不要超过2M
									图片分辨率要小于366*105，请确保图片不侵犯他人权益
								</span>
							</p>
						</div>
					</div>
					
					<div class="hr"></div>
					
					<div class="profess">
						<div class="intro">
							<p class="title"><span></span><em>专业填写</em></p>
							<p class="desc"><em>以下信息将彰显您的专业和权威，展示您的个人主页中</em></p>
						</div>
						
						<div class="clear"></div>
						<div class="hr_dashed"></div>
						
						<div class="area">
							<p>
								<label><em class="star">*</em>职称：</label>
								<input type="text" placeholder="职称" id="inputProfess" name="profess" class="mf" readonly="readonly">
								<span class="error profess-error">请选择您的职称！</span>
							</p>
							<p>
								<label><em class="star">*</em>医院：</label>
								<input type="text" id="inputHospital" name="belongHospital" placeholder="医院" class="mf" readonly="readonly">
								<span class="error hospital-error">请输入您所在的医院！</span>
							</p>
							<p>
								<label><em class="star">*</em>科室：</label>
								<select class="mf" name="belongDept" id="deptInfo">
									
								</select>
							</p>
							<p>
								<label>所属医学会：</label>
								<input type="text" name="belongMedical" maxlength="25" placeholder="所属医学会" class="mf">
							</p>
							<p>
								<label>擅长领域：</label>
								<textarea name="specilArea" rows="5" maxlength="120" cols="33" class="mf" placeholder="&nbsp;&nbsp;擅长领域"></textarea>
							</p>
							<p>
								<label>个人简介：</label>
								<textarea name="personInfro" rows="5" maxlength="120" cols="33" class="mf" placeholder="&nbsp;&nbsp;个人简介"></textarea>
							</p>
						</div>
					</div>
					
					<div class="hr"></div>
					
					<div class="contact">
						<div class="intro">
							<p class="title"><span></span><em>联系信息</em></p>
							<p class="desc"><em>以下信息默认仅用于认仕网跟您联系是使用，我们不会泄漏您的个人信息</em></p>
						</div>
						
						<div class="clear"></div>
						<div class="hr_dashed"></div>
						
						<div class="area">
							<p>
								<label><em class="star">*</em>联系手机：</label>
								<input type="text" name="phoneNo" maxlength="15" id="phoneNo" placeholder="联系手机" class="mf">
								<span class="error phoneNo-error">请输入您的联系手机！</span>
							</p>
							<p>
								<label><em class="star">*</em>联系QQ：</label>
								<input type="text" name="qqNo" maxlength="20" id="qqNo" placeholder="联系QQ" class="mf">
								<span class="error qqNo-error">请输入您的联系QQ！</span>
							</p>
						</div>
					</div>
					
					<div class="hr"></div>
					
					<div class="operater">
						<div>
							<p class="get-sub" id="first-btn">下一步</p>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	
	<div id="selectProfess" class="inputSelect">
		<ul>
			<li class="work">
				<span>住院医师</span>
				<span>主治医师</span>
				<span>副主任医师</span>
				<span>主任医师</span>
			</li>
			<li class="academic">
				<span>讲师</span>
				<span>副教授</span>
				<span>教授</span>
			</li>
			<li class="education">
				<span>硕士生导师</span>
				<span>博士生导师</span>
			</li>
		</ul>
	</div>
	
	<div id="selectHospital" class="inputSelect">
		<ul>
			<c:forEach items="${hospitalList}" var="hospital">
				<li val="${hospital.hospitalId}">${hospital.hospitalName}</li>
			</c:forEach>
		</ul>
	</div>
	
	
	<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
	
</body>
<script type="text/javascript">
	var headPath = '<%=headPath%>';
</script>

<script type="text/javascript" src="${jsPlugin}/widget.select.js"></script>
<script type="text/javascript" src="${jsPlugin}/widget.ajaxFileUpload.js"></script>
<script type="text/javascript" src="${jsPath}/admin/adminBaseInfo.js"></script>
</html>