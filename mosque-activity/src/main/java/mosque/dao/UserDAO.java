package mosque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import mosque.model.User;
import mosque.connection.ConnectionManager;

public class UserDAO {
	static Connection con = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	
	static int userID;
	static String userName, userEmail, userPhoneNo, userAddress, password;
	
	public static User login(User bean) {
		
		userEmail = bean.getUserEmail();
		password = bean.getPassword();
		
		String query = "select * from user where UserEmail='" + userEmail + "'AND UserPassword='" + password + "'";

		try {
			//call getConnection() method //3. create statement  //4. execute query
			con = ConnectionManager.getConnection();
			//3. create statement
			stmt = con.createStatement();
		    //4. execute query
			rs = stmt.executeQuery(query);
			boolean more = rs.next();

			// if user exists set the isValid variable to true
			if (more) {
				int id = rs.getInt("UserID");
				String email = rs.getString("UserEmail");
				bean.setUserID(id);
				bean.setUserEmail(email);

				bean.setValid(true);
			}
			// if user does not exist set the isValid variable to false
			else if (!more) {
				bean.setValid(false);
			}

			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}

		return bean;
	}
	
	public static User getUserByEmail(String email) {
		User user = new User();
		
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			//3. create statement  
			ps=con.prepareStatement("select * from user where UserEmail=?");
			ps.setString(1, email);
			//4. execute query
			rs = ps.executeQuery();

			if (rs.next()) {	            
				user.setUserID(rs.getInt("UserID"));
				user.setUserEmail(rs.getString("UserEmail"));				
				user.setPassword(rs.getString("UserPassword"));
			}
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}
		
		return user;
	}
	
	public void add(User bean) {
		userName = bean.getUserName();
		password = bean.getPassword();
		userEmail = bean.getUserEmail();
		userAddress = bean.getUserAddress();
		userPhoneNo = bean.getUserPhoneNo();
		
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			//3. create statement  
			ps=con.prepareStatement("insert into user(Username, UserPassword, UserEmail, UserAddress, UserPhoneNo)values(?,?,?,?,?)");
			ps.setString(1,userName);
			ps.setString(2,password);
			ps.setString(3,userEmail);
			ps.setString(4,userAddress);
			ps.setString(5,userPhoneNo);
			//4. execute query
			ps.executeUpdate();			
			
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}
	}
	
}
