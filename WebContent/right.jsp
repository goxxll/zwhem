<%@ page language="java"   pageEncoding="UTF-8"%>
<%@ page import="com.zwhem.model.User" %>
<%
String path_right = request.getContextPath();
String basePath_right = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path_right+"/";
//System.out.println(path_right);
//System.out.println(basePath_right);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="style/main.css" />
<script type="text/javascript">

function createCode() {
	document.getElementById('imgcode').src="<%=path_right%>/VerifyCodeServlet?t="+Math.random();
}
</script>
</head>


	<div id="login">
	  <%User user1=(User)session.getAttribute("user");
	  String logininfo=(String)session.getAttribute("logininfo");
	  
	  if(user1==null){
		  Cookie[] ck=request.getCookies();
		  //System.out.println(ck.length);
		  String username="";
		  String password="";
		  if(ck!=null){
		  	for(Cookie c:ck){
				  if(c.getName().equals("username")){
					  username=c.getValue();
			 	 }
			 	 if(c.getName().equals("password")){
					  password=c.getValue();
			 	 }
		  	}
		  }
		 
		%>
			<form id="loginform" name="loginform" method="post" action="<%=path_right%>/LoginServlet" >
				<div><strong>登录名：</strong><input name="txtUser" id="txtUser" size="15" value="<%=username %>" /></div>
				<div><strong>密　码：</strong><input name="txtPassword" type="password" id="txtPassword" size="15" value="<%=password%>" /></div>
				<div>
					<strong>验证码：</strong><input name="verifyCode" id="verifyCode" size="4" />
					<img id="imgcode" src="<%=path_right%>/VerifyCodeServlet"  onclick="createCode()" />
				</div>
				<div><input type="submit" value="登录" name="submit" class="picbut" />　
				<input name="reg" type="button" value="注册用户" class="picbut" onclick="javascript:location.href=('<%=path_right%>/regist.jsp');" />
				</div>
				<div><a href="<%=path_right %>/findPwd.jsp">找回密码</a></div>
				<div><font color=red size=3><%=logininfo==null?"":logininfo %></font></div>
			 </form>
		<%}else{ %>
		<ul>
			<li>欢迎回来，<%=user1.getUserName() %></li>
			<li><a href="<%=path_right %>/product/list_cart.jsp">我的购物车</a></li>
			<li><a href="<%=path_right %>/product/list_order1.jsp">我的订单</a></li>
			<li><a href="<%=path_right %>/userInfo.jsp">个人信息</a></li>
			<li><a href="<%=path_right %>/resetPwd.jsp">修改密码</a></li>
			<li><a href="<%=path_right %>/LogoutServlet">退出</a></li>
		</ul>
		<%} %>
		</div>
		<div class="news">
			<p><img src="<%=path_right %>/images/title3.gif" alt="" width="100" height="30" /></p>
			<ol>
				<li>24小时送达迟一天退10元</li>
				<li>支付宝金账户购物全场98折</li>
				<li>用建行卡购物全场98折</li>
				<li>工行分期付款0.3%/月手续费</li>
				<li>7天内无条件退货</li> 
				<li>运输造成的损害我们承担损失 </li>
			</ol>
		</div>
	

</html>