<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form action="${ ctx }/admin/component/save" method="post" cssClass="form form-h form-h-10em"
	modelAttribute="bean" id="form1">
	<form:hidden path="id"/>
	<div class="dataBox">
		<c:forEach items="${dictionary.property }" var="p">
			<c:if test="${p.table=='component' and p.show}">
				<div class="f-gp">
					<div class="f-lb">
						<label class="f-label">${p.value }：</label>
					</div>
					<div class="f-ct">
						<form:input path="${p.key }" cssClass="f-text span4" />
					</div>
				</div>
			</c:if>
		</c:forEach>
	</div>

	<div class="f-ac f-infer">
		<input id="btn-submit" type="button" class="btn btn-m btn-prim-g btn-submit" value="提交">
	</div>
</form:form>