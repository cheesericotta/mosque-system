package Mosque.Controller;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Mosque.DAO.*;
import Mosque.Model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddActivity
 */
@WebServlet("/AddLecture")
public class AddLecture extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLecture() {
        super();
      
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
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
			
			AdminLectureDAO.addLecture(lect);
			
			request.setAttribute("lectures", AdminLectureDAO.getAllLecture());
			RequestDispatcher view = request.getRequestDispatcher("listLecture.jsp");
			view.forward(request, response);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	    
		
		
	}

}
