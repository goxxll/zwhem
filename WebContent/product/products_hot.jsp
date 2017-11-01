<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.zwhem.dao.*"%>   
<%@ page import="com.zwhem.impl.ProductDaoImpl"%>  
<%@ page import="java.util.*"%>
<%@ page import="com.zwhem.model.Product"%>
<%@ page import="com.zwhem.model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>热卖产品</title>
<script type="text/javascript">

function createCode() {
	document.getElementById('imgcode').src="../VerifyCodeServlet?t="+Math.random();
}
</script>
</head>
<body>
<%
ProductDao pdi = ProductDaoFactory.getInstance();
List<Product> pList = pdi.listHot();
%>
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
				促销价：<span class="onsale" >直降 ￥<%=p.getSale() %></span ><br />
				已卖出：<span class="onsale" ><%=p.getAllHotNum()%>件</span >
				</span >
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