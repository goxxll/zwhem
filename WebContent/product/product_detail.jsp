<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.zwhem.model.*,com.zwhem.impl.ProductDaoImpl"%>
<%@ include file="../verify.jsp"%>
<%
	
	String strId = request.getParameter("id");
	if (strId == null)
		response.sendRedirect("list_product.jsp");
	int id = Integer.parseInt(strId);
	ProductDaoImpl pdi = new ProductDaoImpl();
	Product p = pdi.getProductById(id);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>佳能 单反 ED数码商城产品介绍</title>
		<link type="text/css" rel="stylesheet" href="../style/main.css" />
		<script type="text/javascript">
function checkAddCarForm() {
	var pnum=document.getElementById("pnum");
	
	var num=document.getElementById("num");
	if(parseInt(num.value)>parseInt(pnum.value)){
		
		alert("购买数量超过了库存量！");
		return false;		
	
		
	}
	if (num.value.length <= 0)
		{
			alert("请输入正确的购买数量！");
			return false;
		}
	
	else
		{
		
		document.addCarForm.submit();
		return true;
		}
}
</script>
	</head>
	<body>
		<div id="header">
			<%@ include file="../top.jsp" %>

		</div>
		<div id="allcontent">
		<div id="sidebar2">
				<%@ include file="../sidebar.jsp" %>
				
			</div><!-- end of sidebar2 -->
			<div id="productinfodiv">
				<div id="productimg">
					<img src="<%=p.getPic()%>" width="310" height="310" />
				</div>
				<div id="tips" style="float: left; width: 430px; height: 200px">
					<form action="../AddCartServlet" method="post" name="addCarForm">
						<h1><%=p.getPname()%></h1>
						<input type="hidden" name="flag" value="add" />
						<input type="hidden" name="id" value="<%=p.getP_id()%>" />
						<input type="hidden" name="name" value="<%=p.getPname()%>" />
						<input type="hidden" name="price" value="<%=p.getPrice()%>" />
						<input type="hidden" name="sale" value="<%=p.getSale()%>" />
						<input type="hidden" name="pic" value="<%=p.getPic()%>" />
						<input type="hidden" name="pnum" id="pnum" value="<%=p.getNum()%>" />
						<ul>
							<li style="list-style: none;" class="bt"></li>
							<li style="list-style: none;" class="text">
								商品编号：<%=p.getCode()%></li>
							<li style="list-style: none;" class="text">
								价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格：￥<%=p.getPrice()%></li>
							<li style="list-style: none;" class="text">
								促销信息：直降￥<%=p.getSale()%></li>
							<li style="list-style: none;" class="bt">
								库&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;存：<%=p.getNum()%></li>
							<li
								style="list-style: none; font-size: 13px; font-family: 黑体; color: red;">
								我要买:
								<input type="text" name="num" id="num" size="3">
								件
							</li>
						</ul>
						<img hspace="50" src="../images/gwc.png" onclick=" return checkAddCarForm();" >
					</form>
				</div>
				<div class="cl"></div>
				<div id="main2">

				<div id="intro" style="margin-top: 10px">
					<%=p.getIntro()%>
					
					<div class="cl"></div>
				</div>
				<div class="cl"></div>
			</div>
			</div>
			
            <div id="right"><%@ include file="../right.jsp"%></div>
		
		<div id="footer">
			<%@ include file="../bottom.jsp"%>
		</div>
	</body>
</html>