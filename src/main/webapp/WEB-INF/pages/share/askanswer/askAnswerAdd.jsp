<%@page import="com.group.renshi.cache.DeptInfoCache"%>
<%@page import="com.group.renshi.bean.system.DeptInfoBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.group.renshi.constant.SystemConstantType"%>
<%@ include file="/WEB-INF/pages/common/include.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String casePath = SystemConstantType.QUESTION_PATH;

	List<DeptInfoBean> list = DeptInfoCache.getInstance().getSelectList(1);
	request.setAttribute("list", list);
%>
    
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>认仕医生-医问发布</title>
    <link href="${cssPath}/publish/post.css" rel="stylesheet" />
    <link href="${cssPath}/publish/webuploader.css" rel="stylesheet" />    
    <link href="${cssPath}/publish/jquery.autocomplete.css" rel="stylesheet" />
</head>
<body>
<!--头部开始-->
<%@ include file="/WEB-INF/pages/common/header.jsp" %>
<!--头部结束-->
<div class="case_wrap">
    <div class="case_content">
        <div class="case_content_left">
        	<form action="" method="post" id="saveForm">
        	<input type="hidden" name="shareType" value="5" />
        
            <div class="case_left_share">
                <h1> <a href="javascript:void(0);" class="share_select" >发布您的医问</a></h1>
                    <table class="share_select_tab">
                        <tr>
                            <td class="share_select_title">标题：</td>
                            <td class="title_num">
                            <input name="shareTitle" style="float:left;width: 450px;"id="shareTitle" class="case_title" type="text" placeholder="请输入标题(30字以内)" maxlength="30"/>
                            <span class="error title-error" style="color:red;display:none;">请输入标题！</span></td>
                        </tr>
                        <tr>
                            <td class="share_select_title">科室：</td>
                            <td>
                            	<select class='case_title' style="width: 115px;float:left;" 
                            	      name="belongProfess" id="belongProfess">
                                    <option value="">请选择科室</option>
                                    <c:forEach items="${list}" var="deptInfo">
                                    	<option value="${deptInfo.deptName}">${deptInfo.deptName}</option>
                                    </c:forEach>
                                </select>
                                <span class="error profess-error" style="color:red;display:none;">请选择科室！</span>
                            </td>
                        </tr> 
                       <!--  <tr>
                            <td class="share_select_title">性别：</td>
                            <td class="">
                            	<select name="patientSex" class="case_title" style="float:left;width:auto;">
                            		<option value="男">男</option>
                            		<option value="女">女</option>
                            	</select>
                            	<input id="patientSex" name="patientSex" class="case_title" type="text" placeholder="请输入病人的性别" />
                            </td>
                        </tr>
                        <tr>
                            <td class="share_select_title">年龄：</td>
                            <td class=""><input id="patientAge" style="float:left;width:auto;"name="patientAge" maxlength="3" class="case_title" type="text" placeholder="请输入病人的年龄" onkeyup="value=value.replace(^[0-9]*$,'')" />
                             <span class="error age-error" style="color:red;display:none;">请输入正确的年龄！</span>
                            </td>
                        </tr> -->
                        <tr>
                            <td class="share_select_title">问题详情：</td>
                            <td class="case_detail_content">
                            <script id="editor" type="text/plain" style="width:450px;height:250px;white-space:normal"></script>
                            <span class="error cotent-error" style="color:red;display:none;">请输入详情！</span>
	                     <textarea style="display:none;"name="shareDesc" id="shareDesc" maxlength="120" class="case_detail" placeholder="请输入病人检查结果（描述下该病人的病史，目前的就医检查结果等）以及对该病例的一个总结"></textarea>
	                   
                            </td>
                        </tr>
                        <tr>
                        	<!-- <td></td>
                        	<td  class="case_detail_content" style="height:35px;float:left;background:#f1f1f1;">
                        		<a  href="javascript:void(0);" id="insertImage" style="font-size:20px;"> 
								<img src="../../images/publish/insert_pic.png" style="height:25px;margin:0;"/>
	                            插入图片
	                            <input type="file" id="caseFile" name="caseFile" class="webuploader-element-invisible" />
	                            </a>
	                            <input type="hidden" name="fileUrl" id="caseFileUrl" />
                                <input type="hidden" name="fileName" id="fileName" />
                        	</td> -->
                        	<td class="case_detail_content" align='center' style="line-height:36px;">
                        	  <img src="../images/publish/insert_pic.png" style="float:right;margin-right:10px;"/></td>
                        	<td  class="case_detail_content" ><!-- style="height:35px;float:left;background:#f1f1f1;" -->
                        		<a  href="javascript:void(0);" id="insertImage" > 
				                       <label style="cursor: pointer;"id="messageForImg"> 插入图片</label>
				                      <input type="file" id="caseFile" name="caseFile" class="webuploader-element-invisible" />
	                            </a>
                        	</td>
                        	<td>
                        	 <input type="hidden" name="fileUrl" id="caseFileUrl" />
                             <input type="hidden" name="fileName" id="fileName" />
                             </td>
                        </tr>
                        <tr>
                            <td class="share_select_title">标签：</td>
                            <td class="label_list_content">
                                <input name="shareTag" id="shareTag" style="float:left;width:450px;" maxlength="20" type="text" class="label_content video_label" placeholder="请输入对该医问医答的标签，例如：骨科,外科"/>
                                <span class="error tag-error" style="color:red;display:none;">请输入标签！</span>
                            </td>
                        </tr>
                        <tr>
                            <td class="share_select_title">提醒谁看：</td>
                            <td class=""><input id="callone" style="float:left;width:450px;"name="callone" maxlength="20" class="case_title" type="text" placeholder="@"/></td>
                        </tr>
                        <tr>
                            <td class="share_select_title">浏览权限：</td>
                            <td >
                                <div class="share_copyright" style="float:left;width:450px;">
                                    <input name="readPermission" value="1" checked="checked" class="copyright_sel" type="radio"/>公开
                                    <input name="readPermission" value="2" class="copyright_sel" type="radio"/>仅自己可见
