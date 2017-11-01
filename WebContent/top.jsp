<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path_top = request.getContextPath();
String basePath_top = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path_top+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ED数码在线商城网站</title>
<link type="text/css" rel="stylesheet" href="<%=path_top %>/style/main.css" />
<script type="text/javascript" src="<%=path_top %>/js/imagerollover.js"></script>
</head>


		<div id="header_inside">
	    <p><img src="<%=path_top %>/images/header2.jpg" alt="ED数码商城banner" usemap="#Map" />
		<map name="Map" id="Map">
		<area shape="rect" coords="844,63,869,94" href="<%=path_top %>/product/list_cart.jsp" alt="" />
		<area shape="rect" coords="684,93,714,118" href="<%=path_top %>/index.jsp" alt="" />
		<area shape="rect" coords="769,145,797,168" href="<%=path_top %>/regist.jsp" alt="" />
		</map></p>		
			<div id="menu">
				<ul>
					<li><a href="<%=path_top %>/index.jsp" >网站首页</a></li>
					<li><a href="<%=path_top %>/product/list_product.jsp">商品列表</a></li>
					<li><a href="<%=path_top %>/product/products_hot.jsp">热卖产品</a></li>
					<li><a href="#">最新活动</a></li>
					<li><a href="#">关于我们</a></li>
					<li><a href="#">联系我们</a></li>
				</ul>
			</div>
		</div>


</html>