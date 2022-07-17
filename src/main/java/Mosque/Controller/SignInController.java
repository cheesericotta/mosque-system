package Mosque.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Mosque.DAO.AdminDAO;
import Mosque.DAO.UserDAO;
import Mosque.Model.Admin;
import Mosque.Model.User;

/**
 * Servlet implementation class SignInController
 */
@WebServlet("/SignInController")
public class SignInController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	HttpSession session;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInController() {
        super();
      
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {

			String role = request.getParameter("role");
			
			if (role.equalsIgnoreCase("admin")) {
				Admin admin = new Admin();
				admin.setAdminEmail(email);
				admin.setAdminPassword(password);
				admin = AdminDAO.login(admin);
				if(admin.isValid()){
					System.out.println("login");
					session = request.getSession(true);
					session.setAttribute("sessionId", admin.getAdminID());
					session.setAttribute("sessionEmail", admin.getAdminEmail());
					request.setAttribute("admin", AdminDAO.getAdminByEmail(admin.getAdminEmail()));
					RequestDispatcher view = request.getRequestDispatcher("AdminHome.jsp"); 
					view.forward(request, response);
				}
				else {
					RequestDispatcher view = request.getRequestDispatcher("FailedSignIn.html"); 
					view.forward(request, response);
				}
				
			}
			else {
				User user = new User();
				user.setUserEmail(email);
				user.setUserPassword(password);
				user = UserDAO.login(user);
				if(user.isValid()){
					System.out.println("login");
					session = request.getSession(true);
					session.setAttribute("sessionId", user.getUserID());
					session.setAttribute("sessionEmail", user.getUserEmail());
					request.setAttribute("user", UserDAO.getUserByEmail(user.getUserEmail()));
					RequestDispatcher view = request.getRequestDispatcher("UserHome.jsp"); // staff page
					view.forward(request, response);
				}
				else {
					RequestDispatcher view = request.getRequestDispatcher("FailedSignIn.html"); 
					view.forward(request, response);
				}
			}
		}

		catch (Throwable ex) {
			System.out.println(ex);
		}
	}

}
