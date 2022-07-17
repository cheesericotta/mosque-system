package Mosque.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mosque.DAO.AdminCharityDAO;


/**
 * Servlet implementation class ViewCharityController
 */
@WebServlet("/ViewCharityController")
public class ViewCharityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCharityController() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ActivityID = request.getParameter("ActivityID");

		request.setAttribute("charity",AdminCharityDAO.getCharityByID(ActivityID));
		RequestDispatcher view = request.getRequestDispatcher("Activity/viewCharity.jsp");
		view.forward(request, response);
	}
	}

	


