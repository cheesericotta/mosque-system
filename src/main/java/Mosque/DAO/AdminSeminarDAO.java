package Mosque.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.sql.Date;
import java.sql.Time;

import Mosque.Connection.ConnectionManager;
import Mosque.Model.Activity;
import Mosque.Model.Seminar;



public class AdminSeminarDAO extends AdminActivityDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	private static String InstructorName;
	private static String ActivityID;
	private static String SeminarLocation;
	private static Double SeminarFee;
	

	
	
	public static void addSeminar(Seminar bean) {
		
		InstructorName=bean.getInstructorName();
		SeminarLocation= bean.getSeminarLocation();
		SeminarFee= bean.getSeminarFee();
		ActivityID= bean.getActivityID();
		Activity act =new Activity();
		act.setActivityDate(bean.getActivityDate());
		act.setActivityTitle(bean.getActivityTitle());
		act.setActivityEndTime(bean.getActivityEndTime());
		act.setActivityStartTime(bean.getActivityStartTime());
		act.setActivityID(bean.getActivityID());
		act.setActivityType(bean.getActivityType());
		act.setAdminID(bean.getAdminID());		
		
		try {
			
			con = ConnectionManager.getConnection();
			
			
			String sql = "INSERT INTO seminar (ActivityID,InstructorName,SeminarLocation,SeminarFee)VALUES(?,?,?,?)";
			AdminActivityDAO.addActivity(act);
			ps = con.prepareStatement(sql);
			ps.setString(1, ActivityID);
			ps.setString(2, InstructorName);
			ps.setString(3, SeminarLocation );
			ps.setDouble(4, SeminarFee );
			
			
			
			ps.executeUpdate();
			
			
			
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

	public static Seminar getSeminarByID(String ActivityID) {
		Seminar seminar = new Seminar();
		try {
			con = ConnectionManager.getConnection();
			String sql = "SELECT * FROM seminar JOIN activity USING(ActivityID) WHERE ActivityID=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ActivityID);

			rs = ps.executeQuery();
			if(rs.next()) {
				seminar.setActivityID(rs.getString("ActivityID"));
				seminar.setActivityTitle(rs.getString("ActivityTitle"));
				seminar.getActivityID();
				seminar.setInstructorName(rs.getString("InstructorName"));;
				seminar.setSeminarFee(rs.getDouble("SeminarFee"));
				seminar.setSeminarLocation(rs.getString("SeminarLocation"));
				seminar.setActivityDate(rs.getDate("ActivityDate"));
				seminar.setActivityType(rs.getString("ActivityType"));
				seminar.setActivityStartTime(rs.getTime("ActivityStartTime"));
				seminar.setActivityEndTime(rs.getTime("ActivityEndTime"));
				seminar.setAdminID(rs.getInt("AdminID"));
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return seminar;
	}
	
	

	public static List<Seminar> getAllSeminar(){
		List<Seminar> seminars = new ArrayList<Seminar>();
	
		try {
			
			con = ConnectionManager.getConnection();
			
		
			String sql = "SELECT * FROM seminar JOIN activity using(ActivityID)";
			stmt = con.createStatement();
			
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Seminar seminar = new Seminar();
				
				seminar.setActivityID(rs.getString("ActivityID"));
				seminar.setActivityTitle(rs.getString("ActivityTitle"));
				seminar.setInstructorName(rs.getString("InstructorName"));;
				seminar.setSeminarFee(rs.getDouble("SeminarFee"));
				seminar.setSeminarLocation(rs.getString("SeminarLocation"));
				seminar.setActivityDate(rs.getDate("ActivityDate"));
				seminar.setActivityType(rs.getString("ActivityType"));
				seminar.setActivityStartTime(rs.getTime("ActivityStartTime"));
				seminar.setActivityEndTime(rs.getTime("ActivityEndTime"));
				seminar.setAdminID(rs.getInt("AdminID"));
				
				
				seminars.add(seminar);
			}
			
			
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return seminars;
	}
	
	
	public void updateSeminar(Seminar bean) {
		
		ActivityID= bean.getActivityID();
		SeminarLocation=bean.getSeminarLocation();
		SeminarFee=bean.getSeminarFee();
		InstructorName=bean.getInstructorName();
		
		
		try {
	
			con = ConnectionManager.getConnection();
			
			
			String sql = "UPDATE seminar s inner join activity a on s.ActivityID=a.ActivityID set s.SeminarLocation=?,s.SeminarFee=?,s.InstructorName=? where s.ActivityID=?";
			super.updateActivity(bean);
			ps = con.prepareStatement(sql);		
			ps.setString(1,SeminarLocation);
			ps.setDouble(2,SeminarFee);
			ps.setString(3,InstructorName);
			ps.setString(4,ActivityID);

			
		
			ps.executeUpdate();
			
		
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public void deleteSeminar(String ActivityID) {
		super.deleteActivity(ActivityID);
		try {
			
			con = ConnectionManager.getConnection();
			
			
			String sql = "DELETE FROM seminar JOIN activity WHERE ActivityID=?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, ActivityID);
			
			
			ps.executeUpdate();
			
		
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
