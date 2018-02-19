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
<title>Assign Engineer</title>
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
	    <table border="1">	    
	    <%
	    EnggDAO enggDao=new EnggDAO();
		ArrayList<Engineer> eList=enggDao.allEngineer();
		if(eList!=null){
			%>
			<tr>
	    		<th>Engineer Id</th>
	    		<th>Engineer UserName</th>
	    		<th>Engineer Email</th>
	    		<th>Engineer Conatct No.</th>
	    	</tr>
			<%
			for(Engineer e:eList){				
			%>
				<tr>
		    		<td><%=e.getEnggId() %></td>
		    		<td><%=e.getEnggUserName() %></td>
		    		<td><%=e.getEnggEmail() %></td>
		    		<td><%=e.getEnggContactNo() %></td>		
		    		<%int ticketId=Integer.parseInt(request.getParameter("ticketId")); %>	    		
		    		<td><a href="ticketassign?enggId=<%=e.getEnggId()%>&ticketId=<%=ticketId%>" >Choose</a></td>		    	
		    	</tr>
		    <%} %>
			<%				
		}
		else{
			%>
			<tr>Engineer List Empty... Please Add Engineer</tr>
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