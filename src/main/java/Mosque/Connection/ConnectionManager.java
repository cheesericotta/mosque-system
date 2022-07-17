package Mosque.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	//static Connection con;
	//private static final String DRIVER = "org.postgresql.Driver";
	//private static final  String jdbcURL ="jdbc:postgresql://ec2-3-211-221-185.compute-1.amazonaws.com:5432/dd283fabsjbk3c";
    //private static final  String username="roudqjprncsaet";
    //private static final  String password="f77b9dae0ee6b371ee0855996a822412bd842ed5fa9e492df8795c2c9632a1d6";
    
    static Connection con;
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "http://us-cdbr-east-06.cleardb.net/";
	private static final String DB_USER = "b6037f17a0d586";
	private static final String DB_PASSWORD = "4a65c704";
	
	public static Connection getConnection() {
		try {
			
			//1. load the driver
			 Class.forName(DB_DRIVER);
			
			try {
				//2. create connection
				//con = DriverManager.getConnection(jdbcURL,username,password);
				con = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
				System.out.println("Connected");
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
	

}
