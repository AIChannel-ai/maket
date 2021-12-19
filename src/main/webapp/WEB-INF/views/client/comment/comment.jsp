<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<footer class="page-footer">

	<!-- WIDGET AREA -->
	<div class="widgets">

		<!-- FIRST ROW -->
		<div class="section" style="border: none;padding: 20px 0;">
			<div class="container">
				<div class="row">
					<div class="col-xs-12">
						<form name="form1" id="ff1" action="${ctx }/comment/addcomment" method="post">
							<input type="hidden" name="productid" value="${bean.id }" />
							<section class="widget widget-text">
								<h5 class="widget-title">用户评论</h5>
								<div class="widget-content">
									<textarea class="form-control" name="content" id="content"
										style="height: 80px; width: 95%;"></textarea>
								</div>
								<div style="text-align: center; margin-top: 15px;">
									<button type="button" id="submit" class="btn btn-primary btn-lg">发表评论</button>
								</div>
							</section>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- // FIRST ROW -->

		<!-- SECOND ROW -->
		<div class="section" style="border-top:2px solid #d9d9d9;">
			<div class="container">
				<div class="row">

					<div class="col-xs-12">
						<section class="widget widget-menu" style="margin-right: 40px;">
							<h5 class="widget-title">累计评论</h5>
							<div class="widget-content">
								<ul class="menu iconed-list unstyled" id="table_box">
								</ul>
							</div>
						</section>
					</div>

				</div>
			</div>
		</div>
		<!-- // SECOND ROW -->

	</div>
	<!-- // WIDGET AREA -->

</footer>
<script>
	$(function() {
		
		var options = {
			ajaxurl : "${ctx}/comment/getdata",
			data:{
				productid:"${bean.id}"
			}
		};
		$(this).loadPage(options);
		$('#table_box').tablePage(options);
		$("#btnSearch").formSearch(options);
			
		$("#submit").click(function(){
			var content = $("#content").val();
			if($.trim(content)==""){
				alert("请填写评论内容！");
				return false;
			}
			$("#ff1").ajaxSubmit({
				success : function(data) {
					if(data.code==200){
						alert(data.message);
						window.location.reload(true);
					}else if(data.code==300){
						alert("登录已过期，请重新登录！");
						window.location.href='${ctx}/tologin';
					}
				}
			});
		});
	});
</script>
