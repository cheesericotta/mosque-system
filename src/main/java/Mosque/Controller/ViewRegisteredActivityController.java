package Mosque.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mosque.DAO.RegistrationDAO;
import Mosque.DAO.UserDAO;
import Mosque.Model.User;


/**
 * Servlet implementation class ViewRegisteredActivity
 */
@WebServlet("/ViewRegisteredActivityController")
public class ViewRegisteredActivityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewRegisteredActivityController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int UserID =Integer.parseInt(request.getParameter("UserID"));
		
		request.setAttribute("registrations", RegistrationDAO.getRegisteredActivity(UserID));
		RequestDispatcher view = request.getRequestDispatcher("ListRegisteredActivity.jsp");
		view.forward(request, response);
	}

	

}
