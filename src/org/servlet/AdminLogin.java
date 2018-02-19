package org.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dao.EmpDAO;
import org.pojo.Employee;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String adminEmail=request.getParameter("adminEmail");
		String adminPassword=request.getParameter("adminPassword");
		if(adminEmail.equals("admin") && adminPassword.equals("admin")){
			HttpSession session = request.getSession(true);
			Date createTime = new Date(session.getCreationTime());
			session.setAttribute("ADMIN","admin");
			session.setAttribute("DATE",createTime);
			response.sendRedirect("adminhome.jsp");
		}		
		else{
			response.sendError(300, "Invalid Username or Password");
		}				
		
	}

}
