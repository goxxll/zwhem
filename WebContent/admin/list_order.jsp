<%@ page language="java" import="java.util.*,com.zwhem.model.*,com.zwhem.impl.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>无标题文档</title>
<script type="text/javascript">
	function myhref(){
		var topage=document.getElementById("topage").value;
		//alert("111");
		if(!isNaN(topage) && topage.length>0){
			
			window.location.href="OrderAdminServlet?page="+topage;
		}else{
			//alert(topage+"zheli");
			window.location.href="OrderAdminServlet?page=1";
		}
		
		
	}
</script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {font-size: 12px}
.STYLE4 {
	font-size: 12px;
	color: #1F4A65;
	font-weight: bold;
}

a:link {
	font-size: 12px;
	color: #06482a;
	text-decoration: none;

}
a:visited {
	font-size: 12px;
	color: #06482a;
	text-decoration: none;
}
a:hover {
	font-size: 12px;
	color: #FF0000;
	text-decoration: underline;
}
a:active {
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.STYLE7 {font-size: 12}

-->
</style>

</head>

<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
  	<form action="../OrderAdminServlet" method="post">
 	<input name="flag" type="hidden" value="search" />
  <table  width="50%" border="0" cellspacing="0" cellpadding="0">
  <tr>
 	<td class="row">查询类型</td>
  	<td class="row">
	<select name="searchType" style="font: 黑体;width: 120">
      <option value="">请选择查询类型</option>
      <option value="name">用户名</option>
      <option value="status">交易状态</option>
     </select>
	</td>
	<td class="row">查询关键字</td>
	<td class="row"><input type="text" name="key" /> </td>
	<td><input type="submit" value="查询"></td>
  	</tr>
  	</table>  	
  </form>
  </tr>
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
       <td width="15" height="30"><img src="${pageContext.request.contextPath}/admin/tab/images/tab_03.gif" width="15" height="30" /></td>
        <td width="1101" background="${pageContext.request.contextPath}/admin/tab/images/tab_05.gif"><img src="${pageContext.request.contextPath}/admin/tab/images/311.gif" width="16" height="16" /> <span class="STYLE4">订单信息管理列表</span></td>
        <td width="281" background="${pageContext.request.contextPath}/admin/tab/images/tab_05.gif"><table border="0" align="right" cellpadding="0" cellspacing="0">
             <tr>
              <td width="60"><table width="87%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center">
                        <input type="checkbox" name="checkbox62" value="checkbox" />
                    </div></td>
                    <td class="STYLE1"><div align="center">全选</div></td>
                  </tr>
                  
                  
              </table></td>
               <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="${pageContext.request.contextPath}/admin/tab/images/001.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><div align="center"><a href="../OrderAdminServlet?flag=rank&count=5">排名</a></div></td>
                  </tr>
              </table></td>
              <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="${pageContext.request.contextPath}/admin/tab/images/001.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><div align="center"><a href="orderstat.jsp">统计</a></div></td>
                  </tr>
              </table></td>
              <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="${pageContext.request.contextPath}/admin/tab/images/114.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><div align="center">修改</div></td>
                  </tr>
              </table></td>
              <td width="52"><table width="88%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="${pageContext.request.contextPath}/admin/tab/images/083.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><div align="center">删除</div></td>
                  </tr>
              </table></td>
            </tr>
        </table></td>
        <td width="14"><img src="${pageContext.request.contextPath}/admin/tab/images/tab_07.gif" width="14" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
     
      <tr>
        <td width="9" background="${pageContext.request.contextPath}/admin/tab/images/tab_12.gif">&nbsp;</td>
        <td bgcolor="#f3ffe3">
        <table width="99%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#c0de98" onmouseover="changeto()"  onmouseout="changeback()">
          <tr>
            <td width="5%" height="15" background="${pageContext.request.contextPath}/admin/tab/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">选择</div></td>
            <td width="10%" height="15" background="${pageContext.request.contextPath}/admin/tab/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">编号</div></td>
            <td width="8%" height="15" background="${pageContext.request.contextPath}/admin/tab/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">用户</div></td>
            <td width="25%" height="15" background="${pageContext.request.contextPath}/admin/tab/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">地址</div></td>
            <td width="10%" height="15" background="${pageContext.request.contextPath}/admin/tab/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">电话</div></td>
            <td width="10%" height="15" background="${pageContext.request.contextPath}/admin/tab/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">状态</div></td>
            <td width="8%" height="15" background="${pageContext.request.contextPath}/admin/tab/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">查看详细</div></td>
            <td width="8%" height="15" background="${pageContext.request.contextPath}/admin/tab/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">操作</div></td>
          </tr>
  <%
   		List<Order> orderList = (List<Order>)session.getAttribute("list");

   		PageBean pagebean=(PageBean)session.getAttribute("page");
   		int all=pagebean.getAll();
   		int pageTotal=pagebean.getPageTotal();
   		int pageCount=pagebean.getPageCount();
   		int curPage=pagebean.getCurPage();
   		int pre=pagebean.getPre();
   		int next=pagebean.getNext();
   		
   		for(Order o:orderList){
   		
    %>
          <tr>
            <td hedight="15" bgcolor="#FFFFFF">
            <div align="center" class="STYLE1">
              <input name="checkbox" type="checkbox" class="STYLE2" value="checkbox" />
            </div>
            </td>
            <td height="15" bgcolor="#FFFFFF" class="STYLE2"><div align="center" class="STYLE2 STYLE1"><%=o.getId() %></div></td>
            <td height="15" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1"><%=o.getUserName()%></div></td>
            <td height="15" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1"><%=o.getAddress() %></div></td>
            <td height="15" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1"><%=o.getTelephone() %></div></td>
            <td height="15" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1"><%=o.getStatus() %></div></td>
            <td height="15" bgcolor="#FFFFFF"><div align="center"><img src="${pageContext.request.contextPath}/admin/tab/images/037.gif" width="9" height="9" /><span class="STYLE1"> [</span><a href="${pageContext.request.contextPath}/OrderAdminDetailServlet?id=<%=o.getId()%>">查看详细</a><span class="STYLE1">]</span></div></td>
			<td height="15" bgcolor="#FFFFFF"><div align="center"><img src="${pageContext.request.contextPath}/admin/tab/images/037.gif" width="9" height="9" />
			<%if(o.getStatus().equals("已确认")){%>
			<span class="STYLE1"> [</span>
				<a href="${pageContext.request.contextPath}/OrderAdminSendServlet?id=<%=o.getId() %>" onclick="if(confirm('确定要发货吗？')) return true;else return false;">发货</a>
			<span class="STYLE1">]</span>
			<%}%>
			</div></td>
          </tr>
         <%} 
         %>
        </table></td>
        <td width="9" background="${pageContext.request.contextPath}/admin/tab/images/tab_16.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="29"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="29"><img src="${pageContext.request.contextPath}/admin/tab/images/tab_20.gif" width="15" height="29" /></td>
        <td background="tab/images/tab_21.gif"> <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="25%" height="29" nowrap="nowrap"><span class="STYLE1">共<%=all %>条纪录，当前第<%=curPage %>/<%=pageTotal %>页，每页<%=pageCount %>条纪录</span></td>
            <td width="75%" valign="top" class="STYLE1"><div align="right">
              <table width="352" height="20" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="62" height="22" valign="middle"><div align="right"><a href="OrderAdminServlet?page=1"><img src="${pageContext.request.contextPath}/admin/tab/images/first.gif" width="37" height="15" /></a></div></td>
                  <td width="50" height="22" valign="middle"><div align="right"><a href="OrderAdminServlet?page=<%=pre %>"><img src="${pageContext.request.contextPath}/admin/tab/images/back.gif" width="43" height="15" /></a></div></td>
                  <td width="54" height="22" valign="middle"><div align="right"><a href="OrderAdminServlet?page=<%=next %>"><img src="${pageContext.request.contextPath}/admin/tab/images/next.gif" width="43" height="15" /></a></div></td>
                  <td width="49" height="22" valign="middle"><div align="right"><a href="OrderAdminServlet?page=<%=pageTotal %>"><img src="${pageContext.request.contextPath}/admin/tab/images/last.gif" width="37" height="15" /></a></div></td>
                  <td width="59" height="22" valign="middle"><div align="right">转到第</div></td>
                  <td width="25" height="22" valign="middle"><span class="STYLE7">
                    <input name="topage" id="topage" type="text" class="STYLE1" style="height:10px; width:25px;" size="5" />
                  </span></td>
                  <td width="23" height="22" valign="middle">页</td>
                  <td width="30" height="22" valign="middle"><img src="${pageContext.request.contextPath}/admin/tab/images/go.gif" onclick="myhref()" width="37" height="15" /></td>
                </tr>
              </table>
            </div></td>
          </tr>
        </table></td>
        <td width="14"><img src="${pageContext.request.contextPath}/admin/tab/images/tab_22.gif" width="14" height="29" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
