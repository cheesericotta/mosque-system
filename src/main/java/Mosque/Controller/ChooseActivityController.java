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
 * Servlet implementation class ChooseActivityController
 */
@WebServlet("/ChooseActivityController")
public class ChooseActivityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChooseActivityController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String Choice = request.getParameter("ActivityChoice");

		if(Choice.equalsIgnoreCase("Lecture")) {
			request.setAttribute("lectures", LectureDAO.getAllLecture());
			RequestDispatcher view = request.getRequestDispatcher("listLecture.jsp");
			view.forward(request, response);
			
		}
		else if(Choice.equalsIgnoreCase("Charity")) {
			request.setAttribute("charitys", CharityDAO.getAllCharity());
			RequestDispatcher view = request.getRequestDispatcher("ListCharity.jsp");
			view.forward(request, response);
		}
		else if(Choice.equalsIgnoreCase("Seminar")) {
			request.setAttribute("seminars", SeminarDAO.getAllSeminar());
			RequestDispatcher view = request.getRequestDispatcher("listSeminar.jsp");
			view.forward(request, response);
		}
		else if(Choice.equalsIgnoreCase("All")) {
			request.setAttribute("lectures", LectureDAO.getAllLecture());
			request.setAttribute("charitys", CharityDAO.getAllCharity());	
			request.setAttribute("seminars", SeminarDAO.getAllSeminar());
			RequestDispatcher view = request.getRequestDispatcher("AdminListActivity.jsp");
			view.forward(request, response);
			
		}
		
	}
	

}
