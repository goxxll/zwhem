<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.zwhem.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartlist");
%>


<html>
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>四叶草数码商城购物车</title>
	<link type="text/css" rel="stylesheet" href="../style/main.css" />
	<script type="text/javascript">
	function updateCart(index,num){
       var curForm = document.getElementById("form"+index);
       if(parseInt(curForm.num.value)>parseInt(curForm.pnum.value)){
   		
   		alert("购买数量超过了库存量！");
   		return false;		
   	
   		
   	}
       if((curForm.num.value-(-num))<=0){
       	  alert("请输入正确的数量！");
       	  return false;
       }else{
      	 curForm.num.value = curForm.num.value -(-num);
      	 curForm.submit();
      	 return true;
       }
	}
	function changeNum(index){
		 var curForm = document.getElementById("form"+index);
		 if(parseInt(curForm.num.value)>parseInt(curForm.pnum.value)){
		   		
		   		alert("购买数量超过了库存量！");
		   		return false;		
		   	
		   		
		   	}
		 if(curForm.num.value<=0){
		   alert("请输入正确的数量！");
		   curForm.num.value = 1;
		   return false;
		 }else{
		   curForm.submit();
		   return true;
		 }
	}
</script>
    </head>
    <body>
	<div id="header">
	<%@ include file="../top.jsp"%>
	</div>
	
	<div id="allcontent">
	<div id="sidebar">
		<%@ include file="../sidebar.jsp"%>
	</div>
	<div id="buycar">
		<p><img src="images/buycar_logo.gif" alt="购物车" /></p>
		<table>
			<tr>
				<th width="6%" >选项</th>
				<th width="15%">商品图片</th>
				<th width="25%">商品名称</th>
				<th width="8%">商品单价</th>
				<th width="28%">数量</th>
				<th width="8%">单价优惠</th>
				<th width="6%">小计</th>
				<th width="4%">删除</th>
			</tr>
	<%
	double sum = 0.0;
	if(cartList!=null){ 
		int i = 0;
		for(Cart c : cartList){
			%>
			<form id="form<%=i %>" method="post" action="../UpdateCartServlet">
			<input type="hidden" name="flag" value="update" />
			<input type="hidden" name="id" value="<%=c.getId() %>" />
			<input type="hidden" name="pnum" id="pnum" value="<%=c.getNum()%>" />
			<tr>
				<td><input type="checkbox" name="chkBox" value="checkbox" /></td>
				<td>
				<a href="product_detail.jsp?id=<%=c.getId() %>"><img src="<%=c.getPic() %>" width="75" height="50" alt="<%=c.getName()%>" /></a>
				</td>
				<td><a href="product_detail.jsp?id=<%=c.getId() %>"><%=c.getName().length()>12?(c.getName()).substring(0,12):c.getName() %></a></td>
				<td>￥<%=c.getPrice() %></td>
				<td>
					<a onclick="updateCart(<%=i %>,-1)">-</a>
					<input type="text" size="2" onChange=" return changeNum(<%=i %>);" name="num" id="num" value="<%=c.getNum() %>" />
					<a onclick="updateCart(<%=i %>,1)">+</a>
				</td>
				<td>￥<%=c.getSale() %></td>
				<td>￥<%=(c.getPrice()-c.getSale())*c.getNum() %></td>
				<td><a href="<%=path %>/DeleteCartServlet?id=<%=c.getId() %>">删除</a></td>
			</tr>
			</form>
			<%
			i++;
			sum += (c.getPrice()-c.getSale())*c.getNum();
			} 
			}%>
			<tr>
				<td colspan="6">总价：<%=sum %></td>
				<td>
				<input type="button" name="totalprice" value="返回" class="picbut" onclick="history.back(-1)" />
				</td>
				<td>
				<input type="button" name="totalprice" value="结 算" class="picbut" onclick=" javascript:window.location.href='checkout.jsp'"" />
				</td>
			</tr>
		</table>
		</form>
	</div>
        <div id="right">
      	<%@ include file="../right.jsp"%>
        </div>
	
	</div>
	<div id="footer">
		<%@ include file="../bottom.jsp"%>
	</div>
    </body>
</html>
