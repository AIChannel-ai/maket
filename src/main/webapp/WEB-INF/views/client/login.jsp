<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title><%=com.bs.tools.Constant.SYSTEMNAME%></title>
	<%@ include file="/WEB-INF/views/include/header-bootstrap.jsp"%>
</head>
<body>

<!---->
<div class="container">
	<div class="account">
		<h2>用户登录</h2>
		<div class="account-pass">
			<div class="col-md-7 account-top">
				<form id="ff1" method="post" action="${ctx }/login">
					<div>
						<span>账号</span>
						<input type="text" name="username" required>
					</div>
					<div>
						<span>密码</span>
						<input type="text" name="password" required>
					</div>
					<div>
						<span>类型</span>
						<select name="usertype" style="width: 100%;height:48px; border: 1px solid #aaa;padding: 3px;">
							<c:forEach items="${dictionary.roles }" var="o">
								<c:if test="${o.show}">
									<option value="${o.key }">${o.value }</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
					<input type="submit" value="Login">
				</form>
			</div>
			<div class="col-md-5 left-account ">
				<a href="single.html">
					<img class="img-responsive " src="images/ac.png" alt="">
				</a>
				<div class="five">
					<h1>25% </h1>
					<span>discount</span>
				</div>
				<a href="${ctx }/toregister" class="create">注册新账号</a>
				<div class="clearfix"> </div>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
</div>
<!---->
    
<script type="text/javascript">
	$(function() {
	   var error = '${error}';
	   if(error=='on'){
		   alert('登录账号和密码错误！');
		   window.location.href="${ctx}/tologin";
	   }
	   else if(error=='timeout'){
		   alert('登录已超时，请您重新登录！');
	   }
	});
</script>
</body>
</html>