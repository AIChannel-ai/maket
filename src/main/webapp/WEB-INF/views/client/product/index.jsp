<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title><%=com.bs.tools.Constant.SYSTEMNAME%></title>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/navigate.jsp"%>
	<div class="product-grids" id="table_box">
	</div>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<script>
		$(function() {
			var options = {
				ajaxurl : "${ctx}/product/getdata",
				data:{
					cid:"${cid}",
					title:"${title}"
				}
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