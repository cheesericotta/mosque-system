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
import Mosque.DAO.SeminarDAO;


/**
 * Servlet implementation class ListProductController
 */
@WebServlet("/AdminListActivityController")
public class AdminListActivityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminListActivityController() {
        super();
       
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setAttribute("lectures", LectureDAO.getAllLecture());
		request.setAttribute("charitys", CharityDAO.getAllCharity());	
		request.setAttribute("seminars", SeminarDAO.getAllSeminar());
		RequestDispatcher view = request.getRequestDispatcher("AdminListActivity.jsp");
		view.forward(request, response);
		
		}

}
