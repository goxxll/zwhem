<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path_regist = request.getContextPath();
String basePath_regist = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path_regist+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册信息</title>

<script type="text/javascript">
	function Juge(registform)
    {
		if(registform.userName.value=="")
		   {
		    window.alert("请输入账号！"); 
		    registform.userName.focus(); 
		    return (false); 
		   }
		if(registform.password.value=="")
		   {
		    window.alert("请输入密码！"); 
		    registform.password.focus(); 
		    return (false); 
		   }
		if(registform.password.value.length <6)
	  	{
	  		window.alert("密码长度过短 可能不安全");
	  		registform.password.focus();
	  		return (false);
	  	}
	   if (registform.password.value != registform.password1.value) 
	    { 
	      window.alert("两者密码不匹配！"); 
	      registform.password1.focus(); 
	      return (false); 
	    }
		if(registform.realName.value=="")
		   {
		    window.alert("请输入真实姓名！"); 
		    registform.realName.focus(); 
		    return (false); 
		   }
		if(registform.telephone.value=="")
		   {
		    window.alert("请输入电话号码！"); 
		    registform.telephone.focus(); 
		    return (false); 
		   }
		if(isNaN(registform.telephone.value))
		{
			alert("电话号码不能是字符!");
			return false;
		}
		if(registform.telephone.value.length!=11)
		   {
		    window.alert("手机号码长度错误！"); 
		    registform.telephone.focus(); 
		    return (false); 
		   }
		if(registform.address.value=="")
		   {
		    window.alert("请输入配送地址！"); 
		    registform.address.focus(); 
		    return (false); 
		   }
		if(registform.question.value=="")
		   {
		    window.alert("请输入密码保护问题！"); 
		    registform.question.focus(); 
		    return (false); 
		   }
		if(registform.answer.value=="")
		   {
		    window.alert("请输入密码保护问题的答案！"); 
		    registform.answer.focus(); 
		    return (false); 
		   }
		if(registform.email.value=="")
		   {
		    window.alert("请输入你的邮箱"); 
		    registform.email.focus(); 
		    return (false); 
		   }
		 if(registform.email.value.length!=0)
		    {
		       if (registform.email.value.charAt(0)=="." ||        
		    	registform.email.value.charAt(0)=="@"||       
		         registform.email.value.indexOf('@', 0) == -1 || 
		         registform.email.value.indexOf('.', 0) == -1 || 
		         registform.email.value.lastIndexOf("@")==registform.email.value.length-1 || 
		         registform.email.value.lastIndexOf(".")==registform.email.value.length-1)
		          {
		             alert("Email地址格式不正确！");
		             registform.email.focus();
		             return false;
		          }
		    }  
		 if(!ifChecked()){
			 window.alert("请选择爱好！"); 
			 return (false); 
		 }
    }
	
	function ifChecked()

	{

	   var a = document.getElementsByName("favorate"); 

	   var n = a.length;

	   var k = 0;

	   for (var i=0; i<n; i++){

	        if(a[i].checked){

	            k = 1;
	           

	        }
	    }
	    if(k==1){
	    	return true;
	    	}
	    else{
	    	return false;
	    	}

	    }

</script>
	
</head>

		<div id="registtop">
			<h2>ED商城用户注册</h2>
		</div>
		<div id="regist">
			  <form name="registform" id="registform" action="<%=path_regist%>/RegistSeverlet" onsubmit="return Juge(registform);" method="post" >
				<table>
				  <tr>
					<th>账号：</th>
					<td><input  type="text" name="userName"  size="20" maxlength="20" /></td>
				  </tr>
				  <tr>
					<th>密码：</th>
					<td><input  type="password" name="password" size="20" value="" /></td>
				  </tr>
				  <tr>
					<th>重复密码：</th>
					<td><input  type="password" name="password1" size="20" value="" /></td>
				  </tr>
				  <tr>
					<th>真实姓名：</th>
					<td><input  type="text" name="realName"  size="20" maxlength="20" /></td>
				  </tr>
				  <tr>
					<th>用户性别：</th>
					<td><input name="sex" type="radio" value="男" checked />男&nbsp;
					  <input type="radio" name="sex" value="女" />女</td>
				  </tr>
				  <tr>
					<th>联系电话（手机）：</th>
					<td><input  type="text" name="telephone"  size="20" maxlength="20" /></td>
				  </tr>
				  <tr>
					<th>配送地址：</th>
					<td><input  type="text" name="address"  size="20" maxlength="20" /></td>
				  </tr>
				  <tr>
					<th>密码保护问题：</th>
					<td><select name="question">
						<option value="">--请选择--</option>
						<option value="您的出生地是？">您的出生地是？</option>
						<option value="您父亲的生日是？">您父亲的生日是？</option>
						<option value="您母亲的生日是？">您母亲的生日是？</option>
						<option value="您身份证号码的后6位是？">您身份证号码的后6位是？</option>
						<option value="您手机号码的后6位是？">您手机号码的后6位是？</option>
						<option value="您父亲的姓名是？">您父亲的姓名是？</option>
						<option value="您母亲的姓名是？">您母亲的姓名是？</option>
					  </select>
					</td>
				  </tr>
				  <tr>
					<th>答案：</th>
					<td><input  type="text" name="answer"  size="20" maxlength="20" /></td>
				  </tr>
				  <tr>
					<th>邮箱：</th>
					<td><input  type="text" name="email"  size="20" maxlength="20" /></td>
				  </tr>
				  <tr>
					<th>请选择关注的商品类别：</th>
					<td>
					  <input type="checkbox"  name="favorate" value="手机"/>手机
					  <input type="checkbox"  name="favorate" value="电脑"/>电脑
					  <input type="checkbox"  name="favorate" value="相机"/>相机
					  <input type="checkbox"  name="favorate" value="其他"/>其他
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
			  </div>

	
</html>