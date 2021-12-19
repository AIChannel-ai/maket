<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form action="${ ctx }/admin/user/savemyinfo" method="post"
	cssClass="form form-h form-h-10em" modelAttribute="bean" id="form1" onSubmit="javascript:return(doSubmit(this));">
	<div class="dataBox">
		<div class="f-gp">
			<div class="f-lb">
				<label class="f-label">账号名称：</label>
			</div>
			<div class="f-ct">
				<form:input path="username" cssClass="f-text span4" required="required"/>
			</div>
		</div>
		<div class="f-gp">
			<div class="f-lb">
				<label class="f-label">密码：</label>
			</div>
			<div class="f-ct">${user.password }</div>
		</div>
		<div class="f-gp">
			<div class="f-lb">
				<label class="f-label">账号类型：</label>
			</div>
			<div class="f-ct">${user.usertype }</div>
		</div>
		<div class="f-gp">
			<div class="f-lb">
				<label class="f-label">性别：</label>
			</div>
			<div class="f-ct">
				<form:radiobutton path="sex" value="女" label="女" />
				&nbsp;&nbsp;&nbsp;&nbsp;
				<form:radiobutton path="sex" value="男" label="男" />
			</div>
		</div>
		<div class="f-gp">
			<div class="f-lb">
				<label class="f-label">邮箱：</label>
			</div>
			<div class="f-ct">
				<form:input path="email" cssClass="f-text span4" type="email" required="required"/>
			</div>
		</div>
		<div class="f-gp">
			<div class="f-lb">
				<label class="f-label">手机：</label>
			</div>
			<div class="f-ct">
				<form:input path="phone" cssClass="f-text span4" type="tel" required="required" />
			</div>
		</div>
	</div>
	<div class="f-ac f-infer">
		<input type="submit" class="btn btn-m btn-prim-g btn-submit" value="提交">
	</div>
</form:form>