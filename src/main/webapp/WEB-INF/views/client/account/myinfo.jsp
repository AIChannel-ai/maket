<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title><%=com.bs.tools.Constant.SYSTEMNAME%></title>
	<%@ include file="/WEB-INF/views/include/header-bootstrap.jsp"%>
	<link rel="stylesheet" href="${ctxdef }/css/client-loginstyle.css"/>
</head>
<body>
    <h1 style="margin:80px auto;width:100%;text-align:center;color:#555;">个人信息</h1>
    <div id="page-content" class="single-page" style="background:#f3f3f3;">
        <div class="container" style="padding-top:30px;">
            <div class="row">
                <div class="col-md-4">
                </div>
                <div class="col-md-4">
                    <form:form modelAttribute="bean" id="ff1" method="post" action="${ctx }/savemyinfo">
                        <div class="form-group">
                            <span style="padding-right:3%;">账号</span>
                            <input type="text" value="${bean.username }" style="display:inline-block;width:85%;" class="form-control" name="username" required>
                        </div>
                        <div class="form-group">
                            <span style="padding-right:3%;">手机</span>
                            <input type="tel" value="${bean.phone }" style="display:inline-block;width:85%;" class="form-control" name="phone" required>
                        </div>
                        <div class="form-group">
                            <span style="padding-right:3%;">邮箱</span>
                            <input type="email" value="${bean.email }" style="display:inline-block;width:85%;" class="form-control" name="email" required>
                        </div>
                        <div class="form-group">
                            <span style="padding-right:3%;">性别</span>
                            <form:radiobutton path="sex" value="女" label="女" />
							&nbsp;&nbsp;&nbsp;&nbsp;
							<form:radiobutton path="sex" value="男" label="男" />
                        </div>
                        <div class="form-group">
                            <span style="padding-right:3%;">类型</span>
                            ${bean.usertype }
                        </div>
                        <button style="margin-left:150px;" type="button" class="btn btn-1" name="savebutton" id="savebutton">保存</button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
	    $(document).ready(function() {
	    	
	    	if('${c_user}'==''){
				setTimeout(function(){
					alert("登录已过期，请重新登录！");
					window.location.href='${ctx}/tologin';
				},0);
			}
	    	
			$(document).on('click', '#savebutton', function() {
				$("#ff1").ajaxSubmit({
					success : function(data) {
						alert(data.message);
						if(data.code==200){
							setTimeout(function(){
								window.location.href='${ctx}/';
							},0);
						}
					}
				});
			});
		});
	</script>
</body>
</html>