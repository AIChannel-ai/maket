<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script type="text/javascript">
	window.UEDITOR_HOME_URL = "${ctx }/resources/ueditor/";
</script>
<script type="text/javascript"	src="${ctx }/resources/ueditor/ueditor.config.js"></script>
<script type="text/javascript"	src="${ctx }/resources/ueditor/ueditor.all.min.js"></script>
<script type="text/javascript"	src="${ctx }/resources/ueditor/lang/zh-cn/zh-cn.js"></script>
<form:form action="${ ctx }/admin/product/save" method="post" cssClass="form form-h form-h-10em" enctype="multipart/form-data"
	modelAttribute="bean" id="form1" onSubmit="javascript:return(doSubmit(this));">
	<form:hidden path="id"/>
	<div class="dataBox">
		<div class="f-gp">
			<div class="f-lb">
				<label class="f-label">分类：</label>
			</div>
			<div class="f-ct">
				<form:select path="categoryid" cssClass="f-select block span4" 
				items="${category }" itemLabel="name" itemValue="id">
				</form:select>
			</div>
		</div>
		<c:forEach items="${dictionary.property }" var="p">
			<c:if test="${p.table=='product' and p.show}">
				<div class="f-gp">
					<div class="f-lb">
						<label class="f-label">${p.value }：</label>
					</div>
					<div class="f-ct">
						<c:choose>
							<c:when test="${p.input == 'text' }">
								<form:input  path="${p.key }" cssStyle="${p.style }" type="${p.type }" required="${p.required }" readonly="${p.readonly }" cssClass="f-text span4"  />
							</c:when>
							<c:when test="${p.input == 'radio' }">
								<form:radiobuttons path="${p.key }" items="${fn:split(p.def, ';') }" cssStyle="${p.style }" cssClass="f-radio" />
							</c:when>
							<c:when test="${p.input == 'checkbox' }">
								<form:checkboxes path="${p.key }" items="${fn:split(p.def, ';') }" cssStyle="${p.style }" cssClass="f-checkbox" />
							</c:when>
							<c:when test="${p.input == 'select' }">
								<c:if test="${p.source == '' or p.source == null }">
									<form:select path="${p.key }" items="${fn:split(p.def, ';') }" cssStyle="${p.style }" cssClass="f-select block span4"/>
								</c:if>
								<c:if test="${p.source == 'db' }">
									<!-- 读数据库 
									<form:select path="categoryid" cssClass="f-select block span4" 
										items="${category }" itemLabel="name" itemValue="id">
									</form:select>
									-->
								</c:if>
							</c:when>
							<c:when test="${p.input == 'textarea' }">
								<form:textarea path="${p.key }" cssStyle="${p.style }" cssClass="f-textarea span4"/>
							</c:when>
							<c:when test="${p.input == 'file' }">
								<input id="file" name="file" type="file" />
							</c:when>
							<c:otherwise>
								<form:input path="${p.key }" cssStyle="${p.style }" cssClass="f-text span4"  />
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</c:if>
		</c:forEach>
	</div>

	<div class="f-ac f-infer">
		<input type="submit" class="btn btn-m btn-prim-g btn-submit" value="提交">
	</div>
</form:form>
<script type="text/javascript">
	var ue = UE.getEditor('intro');
</script>