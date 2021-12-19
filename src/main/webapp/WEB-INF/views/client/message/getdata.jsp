<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<table class="table mt10" id="datatable">
	<thead>
		<tr>
			<th class="tdnum">序号</th>
			<th>姓名</th>
			<th>邮箱</th>
			<th>主题</th>
			<th style="width:20%;">留言内容</th>
			<th>留言时间</th>
			<th>回复内容</th>
			<th>回复人</th>
			<th>回复时间</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list }" var="o">
			<c:set var="number" value="${number+1 }"></c:set>
			<tr>
				<td data-type="num">${number }</td>
				<td>${o.name }</td>
				<td>${o.email }</td>
				<td>${o.subject }</td>
				<td>${o.content }</td>
				<td>${o.createdate }</td>
				<td>
					<c:choose>
						<c:when test="${o.replycontent == null }">--</c:when>
						<c:otherwise>${o.replycontent }</c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${o.replayname == null }">--</c:when>
						<c:otherwise>${o.replayname }</c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${o.replydate == null }">--</c:when>
						<c:otherwise>${o.replydate }</c:otherwise>
					</c:choose>
				</td>
				<td class="tc">
					<a data-btn-type="delete" data-id="${o.id }" href="javascript:void(0);">删除</a>&#12288;
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<jsp:include page="/WEB-INF/views/admin/page.jsp" flush="true"></jsp:include>