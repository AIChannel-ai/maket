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
		<main id="main-content" role="main"> <!-- FEATURED PRODUCTS -->
		<section class="section" style="padding-top:0px;">
			<div class="container">
				<c:if test="${ empty list}">
					<table class="table">
						<tr class="empty-cart">
							<td colspan="5">抱歉，没有找到您的订单！</td>
						</tr>
					</table>
				</c:if>
				<c:forEach items="${list }" var="o" varStatus="s1">
					<div class="strip <c:if test="${s1.index==0 }">mt50</c:if>">
						<span style="display: inline-block; width: 33%;">下单时间：${o.createdate }</span>
						<span style="float: right; padding-right: 20px;color: #f55c4b;" data-type="openorder">订单总金额：${o.sumprice }，共${o.orderProduct.size() }件商品</span>
					</div>
					<table class="table">
						<thead>
							<tr>
								<th>商品名称</th>
								<th style="width: 15%;">单价</th>
								<th style="width: 15%;">数量</th>
								<th class="hidden-xs" style="width: 15%;">小计</th>
								<th class="hidden-xs" style="width: 15%;">交易状态</th>
								<th class="hidden-xs" style="width: 15%;">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${o.orderProduct }" var="p" varStatus="status">
								<tr>
									<td><a class="entry-thumbnail" href="javascript:void(0)">
											<img style="width:50px;height:50px;" src="${ctx}/upload_files/${p.imagepath }" onerror="javascript:this.src='${ctx}/upload_files/nopicsmall.png'" alt="">
									</a> <a class="entry-title" target="_blank" href="${ctx }/product/getone?id=${p.productid}">
									${p.title }
									</a></td>
									<td style="text-align:center;line-height:50px;">
										<span class="unit-price">￥ ${p.price }.00</span></td>
									<td style="text-align:center;line-height:50px;">${p.number }</td>
									<td style="text-align:center;line-height:50px;"><strong class="text-bold row-total">￥ ${p.subprice }.00</strong></td>
									<c:if test="${status.index == 0 }">
										<td style="text-align:center;line-height:50px;" class="hidden-xs" rowspan="${ o.orderProduct.size()}">${o.status }</td>
										<td style="text-align:center;line-height:50px;" class="hidden-xs" rowspan="${ o.orderProduct.size()}">
											<c:if test="${o.status == '待发货' }">
												<button type="button" class="btn btn-danger" data-type="cancel" data-order-id="${o.id }">取消订单</button>
											</c:if>
											<c:if test="${o.status == '已发货' }">
												<button type="button" class="btn btn-success" data-type="getproduct" data-order-id="${o.id }">确认收货</button>
											</c:if>
											<c:if test="${o.status == '已完成' }">
												--
											</c:if>
										</td>
									</c:if>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:forEach>
			</div>
		</section>
		</main>
		<!-- SITE FOOTER -->
		<%@ include file="/WEB-INF/views/include/footer.jsp"%>
		<!-- // SITE FOOTER -->
	</div>
	<script>
		$(function() {
			
			$(document).on("click","[data-type=cancel]",function(){
				if(!confirm("确定要取消该订单吗？"))
					return false;
				var id = $(this).attr("data-order-id");
				$.ajax({
					url:"${ctx}/order/cancelorder",
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
			
			$(document).on("click","[data-type=getproduct]",function(){
				if(!confirm("确定要收货吗？"))
					return false;
				var id = $(this).attr("data-order-id");
				$.ajax({
					url:"${ctx}/order/getproduct",
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
			
			/* $(document).on("click","[data-type=openorder]",function(){
				var table = $(this).parent(".strip").next("table");
				if(table.is(":hidden")){
					table.show();
				}else{
					table.hide();
				}
			}); */
		});
	</script>
</body>
</html>