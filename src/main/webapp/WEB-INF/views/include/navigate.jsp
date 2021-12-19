<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%
String pagename = request.getParameter("t");
if("".equals(pagename) || pagename == null){
	pagename="11";
}
request.setAttribute("pagename", pagename);
%>
<script type="text/javascript">
	$(function(){
		var pagename ="${pagename}";
		$("#site-menu").find("a[href$='t="+pagename+"']").parents("li").addClass("active").siblings("li").removeClass("active");
	});
</script>
<div class="line"></div>
<div class="header">
	<div  class="header-top">
		<div class="header-grid" style="position: relative;">
		<div style="color: #fff;position: absolute;top:0;left:20px;line-height: 60px;font-size: 32px;font-weight: bold;">
			<%=com.bs.tools.Constant.SYSTEMNAME%>
		</div>
			<ul class="header-in">
			  	<c:if test="${ empty c_user}">
					<li ><a href="${ctx }/tologin">登录</a></li>
					<li ><a href="${ctx }/toregister">注册</a></li>
			  	</c:if>
				<c:if test="${not empty c_user}">
					<li ><a href="${ctx }/tomyinfo" target="_blank">欢迎您【${c_user.username }】</a></li>
					<li ><a href="${ctx }/cart/index">购物车</a></li>
					<li ><a href="${ctx }/order/index">我的订单</a></li>
					<li ><a	href="${ctx }/tochpwd" target="_blank">修改密码</a></li>
					<li ><a href="${ctx }/loginout" onclick="javascript:return confirm('确定要退出吗？')">退出</a></li>
				</c:if>
			</ul>
			<div class="search-box">
			    <div id="sb-search" class="sb-search">
					<form action="${ctx }/product/index?t=22" method="post">
						<input class="sb-search-input" placeholder="Enter your search term..." type="search" name="title" id="search">
						<input class="sb-search-submit" type="submit" value="">
						<span class="sb-icon-search"> </span>
					</form>
				</div>
		    </div>
			<!-- search-scripts -->
			<script>
				new UISearch( document.getElementById( 'sb-search' ) );
			</script>
			<!-- //search-scripts -->
			<div class="online">
			<a href="javascript:void(0)" >ONLINE</a>
			</div>
			<div class="clearfix"> </div>
		</div>
		<div class="header-bottom">
			<div class="h_menu4"><!-- start h_menu4 -->
			<a class="toggleMenu" href="#">Menu</a>
			<ul class="nav">
				<li class="active"><a href="${ctx }/?t=11">首页</a></li>
				<li><a href="${ctx }/product/index?t=22">商品分类  <i> </i></a>
					<ul>
						<c:forEach items="${category }" var="o">
							<li><a href="${ctx }/product/index?cid=${o.id}&t=22">${o.name }</a></li>
						</c:forEach>
					</ul>
				</li>
				<li><a href="${ctx }/product/indexby/new?t=33">最新上架</a></li>
				<li><a href="${ctx }/product/indexby/hot?t=44">热销排行</a></li>
				<li><a href="${ctx }/message/tomessage?t=55">在线留言</a></li>
			</ul>
		</div>
		<div class="clearfix"> </div>
	  </div>
	</div>
	<div class="clearfix"> </div>
</div>
<!---->