<!--                                     <input name="readPermission" value="3" class="copyright_sel hidden" type="radio"/>指定好友 -->
                                    <input name="readPermission" value="4" class="copyright_sel" type="radio"/>全部好友
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="share_select_title"></td>
                            <td >
                               <div class="share_agrrment"><input type="checkbox" id="agree" name="agree" class="share_agrre"/><label for="agree" style="cursor: pointer;">同意接受《认仕网内容版权协议》</span><span class="error agree-error" style="color:red;display:none;" for="agree">请同意接受《认仕网内容版权协议》</span></div>
                            </td>
                        </tr>
                        <tr>
                            <td class="share_select_title"></td>
                            <td class="share_public"><a href="javascript:void(0);" class="share_btn">确认发布</a></td>
                        </tr>
                    </table>
            </div>
            </form>
            
        </div>
        <div class="case_content_right">
            <div class="case_instract">
                <h1>发布说明</h1>
                <a href="#">1.内容需清晰简洁,语句通顺,无明显错误；用简洁的文字提炼内容，不赘述</a>
                <a href="#">2.禁止发布涉及政治问题及不适合公开讨论的敏感内容</a>
                <a class="case_instract_last" href="#">3.禁止无意义,带有商业性质等无价值的内容,认仕会对相应内容进行隐藏或者删除处罚</a>
            </div>
            <div class="case_adv">
                <a href="#"><img src="${imagePath}/publish/ad.png"/></a>
                
            </div>
        </div>
   </div>
   
 </div>
