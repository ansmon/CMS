package org.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dao.EmpDAO;
import org.pojo.Employee;

/**
 * Servlet implementation class EmpNewReg
 */
@WebServlet("/empreg")
public class EmpReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpReg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String empUserName=request.getParameter("empUserName");
		String empEmail=request.getParameter("empEmail");
		String empPassword=request.getParameter("empPassword");
		String empAddress=request.getParameter("empAddress");
		String empContactNo=request.getParameter("empContactNo");
		try {
			EmpDAO empDao=new EmpDAO();
			int row=empDao.empReg(empUserName, empEmail, empPassword, empAddress, empContactNo);
			if(row==1){
				response.sendRedirect("empregsuccess.jsp");
			}	
			else{
				response.sendError(300, "Some internal Error Occured");
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
