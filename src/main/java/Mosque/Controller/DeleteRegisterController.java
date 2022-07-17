package Mosque.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mosque.DAO.RegistrationDAO;


/**
 * Servlet implementation class DeleteRegisterController
 */
@WebServlet("/DeleteRegisterController")
public class DeleteRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private RegistrationDAO dao; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRegisterController() {
        super();
        dao = new RegistrationDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String activityID =request.getParameter("ActivityID");
		int userID =Integer.parseInt(request.getParameter("UserID"));
		dao.deleteRegistration(activityID);
		request.setAttribute("registrations", RegistrationDAO.getRegisteredActivity(userID));
		RequestDispatcher view = request.getRequestDispatcher("ListRegisteredActivity.jsp"); 	 
		view.forward(request, response);
	}

}
