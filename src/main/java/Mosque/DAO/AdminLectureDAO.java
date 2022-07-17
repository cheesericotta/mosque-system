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
import Mosque.Model.Lecture;




public class AdminLectureDAO extends AdminActivityDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	private static String ActivityID;
	private static String UstazName;
	private static String LectureSlot;
	

	
	
	public static void addLecture(Lecture bean) {
		
	
		
        UstazName=bean.getUstazName();
		LectureSlot= bean.getLectureSlot();
		ActivityID= bean.getActivityID();
		Activity act =new Activity();
		act.setActivityTitle(bean.getActivityTitle());
		act.setActivityDate(bean.getActivityDate());
		System.out.println(bean.getActivityDate());
		act.setActivityEndTime(bean.getActivityEndTime());
		act.setActivityStartTime(bean.getActivityStartTime());;
		act.setActivityID(bean.getActivityID());
		act.setActivityType(bean.getActivityType());
		act.setAdminID(bean.getAdminID());		
		
		try {
			
			con = ConnectionManager.getConnection();
			
			
			String sql = "INSERT INTO lecture (ActivityID,UstazName,LectureSlot)VALUES(?,?,?)";
			AdminActivityDAO.addActivity(act);
			ps = con.prepareStatement(sql);
			ps.setString(1, ActivityID);
			ps.setString(2, UstazName);
			ps.setString(3, LectureSlot );
			
			
			
			ps.executeUpdate();
			
		
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

	public static Lecture getLectureByID(String ActivityID) {
		
		Lecture lecture = new Lecture();
		
		try {
			con = ConnectionManager.getConnection();
			String sql = "SELECT * FROM lecture JOIN activity USING(ActivityID) WHERE ActivityID=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ActivityID);

			rs = ps.executeQuery();
			if(rs.next()) {
				lecture.setActivityID(rs.getString("ActivityID"));
				lecture.setActivityTitle(rs.getString("ActivityTitle"));
				System.out.println(rs.getString("ActivityTitle"));
				lecture.setUstazName(rs.getString("UstazName"));
				lecture.setLectureSlot(rs.getString("LectureSlot"));
				lecture.setActivityDate(rs.getDate("ActivityDate"));
				lecture.setActivityType(rs.getString("ActivityType"));
				lecture.setActivityStartTime(rs.getTime("ActivityStartTime"));
				lecture.setActivityEndTime(rs.getTime("ActivityEndTime"));
				lecture.setAdminID(rs.getInt("AdminID"));
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return lecture;
	}
	
	
	public static List<Lecture> getAllLecture(){
		List<Lecture> lectures = new ArrayList<Lecture>();
	
		try {
			
			con = ConnectionManager.getConnection();
		
			String sql = "SELECT * FROM lecture JOIN activity using(ActivityID)";
			stmt = con.createStatement();
			
		
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Lecture lecture = new Lecture();
				
				lecture.setActivityID(rs.getString("ActivityID"));
				lecture.setActivityTitle(rs.getString("ActivityTitle"));
				lecture.setUstazName(rs.getString("UstazName"));
				lecture.setLectureSlot(rs.getString("LectureSlot"));
				lecture.setActivityDate(rs.getDate("ActivityDate"));
				lecture.setActivityType(rs.getString("ActivityType"));
				lecture.setActivityStartTime(rs.getTime("ActivityStartTime"));
				lecture.setActivityEndTime(rs.getTime("ActivityEndTime"));
				lecture.setAdminID(rs.getInt("AdminID"));
				
				
				lectures.add(lecture);
			}
			
			
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return lectures;
	}
	
	
	public void updateLecture(Lecture bean) {
	

        UstazName= bean.getUstazName();
		LectureSlot= bean.getLectureSlot();
		ActivityID= bean.getActivityID();
		
	try {
			
			con = ConnectionManager.getConnection();
			
			
			String sql = "UPDATE lecture l inner join activity a on l.ActivityID=a.ActivityID set l.UstazName=?,l.LectureSlot=? where l.ActivityID=?";
			super.updateActivity(bean);	
			ps = con.prepareStatement(sql);
			ps.setString(1,UstazName);
			ps.setString(2,LectureSlot);
			ps.setString(3,ActivityID);
			
			
			ps.executeUpdate();
			
		
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public void deleteLecture(String ActivityID) {
		super.deleteActivity(ActivityID);
		try {
			
			con = ConnectionManager.getConnection();
			
			
			String sql = "DELETE FROM lecture join activity WHERE  ActivityID=?";
			
			
			ps = con.prepareStatement(sql);
			ps.setString(1, ActivityID);
			
		
			ps.executeUpdate();
			
		
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
