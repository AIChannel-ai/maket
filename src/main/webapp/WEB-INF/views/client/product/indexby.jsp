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
		<div class="breadcrumb-container">
		</div>
		<!-- SITE MAIN CONTENT -->
		<main id="main-content" role="main"> <!-- FEATURED PRODUCTS -->
		<div class="container">
			<div class="row">
				<div class="m-t-b clearfix">
					<section class="products-wrapper" id="table_box">
					</section>
				</div>
			</div>
		</div>
		</main>
		<!-- SITE FOOTER -->
		<%@ include file="/WEB-INF/views/include/footer.jsp"%>
		<!-- // SITE FOOTER -->
	</div>
	<script>
		$(function() {
			var options = {
				ajaxurl : "${ctx}/product/getdataby/${type}"
			};
			$(this).loadPage(options);
			$('#table_box').tablePage(options);
			$("#btnSearch").formSearch(options);
			
			$(document).on("click","[data-type=addcart]",function(){
    			var productid =$(this).attr("data-product-id");
    			$.ajax({
    				url:'${ctx}/cart/addcart',
    				type:"POST",
    				dataType:"json",
    				data:{
    					productid:productid
    				},success:function(data){
    					alert(data.message);
    					if(data.code==300){
    						window.location.href='${ctx}/tologin';
    					}
    				}
    			});
    		}); 
		});
	</script>
</body>
</html>