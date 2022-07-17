package mosque.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mosque.dao.RegistrationDAO;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userID = Integer.parseInt(request.getParameter("userID"));
		String activityID = request.getParameter("activityID");
		
		RegistrationDAO.registerActivity(userID, activityID);
		request.setAttribute("registrations", RegistrationDAO.getRegisteredActivity(userID));
		RequestDispatcher view = request.getRequestDispatcher("listRegisteredActivity.jsp"); 	 
		view.forward(request, response);
	}

}
