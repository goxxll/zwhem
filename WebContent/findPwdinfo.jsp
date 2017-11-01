<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<div id="content">
        <div id="regist">
        <%
        session=request.getSession(); 
        String info=(String)session.getAttribute("info");
        
        %>
		<div id="registtop">
			<h2>找回密码</h2>
		</div>
		<div><font color=red size=2><%=info==null?"":info %></font></div>
		<div >
			  <form name="registform" id="registform" action="./FindPwdServlet" method="post" >
				<table>
				  <tr>
					<th>账号：</th>
					<td><input  type="text" name="userName"  size="20" maxlength="20" /></td>
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
			  </div>
	</div>
       </div>
</html>