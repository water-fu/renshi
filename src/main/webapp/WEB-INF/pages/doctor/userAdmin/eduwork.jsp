<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%
	String path = request.getContextPath();

	List<String> years = new ArrayList<String>();
	List<String> months = new ArrayList<String>();
	List<String> days = new ArrayList<String>();
	for(int i = 1900; i <= 2015; i++) {
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

<!DOCTYPE html>
<html>
<head>
    <title>教育工作信息</title>
    <link href="${cssPath}/userAdmin/base.css" rel="stylesheet" />
    <link href="${cssPath}/userAdmin/center.css" rel="stylesheet" />
    <script type="text/javascript" src="${jsLib}/jquery-1.11.3.min.js"></script>
    
</head>
<body>
	<%@ include file="/WEB-INF/pages/doctor/userAdmin/head.jsp" %>
  
    <div class="mainContent">
  		<%@ include file="/WEB-INF/pages/doctor/userAdmin/leftMenu.jsp" %>
  		  
        <div class="mainContent_right">
            <div class="basicInfo">
                <span class="basicInfoTit"><i></i>工作经历</span>
                <div class="workingContent">
                    <span class="workingContent_content" id="Addworkcontent"><b>+</b>添加工作经历</span>
                    <!--添加工作经历开始--->
                    <div class="addWorking" id="workExpires" style="display:none;">
                        <p></p>
                        <span class="basicInfoTit addWorkingTit"><i></i>工作经历</span>
                        
                        <form action="" method="post" id="workForm">
                        <input type="hidden" name="accountId" value="${accountInfoBean.accountId}">
                        
                        <table class="addworkingTab">
                                <tr>
                                    <td class="title_type addworingTime">任职时间： </td>
                                    <td><div class="workingTimeFrom">
                                        <select class="workingTime_box" id="startYear1">
                                            <c:forEach items="${years}" var="year">
												<option value="${year}">${year}年</option>
											</c:forEach>
                                        </select>
                                        <select class="workingTime_box" id="startMonth1">
                                            <c:forEach items="${months}" var="month">
												<option value="${month}">${month}月</option>
											</c:forEach>
                                        </select>
                                        <i>—</i>
                                        <select class="workingTime_box" id="endYear1">
                                            <c:forEach items="${years}" var="year">
												<option value="${year}">${year}年</option>
											</c:forEach>
                                        </select>
                                        <select class="workingTime_box" id="endMonth1">
                                            <c:forEach items="${months}" var="month">
												<option value="${month}">${month}月</option>
											</c:forEach>
                                        </select>
                                        </div>
                                        <input type="hidden" name="startDate" id="startDate1">
                                        <input type="hidden" name="endDate" id="endDate1">
                                    </td>
                                </tr>
                            <tr>
                               <td class="title_type addworingTime">工作城市： </td>
                               <td><div class="workingTimeFrom">
                               <select class="workingTime_box" id="country1" name="country1">
									<option value="中国">中国</option>
								</select>
								<select class="workingTime_box" id="province1" name="province1">
								</select>
								<select class ="workingTime_box" id="city1" id="city1">
								</select>
								<select style="display:none;" name="livearea1" id="livearea1"></select>
                                   </div>
                                   <input type="hidden" name="inCity" id="incity1" />
                               </td>
                            </tr>
                            <tr>
                                <td class="title_type addworingTime">所在单位： </td>
                                <td><input class="unit" type="text" id="companyName" name="companyName" maxlength="20"/></td>
                            </tr>
                            <tr>
                            	<td class="title_type addworingTime">科室： </td>
                                <td>
                                    <div class="workingTimeFrom">
	                                    <select class="workingTime_box addClassType deptInfo" name="belongDept">
	                                        
	                                    </select>
                                     </div>
                                </td>
                             </tr>
                             <tr>
                             	<td class="title_type addworingTime">职称： </td>
                                <td>
                                	<div class="workingTimeFrom">
                                       <select class="workingTime_box addClassType" name="prefessName">
                                           <option>主任医师</option>
                                           <option>副主任医师</option>
                                           <option>主治医师</option>
                                           <option>住院医师</option>
                                       </select>
                                    </div>
                                </td>
                             </tr>
                             <tr>
                                  <td class="title_type addworingTime"> </td>
                                  <td><div class="workingTimeFrom">
                                         <a class="addworkingBtn" href="javascript:void(0);" id="workSubmit">确定</a>
                                         <a class="addworkingBtn" id="cancel" href="javascript:void(0);">取消</a>
                                      </div>
                                  </td>
                              </tr>
                        </table>
                        </form>
                    </div>
                    
                    <!--添加工作经历结束--->
                    
                    <c:forEach items="${workList}" var="workInfoBean">
	                    <div class="workingDeatil">
	                        <p><i>【${workInfoBean.startDate} 至 ${workInfoBean.endDate}】</i>${workInfoBean.companyName}&nbsp &nbsp &nbsp &nbsp ${workInfoBean.inCity}</p>
	                        <span class="workPosition"><em>${workInfoBean.belongDept}｜${workInfoBean.prefessName}</em>
	                            <a class="delete hidden" id="ChanBox">修改</a>
	                            <a class="delete" id="workDel${workInfoBean.workId}" val="${workInfoBean.workId}">删除</a>
	                           
	                        </span>
	                        <!--修改工作经历开始--->
	                        <div class="addWorking alterWorking" id="alterExpirens" style="display:none;">
	                        <p class="alter_trangle"></p>
	                        <span class="basicInfoTit addWorkingTit"><i></i>修改工作经历</span>
	                        <table class="addworkingTab">
	                                <tr>
	                                    <td class="title_type addworingTime">任职时间： </td>
	                                    <td><div class="workingTimeFrom">
	                                        <select class="workingTime_box" id="startYear3">
	                                            <c:forEach items="${years}" var="year">
													<option value="${year}">${year}年</option>
												</c:forEach>
                                        	</select>
	                                        <select class="workingTime_box" id="startMonth3">
	                                            <c:forEach items="${months}" var="month">
													<option value="${month}">${month}月</option>
												</c:forEach>
	                                        </select>
                                        	<i>—</i>
	                                        <select class="workingTime_box" id="endYear3">
	                                            <c:forEach items="${years}" var="year">
													<option value="${year}">${year}年</option>
												</c:forEach>
	                                        </select>
	                                        <select class="workingTime_box" id="endMonth3">
	                                            <c:forEach items="${months}" var="month">
													<option value="${month}">${month}月</option>
												</c:forEach>
	                                        </select>
	                                        </div>
	                                        <input type="hidden" name="startDate" id="startDate3">
                                        	<input type="hidden" name="endDate" id="endDate3">
	                                    </td>
	                                </tr>
	                            <tr>
	                               <td class="title_type addworingTime">工作城市： </td>
	                                    <td><div class="workingTimeFrom">
	                                           <select class="workingTime_box" id="country3" name="country3">
									<option value="中国">中国</option>
								</select>
								<select class="workingTime_box" id="province3" name="province3">
								</select>
								<select class ="workingTime_box" id="city3" id="city3">
								</select>
								<select style="display:none;" name="livearea3" id="livearea3"></select>
	                                        </div>
	                                    </td>
	                                </tr>
	                            <tr>
	                                <td class="title_type addworingTime">所在单位： </td>
	                                <td><input class="unit" type="text"/></td>
	                            </tr>
	                            <tr>
	                                    <td class="title_type addworingTime">科室： </td>
	                                    <td><div class="workingTimeFrom">
	                                           <select class="workingTime_box addClassType deptInfo">
	                                               
	                                           </select>
	                                        </div>
	                                    </td>
	                                </tr>
	                               <tr>
	                                    <td class="title_type addworingTime">职称： </td>
	                                    <td><div class="workingTimeFrom">
	                                           <select class="workingTime_box addClassType">
	                                               <option>主任医师</option>
		                                           <option>副主任医师</option>
		                                           <option>主治医师</option>
		                                           <option>住院医师</option>
	                                           </select>
	                                        </div>
	                                    </td>
	                                </tr>
	                               <tr>
	                                    <td class="title_type addworingTime"> </td>
	                                    <td><div class="workingTimeFrom">
	                                           <a class="addworkingBtn" href="#">确定</a>
	                                           <a class="addworkingBtn" id="changeCancel" href="#">取消</a>
	                                        </div>
	                                    </td>
	                                </tr>
	                        </table>
	                    </div>
	                    <!--修改工作经历结束--->
	
                       <!--删除对话框开始--->
                       <div class="dialogContent" id="workdialog${workInfoBean.workId}" style="display:none" >
                           <div class="deleteDialog" >
                               <a class="OK okwork" val="${workInfoBean.workId}">确定</a>
                               <a class="OK cancelworkdialog">取消</a> 
                           </div>
                           <span class="arrow"></span>
                       </div>
                       <!--删除对话框结束--->
	                    </div>
                    </c:forEach>
                </div>
            </div>
            
            
            
            
            
            
            <div class="basicInfo profInfo contactInfo">
                <span class="basicInfoTit"><i></i>教育经历</span>
                <div class="workingContent">
                    <span class="workingContent_content" id="addDegrees"><b>+</b>添加教育背景</span>
                    <!--添加教育背景开始--->
                    <div class="addWorking" id="degrees" style="display:none">
                        <p></p>
                        <span class="basicInfoTit addWorkingTit"><i></i>教育背景</span>
                        
                        <form action="" method="post" id="eduForm">
                        <input type="hidden" name="accountId" value="${accountInfoBean.accountId}">
                        
                        <table class="addworkingTab">
                                <tr>
                                    <td class="title_type addworingTime">就读时间： </td>
                                    <td><div class="workingTimeFrom">
                                           <select class="workingTime_box" id="startYear2">
	                                            <c:forEach items="${years}" var="year">
													<option value="${year}">${year}年</option>
												</c:forEach>
                                        	</select>
	                                        <select class="workingTime_box" id="startMonth2">
	                                            <c:forEach items="${months}" var="month">
													<option value="${month}">${month}月</option>
												</c:forEach>
	                                        </select>
                                        	<i>—</i>
	                                        <select class="workingTime_box" id="endYear2">
	                                            <c:forEach items="${years}" var="year">
													<option value="${year}">${year}年</option>
												</c:forEach>
	                                        </select>
	                                        <select class="workingTime_box" id="endMonth2">
	                                            <c:forEach items="${months}" var="month">
													<option value="${month}">${month}月</option>
												</c:forEach>
	                                        </select>
	                                        </div>
	                                        <input type="hidden" name="startDate" id="startDate2">
                                        	<input type="hidden" name="endDate" id="endDate2">
                                    </td>
                                </tr>
                            <tr>
                               <td class="title_type addworingTime">工作城市： </td>
                                    <td><div class="workingTimeFrom">
		                                              <select class="workingTime_box" id="country2" name="country2">
									<option value="中国">中国</option>
								</select>
								<select class="workingTime_box" id="province2" name="province2">
								</select>
								<select class ="workingTime_box" id="city2" id="city2">
								</select>
								<select style="display:none;" name="livearea2" id="livearea2"></select>
                                        </div>
                                        <input type="hidden" name="inCity" id="incity2" />
                                    </td>
                                </tr>
                            <tr>
                                <td class="title_type addworingTime">就读学校： </td>
                                <td><input class="unit" type="text" placeholder="请输入学校名称" name="schoolName" maxlength="20"/></td>
                            </tr>
                            <tr>
                                    <td class="title_type addworingTime">专业： </td>
                                    <td><div class="workingTimeFrom">
                                           <select class="workingTime_box addClassType deptInfo" name="majorName">
                                               
                                           </select>
                                        </div>
                                    </td>
                                </tr>
                               <tr>
                                    <td class="title_type addworingTime">学位： </td>
                                    <td><div class="workingTimeFrom">
                                           <select class="workingTime_box addClassType" name="degreeName">
                                               <option>博士</option>
                                               <option>研究生</option>
                                               <option>本科</option>
                                           </select>
                                        </div>
                                    </td>
                                </tr>
                               <tr>
                                    <td class="title_type addworingTime"> </td>
                                    <td><div class="workingTimeFrom">
                                           <a class="addworkingBtn" href="javascript:void(0)" id="addEdu">确定</a>
                                           <a class="addworkingBtn" id="addeorkcancel" href="javascript:void(0);">取消</a>
                                        </div>
                                    </td>
                                </tr>
                        </table>
                        </form>
                    </div>
                    <!--添加教育背景结束--->
                    
                    
                    
                    <c:forEach items="${eduList}" var="eduInfoBean">
                    <div class="workingDeatil">
                        <p><i>【${eduInfoBean.startDate} 至 ${eduInfoBean.endDate}】</i>${eduInfoBean.schoolName}&nbsp &nbsp &nbsp &nbsp ${endInfoBean.inCity} </p>
                        <span class="workPosition"><em>${eduInfoBean.majorName}｜${eduInfoBean.degreeName}</em>
                            <a class="delete hidden" id="changeEdu">修改</a>
                            <a class="delete" id="delDegrees${eduInfoBean.educationId}" val="${eduInfoBean.educationId}">删除</a>
                        </span>
                        <!--修改教育背景开始--->
                        <div class="addWorking alterWorking" id="changeEduCon" style="display:none" >
                        <p class="alter_trangle"></p>
                        <span class="basicInfoTit addWorkingTit"><i></i>修改教育背景</span>
                        <table class="addworkingTab">
                                <tr>
                                    <td class="title_type addworingTime">就读时间： </td>
                                    <td><div class="workingTimeFrom">
                                           <select class="workingTime_box">
                                               <option>2015年</option>
                                               <option>2014年</option>
                                               <option>2013年</option>
                                           </select>
                                        <select class="workingTime_box">
                                               <option>10月</option>
                                            <option>9月</option>
                                               <option>8月</option> 
                                           </select>
                                        <i>—</i>
                                        <select class="workingTime_box">
                                               <option>2017年</option>
                                            <option>2014年</option>
                                               <option>2013年</option>
                                           </select>
                                        <select class="workingTime_box">
                                               <option>9月</option>
                                            <option>8月</option>
                                               <option>7月</option> 
                                           </select>
                                        </div>
                                    </td>
                                </tr>
                            <tr>
                               <td class="title_type addworingTime">工作城市： </td>
                                    <td><div class="workingTimeFrom">
                                           <select class="workingTime_box">
                                               <option>中国</option>
                                               <option>日本</option>
                                               <option>美国</option>
                                           </select>
                                        <select class="workingTime_box">
                                               <option>浙江</option>
                                            <option>湖北</option>
                                               <option>江西</option>  
                                           </select>
                                        
                                        <select class="workingTime_box">
                                               <option>杭州</option>
                                            <option>武汉</option>
                                               <option>南昌</option>
                                           </select>
                                        </div>
                                    </td>
                                </tr>
                            <tr>
                                <td class="title_type addworingTime">就读学校： </td>
                                <td><input class="unit" type="text"/></td>
                            </tr>
                            <tr>
                                    <td class="title_type addworingTime">专业： </td>
                                    <td><div class="workingTimeFrom">
                                           <select class="workingTime_box addClassType">
                                               <option>神经科</option>
                                           </select>
                                        </div>
                                    </td>
                                </tr>
                               <tr>
                                    <td class="title_type addworingTime">学位： </td>
                                    <td><div class="workingTimeFrom">
                                           <select class="workingTime_box addClassType">
                                               <option>博士</option>
                                               <option>研究生</option>
                                               <option>本科</option>
                                           </select>
                                        </div>
                                    </td>
                                </tr>
                               <tr>
                                    <td class="title_type addworingTime"> </td>
                                    <td><div class="workingTimeFrom">
                                           <a class="addworkingBtn" href="#">确定</a>
                                           <a class="addworkingBtn" id="educancel" href="#">取消</a>
                                        </div>
                                    </td>
                                </tr>
                        </table>
                    </div>
                    <!--修改教育背景结束--->

                        <!--删除对话框开始--->
                        <div class="dialogContent" id="eduDel${eduInfoBean.educationId}" style="display:none;" >
                            <div class="deleteDialog" >
                                <a class="OK okedudel" val="${eduInfoBean.educationId}">确定</a>
                                <a class="OK canceldegreesdialog">取消</a> 
                            </div>
                            <span class="arrow"></span>
                        </div>
                        <!--删除对话框结束--->
                    </div>
                    </c:forEach>
                    
                </div>
            </div>
              
        </div>

    </div>
    
    <%@ include file="/WEB-INF/pages/common/footer.jsp" %>
</body>
	<script type="text/javascript" src="<%=jsLib %>/jquery.form.js"></script>
	<script type="text/javascript" src="<%=jsPlugin %>/widget.ajaxFormSubmit.js"></script>
	<script type="text/javascript" src="<%=jsPlugin %>/widget.ajaxRequest.js"></script>
    <script >
   		var path = '<%=path%>';
   		
        $(function () {
            $(".mainLeftList a").eq(1).addClass("leftCurrent");
            
         	// 加载头像
            $('.headerUrl').attr('src', path + '/common/showImage?imageUrl=' + $('.headerUrl').attr('link'));
        });
        $(function () {
            $("#Addworkcontent").click(function () {
                $("#workExpires").toggle("slow");
            });
            $("#ChanBox").click(function () {
                $("#alterExpirens").toggle(1000);
            });
            
            // 删除按钮
            $('a[id^=workDel]').click(function() {
            	var $el = $(this);
            	$('#workdialog'+$el.attr('val')).toggle(1000);
            });
            
            // 取消
            $(".cancelworkdialog").each(function() {
            	var $el = $(this);
            	$el.click(function() {
            		$el.parents('.dialogContent').hide();
            	});
            });
            
            // 删除
            $('.okwork').each(function() {
            	var $el = $(this);
            	$el.click(function() {
            		var id = $el.attr('val');
            		$.ajaxRequest({
            			url: path + '/doctor/delWork',
            			data: {
            				'id': id
            			},
            			success: function(data) {
            				location.reload();
            			}
            		});
            	});
            });

            $("#addDegrees").click(function () {
                $("#degrees").toggle(1000);
            });
            
            $("#changeEdu").click(function () {
                $("#changeEduCon").toggle(1000);
            });
            
            //  删除
            $('a[id^=delDegrees]').click(function() {
            	var $el = $(this);
            	$('#eduDel'+$el.attr('val')).toggle(1000);
            });
            
            //  取消
            $(".canceldegreesdialog").each(function() {
            	var $el = $(this);
            	$el.click(function() {
            		$el.parents('.dialogContent').hide();
            	});
            });
            
         	// 删除
            $('.okedudel').each(function() {
            	var $el = $(this);
            	$el.click(function() {
            		var id = $el.attr('val');
            		$.ajaxRequest({
            			url: path + '/doctor/delEdu',
            			data: {
            				'id': id
            			},
            			success: function(data) {
            				location.reload();
            			}
            		});
            	});
            });
            
            $("#cancel").click(function () {
                $("#workExpires").hide();
            });
            
            $("#changeCancel").click(function () {
                $("#alterExpirens").hide();
            });
            
            $("#addeorkcancel").click(function () {
                $("#degrees").hide();
            });
            
            $("#educancel").click(function () {
                $("#changeEduCon").hide();
            });
            

            // 工作新增
            $('#workSubmit').click(function() {
            	
            	var syear = $('#startYear1').val();
            	var smonth = $('#startMonth1').val();
            	var eyear = $('#endYear1').val();
            	var emonth = $('#endMonth1').val();
            	
            	if(!checkDate(syear, smonth, eyear, emonth)) {
            		alert('请选择正确的任职时间');
            		return;
            	}
            	$('#startDate1').val(syear + '.' + smonth);
            	$('#endDate1').val(eyear + '.' + emonth);
            	
            	if($('#companyName').val() == '') {
            		alert('请填写所在单位');
            		return;
            	}
            	
            	var incity = $('#country1').val() + ',' + $('#province1').val() + ',' + $('#city1').val();
            	$('#incity1').val(incity);
            	
            	$('#workForm').attr('action', path + '/doctor/addWork');
            	
            	$.ajaxFormSubmit({
        			formId: 'workForm',
        			success: function(data) {
        				// 把字符串解析称JSON格式
        				var result = data;
        				if(typeof data === 'string') {
        					result = eval('(' + data + ')');
        				}
        				
        				if(result.code == 0) {
        					alert(result.msg);
        					
        					return;
        				}
        				
        				location.reload();
        			}
        		});
            });
        	
         // 工作新增
            $('#addEdu').click(function() {
            	
            	var syear = $('#startYear2').val();
            	var smonth = $('#startMonth2').val();
            	var eyear = $('#endYear2').val();
            	var emonth = $('#endMonth2').val();
            	
            	if(!checkDate(syear, smonth, eyear, emonth)) {	
            		alert('请选择正确的任职时间');
            		return;
            	}
            	$('#startDate2').val(syear + '.' + smonth);
            	$('#endDate2').val(eyear + '.' + emonth);
            	
            	if($('#schoolName').val() == '') {
            		alert('请填写就读学校');
            		return;
            	}
            	
            	var incity = $('#country2').val() + ',' + $('#province2').val() + ',' + $('#city2').val();
            	$('#incity2').val(incity);
            	
            	$('#eduForm').attr('action', path + '/doctor/addEdu');
            	
            	$.ajaxFormSubmit({
        			formId: 'eduForm',
        			success: function(data) {
        				// 把字符串解析称JSON格式
        				var result = data;
        				if(typeof data === 'string') {
        					result = eval('(' + data + ')');
        				}
        				
        				if(result.code == 0) {
        					alert(result.msg);
        					
        					return;
        				}
        				
        				location.reload();
        			}
        		});
            });
         
            $.ajaxRequest({
				url: path + '/doctor/getDeptInfo',
				data: {
					hospitalId: 1
				},
				success: function(data) {
					$('#deptInfo').html('');
					data = data.obj;
					for(var i = 0; i < data.length; i++) {
						var $option = $('<option>' + data[i].deptName + '</option>');
						$option.attr('value', data[i].deptName);
						
						$('.deptInfo').append($option);
					}
				}
			});
    });
        
        function checkDate(syear, smonth, eyear, emonth) {
        	if(syear > eyear) {
        		return false;
        	}
        	else if (syear == eyear) {
        		if(smonth > emonth) {
        			return false;
        		}
        	}
        	return true;
        }
</script>
<script type="text/javascript" src="${jsPath}/system/zone.js"></script>
	<script type="text/javascript">
	addressInit('province1','city1','livearea1','浙江省','杭州市','西湖区-330100');
	addressInit('province2','city2','livearea2','浙江省','杭州市','西湖区-330100');
	</script>

</html>
