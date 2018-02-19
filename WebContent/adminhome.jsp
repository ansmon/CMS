<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="org.pojo.*"%>
<%@page import="org.dao.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Home</title>
</head>
<body>
	<%
	if (session.getAttribute("ADMIN") == null && session.getAttribute("DATE") == null ) {
	    // Not created yet. Now do so yourself.
	   response.sendRedirect("adminlogin.jsp");
	    
	} else {
	    // Already created.
	    String adminEmail=(String) session.getAttribute("ADMIN");
	    %>
	    <h5>Welcome : <%=adminEmail%></h5>
	    
	    <%=(Date)session.getAttribute("DATE")%>
	    <table border="1">	    
	    <%
	    TicketDAO ticketDao=new TicketDAO();
		ArrayList<Ticket> tList=ticketDao.ticketHistory();
		if(tList!=null){
			%>
			<tr>
	    		<th>Ticket Id</th>
	    		<th>Type</th>
	    		<th>Subject</th>
	    		<th>Description</th>
	    		<th>Priority</th>
	    		<th>Status</th>
	    	</tr>
			<%
			for(Ticket t:tList){				
			%>
				<tr>
		    		<td><%=t.getTicketId() %></td>
		    		<td><%=t.getTicketType() %></td>
		    		<td><%=t.getTicketSub() %></td>
		    		<td><%=t.getTicketDesc() %></td>
		    		<td><%=t.getTicketPriority() %></td>
		    		<%
						String Status=null;
						if(t.getEnggId() == 0 && t.getTicketCloseDate()==null)
							Status="Pending";
						if(t.getEnggId() != 0 && t.getTicketCloseDate()==null)
							Status="Assigned";
						if(t.getEnggId() != 0 && t.getTicketCloseDate()!=null)
							Status="Closed";
					%>
		    		<td><%=Status %></td>
		    		<%if(Status.equals("Pending")) {
		    			%>
			    		<td><a href="ticketassign.jsp?ticketId=<%=t.getTicketId()%>" >Next</a></td>
			    		<%
		    		}
		    		%>
		    	</tr>
			<%	
			}
		}
		else{
			%>
			<tr>No Ticket Raised Yet</tr>
			<%
		}
	    %>
	    
	    </table>	    
		<form action="adminlogout" method="post">
			<input type="submit" value="Logout">
		</form>
	    <%
	} %>
</body>
</html>