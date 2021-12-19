<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<c:if test="${empty list }">
	<li>
		<h1 style="text-align: center;">暂无数据！</h1>
	</li>
</c:if>
<c:forEach items="${list }" var="o">
	<c:set var="number" value="${number+1 }"></c:set>
	<li style="border-bottom: 1px solid #ddd; padding-bottom: 10px;">
		<div class="list-content">
			<span><strong style="font-weight: bold;">评论人：</strong>${o.commentname }</span> <span
				style="float: right;"><strong style="font-weight: bold;">评论时间：</strong>${o.createdate }</span>
		</div>
		<div class="list-content" style="text-indent: 25px;">
		${o.content }
		</div>
		<c:if test="${o.replayname != null}">
		<div class="list-content">
			<span><strong style="font-weight: bold;">管理员（${o.replayname }）回复</strong></span> <span
				style="float: right;"><strong style="font-weight: bold;">回复时间：</strong>${o.replydate }</span>
		</div>
		<div class="list-content" style="text-indent: 25px;">
		${o.replycontent }
		</div>
		</c:if>
	</li>
</c:forEach>
<jsp:include page="/WEB-INF/views/client/page.jsp" flush="true"></jsp:include>