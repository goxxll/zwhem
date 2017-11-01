<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.zwhem.model.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function Juge(pwdmodiform)
    {
		if(pwdmodiform.oldpwd.value=="")
		   {
		    window.alert("请输入旧密码！"); 
		    pwdmodiform.oldpwd.focus(); 
		    return (false); 
		   }
		if(pwdmodiform.newpwd.value=="")
		   {
		    window.alert("请输入新密码！"); 
		    pwdmodiform.newpwd.focus(); 
		    return (false); 
		   }
		if(pwdmodiform.newpwd.value.length <6)
	  	{
	  		window.alert("密码长度过短 可能不安全");
	  		pwdmodiform.newpwd.focus();
	  		return (false);
	  	}
		if(pwdmodiform.newpwdsame.value=="")
		   {
		    window.alert("请输入确认密码！"); 
		    pwdmodiform.newpwdsame.focus(); 
		    return (false); 
		   }
		if(pwdmodiform.newpwdsame.value.length <6)
	  	{
	  		window.alert("密码长度过短 可能不安全");
	  		pwdmodiform.newpwdsame.focus();
	  		return (false);
	  	}
	   if (pwdmodiform.newpwd.value != pwdmodiform.newpwdsame.value) 
	    { 
	      window.alert("两者密码不匹配！"); 
	      pwdmodiform.newpwdsame.focus(); 
	      return (false); 
	    }
		
	  }

	       
    </script>	
</head>
<div id="content">
        <div id="regist">
        <%
        session=request.getSession(); 
        User user1=(User)session.getAttribute("user");
        if(user1!=null){
        %>
		<div id="registtop">
			<h2>重置密码</h2>
		</div>
		
		<div >
			  <form name="pwdmodiform" id="registform" action="./PwdModiServlet" onsubmit="return Juge(pwdmodiform);" method="post" >
				<table>
				<tr>
					<th>编号</th>
					<td><input  type="text" readonly="readonly" name="u_id"  size="20" maxlength="20"  value="<%=user1.getU_id() %>" /> </td>
				  </tr>
				  <tr>
					<th>旧密码</th>
					<td><input  type="password" name="oldpwd"  size="20" maxlength="20" /></td>
				  </tr>
				  <tr>
					<th>新密码</th>
					<td><input  type="password" name="newpwd"  size="20" maxlength="20" /></td>
				  </tr>
				  <tr>
					<th>确认密码</th>
					<td><input  type="password" name="mewpwdsame"  size="20" maxlength="20" /></td>
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
			  <%}else{ %>
			  <p>请重新登录！</p>
			  <%} %>
	</div>
	
       </div>
</html>