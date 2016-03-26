<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
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

<!DOCTYPE html>
<html>
<head>
    <title>我的成就</title>
    <link href="${cssPath}/userAdmin/base.css" rel="stylesheet" />
    <link href="${cssPath}/userAdmin/center.css" rel="stylesheet" />
    <script type="text/javascript" src="${jsLib}/jquery-1.11.3.min.js"></script>
    
</head>
<body>
<!--#include file="/include/useradmin/header.inc"-->
	<%@ include file="/WEB-INF/pages/doctor/userAdmin/head.jsp" %>
	
    <div class="mainContent">
<!--#include file="/include/useradmin/leftmenu.inc"-->
		<%@ include file="/WEB-INF/pages/doctor/userAdmin/leftMenu.jsp" %>

        <div class="mainContent_right">
            <!--所获奖项开始-->
            <div class="basicInfo">
                <span class="basicInfoTit"><i></i>所获奖项</span>
                <div class="workingContent">
                    <span class="workingContent_content" id="addachieve"><b>+</b>添加奖项</span>
                      <!--添加奖项开始--->
                    <div class="addWorking" id="addachieveCon" style="display:none">
                        <p></p>
                        <span class="basicInfoTit addWorkingTit"><i></i>添加奖项</span>
                        
                        <form action="" method="post" id="form1">
                        	<input type="hidden" name="accountId" value="${accountInfoBean.accountId}">
                        	
							<table class="addworkingTab">
								<tr>
									<td class="title_type addworingTime">获奖时间：</td>
									<td>
										<div class="workingTimeFrom">
											<select class="workingTime_box" id="year1">
												<c:forEach items="${years}" var="year">
													<option value="${year}">${year}年</option>
												</c:forEach>
											</select> 
											<select class="workingTime_box" id="month1">
												<c:forEach items="${months}" var="month">
													<option value="${month}">${month}月</option>
												</c:forEach>
											</select>
										</div>
										<input type="hidden" name="prizeDate" id="prizeDate">
									</td>
								</tr>
								<tr>
									<td class="title_type addworingTime">奖项名称：</td>
									<td><input class="unit" id="prizeName" name="prizeName" maxlength="100" type="text" placeholder="请输入奖项的名称" /></td>
								</tr>
								<tr>
									<td class="title_type addworingTime">颁奖机构：</td>
									<td><input class="unit" id="awardDept" name="awardDept" maxlength="30" type="text" placeholder="请输入颁奖的机构" /></td>
								</tr>
								<tr>
									<td class="title_type addworingTime"></td>
									<td><div class="workingTimeFrom">
											<a class="addworkingBtn" href="javascript:void(0)" id="submit1">确定</a> <a
												class="addworkingBtn" id="addachieveCon_concel" href="#">取消</a>
										</div></td>
								</tr>
							</table>
						</form>
                    </div>
                    
                    <!--添加奖项结束--->
                    
                    <c:forEach items="${prizeList}" var="prizeInfo">
	                    <div class="workingDeatil">
	                        <p><i>【${prizeInfo.prizeDate}】</i>${prizeInfo.prizeName} </p>
	                        <span class="workPosition"><em class="achiveGoc">颁发机构：${prizeInfo.awardDept}</em>
	                            <a class="delete hidden" >修改</a>
	                            <a class="delete" id="delachive${prizeInfo.prizeId}" val="${prizeInfo.prizeId}">删除</a>
	                        </span>
	                        
	
	                        <!--删除对话框开始--->
	                        <div class="dialogContent" id="achivedialog${prizeInfo.prizeId}" style="display:none;">
	                            <div class="deleteDialog" >
	                                <a class="OK prizeDel" val="${prizeInfo.prizeId}">确定</a>
	                                <a class="OK concelDialog">取消</a> 
	                            </div>
	                            <span class="arrow"></span>
	                        </div>
	                        <!--删除对话框结束--->
	                    </div>
                    </c:forEach>
                    
                </div>
            </div>
            <!--所获奖项结束-->    


            <!--学术专著开始-->
            <div class="basicInfo profInfo">
                <span class="basicInfoTit"><i></i>学术专著</span>
                <div class="workingContent">
                    <span class="workingContent_content" id="addproduct"><b>+</b>添加专著</span>
                         <!--添加专著开始--->
                    <div class="addWorking" id="addproductCon" style="display:none;">
                        <p></p>
                        <span class="basicInfoTit addWorkingTit"><i></i>添加专著</span>

						<form action="" method="post" id="form2">
						<input type="hidden" name="accountId" value="${accountInfoBean.accountId}">
						
						<table class="addworkingTab">
							<tr>
								<td class="title_type addworingTime">出版时间：</td>
								<td>
									<div class="workingTimeFrom">
										<select class="workingTime_box" id="year2">
											<c:forEach items="${years}" var="year">
												<option value="${year}">${year}年</option>
											</c:forEach>
										</select> 
										<select class="workingTime_box" id="month2">
											<c:forEach items="${months}" var="month">
												<option value="${month}">${month}月</option>
											</c:forEach>
										</select>
									</div>
									<input name="publishDate" type="hidden" id="publishDate">
								</td>
							</tr>
							<tr>
								<td class="title_type addworingTime">专著标题：</td>
								<td><input class="unit" id="bookName" name="bookName" maxlength="100" type="text" placeholder="请输入书名" /></td>
							</tr>
							<tr>
								<td class="title_type addworingTime">出版机构：</td>
								<td><input class="unit" id="publishDept" name="publishDept" maxlength="30" type="text" placeholder="请输入书的出版机构" /></td>
							</tr>
							<tr>
								<td class="title_type addworingTime">身份：</td>
								<td>
									<div class="workingTimeFrom">
										<select class="workingTime_box addClassType" name="authorType">
											<option>第一作者</option>
											<option>第二作者</option>
											<option>译者</option>
										</select>
									</div>
								</td>
							</tr>
							<tr>
								<td class="title_type addworingTime">简介：</td>
								<td><textarea class="judgeBox" id="bookDesc" maxlength="100" name="bookDesc" placeholder="请输入……"></textarea></td>
							</tr>
							<tr>
								<td class="title_type addworingTime"></td>
								<td>
									<div class="workingTimeFrom">
										<a class="addworkingBtn" href="javascript:void(0);" id="submit2">确定</a>
										<a class="addworkingBtn" id="conceladdproductCon" href="javascript:void(0);">取消</a>
									</div>
								</td>
							</tr>
						</table>
						</form>
						
					</div>
                    <!--添加专著结束--->
                    
                    <c:forEach items="${bookList}" var="bookInfo">
	                    <div class="workingDeatil">
	                        <p><i>【${bookInfo.publishDate}】</i>${bookInfo.bookName}</p>
	                        <span class="workPosition"><em class="achiveGoc">作者：${bookInfo.authorType}、${bookInfo.publishDept}</em>
	                            <a class="delete hidden">修改</a>
	                            <a class="delete" id="delProduct${bookInfo.bookId}" val="${bookInfo.bookId}">删除</a>
	                        </span>
	                        
	
	                        <!--删除对话框开始--->
	                        <div class="dialogContent" id="productDilog${bookInfo.bookId}" style="display:none;">
	                            <div class="deleteDialog" >
	                                <a class="OK delBook" val="${bookInfo.bookId}">确定</a>
	                                <a class="OK cancelproductDilog">取消</a> 
	                            </div>
	                            <span class="arrow"></span>
	                        </div>
	                        <!--删除对话框结束--->
	                    </div>
                    </c:forEach>
                </div>
            </div>
            <!--学术专著结束-->
           
           
            <!--发明专利开始-->
            <div class="basicInfo profInfo">
                <span class="basicInfoTit"><i></i>发明专利</span>
                <div class="workingContent">
                    <span class="workingContent_content" id="addpatent"><b>+</b>添加专利</span>
                        <!--添加发明专利开始--->
                    <div class="addWorking" id="addpatentCon" style="display:none;">
                        <p></p>
                        <span class="basicInfoTit addWorkingTit" ><i></i>添加产品专利</span>

						<form action="" method="post" id="form3">
						<input type="hidden" name="accountId" value="${accountInfoBean.accountId}">
						
							<table class="addworkingTab">
								<tr>
									<td class="title_type addworingTime">获批时间：</td>
									<td>
										<div class="workingTimeFrom">
											<select class="workingTime_box" id="year3">
												<c:forEach items="${years}" var="year">
													<option value="${year}">${year}年</option>
												</c:forEach>
											</select> <select class="workingTime_box" id="month3">
												<c:forEach items="${months}" var="month">
													<option value="${month}">${month}月</option>
												</c:forEach>
											</select>
										</div>
										<input type="hidden" name="patentDate" id="patentDate">
									</td>
								</tr>
								<tr>
									<td class="title_type addworingTime">专利名称：</td>
									<td><input class="unit" id="patentName" maxlength="100" name="patentName" type="text" placeholder="请输入专利的名称" /></td>
								</tr>
								<tr>
									<td class="title_type addworingTime">专利编号：</td>
									<td><input class="unit" id="patentCode" maxlength="50" name="patentCode" type="text" placeholder="请输入专利的编号" /></td>
								</tr>
								<tr>
									<td class="title_type addworingTime">注册国家</td>
									<td>
										<div class="workingTimeFrom">
											<input class="unit" id="patentCountry" maxlength="10" name="patentCountry" type="text" placeholder="请输入专利国家" />
										</div>
									</td>
								</tr>
								<tr>
									<td class="title_type addworingTime"></td>
									<td>
										<div class="workingTimeFrom">
											<a class="addworkingBtn" href="javascript:void(0)" id="submit3">确定</a>
											<a class="addworkingBtn" id="canceladdpatentCon" href="javascript:void(0);">取消</a>
										</div>
									</td>
								</tr>
							</table>
						</form>

					</div>
                    <!--添加发明专利结束--->
                    </div>
                    
                    <c:forEach items="${patentList}" var="patentInfo">
					<div class="workingDeatil detailNext">
						<p>
							<i>【${patentInfo.patentDate}】</i>${patentInfo.patentName}
						</p>
						<span class="workPosition">
							<em class="achiveGoc">专利信息：${patentInfo.patentCountry}、${patentInfo.patentCode}</em>
							<a class="delete hidden">修改</a>
							<a class="delete" id="delpatentCon${patentInfo.patentId}" val="${patentInfo.patentId}">删除</a>
						</span>

						<div class="dialogContent" id="patentdialog${patentInfo.patentId}" style="display: none;">
							<div class="deleteDialog">
								<a class="OK delPatent" val="${patentInfo.patentId}">确定</a>
								<a class="OK canceldeleteDialog">取消</a>
							</div>
							<span class="arrow"></span>
						</div>
					</div>
				</c:forEach>
                    
                </div>
            <!--发明专利结束-->

              <!--我参加过的会议开始-->
             <div class="basicInfo profInfo attendMeeting">
                <span class="basicInfoTit"><i></i>我参加过的会议</span>
                <div class="workingContent">
                    <span class="workingContent_content" id="addmeting"><b>+</b>添加会议</span>
                          <!--添加会议开始-->
                       <div class="addWorking" id="addmetingCon" style="display:none">
                        <p></p>
                        <span class="basicInfoTit addWorkingTit"><i></i>添加工作会议</span>
                        
                        <form action="" method="post" id="form4">
                        <input type="hidden" name="accountId" value="${accountInfoBean.accountId}">
                        
							<table class="addworkingTab">
								<tr>
									<td class="title_type addworingTime">会议时间：</td>
									<td>
										<div class="workingTimeFrom">
											<select class="workingTime_box" id="year4">
												<c:forEach items="${years}" var="year">
													<option value="${year}">${year}年</option>
												</c:forEach>
											</select> 
											<select class="workingTime_box" id="month4">
												<c:forEach items="${months}" var="month">
													<option value="${month}">${month}月</option>
												</c:forEach>
											</select>
										</div>
										<input name="meetingDate" type="hidden" id="meetingDate">
									</td>
								</tr>
								<tr>
									<td class="title_type addworingTime">举办城市：</td>
									<td>
										<input class="unit" id="meetingAddress" maxlength="10" name="meetingAddress" type="text" placeholder="请输入举办城市" />
									</td>
									
								</tr>
								<tr>
									<td class="title_type addworingTime">会议名称：</td>
									<td><input class="unit" id="meetingName" maxlength="30" name="meetingName" type="text" placeholder="请输入会议的名称" /></td>
								</tr>
								<tr>
									<td class="title_type addworingTime">出席身份：</td>
									<td>
										<div class="workingTimeFrom">
											<select class="workingTime_box addClassType" name="meetingType">
												<option>人大代表</option>
												<option>医生</option>
												<option>院长</option>
											</select>
										</div>
									</td>
								</tr>
								<tr>
									<td class="title_type addworingTime"></td>
									<td>
										<div class="workingTimeFrom">
											<a class="addworkingBtn" href="javascript:void(0);" id="submit4">确定</a>
											<a class="addworkingBtn" id="canceladdmetingCon" href="javascript:void(0);">取消</a>
										</div>
									</td>
								</tr>
							</table>
							
						</form>
                        
                    </div>
                    <!--添加会议结束--->  
                    </div>
                    
                    <c:forEach items="${meetingList}" var="meetingInfo">
	                    <div class="workingDeatil detailNext">
	                         <p><i>【${meetingInfo.meetingDate}】</i>${meetingInfo.meetingName}</p>
	                        <span class="workPosition"><em class="achiveGoc">会议信息：${meetingInfo.meetingAddress}、${meetingInfo.meetingType}</em>
	                        	<a class="delete hidden">修改</a>
	                        	<a class="delete" id="delmeting${meetingInfo.meetingId}" val="${meetingInfo.meetingId}">删除</a>
	                        </span>
	                        
	                        <!--删除对话框开始--->
	                        <div class="dialogContent" style="display:none;" id="metingdiloalog${meetingInfo.meetingId}">
	                            <div class="deleteDialog" >
	                                <a class="OK delMeeting" val="${meetingInfo.meetingId}">确定</a>
	                                <a class="OK concelmetdiloalog">取消</a> 
	                            </div>
	                            <span class="arrow"></span>
	                        </div>
	                        <!--删除对话框结束--->
	                    </div>
                    </c:forEach>
                </div>
            <!--我参加过的会议结束-->  
        </div>

    </div>
