package mosque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mosque.connection.ConnectionManager;
import mosque.model.Registration;

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
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			//3. create statement  
			ps=con.prepareStatement("insert into registration(UserID, ActivityID, RegistrationDate, RegistrationTime)values(?,?,?,?)");
			ps.setInt(1,userID);
			ps.setString(2,activityID);
			ps.setDate(3,reportDate);
			ps.setTime(4,time);
			//4. execute query
			ps.executeUpdate();			
			
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}
	}
	
	public static List<Registration> getRegisteredActivity(int userID){
		List<Registration> registrations = new ArrayList<Registration>();
		
		try { 
			//call getConnection() method
			con = ConnectionManager.getConnection();
			//3. create statement
			ps=con.prepareStatement("select * from registation where userID=? order by activityID");
			ps.setInt(1, userID);
			//4. execute query
			rs = ps.executeQuery();
			while (rs.next()) {
				Registration registration = new Registration();
				registration.setUserID(rs.getInt("UserID"));
				registration.setActivityID(rs.getString("ActivityID"));
				registration.setRegistrationDate(rs.getDate("RegistrationDate"));
				registration.setRegistrationTime(rs.getTime("RegistrationTime"));
				
				registrations.add(registration);
			}
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return registrations;
	}
}
