package Mosque.DAO;


import java.sql.*;
import java.util.*;
import Mosque.Connection.ConnectionManager;
import Mosque.Model.User;



public class UserDAO {
	

		static Connection con = null;
		static ResultSet rs = null; 
		static PreparedStatement ps=null;
		static Statement stmt=null;
		
	    static String Username,UserEmail, UserPassword, UserAddress,UserPhoneNo;
	    static int UserID;

		
	    public static User login(User bean) {
			
			UserEmail = bean.getUserEmail();
			UserPassword = bean.getUserPassword();
			
			String query = "select * from user where UserEmail='" + UserEmail + "'AND UserPassword='" + UserPassword + "'";

			try {
				
				con = ConnectionManager.getConnection();
				
				stmt = con.createStatement();
			 
				rs = stmt.executeQuery(query);
				boolean more = rs.next();

		
				if (more) {
					int id = rs.getInt("UserID");
					String email = rs.getString("UserEmail");
					bean.setUserID(id);
					bean.setUserEmail(email);

					bean.setValid(true);
				}
				
				else if (!more) {
					bean.setValid(false);
				}

			
				con.close();
			}catch(Exception e) {
				e.printStackTrace();		
			}

			return bean;
		}
	    
	    public static User getUserByEmail(String email) {
			User user = new User();
			
			try {
				
				con = ConnectionManager.getConnection();
			
			
				ps=con.prepareStatement("select * from user where UserEmail=?");
				ps.setString(1, email);
			
				rs = ps.executeQuery();
			

				if (rs.next()) {
					System.out.println(email+ "3");
					user.setUserID(rs.getInt("UserID"));
					user.setUsername(rs.getString("Username"));
					user.setUserEmail(rs.getString("UserEmail"));				
					user.setUserPassword(rs.getString("UserPassword"));
					user.setUserPhoneNo(rs.getString("UserPhoneNo"));
					user.setUserAddress(rs.getString("UserAddress"));
				}
				
				con.close();
			}catch(Exception e) {
				e.printStackTrace();		
			}
			
			return user;
		}
	    public void addUser(User bean) {
			Username = bean.getUsername();
			UserPassword = bean.getUserPassword();
			UserEmail = bean.getUserEmail();
			UserAddress = bean.getUserAddress();
			UserPhoneNo = bean.getUserPhoneNo();
			
			try {
				 
				con = ConnectionManager.getConnection();
			
				ps=con.prepareStatement("insert into user(Username, UserPassword, UserEmail, UserAddress, UserPhoneNo)values(?,?,?,?,?)");
				ps.setString(1,Username);
				ps.setString(2,UserPassword);
				ps.setString(3,UserEmail);
				ps.setString(4,UserAddress);
				ps.setString(5,UserPhoneNo);
			
				ps.executeUpdate();			
				
			
				con.close();
			}catch(Exception e) {
				e.printStackTrace();		
			}
		}
	

		
		public static User getUser(int UserID)  {   
			User user = new User();
			
			try {
				
				con = ConnectionManager.getConnection();
				
			
				String sql = "SELECT * FROM user WHERE UserID=?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, UserID);
				
				
				
				rs = ps.executeQuery();
				
				if(rs.next()) {
					user.setUserID(rs.getInt("UserID"));
					user.setUsername(rs.getString("Username"));
					user.setUserPassword(rs.getString("UserPassword"));
					user.setUserEmail(rs.getString("UserEmail"));
					user.setUserPhoneNo(rs.getString("UserPhoneNo"));
					user.setUserAddress(rs.getString("UserAddress"));
					
			
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return user;
		}
	
		public static List<User> getAllUser(){
			List<User> users = new ArrayList<User>();
			
			try {
				
				con = ConnectionManager.getConnection();
				
			
				String sql = "SELECT * FROM user";
				stmt = con.createStatement();
				
			
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					User user = new User();
					
					user.setUserID(rs.getInt("UserID"));
					user.setUsername(rs.getString("Username"));
					user.setUserPassword(rs.getString("UserPassword"));
					user.setUserEmail(rs.getString("UserEmail"));
					user.setUserPhoneNo(rs.getString("UserPhoneNo"));
					user.setUserAddress(rs.getString("UserAddress"));
					
				
					
					users.add(user);
				}
				
				
				con.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return users;
		}
		

	
		public void updateUser(User bean) {
			//get product
			UserID = bean.getUserID();
			Username = bean.getUsername();
			UserPassword = bean.getUserPassword();
			UserEmail = bean.getUserEmail();
			UserAddress = bean.getUserAddress();
			UserPhoneNo = bean.getUserPhoneNo();
			
			
			try {
				
				con = ConnectionManager.getConnection();
				
				
				String sql = "UPDATE user SET  Username=?, UserPassword=?, UserEmail=?, UserAddress=?, UserPhoneNo=? WHERE UserID=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, Username);
				ps.setString(2, UserPassword);
				ps.setString(3, UserEmail);
				ps.setString(4, UserAddress);
				ps.setString(5,UserPhoneNo);
				ps.setInt(6, UserID);
			
				
				ps.executeUpdate();
				
			
				con.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public void deleteUser(int id) {
			try {
				
				con = ConnectionManager.getConnection();
			 
				ps=con.prepareStatement("delete from user where UserID=?");
				ps.setInt(1, id);
				
				ps.executeUpdate();

				
				con.close();
			}catch(Exception e) {
				e.printStackTrace();		
			}
		}	
		public void registerActivity(int userID, String activityID) {
			
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
	}




