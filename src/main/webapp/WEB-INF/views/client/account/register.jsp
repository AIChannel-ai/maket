<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title><%=com.bs.tools.Constant.SYSTEMNAME%></title>
	<%@ include file="/WEB-INF/views/include/header-bootstrap.jsp"%>
	<link rel="stylesheet" href="${ctxdef }/css/client-loginstyle.css" />
</head>
<body>
    <h1 style="margin:50px auto;width:100%;text-align:center;color:#555;">用户注册</h1>
    <div id="page-content" class="single-page" style="background:#f3f3f3;">
        <div class="container" style="padding-top:30px;">
            <div class="row">
                <div class="col-md-4">
                </div>
                <div class="col-md-4">
                    <form name="form1" id="ff1" method="post" action="${ctx }/register" onSubmit="javascript:return(doSubmit(this));">
                        <div class="form-group">
                            <span style="padding-right:3%;">账号</span>
                            <input type="text" style="display:inline-block;width:85%;" class="form-control" name="username" required="required">
                        </div>
                        <div class="form-group">
                            <span style="padding-right:3%;">密码</span>
                            <input type="password" style="display:inline-block;width:85%;" class="form-control" name="password" required="required">
                        </div>
                        <div class="form-group">
                            <span style="padding-right:3%;">手机</span>
                            <input type="tel" style="display:inline-block;width:85%;" class="form-control" name="phone" required="required">
                        </div>
                        <div class="form-group">
                            <span style="padding-right:3%;">邮箱</span>
                            <input type="email" style="display:inline-block;width:85%;" class="form-control" name="email" required="required">
                        </div>
                        <div class="form-group">
                            <span style="padding-right:3%;">性别</span>
                            <input name="sex" value="男" type="radio" checked="true"> 男 &nbsp;&nbsp; <input name="sex" value="女" type="radio"> 女 
                        </div>
                        <div class="form-group">
                            <span style="padding-right:3%;">类型</span>
                            <select name="usertype" style="width: 85%; border: 1px solid #aaa;padding: 3px;">
								<c:forEach items="${dictionary.roles }" var="o">
									<c:if test="${o.show}">
										<option value="${o.key }">${o.value }</option>
									</c:if>
								</c:forEach>
							</select>
                        </div>
                        <button type="submit" class="btn btn-1" name="savebutton" id="savebutton">立即注册</button>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="${ctx }/tologin">已有账号？去登录</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>