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

import org.dao.EnggDAO;
import org.pojo.Engineer;

/**
 * Servlet implementation class EnggLogin
 */
@WebServlet("/engglogin")
public class EnggLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnggLogin() {
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
		String enggEmail=request.getParameter("enggEmail");
		String enggPassword=request.getParameter("enggPassword");
		try {
			EnggDAO enggDao=new EnggDAO();
			Engineer e=enggDao.enggLogin(enggEmail,enggPassword);		
			if(e!=null){
				HttpSession session = request.getSession(true);
				Date createTime = new Date(session.getCreationTime());
				session.setAttribute("ENGG",e);
				session.setAttribute("DATE",createTime);
				response.sendRedirect("engghome.jsp");
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
