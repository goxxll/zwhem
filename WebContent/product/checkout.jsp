<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.zwhem.model.User,com.zwhem.model.Cart" %>
<%@ include file="../verify.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
User user = (User) session.getAttribute("user");
ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartlist");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>ED数码商城购物车</title>
	<link type="text/css" rel="stylesheet" href="../style/main.css" />
    </head>
    <body>
	<div id="header">
		<%@ include file="../top.jsp"%>
	</div>
	
	<div id="allcontent">
	<div id="sidebar">
		<%@ include file="../sidebar.jsp"%>
	</div>
        <div id="right">
   		<%@ include file="../right.jsp"%>
        </div>
	<div id="buycar">
		 <%
	 if(user == null){
	 	out.println("<h1>请先登录！</h1>");
	 }else{
	 Date date = new Date();
	 java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 double sum = 0.0;
	 %> 
	    <div style="width: 535px">
	    <div align="center" style="font-size: 20px;font-family: 黑体;text-shadow: blue;">订单信息</div>
		 <ul style="margin: 0 auto;">
			<li style="list-style: none;" class="text">用户名：<%=user.getUserName() %></li>
			<li style="list-style: none;" class="text">配送地址：<%=user.getAddress() %></li>
			<li style="list-style: none;" class="text">联系电话：<%=user.getTelephone() %></li>
			<li style="list-style: none;" class="text">订单时间：<%=sdf.format(date) %></li>
		 </ul>
		</div>
		<div style="width: 530px;margin-left: 50px;margin-top: 0px" >
		  <table>
			<tr>
			    <th width="40" scope="col">商品图片</th>
				<th width="60" scope="col">商品名称</th>
			 	<th width="20" scope="col">商品价格</th>
			 	<th width="20" scope="col">数量</th>		 	
			</tr>
		<%if(cartList!=null){ 
		for(Cart c : cartList){
		 sum += (c.getPrice()-c.getSale())*c.getNum();
		%>	
		 <tr>
		    <td class="row"><a href="product_detail.jsp?id=<%=c.getId() %>"><img src="<%=c.getPic()%> " width="90" height="60" ></img></a></td>
			<td class="row"><a href="product_detail.jsp?id=<%=c.getId() %>"><%=c.getName() %></a></td>
		 	<td class="row"><%=c.getPrice() %></td>
			<td class="row"><%=c.getNum() %></td>		
		 </tr>
	<%}//end for
	} //end if %>
		</table>
	 </div>
	
	<div align="right" style="width: 450px;margin-top: 20px">
	<p style="font-size: 18px;color: blue">合计：<%=sum %>&nbsp; RMB</p>
	<input type="button" name="totalprice" value="提交订单" class="picbut" onclick="javascript:window.location.href='<%=path %>/AddOrderServlet'" />
	</div>
	<%} %>
	</div>
	</div>
	<div id="footer">
		<%@ include file="../bottom.jsp"%>
	</div>
    </body>
</html>
