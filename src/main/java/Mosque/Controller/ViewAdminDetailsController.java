package Mosque.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mosque.DAO.AdminDAO;

/**
 * Servlet implementation class ViewAdminDetails
 */
@WebServlet("/ViewAdminDetailsController")
public class ViewAdminDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAdminDetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("UserEmail");
		
		request.setAttribute("admin", AdminDAO.getAdminByEmail(email));
		RequestDispatcher view = request.getRequestDispatcher("AdminHome.jsp");
		view.forward(request, response);
	}
	
}
