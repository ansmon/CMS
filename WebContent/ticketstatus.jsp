<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.pojo.*"%>
<%@page import="org.dao.*" %>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
		<%
			String Status=null;
			if(t.getEnggId() == 0 && t.getTicketCloseDate()==null)
				Status="Pending";
			if(t.getEnggId() != 0 && t.getTicketCloseDate()==null)
				Status="Assigned";
			if(t.getEnggId() != 0 && t.getTicketCloseDate()!=null)
				Status="Closed";
		%>
		Ticket Status : <input type="text" name="ticketStatus" value=<%=Status%> readonly="readonly"><br>
		<%
			if(Status.equals("Assigned") || Status.equals("Closed")){
				EnggDAO enggDao=new EnggDAO();
				Engineer engg=enggDao.fetchNameNo(t.getEnggId());		
				if(engg!=null){
				%>
					Assigned Engineer : <input type="text" name="enggUserName" value="<%=engg.getEnggUserName() %>" readonly="readonly"><br>
					Engineer's Contact No. : <input type="text" name="enggContactNo" value="<%=engg.getEnggContactNo() %>" readonly="readonly"><br>
				<%
				}
			}
				
		%>
		
		<a href="emphome.jsp">back</a>
			    
	    <form action="emplogout" method="post">
	<input type="submit" value="Logout">
	</form>
	    <%
	} %>
</body>
</html>