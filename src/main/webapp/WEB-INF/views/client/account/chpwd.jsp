<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title><%=com.bs.tools.Constant.SYSTEMNAME%></title>
	<%@ include file="/WEB-INF/views/include/header-bootstrap.jsp"%>
	<link rel="stylesheet" href="${ctxdef }/css/client-loginstyle.css"/>
</head>
<body>
    <h1 style="margin:50px auto;width:100%;text-align:center;color:#555;">用户修改密码</h1>
    <div id="page-content" class="single-page" style="background:#f3f3f3;">
        <div class="container" style="padding-top:30px;">
            <div class="row">
                <div class="col-md-4">
                </div>
                <div class="col-md-5">
                    <form name="form1" id="ff1" method="post" action="${ctx }/savepwd">
                        <div class="form-group">
                            <span style="padding-right:3%;">原来密码</span>
                            <input type="password" style="display:inline-block;width:80%;" class="form-control" name="oldPassword" required>
                        </div>
                        <div class="form-group">
                            <span style="padding-right:3%;">新的密码</span>
                            <input type="password" style="display:inline-block;width:80%;" class="form-control" name="newPassword" required>
                        </div>
                        <div class="form-group">
                            <span style="padding-right:3%;">重复密码</span>
                            <input type="password" style="display:inline-block;width:80%;" class="form-control" name="password" required>
                        </div>
                        <button style="margin-left:200px;" type="button" class="btn btn-1" name="savebutton" id="savebutton">保存</button>
                    </form>
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
				var p1=$("[name=newPassword]").val();
				var p2=$("[name=password]").val();
				if(p1!=p2){
					alert("两次密码不一致！");
					return false;
				}
				$("#ff1").ajaxSubmit({
					success : function(data) {
						alert(data.message);
						if(data.code==200){
							setTimeout(function(){
								window.location.href='${ctx}/tologin';
							},0);
						}
					}
				});
			});
		});
	</script>
</body>
</html>