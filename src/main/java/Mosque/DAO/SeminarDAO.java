package Mosque.DAO;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;


import Mosque.Connection.ConnectionManager;
import Mosque.Model.Seminar;

public class SeminarDAO extends ActivityDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	
	String ActivityID;
	String SeminarLocation;
	Double SeminarFee;
	String InstructorName;
	
	public void addSeminar(Seminar bean) {
		
	    ActivityID= bean.getActivityID();
		SeminarLocation= bean.getSeminarLocation();
		SeminarFee= bean.getSeminarFee();
		InstructorName= bean.getInstructorName();		
		
		super.addActivity(bean);
		try {
			
			con = ConnectionManager.getConnection();
			
		
			String sql = "INSERT INTO seminar (ActivityID,SeminarLocation, SeminarFee, InstructorName)VALUES(?,?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, ActivityID);
			ps.setString(2, SeminarLocation);
			ps.setDouble(3, SeminarFee);
			ps.setString(4, InstructorName);
			
			
			
	
			ps.executeUpdate();
			
			
		
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Seminar getSeminar(String ActivityID) {
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
				seminar.setActivityDate(rs.getDate("ActivityDate"));
				seminar.setActivityType(rs.getString("ActivityType"));
				seminar.setActivityStartTime(rs.getTime("ActivityStartTime"));
				seminar.setActivityEndTime(rs.getTime("ActivityEndTime"));
				seminar.setSeminarLocation(rs.getString("SeminarLocation"));
				seminar.setSeminarFee(rs.getDouble("SeminarFee"));
				seminar.setInstructorName(rs.getString("InstructorName"));
			
			
		}
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
					seminar.setActivityDate(rs.getDate("ActivityDate"));
					seminar.setActivityType(rs.getString("ActivityType"));
					seminar.setActivityStartTime(rs.getTime("ActivityStartTime"));
					seminar.setActivityEndTime(rs.getTime("ActivityEndTime"));
					seminar.setAdminID(rs.getInt("AdminID"));
					seminar.setSeminarLocation(rs.getString("SeminarLocation"));
					seminar.setSeminarFee(rs.getDouble("SeminarFee"));
					seminar.setInstructorName(rs.getString("InstructorName"));

					
					
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
			
			super.updateActivity(bean);
			try {
				
				con = ConnectionManager.getConnection();
				
		
				String sql = "UPDATE seminar SET  ActivityID=?,SeminarLocation=?, SeminarFee=?, InstructorName=? WHERE ActivityID=?";
				
				ps = con.prepareStatement(sql);
						
				ps.setString(1,ActivityID);
				ps.setString(2,SeminarLocation);
				ps.setDouble(3,SeminarFee);
				ps.setString(4,InstructorName);

				
			
				ps.executeUpdate();
				
			
				con.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		public void deleteSeminar(int activityID) {
			super.deleteActivity(ActivityID);
			try {
				
				con = ConnectionManager.getConnection();
				
			
				String sql = "DELETE FROM seminar WHERE ActivityID=?";
				
				ps = con.prepareStatement(sql);
				ps.setString(1, ActivityID);
				
			
				ps.executeUpdate();
				
		
				con.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
}
