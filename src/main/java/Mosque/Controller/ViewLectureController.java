package Mosque.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mosque.DAO.*;

/**
 * Servlet implementation class ViewLectureController
 */
@WebServlet("/ViewLectureController")
public class ViewLectureController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewLectureController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ActivityID = request.getParameter("ActivityID");

		request.setAttribute("lecture",AdminLectureDAO.getLectureByID(ActivityID));
		RequestDispatcher view = request.getRequestDispatcher("viewLecture.jsp");
		view.forward(request, response);
	}


}
