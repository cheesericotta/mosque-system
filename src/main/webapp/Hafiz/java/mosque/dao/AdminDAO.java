package mosque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import mosque.connection.ConnectionManager;
import mosque.model.Admin;

public class AdminDAO {
	static Connection con = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	
	static int adminID;
	static String adminName, adminEmail, adminPhoneNo, password;
	
	public static Admin login(Admin bean) {
		
		adminEmail = bean.getAdminEmail();
		password = bean.getPassword();
		
		String query = "select * from admin where AdminEmail='" + adminEmail + "'AND Password='" + password + "'";
		
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
				
				int id = rs.getInt("AdminID");
				String email = rs.getString("AdminEmail");
				bean.setAdminID(id);
				bean.setAdminEmail(email);

				bean.setValid(true);
				System.out.println("valid");
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
	
	public static Admin getAdminByEmail(String email) {
		Admin admin = new Admin();
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			//3. create statement  
			ps=con.prepareStatement("select * from admin where AdminEmail=?");
			ps.setString(1, email);
			//4. execute query
			rs = ps.executeQuery();

			if (rs.next()) {	            
				admin.setAdminID(rs.getInt("AdminID"));
				admin.setAdminEmail(rs.getString("AdminEmail"));				
				admin.setPassword(rs.getString("Password"));
			}
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}
		
		return admin;
	}
}
