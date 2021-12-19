<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<table class="table mt10" id="datatable">
	<thead>
		<tr>
			<th class="tdnum">序号</th>
			<th>分类名称</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list }" var="o">
			<c:set var="number" value="${number+1 }"></c:set>
			<tr>
				<td data-type="num">${number }</td>
				<td>${o.name }</td>
				<td class="tc">
					<a data-btn-type="delete" data-id="${o.id }" href="javascript:void(0);">删除</a>&#12288;
					<a data-btn-type="edit" data-url="admin/category/toadd?id=${o.id }" href="javascript:void(0);">编辑</a>&#12288;
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<jsp:include page="/WEB-INF/views/admin/page.jsp" flush="true"></jsp:include>