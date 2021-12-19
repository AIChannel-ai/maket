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
		<div class="container">
			<div class="row">
				<div class="m-t-b clearfix">
					<section class="products-wrapper">
						<div class="col-xs-12 col-sm-4">

							<div class="product-preview">
								<div class="big-image">
									<a href="javascript:void(0)"> 
									<img style="width:300px;height:400px;"
										onerror="javascript:this.src='${ctx}/upload_files/nopicbig.png'"
										src="${ctx}/upload_files/${bean.imagepath }" alt="">
									</a>
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-8">
							<section class="product-details add-cart">
								<header class="entry-header">
									<h2 class="entry-title uppercase">${bean.title }</h2>
								</header>
								<article class="entry-content" style="margin-top: 30px;">
									<figure>
										<span class="entry-price inline-middle">￥ ${bean.price }</span>
										<span class="entry-review-count inline-middle">(
											累计评价&nbsp;&nbsp; <b style="color: #000;font-size: 20px;">${allComment }</b> &nbsp;&nbsp;|&nbsp;&nbsp; 总销量&nbsp;&nbsp;
											<b style="color: #f00;font-size: 20px;">${allSale }</b> )
										</span>
										<ul class="entry-meta unstyled">
											<c:forEach items="${dictionary.property }" var="p">
												<c:if test="${p.table=='productone' and p.show}">
													<li>
														<span class="key">${p.value }:</span> 
														<span class="value">${bean[p.key] }</span>
													</li>
												</c:if>
											</c:forEach>
										</ul>

										<div class="clearfix"></div>

										<div class="row">
											<div class="col-xs-12 col-sm-6">
												<h5 class="subheader uppercase">数量:</h5>
												<input type="number" required class="form-control"
													style="width: 100px;" value="1" id="number">
											</div>
											<div class="space30 visible-xs"></div>
											<div class="col-xs-12 col-sm-6">
												<h5 class="subheader uppercase">库存:</h5>
												<span style="font-size: 18px;">${bean.number }</span>
											</div>
										</div>

										<ul class="inline-li li-m-r-l m-t-lg" style="padding-left: 10em;">
											<li>
												<a href="javascript:void(0)" id="addcart" style="background: #F22D00;padding: 10px 50px;"
												class="btn btn-default btn-lg" data-product-id="${bean.id }">
													+ Add to Cart</a>
											</li>
										</ul>

									</figure>
								</article>
							</section>
						</div>
					</section>
					<div class="clearfix"></div>
					  <section class="section" id="ui-tabs">
						<ul class="nav nav-tabs">
							<li class="active" style="margin-left: 0px;"><a href="#tab-1" data-toggle="tab">宝贝详情</a></li>
							<li class=""><a href="#tab-2" data-toggle="tab">累计评论 ${allComment }</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane fade active in" id="tab-1">
								${bean.intro } 
							</div>
							<div class="tab-pane fade" id="tab-2">
								<%@ include file="/WEB-INF/views/client/comment/comment.jsp"%>
							</div>
						</div>
						<div class="space40"></div>
						<div class="clearfix"></div>
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
			$("#addcart").click(function() {
				var number = $("#number").val();
				var re = /^[0-9]+$/;
				if (!re.test(number)) {
					alert("加入购物车的数量只能是正整数！");
					$("#number").val(1);
					return false;
				}
				var productid = $(this).attr("data-product-id");
				$.ajax({
					url : '${ctx}/cart/addcart',
					type : "POST",
					dataType : "json",
					data : {
						productid : productid,
						number : number
					},
					success : function(data) {
						alert(data.message);
						if (data.code == 300) {
							window.location.href = '${ctx}/tologin';
						}
					}
				});
			});
		});
	</script>
</body>
</html>