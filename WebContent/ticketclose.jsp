<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="org.pojo.*"%>
<%@page import="org.dao.*" %>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Close Ticket</title>
</head>
<body>
	<%
	if (session.getAttribute("ENGG") == null && session.getAttribute("DATE") == null ) {
	    // Not created yet. Now do so yourself.
	   response.sendRedirect("engglogin.jsp");
	    
	} else {
	    // Already created.
	    Engineer e=(Engineer) session.getAttribute("ENGG");
	    %>
	    <h5>Welcome : <%=e.getEnggEmail()%></h5>
	    
	    <%=(Date)session.getAttribute("DATE")%>
	    <%
	    int ticketId=Integer.parseInt(request.getParameter("ticketId"));	    
	    TicketDAO ticketDao=new TicketDAO();
		Ticket t=ticketDao.ticketDetails(ticketId);
		
		%>
		<br>
		Ticket Id : <input type="text" name="ticketId" value="<%=ticketId %>" readonly="readonly"><br>
		Ticket Type : <input type="text" name="ticketType" value="<%=t.getTicketType()%>" readonly="readonly"><br>
		Ticket Subject : <input type="text" name="ticketSub" value="<%=t.getTicketSub()%>" readonly="readonly"><br>
		Ticket Description : <input type="text" name="ticketDesc" value="<%=t.getTicketDesc()%>" readonly="readonly"><br>
		Ticket Priority : <input type="text" name="ticketPriority" value="<%=t.getTicketPriority()%>" readonly="readonly"><br>
		Estimated Solution Date : <input type="text" name="ticketEstSolDate" value="<%=t.getTicketEstSolDate()%>" readonly="readonly"><br>
		Raise Date : <input type="text" name="ticketRaiseDate" value="<%=t.getTicketRaiseDate()%>" readonly="readonly"><br>
		<form action="ticketclose" method="post">
			<input type="hidden" name="ticketId" value="<%=ticketId %>"><br>
			<input type="submit" value="Close Ticket">
		</form>
		<h4><a href="engghome.jsp">back</a></h4>
	    <%
	} %>
	
</body>
</html>