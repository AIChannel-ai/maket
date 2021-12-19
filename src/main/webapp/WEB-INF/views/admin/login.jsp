<%@page import="com.bs.tools.CommonUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>	
<!DOCTYPE html>
<html>
<head>
	<title><%=com.bs.tools.Constant.SYSTEMNAME %></title>
	<link rel="stylesheet" href="${ctxdef }/css/sys-common.css" />
	<link rel="stylesheet" href="${ctxdef }/css/sys-login.css" />
	<script type="text/javascript" src="${ctxdef }/scripts/jquery-1.10.2.min.js"></script>
	<style type="text/css">
		.content {
		    position: relative;
		    width: 100%;
		    margin-bottom: 40px;
		}
		#login-banner-wrap .inner {
		    position: relative;
		    width: 1190px;
		    margin: auto;
		}
		#login-banner-wrap img {
		    display: block;
		    margin: auto;
		}
		.content .form {
		    display: none;
		    position: absolute;
		    top:50%;
		    margin-top: -170px;
		    right: 60px;
		    
		}
		.loginlogo{
			position: absolute;
			z-index: 9999;
			height: 400px;
			width: 400px;
			background: #EC7300;
			border-radius:400px;
			line-height: 400px;
			font-size: 100px;
			text-align: center;
			top:50%;
			margin-top: -200px;
			left:60px;
			font-family: "黑体"
		}
	</style>
</head>
<%-- <%=CommonUtils.getRandom(10, 1) %> --%>
<body class="login_body" style="background:url(${ctxdef}/images/login/3.jpg);">
	<div id="mallPage" class="tms-page mallAct tmall-login w1190 page-market">
      <div class="header" data-spm="a2226n0">
            <div class="logoTitle"><%=com.bs.tools.Constant.SYSTEMNAME %></div>
      </div> 
      <div class="content">
        <div id="login-banner-wrap" style="width: 100%;position: relative;" title="天猫年货节">
        	<div class="inner">
	        	<div class="loginlogo" style="">
	        		旧爱
	        	</div>
        		<img src="${ctxdef}/images/login-form-bg3.jpg" alt="">
        	</div>
        </div>
        <div class="form J_form" style="display: block; right: 148px;">
            <div class="form-inner">
                <div class="form-content">
                  <div class="logon" style="height:250px;">
						<form action="${pageContext.request.contextPath }/admin/login" method="post">
							<div>
								<label>账 号：</label> <input type="text" class="useName" id="username"
									name="username">
							</div>
							<div class="mt30">
								<label>密 码：</label> <input type="password" class="useName" id="password"
									name="password">
							</div>
							<div class="mt30">
								<label>类型：</label> 
								<select name="usertype" class="useName" style="height:35px;width:316px;">
									<c:forEach items="${dictionary.roles }" var="o">
										<option value="${o.key }">${o.value }</option>
									</c:forEach>
								</select>
							</div>
							<div class="logonButton">
								<input id="btn_login" type="submit" value="登&nbsp;&nbsp;&nbsp;&nbsp;录"
									class="btn btn-m btn_login btn-prim-g btn-submit" /> 
							</div>
						</form>
					</div>
                </div>
            </div>
        </div>
      </div>
    </div>

	<script type="text/javascript">
		$(function() {
		   var error = '${error}';
		   if(error=='on'){
			   alert('登录账号和密码错误！');
		   }
		});
	</script>

</body>
</html>