
<%@ page import="com.zwhem.model.*" %>    
<%
 User usersession=(User)session.getAttribute("user");
if(usersession==null){
	response.sendRedirect("../index.jsp");
}
%>