package Mosque.Controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mosque.DAO.UserDAO;

/**
 * Servlet implementation class DeleteProductController
 */
@WebServlet("/DeleteUserController")
public class DeleteUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO dao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserController() {
        super();
        dao = new UserDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int UserID =Integer.parseInt(request.getParameter("UserID")) ;
		dao.deleteUser(UserID);
		RequestDispatcher view = request.getRequestDispatcher("index.html");
		view.forward(request, response);
	}


}
