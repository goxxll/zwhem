<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.zwhem.dao.*"%>   
 <%@ page import="com.zwhem.impl.ProductDaoImpl"%>  
 <%@ page import="java.util.*"%>
 <%@ page import="com.zwhem.model.Product"%>
 <%@ page import="com.zwhem.model.User"%>
<%
ProductDao pdi = ProductDaoFactory.getInstance();
List<Product> pList = pdi.list();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>浏览商品</title>
<link type="text/css" rel="stylesheet" href="../style/main.css" />
<script type="text/javascript">

function createCode() {
	document.getElementById('imgcode').src="../VerifyCodeServlet?t="+Math.random();
}
</script>
</head>
<body>

	<div id="header">
		<%@include file="../top.jsp" %>
    </div>
	<div id="allcontent">
		<div id="sidebar"><%@ include file="../sidebar.jsp"%></div>
		<div id="right">
		<%@include file="../right.jsp" %>
      </div>
		<div id="content">
		<div id="pro_list1">
			<%
				if(pList!=null){
					for(Product p : pList){
			 %>
			<div class="productslist">
				<div><a href="product_detail.jsp?id=<%=p.getP_id() %>"><img src="<%=p.getPic() %>" width="170" height="128" /></a></div>
				<strong><%=p.getPname() %><br />
				经济高效，超低成本！<br /></strong>
				原价：<span class="price">￥<%=p.getPrice() %></span><br />
				促销价：<span class="onsale" >直降 ￥<%=p.getSale() %></span >
			</div>
			<%} 
			}%>
        </div>
	</div>	
	</div>
	<div id="footer">
			<%@ include file="../bottom.jsp"%>
		</div>
</body>
</html>
