package Mosque.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mosque.DAO.AdminActivityDAO;


/**
 * Servlet implementation class DeleteSeminar
 */
@WebServlet("/DeleteSeminar")
public class DeleteSeminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminActivityDAO dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSeminar() {
        super();
        dao = new AdminActivityDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ActivityID = request.getParameter("ActivityID");
		dao.deleteActivity(ActivityID);
		
		RequestDispatcher view = request.getRequestDispatcher("AdminListActivityController");
		view.forward(request, response);
	}

	
}
