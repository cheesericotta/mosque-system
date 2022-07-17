package Mosque.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import Mosque.Connection.ConnectionManager;
import Mosque.Model.Charity;

public class CharityDAO extends ActivityDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	
	String ActivityID;
	String DonationType;
	
public void addCharity(Charity bean) {
		
	
		
        ActivityID= bean.getActivityID();
		DonationType= bean.getDonationType();
				
		super.addActivity(bean);
		try {
			
			con = ConnectionManager.getConnection();
			
		
			String sql = "INSERT INTO charity (ActivityID,DonationType)VALUES(?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, ActivityID);
			ps.setString(2, DonationType);
			
			
			
			
			ps.executeUpdate();
			
			
		
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

	public static Charity getCharity(String ActivityID) {
		Charity charity = new Charity();
		
		try {
			
			con = ConnectionManager.getConnection();
			
			
			String sql = "SELECT * FROM charity JOIN activity USING(ActivityID) WHERE ActivityID=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ActivityID);
			
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				charity.setActivityID(rs.getString("ActivityID"));
				charity.setActivityTitle(rs.getString("ActivityTitle"));
				charity.setActivityDate(rs.getDate("ActivityDate"));
				charity.setActivityType(rs.getString("ActivityType"));
				charity.setActivityStartTime(rs.getTime("ActivityStartTime"));
				charity.setActivityEndTime(rs.getTime("ActivityEndTime"));
				charity.setDonationType(rs.getString("DonationType"));
				charity.setAdminID(rs.getInt("AdminID"));
				
					
			
			
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return charity;
	}
	
	
	public static List<Charity> getAllCharity(){
		List<Charity> charitys = new ArrayList<Charity>();
	
		try {
			
			con = ConnectionManager.getConnection();
			
			
			String sql = "SELECT * FROM charity JOIN activity using(ActivityID)";
			stmt = con.createStatement();
			
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Charity charity = new Charity();
				
				charity.setActivityID(rs.getString("ActivityID"));
				charity.setActivityTitle(rs.getString("ActivityTitle"));
				charity.setActivityDate(rs.getDate("ActivityDate"));
				charity.setActivityType(rs.getString("ActivityType"));
				charity.setActivityStartTime(rs.getTime("ActivityStartTime"));
				charity.setActivityEndTime(rs.getTime("ActivityEndTime"));
				charity.setDonationType(rs.getString("DonationType"));
				charity.setAdminID(rs.getInt("AdminID"));
				
				
				charitys.add(charity);
			}
			
			
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return charitys;
	}
	
	
	public void updateCharity(Charity bean) {
		

        
		ActivityID= bean.getActivityID();
		DonationType=bean.getDonationType();
				
		super.updateActivity(bean);
		try {
		
			con = ConnectionManager.getConnection();
			
			
			String sql = "UPDATE charity SET  ActivityID=?,DonationType=?, WHERE ActivityID=?";
			
			ps = con.prepareStatement(sql);
					
			ps.setString(1,ActivityID);
			ps.setString(2,DonationType);
			
		
			ps.executeUpdate();
			
		
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public void deleteCharity(int activityID) {
		
		super.deleteActivity(ActivityID);
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

