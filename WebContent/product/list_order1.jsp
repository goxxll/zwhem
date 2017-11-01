<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.zwhem.model.*,com.zwhem.impl.*,com.zwhem.dao.*" %>
<%@ include file="../verify.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>ED数码商城订单列表</title>
	<link type="text/css" rel="stylesheet" href="../style/main.css" />
	<SCRIPT language=JavaScript>
	var isShow = false;
	function getDetailList(tarId){
		var detaillist=document.getElementsByName("detaillist"+tarId);
		if(isShow){
			for (i=0; i<detaillist.length; i++){
				 detaillist[i].style.display="none" ;
			}
			isShow = false;
		}else{
			for (i=0; i<detaillist.length; i++){
				 detaillist[i].style.display='';
			}
			isShow = true;
		}
		
		
	   
		
	}
	</SCRIPT>
    </head>
    <body>
	<div id="header">
	<%@include file="../top.jsp" %>
	</div>
	
	<div id="allcontent">
	<div id="sidebar">
		<%@ include file="../sidebar.jsp"%>
	</div>
        <div id="right">
       <%@include file="../right.jsp" %>
        </div>
	<div id="buycar">
	<%
	User user = (User)session.getAttribute("user"); 
    OrderDao odi = OrderDaoFactory.getInstance();
    if(user == null){
 	    out.print("<h1>请重新登陆！</h1>");
    }else{
       List<Order> orderList = odi.getOrderByUser(user.getU_id());
    %>
    <div align="center" style="width: 535px">
      <div align="center" style="width: 535px;margin-left: 30px">
	    	<!--  <img src="images/order.jpg" width="48" height="48" align="left"/>-->
	    	<font size="6" style="margin-left: 100px">我的订单</font>
	    </div>
		<div style="width: 530px">
		<%
		int i=0;
		for(Order order:orderList){ 
		i++;
		%>
	 <table>
	   <tr id="order<%=i %>" ">
			<th scope="col" colspan="4">
			<a onclick="getDetailList(<%=i%>)">
			订单编号：<span style="font-size: 12px;color: blue;"><%=order.getId() %></span>&nbsp;
			状态：<span style="font-size: 12px;color: blue;"><%=order.getStatus() %></span>&nbsp;
			订单时间：<span style="font-size: 12px;color: blue;"><%=order.getOrdertime() %></span>&nbsp;
			收货人：<span style="font-size: 12px;color: blue;"><%=order.getUserName() %></span>&nbsp;
			
			<%if(order.getStatus().equals("已发货")){ %>
				<span style="font-size: 12px;color: red;">
				<a href="../OrderReceiveServlet?id=<%=order.getId() %>" onClick="if(confirm('确定要收货吗？')) return true;else return false;">确认收货</a>
				</span>
		   
			<%} %>
			</a>
			</th>
	   </tr>
	<%for(OrderDetail od : order.getDetailList()){ 
	%>
	 <tr name="detaillist<%=i %>" style="DISPLAY: none">
		<td class="row" width="40%"><%=od.getpName() %></td>
		<td class="row" width="40%"><img src="<%=od.getPic() %>" width="75" height="50" /></td>
		<td class="row" width="10%"><%=od.getPrice() %></td>
		<td class="row" width="10%"><%=od.getNum() %></td>
	</tr>
	<%} %>
	</table>
	<%} %>
		</div>
	</div>
<%} %>
	</div>
	</div>
	<div id="footer">
		<%@ include file="../bottom.jsp"%>
	</div>
    </body>
</html>
