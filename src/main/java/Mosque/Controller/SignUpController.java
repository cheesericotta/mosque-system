package Mosque.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Mosque.DAO.UserDAO;
import Mosque.Model.User;

/**
 * Servlet implementation class SignUpController
 */
@WebServlet("/SignUpController")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static UserDAO dao; 
    HttpSession session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpController() {
        super();
        dao = new UserDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUsername(request.getParameter("userName"));
		user.setUserEmail(request.getParameter("userEmail"));
		user.setUserAddress(request.getParameter("userAddress"));
		user.setUserPhoneNo(request.getParameter("userPhoneNo"));
		user.setUserPassword(request.getParameter("password1"));
		
		try {
    		//if user not exist, add/register the user 
			dao.addUser(user);
			System.out.println("login");
			session = request.getSession(true);
			session.setAttribute("sessionId", user.getUserID());
			session.setAttribute("sessionEmail", user.getUserEmail());
			request.setAttribute("user", UserDAO.getUserByEmail(user.getUserEmail()));
			RequestDispatcher view = request.getRequestDispatcher("UserHome.jsp"); // staff page
			view.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//redirect to login page
    
	}

}
