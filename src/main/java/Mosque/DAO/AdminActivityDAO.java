package Mosque.DAO;
import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Date;


import Mosque.Connection.ConnectionManager;
import Mosque.Model.Activity;


public class AdminActivityDAO {
	static Connection con =null;
	static ResultSet rs =null;
	static PreparedStatement ps=null;
	static Statement stat=null;
	
	protected static String ActivityID;
	private static  int AdminID;
	static String ActivityTitle;
	static Date ActivityDate;
	static Time ActivityStartTime;
	static Time ActivityEndTime;
	static String ActivityType;

	
	
	public static void addActivity(Activity bean) {
		
		ActivityID=bean.getActivityID();
		ActivityTitle=bean.getActivityTitle();
		ActivityDate=bean.getActivityDate();
		ActivityStartTime=bean.getActivityStartTime();
		ActivityEndTime=bean.getActivityEndTime();
		ActivityType=bean.getActivityType();
		AdminID=bean.getAdminID();
		
		try {
			
			con=ConnectionManager.getConnection();
			
		
			String sql="INSERT INTO activity(ActivityID,ActivityTitle,ActivityDate,ActivityType,ActivityStartTime,ActivityEndTime,AdminID)VALUES(?,?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, ActivityID);
			ps.setString(2, ActivityTitle);
			ps.setDate(3,  ActivityDate);
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
	
	public static Activity getActivityByID(String ActivityID) {
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
		
		ActivityID=bean.getActivityID();
		ActivityTitle=bean.getActivityTitle();
		AdminID=bean.getAdminID();
		ActivityDate=bean.getActivityDate();
		AdminID=bean.getAdminID();
		ActivityStartTime=bean.getActivityStartTime();
		ActivityEndTime=bean.getActivityEndTime();
		ActivityType=bean.getActivityType();
		try {
			
		
			
			con=ConnectionManager.getConnection();
			
			
			String sql="Update activity set AdminID=?,ActivityStartTime=?,ActivityEndTime=?,ActivityType=?,ActivityDate=?,ActivityTitle=? WHERE ActivityID=? ";
			ps=con.prepareStatement(sql);
			ps.setInt(1, AdminID);
			ps.setTime(2, ActivityStartTime);
			ps.setTime(3, ActivityEndTime);
			ps.setString(4, ActivityType);
			ps.setDate(5, ActivityDate);
			ps.setString(6, ActivityTitle);
			ps.setString(7, ActivityID);
			
			
			ps.executeUpdate();
			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteActivity(String ActivityID) {
		try {
			
			con=ConnectionManager.getConnection();
			
			
			String sql="DELETE FROM activity where ActivityID=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, ActivityID);
			
			
			ps.executeUpdate();
			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
