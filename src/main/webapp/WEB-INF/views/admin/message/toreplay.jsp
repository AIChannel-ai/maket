<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<form:form action="${ ctx }/admin/message/save" method="post" cssClass="form form-h form-h-10em"
	modelAttribute="bean" id="form1" onSubmit="javascript:return(doSubmit(this));">
	<form:hidden path="id"/>
	<div class="dataBox">
		<div class="f-gp">
			<div class="f-lb">
				<label class="f-label">回复内容：</label>
			</div>
			<div class="f-ct">
				<form:textarea path="replycontent" cssStyle="width:600px;height:80px;" required="required"/>
			</div>
		</div>
	</div>

	<div class="f-ac f-infer">
		<input type="submit" class="btn btn-m btn-prim-g btn-submit" value="提交">
	</div>
</form:form>