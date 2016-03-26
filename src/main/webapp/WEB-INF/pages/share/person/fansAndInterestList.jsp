<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/pages/common/include.jsp"%>
<!DOCTYPE html>

<c:if test="${!empty pageQueryResult.list}">
	<c:forEach items="${pageQueryResult.list}" var="map">
		<div class="message-content">
			<div class="message-left"><!--  -->
				<a  href="${path}/blog/${map.ACCOUNT_ID}"><img src="${path}/common/showImage?imageUrl=${map.HEAD_URL}" alt=""
					link="${map.HEAD_URL}"></a>
			</div>
			<div class="message-right">
				<div class="m-r-l">
					<p class="user-name color-666 font-14">
						<a href="${path}/blog/${map.ACCOUNT_ID}"><em
							class="u-name font-16">${map.REAL_NAME}</em></a><span>${map.BELONG_DEPT}</span><span>${map.WORK_PROFESS}</span>
					</p>
					<p class="interest color-666">
						<a href="${path}/blog/${map.ACCOUNT_ID}">
						<span>关注
						<em>${map.FOLLOW_NUM}</em>
						</span></a>
						|
						<a href="${path}/blog/${map.ACCOUNT_ID}">
						<span>粉丝
						<em>${map.FANS_NUM}</em>
						</span>
						</a>
						|<a href="${path}/blog/${map.ACCOUNT_ID}">
						<span>人气
						<em>${map.BROWER_NUM}</em>
						</span>
						</a>
					</p>
					<p class="user-intro color-333">
						<span>简介：</span><a href="${path}/blog/${map.ACCOUNT_ID}"><em>${map.PERSON_INFRO}</em>
						</a>
					</p>
					<p class="user-achieve color-666">
						<strong>成就：</strong>
						<a href="${path}/blog/${map.ACCOUNT_ID}"><span class="video">视频<em>${map.VIDEO_NUM}</em></span></a>
						|
						<a href="${path}/blog/${map.ACCOUNT_ID}"><span>文章<em>${map.ARTICLE_NUM}</em></span></a>
						|
						<a href="${path}/blog/${map.ACCOUNT_ID}"><span>病例<em>${map.CASE_NUM}</em></span>
						</a>|
						<a href="${path}/blog/${map.ACCOUNT_ID}"><span>文件<em>${map.COURSE_NUM}</em></span></a>
					</p>
				</div>
				<div class="m-r-r hidden">
					<div class="inter-status">
						<img src="../images/person/interest.png" alt=""> <select
							name="" id="">
							<option value="">更多</option>
						</select>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</c:if>

<%@ include file="/WEB-INF/pages/common/page.jsp"%>

<script type="text/javascript">
	function getPageData(pageNo) {
		var params = $('#queryForm').formSerialize() + '&pageNo=' + pageNo;
		//alert(params);
		var isFanOrInterest = $('#isFanOrInterest').val();
		var url = path + '';
		if (isFanOrInterest == 'fans') {
			url = url + '/blog/pagefans';
		} else if (isFanOrInterest == 'interests') {
			url = url + '/blog/pageInterests';
		}
		$.ajax({
			type : 'get',
			url : url,
			data : params,
			dataType : 'html',
			success : function(result) {
				$('.message-list').html(result);
			}
		});
	}
	
	$(document).ready(function() {
		//用js替换href  
		/*alert("hah");
		var hrefString=$('#hrefWithID').attr('href');
		alert(hrefString);
		var isFanOrInterest = $('#isFanOrInterest').val();
		if(isFanOrInterest == 'interests'){//默认是粉丝
			hrefString=hrefString.replace('isFanOrInterest','\'${map.FOLLOW_ACCOUNT}\'');
		}else if(isFanOrInterest == 'fans'){
			hrefString=hrefString.replace('isFanOrInterest','\'${map.ACCOUNT_ID}\'');
		}
		alert(hrefString);
		$('#hrefWithID').attr('href',hrefString);
		//var list=new Array();
		//list='${map.pageQueryResult.list}';
		
		//for(int i=0;i<list.size.i++){
		//   alert(list.ACCOUNT_ID);	
		//}
		$('#hrefWithID').click(function(){
			location.href = path +'/blog/${map.ACCOUNT_ID}';
		});*/
		//getPageData(1);
		//$('.message-left img').attr('src', path + '/common/showImage?imageUrl=' + $('.message-left img').attr('link'));
	});
</script>