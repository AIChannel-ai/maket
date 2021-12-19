<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title><%=com.bs.tools.Constant.SYSTEMNAME%></title>
<%@ include file="/WEB-INF/views/include/header-sys.jsp"%>
</head>
<body>
	<div class="sz_top sec_top posr">
		<h1 class="logo">
			<%=com.bs.tools.Constant.SYSTEMNAME%>
		</h1>
		<div class="sz_login">
			<span>欢迎您【${user.username }】（${user.usertype }）</span> <span
				class="szBlue">│</span> <a class="szExit" href="${ctx }/admin/login">退出系统</a>
		</div>
	</div>
	<div class="sz_content mt20 clearfix">
		<div class="sz_left page-sidebar" id="sz_left">
			<ul id="accordion" class="accordion">
				<c:if test="${user.usertype =='管理员'}">
					<li><div class="link">
							系统管理<i class="fa fa-chevron-down"></i>
						</div>
						<ul class="submenu">
							<li><a data-type="left-nav" data-url="admin/user/index"
								href="javascript:void(0);">账号管理</a></li>
							<li><a data-type="left-nav" data-url="admin/user/toadd"
								href="javascript:void(0);">添加账号</a></li>
						</ul>
					</li>
					<li>
						<div class="link">
							商品分类管理<i class="fa fa-chevron-down"></i>
						</div>
						<ul class="submenu">
							<li><a data-type="left-nav" data-url="admin/category/index"
								href="javascript:void(0);">商品类别管理</a></li>
							<li><a data-type="left-nav" data-url="admin/category/toadd"
								href="javascript:void(0);">添加商品类别</a></li>
						</ul>
					</li>
					<li>
						<div class="link">
							商品管理<i class="fa fa-chevron-down"></i>
						</div>
						<ul class="submenu">
							<li><a data-type="left-nav" data-url="admin/product/index"
								href="javascript:void(0);">商品管理</a></li>
							<li><a data-type="left-nav" data-url="admin/product/toadd"
								href="javascript:void(0);">添加商品</a></li>
						</ul>
					</li>

					<li>
						<div class="link">
							订单受理<i class="fa fa-chevron-down"></i>
						</div>
						<ul class="submenu">
							<li><a data-type="left-nav" data-url="admin/order/indexmanage"
								href="javascript:void(0);">订单受理</a></li>
						</ul>
					</li>
					<li>
						<div class="link">
							评论管理<i class="fa fa-chevron-down"></i>
						</div>
						<ul class="submenu">
							<li><a data-type="left-nav" data-url="admin/comment/index"
								href="javascript:void(0);">评论管理</a></li>
						</ul>
					</li>
					<li>
						<div class="link">
							留言管理<i class="fa fa-chevron-down"></i>
						</div>
						<ul class="submenu">
							<li><a data-type="left-nav" data-url="admin/message/index"
								href="javascript:void(0);">留言管理</a></li>
						</ul>
					</li>
				</c:if>
				<c:if test="${user.usertype =='普通用户'}">
					<li>
						<div class="link">
							财务部汇总<i class="fa fa-chevron-down"></i>
						</div>
						<ul class="submenu">
							<li><a data-type="left-nav"
								data-url="admin/employee/chindex" href="javascript:void(0);">人员变动单</a></li>
						</ul>
					</li>
				</c:if>
				
				<li>
					<div class="link">
						个人信息<i class="fa fa-chevron-down"></i>
					</div>
					<ul class="submenu">
						<li><a data-type="left-nav" data-url="admin/user/myinfo"
							href="javascript:void(0);">我的信息</a></li>
						<li><a data-type="left-nav" data-url="admin/user/tochpwd"
							href="javascript:void(0);">修改密码</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<div class="sz_right" id="sz_right">
			<style>
				tr{height: 60px;}
				.table th{background-color:#fcfcfc;}
			</style>
			<br/>
			<h1 style="text-align: center;">欢迎您使用【<%=com.bs.tools.Constant.SYSTEMNAME%>】</h1>
			<br/>
			<table class="table mt10" style=" width:99%;<%-- background:url(${ctx}/images/mascot.png);background-repeat:no-repeat; --%>">
				<!-- <thead>
					<tr>
						<th>项目名称</th>
						<th>项目内容</th>
					</tr>
				</thead> -->
				<tbody>
					<tr>
						<th>操作系统类型</th>
						<td class="tc">Windows</td>
					</tr>
					<tr>
						<th>编程语言</th>
						<td class="tc">Java</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<script type="text/javascript">
		$(function() {
			var rootUrl = '${ ctx }';
			$('#sz_left').loadDataByLeft(rootUrl);
		});
	</script>
</body>
</html>