<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form action="${ ctx }/admin/category/save" method="post" cssClass="form form-h form-h-10em"
	modelAttribute="bean" id="form1" onSubmit="javascript:return(doSubmit(this));">
	<form:hidden path="id"/>
	<div class="dataBox">
		<div class="f-gp">
			<div class="f-lb">
				<label class="f-label">分类名称：</label>
			</div>
			<div class="f-ct">
				<form:input path="name" cssClass="f-text span4" required="required"/>
			</div>
		</div>
	</div>

	<div class="f-ac f-infer">
		<input type="submit" class="btn btn-m btn-prim-g btn-submit" value="提交">
	</div>
</form:form>