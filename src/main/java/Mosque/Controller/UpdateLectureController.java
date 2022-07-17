package Mosque.Controller;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Mosque.DAO.AdminLectureDAO;
import Mosque.DAO.CharityDAO;
import Mosque.DAO.LectureDAO;
import Mosque.DAO.SeminarDAO;
import Mosque.Model.Lecture;


/**
 * Servlet implementation class UpdateLectureController
 */
@WebServlet("/UpdateLectureController")
public class UpdateLectureController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdminLectureDAO dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateLectureController() {
        super();
        dao = new AdminLectureDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String ActivityID = request.getParameter("ActivityID");

		request.setAttribute("lecture",AdminLectureDAO.getLectureByID(ActivityID));
		RequestDispatcher view = request.getRequestDispatcher("updateLecture.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			Lecture lect=new Lecture();
			java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("ActivityDate"));
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			lect.setActivityDate(sqlDate);
			String s = request.getParameter("ActivityStartTime");
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
			long ms = sdf.parse(s).getTime();
			Time t = new Time(ms);
			lect.setActivityStartTime(t);
			ms = sdf.parse(request.getParameter("ActivityEndTime")).getTime();
			Time t1 = new Time(ms);
			
			lect.setActivityEndTime(t1);
			lect.setActivityID(request.getParameter("ActivityID"));
			lect.setActivityTitle(request.getParameter("ActivityTitle"));
			lect.setUstazName(request.getParameter("UstazName"));
			lect.setLectureSlot(request.getParameter("LectureSlot"));
			lect.setActivityType(request.getParameter("ActivityType"));
			lect.setAdminID(Integer.parseInt(request.getParameter("AdminID")));    
			
			dao.updateLecture(lect);
			
			request.setAttribute("lectures", AdminLectureDAO.getAllLecture());
			RequestDispatcher view = request.getRequestDispatcher("listLecture.jsp");
			view.forward(request, response);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
		

