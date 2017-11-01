<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.zwhem.model.User" %>
<%@ page import="com.zwhem.dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<div id="pro_list1">

	<%
	String id=request.getParameter("id");
	UserDao udi=UserDaoFactory.getInstance();
	User user = udi.getUserById(Integer.parseInt(id));
	%>
			  <form name="registform" id="registform" action="" method="post" >
				<table>
				<tr>
					<th>编号：</th>
					<td><%=user.getU_id()%></td>
				  </tr>
				  <tr>
					<th>账号：</th>
					<td><%=user.getUserName() %></td>
				  </tr>
				  <tr>
					<th>积分：</th>
					<td><%=user.getScore() %></td>
				  </tr>
				  <tr>
					<th>真实姓名：</th>
					<td><%=user.getRealName() %></td>
				  </tr>
				  <tr>
					<th>用户性别：</th>
					<td><%=user.getSex() %>					
				  </tr>
				  <tr>
					<th>联系电话：</th>
					<td><%=user.getTelephone() %></td>
				  </tr>
				  <tr>
					<th>配送地址：</th>
					<td><%=user.getAddress() %></td>
				  </tr>
				  <tr>
			 <%String[] questiones={"您的出生地是？","您父亲的生日是？","您母亲的生日是？","您身份证号码的后6位是？","您手机号码的后6位是？"
			 ,"您手机号码的后6位是？","您父亲的姓名是？","您母亲的姓名是？"}; %>
					<th>密码保护问题：</th>
					<td><select name="question">
						<option value="">--请选择--</option>
						<%for(String q:questiones){
						if(q.equals(user.getQuestion())){
							out.print("<option value='"+q+"' selected>"+q+"</option>");
						}else{
							
						}
						}
						%>
					  </select>
					</td>
				  </tr>

				  <tr>
					<th>答案：</th>
					<td><%=user.getAnswer() %></td>
				  </tr>
				  <tr>
					<th>邮箱：</th>
					<td><%=user.getEmail() %>"</td>
				  </tr>
				  <tr>
					<th>请选择关注的商品类别：</th>
					<td>
					<%
					String favorate[] = {"手机","电脑","相机","其他"};
					for(String f : favorate) {
					boolean flag = false;
					if(user.getFavorate()!=null&&user.getFavorate().contains(f))
						flag=true;
				
					if(flag){
					 out.println("<input type='checkbox'  name='favorate' value="+f+" checked />"+f);
					 }else{
					 out.println("<input type='checkbox'  name='favorate' value="+f+" />"+f);
					 }
					}
					%>
					</td>
				  </tr>

				  
				</table>
			  </form>
	
</div>
</html>