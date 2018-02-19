package org.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dao.EmpDAO;
import org.dao.TicketDAO;
import org.pojo.Employee;
import org.pojo.Ticket;

/**
 * Servlet implementation class EmpLogin
 */
@WebServlet("/emplogin")
public class EmpLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		String empEmail=request.getParameter("empEmail");
		String empPassword=request.getParameter("empPassword");
		try {
			EmpDAO empDao=new EmpDAO();
			Employee e=empDao.empLogin(empEmail,empPassword);	
			if(e!=null){
				HttpSession session = request.getSession(true);
				Date createTime = new Date(session.getCreationTime());
				session.setAttribute("EMP",e);
				session.setAttribute("DATE",createTime);
				response.sendRedirect("emphome.jsp");
			}
			else{
				response.sendError(300, "Invalid Username or Password");
			}				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendError(200, "Error in Loading Class");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendError(100, e.getErrorCode()+" "+e.getMessage());
		}
	}

}
