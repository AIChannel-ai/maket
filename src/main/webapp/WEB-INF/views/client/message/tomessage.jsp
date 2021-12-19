<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title><%=com.bs.tools.Constant.SYSTEMNAME%></title>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
</head>
<body>
	<!-- PAGE WRAPPER -->
	<div id="page-wrapper">
		<!-- SITE HEADER -->
		<%@ include file="/WEB-INF/views/include/navigate.jsp"%>
		<!-- // SITE HEADER -->
		<div class="breadcrumb-container"></div>
		<!-- SITE MAIN CONTENT -->
		<main id="main-content" role="main">
		<section class="section" style="padding-top: 10px;margin-top: 20px;">
			<div class="container">
				<section class="col-xs-12 col-sm-12 col-md-12">
					<form action="${ctx }/message/save" method="post" class="clearfix"
						onSubmit="javascript:return(doSubmit(this));">
						<div class="col-xs-12 col-sm-12 col-md-5">
							<div class="form-group stylish-input">
								<label for="contactName" class="required">您的姓名</label> <input
									type="text" class="form-control" name="name"
									value="${c_user.username }" required="required">
							</div>
							<div class="form-group stylish-input">
								<label for="contactEmail" class="required">您的邮箱</label> <input
									type="email" class="form-control" name="email"
									required="required">
							</div>
							<div class="form-group stylish-input">
								<label for="contactSubject" class="required">主题</label> <input
									type="text" class="form-control" name="subject"
									required="required">
							</div>
						</div>
						<div class="space10 visible-xs visible-sm"></div>
						<div class="col-xs-12 col-sm-12 col-md-7">
							<div class="form-group stylish-input">
								<label for="contactMSG" class="required">留言内容</label>
								<textarea id="contactMSG" class="form-control" name="content"
									style="height: 178px;" required="required"></textarea>
							</div>
						</div>
						<div class="space10"></div>
						<div class="col-xs-6 col-sm-6 send-in col-xs-offset-3 col-sm-offset-3">
							<input type="submit" class="btn btn-default pull-right"
								value="提交留言" />
						</div>
					</form>
				</section>
			</div>
			<c:if test="${not empty list }">
				<div class="container">
					<section class="col-xs-12 col-sm-12 col-md-12"
						style="border-top: 1px solid #ccc; margin: 20px 0px;">
						<h3 class="uppercase text-bold" style="margin: 20px 0px;">
							<span class="text-xs">我的留言</span>
						</h3>
						<div class="sz_rightBody" id="table_box"></div>
					</section>
				</div>
				<!-- // SECOND ROW -->
			</c:if>
		</section>
		</main>
		<!-- SITE FOOTER -->
		<%@ include file="/WEB-INF/views/include/footer.jsp"%>
		<!-- // SITE FOOTER -->
	</div>
	<script>
		$(function() {
			var options = {
				ajaxurl : "${ctx}/message/getdata"
			};
			$(this).loadPage(options);
			$('#table_box').tablePage(options);
			$('#table_box').deleteData('${ctx}/message/delete');
		});
	</script>
</body>
</html>