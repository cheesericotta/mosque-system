package Mosque.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mosque.DAO.UserDAO;
import Mosque.Model.User;

/**
 * Servlet implementation class UpdateProductController
 */
@WebServlet("/UpdateUserController")
public class UpdateUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserController() {
        super();
        dao = new UserDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int UserID = Integer.parseInt(request.getParameter("UserID"));
		request.setAttribute("user", UserDAO.getUser(UserID));
		RequestDispatcher view = request.getRequestDispatcher("UpdateUserProfile.jsp");
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		
		user.setUserID(Integer.parseInt(request.getParameter("userid")));
		user.setUsername(request.getParameter("username"));
		user.setUserPassword(request.getParameter("userpassword"));
		user.setUserEmail(request.getParameter("useremail"));
		user.setUserPhoneNo(request.getParameter("userHp"));
		user.setUserAddress(request.getParameter("useraddress"));
	
	
		
		dao.updateUser(user);
		
		//forward quest
		int UserID = Integer.parseInt(request.getParameter("userid"));
		request.setAttribute("user", UserDAO.getUser(UserID));
		RequestDispatcher view = request.getRequestDispatcher("UserProfile.jsp");
		view.forward(request, response);	}

}
