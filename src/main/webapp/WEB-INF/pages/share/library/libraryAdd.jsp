<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.group.renshi.cache.DeptInfoCache"%>
<%@page import="com.group.renshi.bean.system.DeptInfoBean"%>
<%@page import="java.util.List"%>
<%@page import="com.group.renshi.constant.SystemConstantType"%>
<%@ include file="/WEB-INF/pages/common/include.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String libraryPath = SystemConstantType.LIBRARY_PATH;

	List<DeptInfoBean> list = DeptInfoCache.getInstance().getSelectList(1);
	request.setAttribute("list", list);
%>
    
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>认仕医生-文档发布</title>
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
        	<input type="hidden" name="shareType" value="4" />
        	
            <div class="case_left_share">
                <h1> <a href="#" class="share_select">分享你的文档</a></h1>
                    <table class="share_select_tab">
                        <tr>
                            <td class="share_select_title"></td>
                            <td >
                              <div class="video_type" style="width:450px;">
                                  <ul class="library_list">
                                      <li><em>格式支持：</em></li>
                                      <li><img src="${imagePath}/publish/word.png"/><em>Word</em></li>
                                      <li><img src="${imagePath}/publish/excel.png"/><em>Excel</em></li>
                                      <li><img src="${imagePath}/publish/pdf.png"/><em>PDF</em></li>
                                      <li><img src="${imagePath}/publish/text.png"/><em>Txt</em></li>
                                      <li><img src="${imagePath}/publish/ppt.png"/><em>PPT</em></li>
                                  </ul>
                                  <span>
                                    <div id="uploader" class="wu-example">
                                        <div id="thelist" class="uploader-list"></div>
                                        <div class="btns" style="margin-left: 180px;">
                                            <div id="picker" class="webuploader-container"><div class="webuploader-pick">选择文件</div><div id="rt_rt_19pi00h0f16uhb7tk3o58t5e11" style="position: absolute; top: 0px; left: 0px; width: 88px; height: 34px; overflow: hidden; bottom: auto; right: auto;"><input type="file" id="libraryFile" name="libraryFile" class="webuploader-element-invisible"><label style="opacity: 0; width: 100%; height: 100%; display: block; cursor: pointer; background-color: rgb(255, 255, 255); background-position: initial initial; background-repeat: initial initial;"></label></div></div>
                                        </div>
                                    </div><span  class="error upload-error" style="color:red;float:right;font-size:20px;display:none;">请选择上传文件！</span>
                                    
                                    <input type="hidden" name="fileUrl" id="libraryFileUrl" />
                                    <input type="hidden" name="fileName" id="fileName" />
                                    
                                    <span id="loading" 
                                    style="width:100%;text-align:center;color:#6b6b6b;font-size:14px;padding-bottom:25px;padding-top:25px;display:inline-block;">
                                                                                                             从我的电脑选择要上传的文件</span>
                                    
                              </div>
                              </span>
                            </td>
                        </tr>
                        <tr>
                            <td class="share_select_title">标题：</td>
                            <td class="title_num"><input name="shareTitle" id="shareTitle" class="case_title" style="width:450px;float:left;"type="text" placeholder="请输入标题(30字以内)" maxlength="30"/><span class="error title-error" style="color:red;display:none;">请输入标题！</span></td>
                        </tr>
                        <tr>
                            <td class="share_select_title">文档详情：</td>
                            <td class="case_detail_content">
                            <script id="editor" type="text/plain" style="width:450px;height:300px;white-space:normal"></script>
                            <span class="error cotent-error" style="color:red;display:none;float:left;">请输入详情！</span>
                            <textarea style="display:none;" name="shareDesc" id="shareDesc" class="case_detail video_detail" placeholder="请输入对该文档的详细叙述"></textarea></td>
                        </tr>
                        <tr>
                            <td class="share_select_title">科室：</td>
                            <td>
                            	<select class='case_title' name="belongProfess" id="belongProfess" style="width:115px;float:left;">
                                    <option value="">请选择科室</option>
                                    <c:forEach items="${list}" var="deptInfo">
                                    	<option value="${deptInfo.deptName}">${deptInfo.deptName}</option>
                                    </c:forEach>
                                </select> 
                                <span  class="error profess-error" style="color:red;display:none;">请选择科室！</span>  
                            </td>
                        </tr> 
                        
                        
                       <tr>
                            <td class="share_select_title">标签：</td>
                            <td class="label_list_content">
                                <input name="shareTag" style="width:450px;float:left;"id="shareTag" type="text" class="label_content video_label" placeholder="请输入对该文库的标签，例如：骨科,外科"/><span class="error tag-error" style="color:red;display:none;">请输入标签！</span>
                            </td>
                        </tr>
                        
                         <tr>
                            <td class="share_select_title">提醒谁看：</td>
                            <td class="">
                                <input style="width:450px;float:left;" id="callone" name="callone" class="case_title "  type="text" placeholder="提醒谁看@"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="share_select_title">浏览权限：</td>
                            <td >
                                <div class="share_copyright" style="width:450px;">
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
                               <div class="share_agrrment"><input type="checkbox" id="agree" name="agree" class="share_agrre"/><label style="cursor: pointer; "for="agree">同意接受《认仕网内容版权协议》</label><span class="error agree-error" style="color:red;display:none;" for="agree">请同意接受《认仕网内容版权协议》</span></div>
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

   <div id="contentDiv" style="display:none;"> </div>
   
 </div>
