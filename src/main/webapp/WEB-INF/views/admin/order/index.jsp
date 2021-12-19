<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<div class="sz_rightTop">
	<form id="searchForm">
		<label class="ml10">订单编号：</label> <input type="text" name="ordercode"
			class="f-text span3"> 
		<label class="ml10">订单状态：</label>
		<select class="f-text span2" name="status">
			<option value="">全部</option>
			<c:forEach items="${status }" var="o">
				<option value="${o.key }">${o.value }</option>
			</c:forEach>
		</select>  
		<a href="javascript:void(0);" class="btn btn-m btn-warn-f"
			id="btnSearch">检索</a>
	</form>
</div>
<div class="sz_rightBody" id="table_box"></div>
<script>
	$(function() {
		var options = {
			ajaxurl : "${ctx}/admin/order/getdata"
		};
		$(this).loadPage(options); 
		$('#table_box').tablePage(options); 
		$("#btnSearch").formSearch(options);
		
		$('#table_box').execute('${ctx}/admin/order/send','[data-btn-type=send]',function(){
			$(this).loadPage(options); 
		});
	});
</script>
