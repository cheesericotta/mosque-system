package Mosque.Controller;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mosque.DAO.AdminLectureDAO;
import Mosque.DAO.AdminSeminarDAO;
import Mosque.DAO.CharityDAO;
import Mosque.DAO.LectureDAO;
import Mosque.DAO.SeminarDAO;
import Mosque.Model.Lecture;
import Mosque.Model.Seminar;

/**
 * Servlet implementation class UpdateSeminarController
 */
@WebServlet("/UpdateSeminarController")
public class UpdateSeminarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminSeminarDAO dao;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSeminarController() {
        super();
        dao = new AdminSeminarDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String ActivityID = request.getParameter("ActivityID");

		request.setAttribute("seminar",AdminSeminarDAO.getSeminarByID(ActivityID));
		RequestDispatcher view = request.getRequestDispatcher("updateSeminar.jsp");
		view.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		try {
			Seminar seminar = new Seminar();
			java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("ActivityDate"));
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			seminar.setActivityDate(sqlDate);
			String s = request.getParameter("ActivityStartTime");
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
			long ms = sdf.parse(s).getTime();
			Time t = new Time(ms);
			seminar.setActivityStartTime(t);
			ms = sdf.parse(request.getParameter("ActivityEndTime")).getTime();
			Time t1 = new Time(ms);
			seminar.setActivityEndTime(t1);
			

			seminar.setActivityID(request.getParameter("ActivityID"));
			seminar.setActivityTitle(request.getParameter("ActivityTitle"));
			seminar.setInstructorName(request.getParameter("InstructorName"));;
			seminar.setSeminarFee(Double.parseDouble(request.getParameter("SeminarFee")));
			seminar.setSeminarLocation(request.getParameter("SeminarLocation"));
			seminar.setActivityType(request.getParameter("ActivityType"));
			seminar.setAdminID(Integer.parseInt(request.getParameter("AdminID"))); 
			
			dao.updateSeminar(seminar);

			//forward quest
			
			request.setAttribute("seminars", SeminarDAO.getAllSeminar());
			RequestDispatcher view = request.getRequestDispatcher("listSeminar.jsp");
			view.forward(request, response);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		

		
		
	}
	
	
		
		


}
