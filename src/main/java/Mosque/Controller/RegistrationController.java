package Mosque.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Mosque.DAO.CharityDAO;
import Mosque.DAO.LectureDAO;
import Mosque.DAO.RegistrationDAO;
import Mosque.DAO.SeminarDAO;
import Mosque.DAO.UserDAO;
import Mosque.Model.User;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Email = request.getParameter("UserEmail");
		User user = new User();
		user = UserDAO.getUserByEmail(Email);
		int userID = user.getUserID();
		System.out.println(userID);
		String activityID = request.getParameter("ActivityID");
		RegistrationDAO.registerActivity(userID, activityID);
		request.setAttribute("registration", RegistrationDAO.getRegistration(userID));
		request.setAttribute("user", UserDAO.getUser(userID));
		
		if(activityID.substring(0,2).equalsIgnoreCase("AL")) {
			request.setAttribute("lecture", LectureDAO.getLecture(activityID));
			RequestDispatcher view = request.getRequestDispatcher("ActivityLectureRegistered.jsp"); 	 
			view.forward(request, response);
			
		}
		else if(activityID.substring(0,2).equalsIgnoreCase("AC")) {
			System.out.println("C"+activityID.substring(0,2));
			request.setAttribute("charity", CharityDAO.getCharity(activityID));
			RequestDispatcher view = request.getRequestDispatcher("ActivityCharityRegistered.jsp"); 	 
			view.forward(request, response);
		}
		else if(activityID.substring(0,2).equalsIgnoreCase("AS"))  {
			System.out.println("S"+activityID.substring(0,2));
			request.setAttribute("seminar", SeminarDAO.getSeminar(activityID));
			RequestDispatcher view = request.getRequestDispatcher("ActivitySeminarRegistered.jsp"); 	 
			view.forward(request, response);
		}
		
		
	}

}
