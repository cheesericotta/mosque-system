package Mosque.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.Date;

import Mosque.Connection.ConnectionManager;
import Mosque.Model.Activity;


public class ActivityDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;

	
	protected String ActivityID;
	private String ActivityTitle;
	private Date ActivityDate;
	private String ActivityType;
	private Time ActivityStartTime;
	private Time ActivityEndTime;
	private int AdminID;

	
	
	public void addActivity(Activity bean) {
		
	
		ActivityID= bean.getActivityID();
		ActivityTitle= bean.getActivityTitle();
		ActivityDate= bean.getActivityDate();
		ActivityType= bean.getActivityType();
		ActivityStartTime= bean.getActivityStartTime();
		ActivityEndTime= bean.getActivityEndTime();
		AdminID= bean.getAdminID();
		
		try {
			
			con = ConnectionManager.getConnection();
			
		
			String sql = "INSERT INTO activity (ActivityID,ActivityTitle,ActivityDate,ActivityType,ActivityStartTime,ActivityEndTime,AdminID)VALUES(?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, ActivityID);
			ps.setString(2, ActivityTitle);
			ps.setDate(3, (java.sql.Date) ActivityDate);
			ps.setString(4, ActivityType);
			ps.setTime(5, ActivityStartTime);
			ps.setTime(6, ActivityEndTime);
			ps.setInt(7, AdminID);
		
			ps.executeUpdate();
			
			
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

	public static Activity getActivity(String ActivityID) {
		Activity activity = new Activity();
		
		try {
			
			con = ConnectionManager.getConnection();
			
			
			String sql = "SELECT * FROM activity WHERE ActivityID=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ActivityID);
			
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				activity.setActivityID(rs.getString("ActivityID"));
				activity.setActivityTitle(rs.getString("ActivityTitle"));
				activity.setActivityDate(rs.getDate("ActivityDate"));
				activity.setActivityType(rs.getString("ActivityType"));
				activity.setActivityStartTime(rs.getTime("ActivityStartTime"));
				activity.setActivityEndTime(rs.getTime("ActivityEndTime"));
				activity.setAdminID(rs.getInt("AdminID"));
				
				
			
			
			
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return activity;
	}
	
	
	
	public void updateActivity(Activity bean) {
		
		ActivityID= bean.getActivityID();
		ActivityTitle= bean.getActivityTitle();
		ActivityDate= bean.getActivityDate();
		ActivityType= bean.getActivityType();
		ActivityStartTime= bean.getActivityStartTime();
		ActivityEndTime= bean.getActivityEndTime();
		AdminID= bean.getAdminID();
		
		
		try {
			
			con = ConnectionManager.getConnection();
			
		
			String sql = "UPDATE complaint SET ActivityID=?, ActivityTitle=?,ActivityDate=?,ActivityType=?,ActivityStartTime,ActivityEndTime=?,AdminID=?, WHERE ActivityID=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ActivityID);
			ps.setString(2, ActivityTitle);
			ps.setDate(3, (java.sql.Date) ActivityDate);
			ps.setString(4, ActivityType);
			ps.setTime(5, ActivityStartTime);
			ps.setTime(6, ActivityEndTime);
			ps.setInt(7, AdminID);
			ps.setString(8, ActivityID);
			//4. execute query
			ps.executeUpdate();
			
		
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public void deleteActivity(String activityID) {
		
		try {
			
			con = ConnectionManager.getConnection();
			
			
			String sql = "DELETE FROM activity WHERE ActivityID=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ActivityID);
			
			
			ps.executeUpdate();
			
		
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
