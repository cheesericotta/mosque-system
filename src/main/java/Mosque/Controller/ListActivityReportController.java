package Mosque.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Mosque.DAO.RegistrationDAO;

/**
 * Servlet implementation class ListActivityReportController
 */
@WebServlet("/ListActivityReportController")
public class ListActivityReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListActivityReportController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		// TODO Auto-generated method stub
   		
   		request.setAttribute("reports", RegistrationDAO.getReport());
   		RequestDispatcher view = request.getRequestDispatcher("ActivityReport.jsp");
   		view.forward(request, response);
   	}
   	
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
   		
   		String month = request.getParameter("month");
   		System.out.println(month);
   		request.setAttribute("reports", RegistrationDAO.getReportByMonth(month));
		RequestDispatcher view = request.getRequestDispatcher("ActivityReport.jsp");
		view.forward(request, response);

   	}





}
