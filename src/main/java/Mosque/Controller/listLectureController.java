package Mosque.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Mosque.DAO.AdminLectureDAO;

/**
 * Servlet implementation class listLecture
 */
@WebServlet("/listLectureController")
public class listLectureController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listLectureController() {
        super();
       
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setAttribute("lectures", AdminLectureDAO.getAllLecture());
		RequestDispatcher view = request.getRequestDispatcher("Activity/listLecture.jsp");
		view.forward(request, response);
	}

}
