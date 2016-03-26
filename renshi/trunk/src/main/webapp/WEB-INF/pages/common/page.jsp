<%@page import="com.group.webFramework.uitl.PageQueryResult"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<%
	PageQueryResult pageQueryResult = (PageQueryResult) request.getAttribute("pageQueryResult");
	int totalPage = Integer.parseInt(pageQueryResult.getTotalPage() + "");
%>

<style>
	div.page{
		width: 65%;
		margin: 0 auto;
		height: 60px;
		text-align: center;
		line-height: 60px;
	}
	div.page span{
		position: relative;
		top: -10px;
		display: inline-block;
		border: 1px solid #d6d6d6;
		padding: 8px 4px;
	}
	li.page-prev {
		border-top-left-radius: 12px;
		border-bottom-left-radius: 12px;
		color: #d6d6d6;
		cursor: pointer;
	}
	li.page-next {
		border-top-right-radius: 12px;
		border-bottom-right-radius: 12px;
		color: #d6d6d6;
		cursor: pointer;
	}
	div.page ul{
		display: inline-block;
	
	}
	div.page li{
		float: left;
		overflow: hidden;
		display: inline-block;
		width: 30px;
		height: 30px;
		line-height: 30px;
		text-align: center;
		border: 1px solid #25be98;
		margin-left: 4px;
		margin-right: 4px;
	}
</style>

<div class="page">
	<ul>
		<li class="page-prev" onclick="doPage(-1)">&lt;&lt;</li>
		<%
			int index = 0;
			
			int start = (pageQueryResult.getPageNo() - 4 > 0) ? (pageQueryResult.getPageNo() - 4) : 1;
			int end = (pageQueryResult.getPageNo() + 4 < totalPage) ? (pageQueryResult.getPageNo() + 4) : totalPage;
			
			if(pageQueryResult.getPageNo() <= 4) {
				index = 4 - pageQueryResult.getPageNo() + 1;
				if((end + index) >= totalPage) {
					end = totalPage;
				} else {
					end = end + index;
				}
			}
			
			if(totalPage - pageQueryResult.getPageNo() <= 4) {
				index = 4 - (totalPage - pageQueryResult.getPageNo()) + 1;
				if((start - index) <= 1) {
					start = 1;
				} else {
					start = start - index + 1;
				}
			}
			for(int i = start; i <= end; i++) {
		%>
				<li><a href="javascript:void(0);" onclick="doPage(<%=i%>)"><%=i %></a></li>
		<%
			}
		%>
		<li class="page-next" onclick="doPage(-2)">&gt;&gt;</li>
	</ul>
</div>

<script type="text/javascript">
function doPage(num) {
	var currentPageNo = ${pageQueryResult.pageNo};
	var totalPage = ${pageQueryResult.totalPage};
	
	var pageNo = 1;
	
	//上一页
	if(num == -1) {
		if(currentPageNo - 1 > 0) {
			pageNo = currentPageNo - 1;
		} else {
			pageNo = currentPageNo;
		}
	}
	//下一页
	else if(num == -2) {
		if(currentPageNo + 1 < totalPage) {
			pageNo = currentPageNo + 1;
		} else {
			pageNo = totalPage;
		}
	}
	else {
		pageNo = num;
	}
	
	getPageData(pageNo);
}
</script>