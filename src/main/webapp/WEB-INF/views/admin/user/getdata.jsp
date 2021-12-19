<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<table class="table mt10" id="datatable">
	<thead>
		<tr>
			<th class="tdnum">序号</th>
			<th>账号名称</th>
			<th>密码</th>
			<th>用户类型</th>
			<th>性别</th>
			<th>邮箱</th>
			<th>手机</th>
			<c:forEach items="${dictionary.property }" var="p">
				<c:if test="${p.table=='user' and p.show}">
					<th>${p.value }</th>
				</c:if>
			</c:forEach>
			<th>创建时间</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list }" var="o">
			<c:set var="number" value="${number+1 }"></c:set>
			<tr>
				<td data-type="num">${number }</td>
				<td>${o.username }</td>
				<td>${o.password }</td>
				<td>${o.usertype }</td>
				<td>${o.sex }</td>
				<td>${o.email }</td>
				<td>${o.phone }</td>
				<c:forEach items="${dictionary.property }" var="p">
					<c:if test="${p.table=='user' and p.show}">
						<td>${o[p.key] }</td>
					</c:if>
				</c:forEach>
				<td>${o.createdate }</td>
				<td class="tc">
					<a data-btn-type="delete" data-id="${o.id }" href="javascript:void(0);">删除</a>&#12288;
					<a data-btn-type="edit" data-url="admin/user/toadd?id=${o.id }" href="javascript:void(0);">编辑</a>&#12288;
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<jsp:include page="/WEB-INF/views/admin/page.jsp" flush="true"></jsp:include>