<!--#include file="/include/useradmin/footer.inc"-->
</body>
	<script type="text/javascript" src="<%=jsLib %>/jquery.form.js"></script>
	<script type="text/javascript" src="<%=jsPlugin %>/widget.ajaxFormSubmit.js"></script>
	<script type="text/javascript" src="<%=jsPlugin %>/widget.ajaxRequest.js"></script>
<script >
	var path = '<%=path%>';
	
	$(function() {
		$(".mainLeftList a").eq(2).addClass("leftCurrent");
		
		// 加载头像
        $('.headerUrl').attr('src', path + '/common/showImage?imageUrl=' + $('.headerUrl').attr('link'));
		
		$('#submit1').click(function() {
			$('#form1').attr('action', path + '/doctor/addPrize');

			if($('#prizeName').val == '') {
				alert('请填写获奖名称');
				return;
			}
			if($('#awardDept').val == '') {
				alert('请填写颁奖单位');
				return;
			}

			$('#prizeDate').val($('#year1').val() + '.' + $('#month1').val());
			
			$.ajaxFormSubmit({
				
    			formId: 'form1',
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
		
		$('#submit2').click(function() {
			$('#form2').attr('action', path + '/doctor/addBook');
			
			if($('#bookName').val == '') {
				alert('请填写著作名称');
				return;
			}
			
			if($('#publishDept').val == '') {
				alert('请填写出版机构');
				return;
			}
			
			if($('#bookDesc').val == '') {
				alert('请填写著作描述');
				return;
			}
			
			$('#publishDate').val($('#year2').val() + '.' + $('#month2').val());
			
			$.ajaxFormSubmit({
    			formId: 'form2',
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
		
		$('#submit3').click(function() {
			$('#form3').attr('action', path + '/doctor/addPatent');
			
			if($('#patentName').val == '') {
				alert('请填写专利名称');
				return;
			}
			
			if($('#patentCode').val == '') {
				alert('请填写专利编码');
				return;
			}
			
			if($('#patentCountry').val == '') {
				alert('请填写专利国家');
				return;
			}
			
			$('#patentDate').val($('#year3').val() + '.' + $('#month3').val());
			
			$.ajaxFormSubmit({
    			formId: 'form3',
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
		
		$('#submit4').click(function() {
			$('#form4').attr('action', path + '/doctor/addMeeting');
			
			if($('#meetingAddress').val == '') {
				alert('请填写会议地址');
				return;
			}
			
			if($('#meetingName').val == '') {
				alert('请填写会议名称');
				return;
			}
			
			$('#meetingDate').val($('#year4').val() + '.' + $('#month4').val());
			
			$.ajaxFormSubmit({
    			formId: 'form4',
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
	});
	$(function() {
		$("#addachieve").click(function() {
			$("#addachieveCon").toggle(1000);
		});
		$("#addachieveCon_concel").click(function() {
			$("#addachieveCon").hide();
		});
		
		// 删除
		$('a[id^=delachive]').each(function() {
			var $el = $(this);
			$el.click(function() {
				$('#achivedialog' + $el.attr('val')).toggle(1000);
			});
		});
		
		// 取消删除
		$('.concelDialog').click(function() {
			$(this).parents('.dialogContent').hide();
		});
		
		// 删除数据
		$('.prizeDel').click(function() {
			var id = $(this).attr('val');
			
			$.ajaxRequest({
				url: path + '/doctor/delPrize',
				data: {
					id: id
				},
				success: function(data) {
					location.reload();
				}
			});
		});

		$("#addjudge").click(function() {
			$("#addjudgeCon").toggle(1000);
		});
		$("#cenceljudge").click(function() {
			$("#addjudgeCon").hide();
		});
		$("#changejudge").click(function() {
			$("#judgedialog").toggle(1000);
		});
		$("#conceljudegedialog").click(function() {
			$("#judgedialog").hide();
		});

		$("#addproduct").click(function() {
			$("#addproductCon").toggle(1000)
		});
		$("#conceladdproductCon").click(function() {
			$("#addproductCon").hide();
		});
		
		// 删除按钮
		$('a[id^=delProduct]').each(function() {
			var $el = $(this);
			$el.click(function() {
				$('#productDilog' + $el.attr('val')).toggle(1000);
			});
		});
		
		// 取消删除
		$(".cancelproductDilog").click(function() {
			$(this).parents('.dialogContent').hide();
		});
		
		// 删除数据
		$('.delBook').click(function() {
			var id = $(this).attr('val');
			
			$.ajaxRequest({
				url: path + '/doctor/delBook',
				data: {
					id: id
				},
				success: function(data) {
					location.reload();
				}
			});
		});

		$("#addpatent").click(function() {
			$("#addpatentCon").toggle(1000)
		});
		$("#canceladdpatentCon").click(function() {
			$("#addpatentCon").hide();
		});
		
		// 删除按钮
		$('a[id^=delpatentCon]').each(function() {
			var $el = $(this);
			$el.click(function() {
				$('#patentdialog' + $el.attr('val')).toggle(1000);
			});
		});
		
		// 取消删除
		$(".canceldeleteDialog").click(function() {
			$(this).parents('.dialogContent').hide();
		});

		// 删除数据
		$('.delPatent').click(function() {
			var id = $(this).attr('val');
			
			$.ajaxRequest({
				url: path + '/doctor/delPatent',
				data: {
					id: id
				},
				success: function(data) {
					location.reload();
				}
			});
		});
		
		
		$("#addmeting").click(function() {
			$("#addmetingCon").toggle(1000);
		});
		$("#canceladdmetingCon").click(function() {
			$("#addmetingCon").hide();
		});
		
		// 删除按钮
		$('a[id^=delmeting]').each(function() {
			var $el = $(this);
			$el.click(function() {
				$('#metingdiloalog' + $el.attr('val')).toggle(1000);
			});
		});
		
		// 取消删除
		$(".concelmetdiloalog").click(function() {
			$(this).parents('.dialogContent').hide();
		});
		
		// 删除数据
		$('.delMeeting').click(function() {
			var id = $(this).attr('val');
			
			$.ajaxRequest({
				url: path + '/doctor/delMeeting',
				data: {
					id: id
				},
				success: function(data) {
					location.reload();
				}
			});
		});
	});
</script>    
</html>
