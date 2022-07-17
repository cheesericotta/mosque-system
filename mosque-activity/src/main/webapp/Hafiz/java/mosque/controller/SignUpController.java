package mosque.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mosque.dao.UserDAO;
import mosque.model.User;

/**
 * Servlet implementation class SignUpController
 */
@WebServlet("/SignUpController")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static UserDAO dao;   
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
		user.setUserName(request.getParameter("userName"));
		user.setUserEmail(request.getParameter("userEmail"));
		user.setUserAddress(request.getParameter("userAddress"));
		user.setUserPhoneNo(request.getParameter("userPhoneNo"));
		user.setPassword(request.getParameter("password1"));
		
		try {
    		//if user not exist, add/register the user
			dao.add(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//redirect to login page
    	RequestDispatcher view = request.getRequestDispatcher("/User/Home/index.html");
		view.forward(request, response);
		
	}

}
