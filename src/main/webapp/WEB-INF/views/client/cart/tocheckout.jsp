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
		<section class="section">
			<div class="container">
				<form name="form1" id="ff1" action="${ctx }/order/addorder"
					method="post">
					<div class="strip">
						<span>收货地址</span> <span style="float: right; padding-right: 20px;">
							<button id="toadd-addresss" type="button"
								class="btn btn-danger btn-xs">新增收货地址</button>
						</span>
					</div>
					<table width="100%" cellspacing="0" cellpadding="0" border="0"
						class="table">
						<thead>
							<tr class="thead">
								<th class="tdnum">选择</th>
								<th>地址</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${address }" var="o">
								<tr>
									<td><input name="address" type="radio" value="${o.title }" /></td>
									<td>${o.title }</td>
									<td class="tc"><a data-type="del-address"
										class="btn btn-default btn-xs" data-id="${o.id }"
										href="javascript:void(0);">删除</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<div class="strip mt50">
						<span>付款方式</span>
					</div>
					<table width="100%" cellspacing="0" cellpadding="0" border="0"
						class="table">
						<thead>
							<tr class="thead">
								<th class="tdnum">选择</th>
								<th>付款方式</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input name="paytype" type="radio" checked="checked"
									value="支付宝" /></td>
								<td>支付宝</td>
							</tr>
							<tr>
								<td><input name="paytype" type="radio" value="微信" /></td>
								<td>微信</td>
							</tr>
							<tr>
								<td><input name="paytype" type="radio" value="银联" /></td>
								<td>银联</td>
							</tr>
							<tr>
								<td><input name="paytype" type="radio" value="货到付款" /></td>
								<td>货到付款</td>
							</tr>
						</tbody>
					</table>

					<div class="strip mt50">
						<span>订单确认</span>
					</div>
					<table class="table">
						<thead>
							<tr>
								<th>商品名称</th>
								<th style="width: 15%;">单价</th>
								<th style="width: 15%;">数量</th>
								<th class="hidden-xs" style="width: 15%;">小计</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list }" var="o">
								<tr>
									<td><a class="entry-thumbnail" href="javascript:void(0)">
											<img style="width:50px;height:50px;" src="${ctx}/upload_files/${o.imagepath }"
											onerror="javascript:this.src='${ctx}/upload_files/nopicsmall.png'"
											alt="">
									</a> <a class="entry-title" target="_blank"
										href="${ctx }/product/getone?id=${o.productid}">${o.title }</a></td>
									<td style="text-align:center;line-height:50px;">
										<span class="unit-price">￥${o.price }.00</span>
									</td>
									<td style="text-align:center;line-height:50px;">${o.number }</td>
									<td style="text-align:center;line-height:50px;">
										<strong class="text-bold row-total">￥
											${o.subprice }.00</strong>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<div class="shopcart-total pull-right clearfix">
						<div class="cart-total text-bold m-b-lg clearfix">
							<span class="pull-left">总计:</span> <span class="pull-right">￥
								<em data-type="total">${sumprice }</em>.00
							</span> <input type="hidden" name="sumprice" value="${sumprice }" />
						</div>
						<div class="text-center">
							<a class="btn btn-primary btn-lg" href="javascript:void(0)"
								id="submit">提交订单</a>
						</div>
					</div>
				</form>
			</div>
		</section>
		</main>
		<!-- SITE FOOTER -->
		<%@ include file="/WEB-INF/views/include/footer.jsp"%>
		<!-- // SITE FOOTER -->
	</div>
	<div id="dialog" title="新增地址">
		<div class="col-xs-12 col-sm-12">
			<form id="formaddress" action="${ctx }/component/save" method="post">
				<input type="hidden" name="type1" value="address" />
				<div class="form-group stylish-input">
					<label class="required" for="title">请填写收货地址:</label> 
					<input	type="text" id="title" name="title" required="required" class="form-control">
				</div>
			</form>
		</div>
	</div>
	<script>
		$(function() {

			$("#dialog").dialog({
				autoOpen : false,
				width : 600,
				height:200,
				buttons : [ {
					text : "保存",
					click : function() {
						var title = $.trim($("#title").val());
						if(title==""){
							alert("收货地址不能为空哦！");
							return false;
						}
						$("#formaddress").ajaxSubmit({
							success : function(data) {
								if (data.code == 300) {
									alert("登录已过期，请重新登录！");
									window.location.href = '${ctx}/tologin';
								} else {
									alert(data.message);
									setTimeout(function() {
										window.location.href = '${ctx}/cart/tocheckout';
									}, 0);
								}
							}
						});
					}
				}, {
					text : "取消",
					click : function() {
						$(this).dialog("close");
					}
				} ]
			});

			$("#toadd-addresss").click(function(event) {
				$("#dialog").dialog("open");
				event.preventDefault();
			});

			$("[data-type=del-address]").click(function(){
				if(!confirm("确定要删除吗？"))
					return false;
				var id = $(this).attr("data-id");
				$.post("${ctx}/component/delete",{id:id},function(){
					alert("操作成功！");
					window.location.reload(true);
				});
			});
			
			$("#submit").click(function() {
				var len = $("[name=address]:checked").size();
				if (len == 0) {
					alert("请选择收货地址！");
					return false;
				}
				$("#ff1").ajaxSubmit({
					success : function(data) {
						if (data.code == 300) {
							alert("登录已过期，请重新登录！");
							window.location.href = '${ctx}/tologin';
						} else {
							alert(data.message);
							setTimeout(function() {
								window.location.href = '${ctx}/order/index';
							}, 0);
						}
					}
				});
			});
		});
	</script>
</body>
</html>