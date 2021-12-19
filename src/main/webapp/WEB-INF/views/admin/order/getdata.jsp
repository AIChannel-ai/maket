<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<table class="table mt10" id="datatable">
	<thead>
		<tr>
			<th class="tdnum">序号</th>
			<th>订单编号</th>
			<!-- <th>订单名称</th> -->
			<th>订单总价</th>
			<th>支付方式</th>
			<th>下单人</th>
			<th>订单状态</th>
			<th>创建时间</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list }" var="o">
			<c:set var="number" value="${number+1 }"></c:set>
			<tr>
				<td data-type="num">${number }</td>
				<td>${o.ordercode }</td>
				<%-- <td>${o.ordername }</td> --%>
				<td>${o.sumprice }</td>
				<td>${o.paytype }</td>
				<td>${o.username }</td>
				<td style="font-weight:bold;
					<c:choose>
						<c:when test="${'待发货' == o.status }">
							color: #ef0d4a;
						</c:when>
						<c:when test="${'已发货' == o.status }">
							color: #0044cc;
						</c:when>
						<c:when test="${'已完成' == o.status }">
							color: #0a980a;
						</c:when>
						<c:otherwise>
							color: #000;
						</c:otherwise>
					</c:choose>
				 ">${o.status }</td>
				<td>${o.createdate }</td>
				<td class="tc">
					<c:choose>
						<c:when test="${NO_SEND == o.status }">
							<b><a data-btn-type="send" data-id="${o.id }" class="btn btn-m btn-dang-f" href="javascript:void(0);">发货</a></b>
						</c:when>
						<c:otherwise>
							--
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<jsp:include page="/WEB-INF/views/admin/page.jsp" flush="true"></jsp:include>