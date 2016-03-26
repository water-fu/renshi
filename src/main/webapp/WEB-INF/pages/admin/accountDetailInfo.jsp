<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<style type="text/css">
	.f-left{

		float:left;}
	.f-right{
		float:right;}
	div.doc-content{
		width: 90%;
		margin:0 auto;
		overflow: hidden;
		margin-bottom: 20px;
		margin-top: 20px;
	}
	div.doc-intro{
		overflow:hidden;
		margin-bottom:15px;
	}
	p.doc-info{
		height: 30px;
		font-size: 1.2em;
		color: #666;
		overflow:hidden;
	}
	p.doc-detail{
		line-height: 23px;
		font-size: 0.925em;
	}
	p.doc-detail em{
		color: #000;
	}
	p.doc-detail span{
		color: #999;
	}
	.f-right img{
	width:100px;
	height:100px;}
	.doc-intro p{
	overhidden:hidden;}
	.doc-intro p span{
	width:90px;
	text-align:left;
	display:inline-block;}
	.doc-intro p{
		overhidden:hidden;}
	.doc-intro p span{
		width:90px;
		text-align:left;
		display:inline-block;}
</style>
<div class="doc-content">
	<div class="doc-intro">
		<div class="f-left">
			<p class="doc-info"><em class="doc-name">${userInfoBean.realName}</em><span>${userInfoBean.belongDept}</span><span>${userInfoBean.workProfess}</span></p>
			<p class="doc-detail"><em>个人简介：</em><span>${authenticInfoBean.workProfess}</span></p>
		</div>
		<div class="f-right">
			<img src="" alt="" link="${userInfoBean.headUrl}">
		</div>
	</div>
	<div class="doc-intro">
		<p class="f-left"><span>性别：</span><em><c:if test="${userInfoBean.accountSex=='1'}">男</c:if><c:if test="${userInfoBean.accountSex=='2'}">女</c:if></em></p>
		<p class="f-right"><span>出生日期：</span><em>${userInfoBean.birthDate}</em></p>
	</div>
	<div class="doc-intro">
		<p class="f-left"><span>故乡：</span><em>${userInfoBean.homeTown}</em></p>
		<p class="f-right"><span>所在科室：</span><em>${userInfoBean.belongDept}</em></p>
	</div>
	<div class="doc-intro">
		<p class="f-left"><span>现居住地：</span><em>${userInfoBean.liveTown}</em></p>
		<p class="f-right"><span>所在医院：</span><em>${userInfoBean.belongHospital}</em></p>
	</div>
	<div class="doc-intro">
		<p class="f-left"><span>工作职称：</span><em>${userInfoBean.workProfess}</em></p>
		<p class="f-right"><span>所属医学会：</span><em>${userInfoBean.belongMedical}</em></p>
	</div>
	<div class="doc-intro">
		<p class="f-left"><span>擅长领域：</span><em>${userInfoBean.specilArea}</em></p>
	</div>


	<div class="doc-intro">
		<p class="f-left"><span>工作职称：</span><em>${authenticInfoBean.workProfess}</em></p>
	</div>
	<div class="doc-intro">
		<p class="f-left"><span>学术职称：</span><em>${authenticInfoBean.academicProfess}</em></p>
	</div>
	<div class="doc-intro">
		<p class="f-left"><span>教育职称：</span><em>${authenticInfoBean.educationProfess}</em></p>
	</div>
	<div class="doc-intro">
		<p class="f-left"><span>职称级别：</span><em>${authenticInfoBean.professLevel}</em></p>
	</div>
	<div class="doc-intro">
		<p class="f-left"><span>身份证编码：</span><em>${authenticInfoBean.idCard}</em></p>
	</div>
	<div class="doc-intro">
		<p class="f-left"><span>身份证照片--正面：</span><em><img src="" alt="" link="${authenticInfoBean.frontUrl}"></em></p>
	</div>
	<div class="doc-intro">
		<p class="f-left"><span>身份证照片--反面：</span><em><img src="" alt="" link="${authenticInfoBean.backUrl}"></em></p>
	</div>
	<div class="doc-intro">
		<p class="f-left"><span>证书类型：</span><em>${authenticInfoBean.certificateType}</em></p>
	</div>
	<div class="doc-intro">
		<p class="f-left"><span>证书编号：</span><em>${authenticInfoBean.certificateNo}</em></p>
	</div>
	<div class="doc-intro">
		<p class="f-left"><span>照片地址：</span><em><img src="" alt="" link="${authenticInfoBean.certificateUrl}"></em></p>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		$('img').each(function() {
			var $this = $(this);
			$this.attr('src', path + '/common/showImage?imageUrl=' + $this.attr('link'));
		});
	});
</script>