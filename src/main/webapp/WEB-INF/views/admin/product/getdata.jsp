<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<table class="table mt10" id="datatable">
	<thead>
		<tr>
			<th class="tdnum">序号</th>
			<th>分类</th>
			<c:forEach items="${dictionary.property }" var="p">
				<c:if test="${p.table=='product' and p.listshow}">
					<th>${p.value }</th>
				</c:if>
			</c:forEach>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list }" var="o">
			<c:set var="number" value="${number+1 }"></c:set>
			<tr>
				<td data-type="num">${number }</td>
				<td>${o.categoryname }</td>
				<c:forEach items="${dictionary.property }" var="p">
					<c:if test="${p.table=='product' and p.listshow}">
						<c:choose>
							<c:when test="${p.input=='file' }">
								<td><img alt="" src="${ctx}/upload_files/${o[p.key] }" height="50"/></td>
							</c:when>
							<c:otherwise>
								<td>${o[p.key] }</td>
							</c:otherwise>
						</c:choose>
					</c:if>
				</c:forEach>
				<td class="tc">
					<a data-btn-type="delete" data-id="${o.id }" href="javascript:void(0);">删除</a>&#12288;
					<a data-btn-type="edit" data-url="admin/product/toadd?id=${o.id }" href="javascript:void(0);">编辑</a>&#12288;
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<jsp:include page="/WEB-INF/views/admin/page.jsp" flush="true"></jsp:include>