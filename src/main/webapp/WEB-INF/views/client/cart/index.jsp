<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title><%=com.bs.tools.Constant.SYSTEMNAME%></title>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
</head>
<body>
	<div id="page-wrapper">
		<%@ include file="/WEB-INF/views/include/navigate.jsp"%>
		<main id="main-content" role="main"> <!-- FEATURED PRODUCTS -->
		<section class="section">
			<div class="container" style="background: #fff;padding:30px;">
				<table class="table">
					<thead>
						<tr>
							<th>商品名称</th>
							<th style="width: 15%;">单价</th>
							<th style="width: 15%;">数量</th>
							<th style="width: 15%;">小计</th>
							<th style="width: 10%;">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${ empty list}">
							<tr class="empty-cart">
								<td colspan="5">您的购物车是空的</td>
							</tr>
						</c:if>
						<c:if test="${not empty list}">
							<c:forEach items="${list}" var="o">
								<tr>
									<td><a class="entry-thumbnail" href="javascript:void(0)">
											<img style="width:50px;height:50px;" src="${ctx}/upload_files/${o.imagepath }" onerror="javascript:this.src='${ctx}/upload_files/nopicsmall.png'" alt="">
									</a> <a class="entry-title" target="_blank" href="${ctx }/product/getone?id=${o.productid}">${o.title }</a></td>
									<td style="text-align:center;line-height:50px;">
										<span class="unit-price">￥${o.price }.00</span>
									</td>
									<td style="text-align:center;line-height:50px;">
										<div class="qty-btn-group">
											<button type="button" class="down" data-unit-price="${o.price }" data-id="${o.id }" data-product-id="${o.productid }">
												<i class="iconfont-caret-down inline-middle"></i>
											</button>
											<input type="text" value="${o.number }" data-id="${o.id }" data-type="number">
											<button type="button" class="up" data-unit-price="${o.price }" data-id="${o.id }" data-product-id="${o.productid }">
												<i class="iconfont-caret-up inline-middle"></i>
											</button>
										</div>
									</td>
									<td style="text-align:center;line-height:50px;">
										<strong class="text-bold row-total" >￥ <span data-type="row-total" data-id="${o.id }">${o.subprice }</span>.00</strong></td>
									<td style="text-align:center;line-height:50px;">
									<button style="float:none;" type="button" class="close" data-id="${o.id }" aria-hidden="true">×</button></td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>

				<c:if test="${not empty list}">
					<div class="shopcart-total pull-right clearfix">
						<div class="cart-total text-bold m-b-lg clearfix">
							<span class="pull-left">总计:</span> 
							<span class="pull-right">￥ <em data-type="total">${sumprice }</em>.00</span>
						</div>
						<div class="text-center">
							<a class="btn btn-primary btn-lg uppercase" href="${ctx }/cart/tocheckout">去结算</a>
						</div>
					</div>
				</c:if>
			</div>
		</section>
		</main>
		<!-- SITE FOOTER -->
		<%@ include file="/WEB-INF/views/include/footer.jsp"%>
		<!-- // SITE FOOTER -->
	</div>
	<script>
		$(function() {
			
			$(".up").click(function(){
				var id = $(this).attr("data-id");
				var productid = $(this).attr("data-product-id");
				
				var number = parseInt($("[data-type=number][data-id="+id+"]").val());
				$("[data-type=number][data-id="+id+"]").val(++number);
				
				var price = parseInt($(this).attr("data-unit-price"));
				var rowtotal = parseInt($("[data-type=row-total][data-id="+id+"]").html());
				$("[data-type=row-total][data-id="+id+"]").html(rowtotal+price);
				
				var total = parseInt($("[data-type=total]").html());
				$("[data-type=total]").html(total + price);
				
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
			
			$(".down").click(function(){
				var id = $(this).attr("data-id");
				var productid = $(this).attr("data-product-id");
				var number = parseInt($("[data-type=number][data-id="+id+"]").val());
				if(number<=0){
					return false;
				}
				$("[data-type=number][data-id="+id+"]").val(--number);
				
				var price = parseInt($(this).attr("data-unit-price"));
				var rowtotal = parseInt($("[data-type=row-total][data-id="+id+"]").html());
				$("[data-type=row-total][data-id="+id+"]").html(rowtotal-price);
				
				var total = parseInt($("[data-type=total]").html());
				$("[data-type=total]").html(total - price);
				
				$.ajax({
    				url:'${ctx}/cart/removecart',
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
			
			$(".close").click(function(){
				if(!confirm("确定要删除吗？"))
					return false;
				var id = $(this).attr("data-id");
				
				$.ajax({
    				url:'${ctx}/cart/deletecart',
    				type:"POST",
    				dataType:"json",
    				data:{
    					id:id
    				},success:function(data){
    					alert(data.message);
    					if(data.code==200){
    						window.location.reload(true);
    					}
    					else if(data.code==300){
    						window.location.href='${ctx}/tologin';
    					}
    				}
    			});
			});
		});
	</script>
</body>
</html>