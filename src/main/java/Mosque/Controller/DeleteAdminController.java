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
 * Servlet implementation class DeleteProductController
 */
@WebServlet("/DeleteAdminController")
public class DeleteAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdminDAO dao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAdminController() {
        super();
        dao = new AdminDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("AdminEmail");
		dao.deleteAdmin(email);
		RequestDispatcher view = request.getRequestDispatcher("Sign-In/index.jsp");
		view.forward(request, response);
	}


}
