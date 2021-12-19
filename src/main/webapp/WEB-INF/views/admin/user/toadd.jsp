<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form action="${ ctx }/admin/user/save" method="post" cssClass="form form-h form-h-10em"
	modelAttribute="bean" id="form1" onSubmit="javascript:return(doSubmit(this));">
	<form:hidden path="id"/>
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
			<div class="f-ct">
				<form:input path="password" cssClass="f-text span4" required="required"/>
			</div>
		</div>
		<div class="f-gp">
			<div class="f-lb">
				<label class="f-label">账号类型：</label>
			</div>
			<div class="f-ct">
			<form:select path="usertype" cssClass="f-select block span4" 
				items="${dictionary.roles }" itemLabel="value" itemValue="key">
			</form:select>
			</div>
		</div>
		<div class="f-gp">
			<div class="f-lb">
				<label class="f-label">性别：</label>
			</div>
			<div class="f-ct">
				<form:radiobutton path="sex" value="女" label="女" />
				&nbsp;&nbsp;&nbsp;&nbsp;
				<form:radiobutton path="sex" value="男" label="男" checked="true"/>
			</div>
		</div>
		<div class="f-gp">
			<div class="f-lb">
				<label class="f-label">邮箱：</label>
			</div>
			<div class="f-ct">
				<form:input path="email" cssClass="f-text span4" type="email" />
			</div>
		</div>
		<div class="f-gp">
			<div class="f-lb">
				<label class="f-label">手机：</label>
			</div>
			<div class="f-ct">
				<form:input path="phone" cssClass="f-text span4" type="tel" />
			</div>
		</div>
		<c:forEach items="${dictionary.property }" var="p">
			<c:if test="${p.table=='user' and p.show}">
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
		<input type="submit" class="btn btn-m btn-prim-g btn-submit" value="提交">
	</div>
</form:form>