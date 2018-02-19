<%@page import="org.pojo.Employee"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Ticket</title>
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
	<form action="newticket" method="post">
		Ticket Type : <input type="text" name="ticketType"><br>
		Ticket Subject : <input type="text" name="ticketSub"><br>
		Ticket Description : <input type="text" name="ticketDesc"><br>
		Ticket Priority : <input type="text" name="ticketPriority"><br>
		Estimated Solution Date : <input type="text" name="ticketEstSolDate"><br>
		<input type="hidden" name="empId" value="<%=e.getEmpId()%>">
		<input type="submit" value="Raise Ticket">
	</form>	<h4><a href="emphome.jsp">back</a>  </h4>
	
	    <%
	} %>
	
</body>
</html>