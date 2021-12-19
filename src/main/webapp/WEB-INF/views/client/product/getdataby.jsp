<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:if test="${empty list }">
	<h1 style="text-align: center;">暂无数据！</h1>
</c:if>
<div class="container">
	<div class="product-top">
		<c:forEach items="${list }" var="o" varStatus="status">
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
	<div class="product-top" style="text-align: center;">
		<jsp:include page="/WEB-INF/views/client/page.jsp" flush="true"></jsp:include>
	</div>
</div>