<!--内容结束-->
<!--底部开始-->
<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
<!--底部结束-->
</body>
<script src="${jsPath}/publish/jquery.autocomplete.min.js"></script>
<script>
	var casePath = '<%=casePath%>';
	
    // 数据可以异步获取
    var websites = [
        "@Google", "@NetEase", "@Sohu", "@Sina", "@Sogou", "@Baidu", "@Tencent",
        "@Taobao", "@Tom", "@Yahoo", "@JavaEye", "@Csdn", "@Alipay"
    ];
    $(function () {
        $("#callone").focus($(this).attr("contenteditable", true)).blur($(this).attr("contenteditable", false));
        
        // 点击上传图片
		$('#insertImage').click(function() {
			$('#caseFile')[0].click(function(){
				$('#messageForImg').text('图片正在上传...');
			});
		});
        
        // 上传图片
        $('#insertImage').on('change', '#caseFile',  function() {
        	var tag='';
        	$.fileUpload({
    			fileElementId: 'caseFile',
    			data: {
    				storePath : casePath
    			},
    			success: function(data) {
    				tag="true";
    				$('#caseFileUrl').val(data.obj[0]);
    				$('#fileName').val(data.obj[1]);
    				$('#messageForImg').text('插入图片成功');
    			},
    			failed: function(data) {
    				tag="false";
    				$('#messageForImg').text('插入图片失败，请重新插入图片');
    			}
    		});
        	if(tag=="")//存在两种情况，1、选择了错误格式的文件2、重新选择了符合条件格式的另一个文件
         	   $('#messageForImg').text("点击重新上传图片");
        });
    });
    
 	// 同意协议切换
	$('#agree').attr('checked', false);
	$('#agree').change(function() {
		if(!$(this).attr('checked')) {
			$('#agree').attr('checked', true);
		} else {
			$('#agree').attr('checked', false);
		}
	});
	   //标题  失去焦点 进行 验证
	   $('#shareTitle').blur(function(){
		    var shareTitle = $.trim($('#shareTitle').val());
			if(shareTitle == '') {
				$('.title-error').show();
			} else {
				$('.title-error').hide();
			}
		});
		//文本编辑框  失去焦点进行验证
		 $('body').click(function(){
		    var ue =UE.getEditor('editor');
	        var content = ue.getContent();
	        $('#shareDesc').val(content);
			var shareDesc =  $.trim($('#shareDesc').val());
			if(shareDesc == '') {
				$('.cotent-error').show();
			}
			else
				$('.cotent-error').hide();
		 });
		//科室失去焦点  进行校验
		 $('#belongProfess').blur(function(){
		    var belongProfess = $.trim($('#belongProfess').val());
			if(belongProfess == '') {
				$('.profess-error').show();
			}
			else
				$('.profess-error').hide();
		 });
		//检查标签
		 $('#shareTag').blur(function(){
			var shareTag = $.trim($('#shareTag').val());
			if(shareTag == '') {
				$('.tag-error').show();
			}else
				$('.tag-error').hide();
		 });
			//检查协议
		 $('#agree').blur(function(){
			var agree = $('#agree').attr('checked');
			if(!agree) {
				$('.agree-error').show();
				}else
				$('.agree-error').hide();
			
		 });
 	// 提交按钮
	$('.share_btn').click(function() {
		
		$('.error').hide();
		
		// 第一个错误标签
		var $error = '';
		
		//标题  校验
		var shareTitle = $.trim($('#shareTitle').val());
		if(shareTitle == '') {
			$('.title-error').show();
			if($error == '') {
				$error = $('.title-error');
			}
		}
		
		//科室校验
		var belongProfess = $.trim($('#belongProfess').val());
		if(belongProfess == '') {
			$('.profess-error').show();
			if($error == '') {
				$error = $('.profess-error');
			}
		}
		
		//编辑框校验
		var ue = UE.getEditor('editor');
        var content = ue.getContent();
        $('#shareDesc').val(content);
		var shareDesc = $.trim($('#shareDesc').val());
		if(shareDesc == '') {
			$('.cotent-error').show();
			if($error == '') {
				$error = $('.cotent-error');
			}
		}
		
		//标签校验
		var shareTag = $.trim($('#shareTag').val());
		if(shareTag == '') {
			$('.tag-error').show();
			if($error == '') {
				$error = $('.tag-error');
			}
		}
		
		//协议校验
		var agree =  $.trim($('#agree').attr('checked'));
		if(!agree) {
			$('.agree-error').show();
			if($error == '') {
				$error = $('.agree-error');
			}
		}
		
		if($error != '') {
			// 定位
			var height = ($error.position().top - 15) > 0 ? ($error.position().top - 15) : 0;
			$('body').scrollTop(height);
			return;
		}
		// 提交
		
		$('#saveForm').attr('action', path+'/blog/addLibrary');
		// 设置按钮不可用
		$this = $(this);
		
		// 表单提交
		$.ajaxFormSubmit({
			formId: 'saveForm',
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
				
				location.href = path + '/blog/' + data.obj.accountId;
			}
		});
	});
</script>
<script type="text/javascript" src="${jsPlugin}/widget.ajaxFileUpload.js"></script>
<script type="text/javascript" charset="utf-8" src="${jsPlugin}/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${jsPlugin}/ueditor/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="${jsPlugin}/ueditor/lang/zh-cn/zh-cn.js"></script>
    <script>


            $(document).ready(function () {
                //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
                var ue = UE.getEditor('editor');
                ue.addListener("ready", function () {
                     // editor准备好之后才可以使用
                     ue.setContent($('#contentDiv').html());
                });
            
            });
    </script>
</html>