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
@WebServlet("/AddCharity")
public class AddCharity extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public AdminActivityDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCharity() {
        super();
        
        dao = new AdminActivityDAO();
       
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		try {
			Charity charity=new Charity();
			java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("ActivityDate"));
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			charity.setActivityDate(sqlDate);
			String s = request.getParameter("ActivityStartTime");
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
			long ms = sdf.parse(s).getTime();
			Time t = new Time(ms);
			charity.setActivityStartTime(t);
			ms = sdf.parse(request.getParameter("ActivityEndTime")).getTime();
			Time t1 = new Time(ms);
			charity.setActivityEndTime(t1);
			charity.setActivityID(request.getParameter("ActivityID"));
			charity.setActivityTitle(request.getParameter("ActivityTitle"));
			charity.setDonationType(request.getParameter("DonationType"));
			charity.setActivityType(request.getParameter("ActivityType"));
			charity.setAdminID(Integer.parseInt(request.getParameter("AdminID")));    
		
		AdminCharityDAO.addCharity(charity);
		
		request.setAttribute("charities", AdminCharityDAO.getAllCharity());
		RequestDispatcher view = request.getRequestDispatcher("ListCharity.jsp");
		view.forward(request, response);
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}

}
