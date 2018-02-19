<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Assign Ticket Success</title>
</head>
<body>
	<%
	if (session.getAttribute("ADMIN") == null && session.getAttribute("DATE") == null) {
	    // Not created yet. Now do so yourself.
	   response.sendRedirect("adminlogin.jsp");
	    
	} else {
	    // Already created.
	    String adminEmail=(String) session.getAttribute("ADMIN");
	    %>
	    <h5>Welcome : <%=adminEmail%></h5>
	    <%=(Date)session.getAttribute("DATE")%>
	    <%
	    int ticketId=Integer.parseInt(request.getParameter("ticketId"));
		int enggId=Integer.parseInt(request.getParameter("enggId"));
		%>
		<h4>Ticket Id : <%=ticketId %> is Assigned to Engineer Id : <%=enggId %></h4> 
		<h4>now click <a href="adminhome.jsp">here</a> for home</h4>
		<form action="adminlogout" method="post">
			<input type="submit" value="Logout">
		</form>
	    <%
	} %>
</body>
</html>