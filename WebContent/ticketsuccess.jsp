<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="org.pojo.Employee"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ticket Successfull</title>
</head>
<body>
		
	<%
	if (session.getAttribute("EMP") == null && session.getAttribute("DATE") == null ) {
	    // Not created yet. Now do so yourself.
	   response.sendRedirect("emplogin.jsp");
	    
	} else {
	    // Already created.
	    Employee e=(Employee) session.getAttribute("EMP");
	    %>
	    <h5>Welcome : <%=e.getEmpEmail()%></h5>
	    
	    <%=(Date)session.getAttribute("DATE")%>
			<h4>You Successfully Created Ticket...</h4>
			<h4>now click <a href="emphome.jsp">here</a> for home page</h4>
			</table>	    
	    <form action="emplogout" method="post">
	<input type="submit" value="Logout">
	</form>
	    <%
	    
	} %>
</body>
</html>