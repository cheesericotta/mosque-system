package Mosque.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Mosque.Connection.ConnectionManager;
import Mosque.Model.Registration;
import Mosque.Model.Report;
import Mosque.Model.User;

public class RegistrationDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	
	static int userID;
	static String activityID;
	static java.sql.Date registrationDate;
	static java.sql.Time registrationTime;
	
	public static void registerActivity(int userID, String activityID) {
		
		java.sql.Date reportDate = java.sql.Date.valueOf(java.time.LocalDate.now());
		java.sql.Time time = java.sql.Time.valueOf(java.time.LocalTime.now());
		
		try {
			
			con = ConnectionManager.getConnection();
		  
			ps=con.prepareStatement("insert into registration(UserID, ActivityID, RegistrationDate, RegistrationTime)values(?,?,?,?)");
			ps.setInt(1,userID);
			ps.setString(2,activityID);
			ps.setDate(3,reportDate);
			ps.setTime(4,time);
		
			ps.executeUpdate();			
			
			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}
	}
	
	public static List<Registration> getRegisteredActivity(int userID){
		List<Registration> registrations = new ArrayList<Registration>();
		
		try { 
			
			con = ConnectionManager.getConnection();
		
			ps=con.prepareStatement("select * from registration  where UserID=? order by ActivityID");
			ps.setInt(1, userID);
		
			rs = ps.executeQuery();
			while (rs.next()) {
				Registration registration = new Registration();
				registration.setUserID(rs.getInt("UserID"));
				registration.setActivityID(rs.getString("ActivityID"));
				registration.setRegistrationDate(rs.getDate("RegistrationDate"));
				registration.setRegistrationTime(rs.getTime("RegistrationTime"));
				
				registrations.add(registration);
			}
		
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return registrations;
	}
	
	
	public static Registration getRegistration(int UserID) {
		Registration registration = new Registration();
		
		try {
			
			con = ConnectionManager.getConnection();
			
	
			String sql = "SELECT * FROM registration WHERE UserID=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, UserID);
			
		
			rs = ps.executeQuery();
			
			if(rs.next()) {
				registration.setUserID(rs.getInt("UserID"));
				registration.setActivityID(rs.getString("ActivityID"));
				registration.setRegistrationDate(rs.getDate("RegistrationDate"));
				registration.setRegistrationTime(rs.getTime("RegistrationTime"));
				
				
				
				
			
			
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return registration;
	}
	public static List<Report> getReportByMonth(String month){
		List<Report> reports = new ArrayList<Report>();
		String sql = "SELECT ActivityID,ActivityTitle,COUNT(ActivityID),ActivityDate from registration JOIN activity USING(ActivityID) WHERE RegistrationDate like'"+month+"%' GROUP BY ActivityID  "; 
		try { 
			
			con = ConnectionManager.getConnection();
		
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println(month);
			while (rs.next()) {
				Report report = new Report();
				
				report.setCount(rs.getInt("Count(ActivityID)"));
				report.setActivityID(rs.getString("ActivityID"));
				report.setActivityTitle(rs.getString("ActivityTitle"));
				report.setActivityDate(rs.getDate("ActivityDate"));
			
				
				reports.add(report);
			}
		
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return reports;
	}
	public static List<Report> getReport(){
		List<Report> reports = new ArrayList<Report>();
		
		try {
			
			con = ConnectionManager.getConnection();
			
		
			String sql = "SELECT ActivityID,ActivityTitle,COUNT(ActivityID),ActivityDate from registration JOIN activity USING(ActivityID) GROUP BY ActivityID";
			stmt = con.createStatement();
			
		
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				Report report = new Report();
				
				report.setCount(rs.getInt("Count(ActivityID)"));
				report.setActivityID(rs.getString("ActivityID"));
				report.setActivityTitle(rs.getString("ActivityTitle"));
				report.setActivityDate(rs.getDate("ActivityDate"));
				
			
				
				reports.add(report);
			}
			
			
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return reports;
	}
	
	public void deleteRegistration(String ActivityID) {
		try {
		
			con = ConnectionManager.getConnection();
			 
			ps=con.prepareStatement("delete from registration where ActivityID=?");
			ps.setString(1, ActivityID);
		
			ps.executeUpdate();

		
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}
	}	
}
