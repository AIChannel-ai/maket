<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<div class="sz_rightTop">
	<form id="searchForm">
		<label class="ml10">商品代码：</label> <input type="text" name="productcode"
			class="f-text span3"> 
		<label class="ml10">名称：</label> <input type="text" name="title"
			class="f-text span3"> 
		<a href="javascript:void(0);" class="btn btn-m btn-warn-f"
			id="btnSearch">检索</a>
	</form>
</div>
<div class="sz_rightBody" id="table_box"></div>
<script>
	$(function() {
		var options = {
			ajaxurl : "${ctx}/admin/product/getdata"
		};
		$(this).loadPage(options); 
		$('#table_box').tablePage(options); 
		$("#btnSearch").formSearch(options);
		$('#table_box').deleteData('${ctx}/admin/product/delete');
		
		var rootUrl = '${ ctx }';
		$('#table_box').loadDataByEdit(rootUrl);
	});
</script>
