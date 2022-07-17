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
@WebServlet("/AddSeminar")
public class AddSeminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSeminar() {
        super();
      
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Seminar seminar=new Seminar();
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
			
		AdminSeminarDAO.addSeminar(seminar);
		
		request.setAttribute("seminars", AdminSeminarDAO.getAllSeminar());
		RequestDispatcher view = request.getRequestDispatcher("listSeminar.jsp");
		view.forward(request, response);
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
