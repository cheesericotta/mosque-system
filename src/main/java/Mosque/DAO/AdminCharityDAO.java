package Mosque.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.Time;


import Mosque.Connection.ConnectionManager;
import Mosque.Model.*;

public class AdminCharityDAO extends AdminActivityDAO {
	
	static Connection con =null;
	static ResultSet rs =null;
	static PreparedStatement ps=null;
	static Statement stat=null;
	static private String ActivityID;
	static private String DonationType;
	
	
	
	
	public static void addCharity(Charity bean) {
		ActivityID=bean.getActivityID();
		DonationType=bean.getDonationType();
		Activity act =new Activity();
		act.setActivityTitle(bean.getActivityTitle());
		act.setActivityDate(bean.getActivityDate());
		act.setActivityEndTime(bean.getActivityEndTime());
		act.setActivityStartTime(bean.getActivityStartTime());
		act.setActivityID(bean.getActivityID());
		act.setActivityType(bean.getActivityType());
		act.setAdminID(bean.getAdminID());
		AdminActivityDAO.addActivity(act);
		
		try {
			con=ConnectionManager.getConnection();
		
			String sql="Insert into charity (ActivityID,DonationType) values (?,?)";
		
			ps=con.prepareStatement(sql);
			ps.setString(1, ActivityID);
			ps.setString(2, DonationType);
			
			ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static Charity getCharityByID(String ActivityID) {
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
				charity.getActivityID();
				charity.setDonationType(rs.getString("DonationType"));
				charity.setActivityDate(rs.getDate("ActivityDate"));
				charity.setActivityType(rs.getString("ActivityType"));
				charity.setActivityStartTime(rs.getTime("ActivityStartTime"));
				charity.setActivityEndTime(rs.getTime("ActivityEndTime"));
				charity.setAdminID(rs.getInt("AdminID"));
				
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return charity;
	}
	
	public static List<Charity> getAllCharity(){
		List<Charity> charities = new ArrayList<Charity>();
	
		try {
			
			con = ConnectionManager.getConnection();
			
			
			String sql = "SELECT * FROM charity JOIN activity using(ActivityID)";
			stat = con.createStatement();
			
			
			rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				Charity charity=new Charity();
				
				charity.setActivityID(rs.getString("ActivityID"));
				charity.setActivityTitle(rs.getString("ActivityTitle"));
				charity.setDonationType(rs.getString("DonationType"));
				charity.setActivityDate(rs.getDate("ActivityDate"));
				charity.setActivityType(rs.getString("ActivityType"));
				charity.setActivityStartTime(rs.getTime("ActivityStartTime"));
				charity.setActivityEndTime(rs.getTime("ActivityEndTime"));
				charity.setAdminID(rs.getInt("AdminID"));
				
				
				charities.add(charity);
			}
			
			
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return charities;
	}
public void updateCharity(Charity bean) {
		

		DonationType= bean.getDonationType();
		ActivityID= bean.getActivityID();
				
		
		
		try {
			
			con = ConnectionManager.getConnection();
			
			
			String sql = "UPDATE charity c inner join activity a on c.ActivityID=a.ActivityID set c.DonationType=? where c.ActivityID=?";
			super.updateActivity(bean);
			ps = con.prepareStatement(sql);
			ps.setString(1,DonationType);
			ps.setString(2,ActivityID);
			
			
			ps.executeUpdate();
			
			
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

public void deleteCharity(String ActivityID) {
	super.deleteActivity(ActivityID);
	try {
		
		con = ConnectionManager.getConnection();
		
		
		String sql = "DELETE FROM charity JOIN activity WHERE ActivityID=?";
		
		ps = con.prepareStatement(sql);
		ps.setString(1, ActivityID);
		
	
		ps.executeUpdate();
		
		
		con.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}

}
