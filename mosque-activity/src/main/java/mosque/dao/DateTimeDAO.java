package mosque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;

import mosque.connection.ConnectionManager;
import mosque.model.DateTime;

import java.sql.Date;

public class DateTimeDAO {
	static Connection con = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	
	static Date date;
	static Time time;
	
	public static void addDateTime(DateTime bean) {
		date = bean.getDate();
		time = bean.getTime();
		
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			//3. create statement  
			ps=con.prepareStatement("insert into datetime(date, time)values(?,?)");
			ps.setDate(1,date);
			ps.setTime(2,time);
			ps.executeUpdate();			
			
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}
	}
}
