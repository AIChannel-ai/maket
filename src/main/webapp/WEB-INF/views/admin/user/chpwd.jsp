<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form action="${ ctx }/admin/user/chpwd" method="post" cssClass="form form-h form-h-10em" id="form1" onSubmit="javascript:return(doSubmit(this));">
	<div class="dataBox">
		<div class="f-gp">
			<div class="f-lb">
				<label class="f-label">原密码：</label>
			</div>
			<div class="f-ct">
				<input type="password" name="oldPassword" class="f-text span4" required="required" autocomplete="off"/>
			</div>
		</div>
		<div class="f-gp">
			<div class="f-lb">
				<label class="f-label">新密码：</label>
			</div>
			<div class="f-ct">
				<input type="password" name="newPassword" class="f-text span4" required="required"/>
			</div>
		</div>
		<div class="f-gp">
			<div class="f-lb">
				<label class="f-label">确认密码：</label>
			</div>
			<div class="f-ct">
				<input type="password" name="rePassword" class="f-text span4" required="required"/>
			</div>
		</div>
		
	</div>

	<div class="f-ac f-infer">
		<input type="submit" class="btn btn-m btn-prim-g btn-submit" value="提交">
	</div>
</form:form>