package org.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.EnggDAO;

/**
 * Servlet implementation class EnggReg
 */
@WebServlet("/enggreg")
public class EnggReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnggReg() {
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
		String enggUserName=request.getParameter("enggUserName");
		String enggEmail=request.getParameter("enggEmail");
		String enggPassword=request.getParameter("enggPassword");
		String enggAddress=request.getParameter("enggAddress");
		String enggContactNo=request.getParameter("enggContactNo");
		try {
			EnggDAO enggDao=new EnggDAO();
			int row=enggDao.enggReg(enggUserName, enggEmail, enggPassword, enggAddress, enggContactNo);
			if(row==1)
			{
				response.sendRedirect("enggregsuccess.jsp");
			}
			else{
				response.sendError(300, "Some internal Error Occured");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			response.sendError(200, "Error in Loading Class");
			e.printStackTrace();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			response.sendError(100, e.getErrorCode()+" "+e.getMessage());
			e.printStackTrace();
		}
	}

}
