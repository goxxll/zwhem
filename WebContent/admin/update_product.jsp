<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.zwhem.model.Product" %>
<%@ page import="com.zwhem.dao.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
<title>商品添加</title>

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="../ckfinder/ckfinder.js"></script>
<link type="text/css" rel="stylesheet" href="../style/main.css" />
<script type="text/javascript">
function BrowseServer( inputId )
{
	var finder = new CKFinder() ;
	finder.BasePath = '../ckfinder/' ;
	finder.selectActionFunction  = SetFileField ;
	finder.selectActionData  = inputId ;
	finder.popup() ;
}
function SetFileField( fileUrl, data )
{
	document.getElementById( data["selectActionData"] ).value = fileUrl ;
}
function Juge(updateform)
{
	if(updateform.name.value=="")
	   {
	    window.alert("请输入商品名称！"); 
	    updateform.name.focus(); 
	    return (false); 
	   }
	if(updateform.code.value=="")
	   {
	    window.alert("请输入商品编码！"); 
	    updateform.code.focus(); 
	    return (false); 
	   }
	if(updateform.brand.value=="")
	   {
	    window.alert("请输入商品品牌！"); 
	    updateform.brand.focus(); 
	    return (false); 
	   }
	if(updateform.brand.value=="")
	   {
	    window.alert("请输入商品品牌！"); 
	    updateform.brand.focus(); 
	    return (false); 
	   }
	if(updateform.price.value=="")
	   {
	    window.alert("请输入商品价格！"); 
	    updateform.price.focus(); 
	    return (false); 
	   }
	if(isNaN(updateform.price.value))
	{
		alert("价格不能是字符!");
		 updateform.price.focus(); 
		return false;
	}
	if(updateform.sale.value=="")
	   {
	    window.alert("请输入商品促销价格！"); 
	    updateform.sale.focus(); 
	    return (false); 
	   }
	if(isNaN(updateform.sale.value))
	{
		alert("促销价格不能是字符!");
		 updateform.sale.focus(); 
		return false;
	}
	if(updateform.type.value=="")
	   {
	    window.alert("请选择商品类型！"); 
	    updateform.type.focus(); 
	    return (false); 
	   }
	f(updateform.pic.value==""||updateform.pic.value.length==0)
	   {
	    window.alert("请选择商品图片！"); 
	    updateform.pic.focus(); 
	    return (false); 
	   }
	if(updateform.num.value==""||updateform.num.value.length==0)
	   {
	    window.alert("请输入商品数量！"); 
	    updateform.num.focus(); 
	    return (false); 
	   }
	if(isNaN(updateform.num.value))
	{
		alert("商品数量不能是字符!");
		 updateform.num.focus(); 
		return false;
	}
	if(updateform.intro.value=="")
	   {
	    window.alert("请编辑商品介绍信息！"); 
	    updateform.intro.focus(); 
	    return (false); 
	   }
	
}
</script>
</head>
<body>
<%
	String[] ops = {"电脑","手机","相册","其他"};
 	String strId = request.getParameter("id");
	if(strId == null)
		response.sendRedirect("list_product.jsp");
	ProductDao pdi = ProductDaoFactory.getInstance();
	Product p =  pdi.getProductById(Integer.parseInt(strId));
%>
	<form id="updateform" name="updateform" method="post" action="../UpdateProductServlet" onsubmit="return Juge(updateform);">
		<input type="hidden" name="flag" value="update" >
		<input type="hidden" name="id" value="<%=p.getP_id() %>" >
		<div id="regist">
		<table border="0" bordercolor="#4f6b72">
      	<tr>
      	  <td class="row" colspan="2" align="center"><h1>商品信息修改</h1></td>
      	</tr>
        <tr>
          <td class="row">商品名称:</td>
          <td><input type="text" name="name" value="<%=p.getPname() %>" ><font color="red">*</font></td>
          <td class="row">商品编码:</td>
          <td><input type="text" name="code" value="<%=p.getCode() %>" ><font color="red">*</font></td>
          <td class="row">商品品牌:</td>
          <td><input type="text" name="brand" value="<%=p.getBrand() %>" ><font color="red">*</font></td>
        </tr>
        <tr>
          <td class="row">商品价格:</td>
          <td><input type="text" name="price" value="<%=p.getPrice() %>" ><font color="red">*</font></td>
          <td class="row">促销价格:</td>
          <td><input type="text" name="sale" value="<%=p.getSale() %>" ><font color="red">*</font></td>
          <td class="row">商品类别:</td>
          <td>
          <select name="type" style="font: 黑体;width: 155">
          <option value="">请选择商品种类</option>
          <%
          for(String s : ops){
        	  if(s.equals(p.getType())){
        		  out.print("<option value='"+s+"' selected>"+s+"</option>");
        	  }else{
        		  out.print("<option value='"+s+"'>"+s+"</option>");
        	  }
          }
          %>
          </select><font color="red">*</font>
          </td>
        </tr>
       
        <tr>
          <td class="row">商品图片:</td>
          <td><input type="text" name="pic" id="pic" value="<%=p.getPic() %>" onclick="BrowseServer('pic');" ><font color="red">*</font>
          </td>
          <td class="row">商品数量:</td>
          <td><input type="text" name="num" value="<%=p.getNum() %>" ><font color="red">*</font></td>
          <td class="row"><input type="submit" value="保存"/></td>
          <td class="row"><input type="reset" value="重置"/></td>
        </tr> 
      </table>
			<textarea id="intro" name="intro" class="ckeditor" rows="10" cols="80">
			<%=p.getIntro().length()>0?p.getIntro(): "&nbsp;"%>
			</textarea>
		</div>
	</form>
</body>
</html>