<!--内容结束-->
<!--底部开始-->
<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
<!--底部结束-->
</body>
<script src="${jsPath}/publish/jquery.autocomplete.min.js"></script>
<script>
	var libraryPath = '<%=libraryPath%>';
	
    // 数据可以异步获取
    var websites = [
        "@Google", "@NetEase", "@Sohu", "@Sina", "@Sogou", "@Baidu", "@Tencent",
        "@Taobao", "@Tom", "@Yahoo", "@JavaEye", "@Csdn", "@Alipay"
    ];
    
    $(function () {
        $("#callone").focus($(this).attr("contenteditable", true)).blur($(this).attr("contenteditable", false));
        
        // 点击上传文档
		$('.webuploader-pick').next().click(function() {
			$('#libraryFile')[0].click();
		});
        
        // 上传文档
        $('.webuploader-pick').next().on('change', '#libraryFile',  function() {
        	var   tag="";
				$('#loading').text("文档正在上传...");
        	$.fileUpload({
        		
    			fileElementId: 'libraryFile',
    			allowExt: ['.DOC', '.DOCX', '.XLS', '.XLSX', '.PPT', '.PPTX', '.TXT', '.PDF'],
    			data: {
    				storePath : libraryPath
    			},
    			success: function(data) {
    				tag='true';
    				//文档上传成功  隐藏错误信息
    				$('.upload-error').hide();
    				
    				$('#libraryFileUrl').val(data.obj[0]);
    				$('#fileName').val(data.obj[1]);
    				
    				$('#loading').text("文档上传成功");
    			},
    			failed: function(data) {
    				tag='false';
    				//文档上传失败  隐藏错误信息  不同属一类错误
    				$('.upload-error').hide();
    				
    				$('#loading').text("文档上传失败，请重新上传");
    			}
    		});
        	if(tag=="")//存在两种情况，1、选择了错误格式的文件2、重新选择了符合条件格式的另一个文件
        		$('#loading').text("点击重新上传文档");
        	
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
		
		//检查文本编辑器
		 $('body').click(function(){
            var ue = UE.getEditor('editor');
            var content = ue.getContent();

		   $('#shareDesc').val(content);
           var shareDesc = $.trim($('#shareDesc').val());
		   if(shareDesc == '') 
			 $('.cotent-error').show();
			 else  
			 $('.cotent-error').hide();
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
     
		//文件上传路径
		var libraryFileUrl =$('#libraryFileUrl').val();
		if(libraryFileUrl == '') {
			$('.upload-error').show();
			if($error == '') {
				$error = $('.upload-error');
			}
		}
		
		//文库标题
		var shareTitle = $.trim($('#shareTitle').val());
		if(shareTitle == '') {
			$('.title-error').show();
			if($error == '') {
				$error = $('.title-error');
			}
		}
		
		//文本编辑框
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
		
		//科室
		var belongProfess = $.trim($('#belongProfess').val());
		if(belongProfess == '') {
			$('.profess-error').show();
			if($error == '') {
				$error = $('.profess-error');
			}
		}
		
		//分享标签
		var shareTag = $.trim($('#shareTag').val());
		if(shareTag == '') {
			$('.tag-error').show();
			if($error == '') {
				$error = $('.tag-error');
			}
		}
		
		//协议同意
		var agree = $('#agree').attr('checked');
		if(!agree) {
			$('.agree-error').show();
			if($error == '') {
				$error = $('.agree-error');
			}
		}
		// 有错误
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
