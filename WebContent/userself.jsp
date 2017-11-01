<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.zwhem.model.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<div id="pro_list1">

	<%
	User user1 = (User)session.getAttribute("user"); 
	if(user1==null){
	out.print("<h1>请重新登陆！</h1>");
	}else{%>
			  <form name="registform" id="registform" action="./UpdateUserServlet" method="post" >
				<table>
				<tr>
					<th>编号：</th>
					<td><input  type="text" name="u_id" readonly="readonly" value="<%=user1.getU_id()%>" size="20" maxlength="20" /></td>
				  </tr>
				  <tr>
					<th>账号：</th>
					<td><input  type="text" name="userName" value="<%=user1.getUserName() %>" size="20" maxlength="20" /></td>
				  </tr>
				  <tr>
					<th>积分：</th>
					<td><input  type="text" readonly="readonly" name="score" size="20" value="<%=user1.getScore() %>" /></td>
				  </tr>
				  <tr>
					<th>真实姓名：</th>
					<td><input  type="text" name="realName" value="<%=user1.getRealName() %>" size="20" maxlength="20" /></td>
				  </tr>
				  <tr>
					<th>用户性别：</th>
					<td>
					<%if("男".equals(user1.getSex())){ %>
					  <input name="sex" type="radio" value="男" checked />男&nbsp;
					  <input type="radio" name="sex" value="女" />女</td>
					  <%}else{ %>
					   <input name="sex" type="radio" value="男" />男&nbsp;
					  <input type="radio" name="sex" value="女" checked />女</td>
					  <%} %>
				  </tr>
				  <tr>
					<th>联系电话：</th>
					<td><input  type="text" name="telephone"  size="20" value="<%=user1.getTelephone() %>" maxlength="20" /></td>
				  </tr>
				  <tr>
					<th>配送地址：</th>
					<td><input  type="text" name="address"  size="20" value="<%=user1.getAddress() %>" maxlength="20" /></td>
				  </tr>
				  <tr>
			 <%String[] questiones={"您的出生地是？","您父亲的生日是？","您母亲的生日是？","您身份证号码的后6位是？","您手机号码的后6位是？"
			 ,"您手机号码的后6位是？","您父亲的姓名是？","您母亲的姓名是？"}; %>
					<th>密码保护问题：</th>
					<td><select name="question">
						<option value="">--请选择--</option>
						<%for(String q:questiones){
						if(q.equals(user1.getQuestion())){
							out.print("<option value='"+q+"' selected>"+q+"</option>");
						}else{
							out.print("<option value='"+q+"'>"+q+"</option>");
						}
						}
						%>
					  </select>
					</td>
				  </tr>

				  <tr>
					<th>答案：</th>
					<td><input  type="text" name="answer" value="<%=user1.getAnswer() %>" size="20" maxlength="20" /></td>
				  </tr>
				  <tr>
					<th>邮箱：</th>
					<td><input  type="text" name="email" value="<%=user1.getEmail() %>" size="20" maxlength="20" /></td>
				  </tr>
				  <tr>
					<th>请选择关注的商品类别：</th>
					<td>
					<%
					String favorate[] = {"手机","电脑","相机","其他"};
					for(String f : favorate) {
					boolean flag = false;
					if(user1.getFavorate()!=null&&user1.getFavorate().contains(f))
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

				   <tr>
					<td colspan="2" align="center">
					<input type="submit" name="submit" value=" 提交" class="picbut" />
					  &nbsp;&nbsp;
					<input name="reset" type="reset" value="清空" class="picbut" />
					
					  </td>
				  </tr>
				</table>
			  </form>
	<%}	%>
</div>
</html>