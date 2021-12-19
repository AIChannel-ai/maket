<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title><%=com.bs.tools.Constant.SYSTEMNAME%></title>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
</head>
<body class="home">
    <%@ include file="/WEB-INF/views/include/navigate.jsp"%>
	<div class="banner">
	<div class="container">
		<div class="banner-matter">
			<h1>We are the best,You buy</h1>
			<div class="out">
				<div class="clearfix"> </div>
			</div>
		</div>	
		</div>
	</div>
	<div style="font-size: 25px;margin: 10px;margin-top: 30px;text-align: center;">最新上架</div>
	<div class="line1"></div>
	
	<div class="product-grids">
		<div class="container">
			<div class="product-top">
				<c:forEach items="${listnews }" var="o" varStatus="status">
				<div class="col-md-3 grid-product-in">	
				  <div class=" product-grid">	
					<a target="_blank" href="${ctx }/product/getone?id=${o.id}">
						<img src="${ctx}/upload_files/${o.imagepath }" onerror="javascript:this.src='${ctx}/upload_files/nopic.png'" alt="" class="lazyOwl thumb" style="width:255px;height:214px;" />
					</a>		
					<div class="shoe-in">
						<h6><a target="_blank" href="${ctx }/product/getone?id=${o.id}">${o.title } </a></h6>
						<label>￥ ${o.oldprice }.00</label>
						<a href="javascript:void(0)" data-type="addcart" data-product-id="${o.id }" class="pull-right">+ Add to Cart</a>
						<a href="javascript:void(0)" class="store">NEW</a>
					</div>
				  </div>	
				</div>
				</c:forEach>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
	<!-- end -->
	
	<div style="font-size: 25px;margin: 10px;margin-top: 30px;text-align: center;">热销商品</div>
	<div class="line1"></div>
	<div class="product-grids">
	<div class="container">
	
	<div class="product-top">
		<c:forEach items="${listhots }" var="o" varStatus="status">
		<div class="col-md-3 grid-product-in">	
		  <div class=" product-grid">	
			<a target="_blank" href="${ctx }/product/getone?id=${o.id}">
				<img src="${ctx}/upload_files/${o.imagepath }" onerror="javascript:this.src='${ctx}/upload_files/nopic.png'" alt="" class="lazyOwl thumb" style="width:255px;height:214px;" />
			</a>		
			<div class="shoe-in">
				<h6><a target="_blank" href="${ctx }/product/getone?id=${o.id}">${o.title } </a></h6>
				<label>￥ ${o.oldprice }.00</label>
				<a href="javascript:void(0)" data-type="addcart" data-product-id="${o.id }" class="pull-right">+ Add to Cart</a>
				<a href="javascript:void(0)" class="store">HOT</a>
			</div>
		  </div>	
		</div>
		</c:forEach>
	</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/include/footer.jsp"%>

 <script type="text/javascript">
 	$(function(){
 		
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