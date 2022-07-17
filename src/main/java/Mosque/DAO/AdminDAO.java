package Mosque.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Mosque.Connection.ConnectionManager;
import Mosque.Model.Admin;


public class AdminDAO {
	static Connection con = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	
	static int AdminID;
	static String AdminName, AdminEmail, AdminPhoneNum, AdminPassword;
	
	public static Admin login(Admin bean) {
		
		AdminEmail = bean.getAdminEmail();
		AdminPassword = bean.getAdminPassword();
		
		String query = "select * from admin where AdminEmail='" + AdminEmail + "'AND AdminPassword='" + AdminPassword + "'";
		
		try {
			
			con = ConnectionManager.getConnection();
			
			stmt = con.createStatement();
		   
			rs = stmt.executeQuery(query);
			boolean more = rs.next();

			
			if (more) {
				
				int id = rs.getInt("AdminID");
				String email = rs.getString("AdminEmail");
				bean.setAdminID(id);
				bean.setAdminEmail(email);

				bean.setValid(true);
				System.out.println("valid");
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
	
	public static Admin getAdminByEmail(String email) {
		Admin admin = new Admin();
		try {
			
			con = ConnectionManager.getConnection();
		
			ps=con.prepareStatement("select * from admin where AdminEmail=?");
			ps.setString(1, email);
			
			rs = ps.executeQuery();

			if (rs.next()) {	            
				admin.setAdminID(rs.getInt("AdminID"));
				admin.setAdminName(rs.getString("AdminName"));
				admin.setAdminEmail(rs.getString("AdminEmail"));				
				admin.setAdminPassword(rs.getString("AdminPassword"));
				admin.setAdminPhoneNum(rs.getString("AdminPhoneNum"));
			}
			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}
		
		return admin;
	}


//get user by id
public static Admin getAdmin(int AdminID)  {   
	Admin admin = new Admin();
	
	try {
		
		con = ConnectionManager.getConnection();
		
	
		String sql = "SELECT * FROM admin WHERE AdminID=?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, AdminID);
		
		
		
		rs = ps.executeQuery();
		
		if(rs.next()) {
			admin.setAdminID(rs.getInt("AdminID"));
			admin.setAdminName(rs.getString("AdminName"));
			admin.setAdminPassword(rs.getString("AdminPassword"));
			admin.setAdminPhoneNum(rs.getString("AdminPhoneNum"));
			admin.setAdminEmail(rs.getString("AdminEmail"));
		
			
		
	}
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	return admin;
}

public static List<Admin> getAllAdmin(){
	List<Admin> admins = new ArrayList<Admin>();
	
	try {
		
		con = ConnectionManager.getConnection();
		
	
		String sql = "SELECT * FROM admin";
		stmt = con.createStatement();
		
	
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			Admin admin = new Admin();
			
			admin.setAdminID(rs.getInt("AdminID"));
			admin.setAdminName(rs.getString("AdminName"));
			admin.setAdminPassword(rs.getString("AdminPassword"));
			admin.setAdminPhoneNum(rs.getString("AdminPhoneNum"));
			admin.setAdminEmail(rs.getString("AdminEmail"));
		
			
			admins.add(admin);
		}
		
		
		con.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	return admins;
}



public void updateAdmin(Admin bean) {
	//get product
	AdminID = bean.getAdminID();
	AdminName = bean.getAdminName();
	AdminPassword = bean.getAdminPassword();
	AdminEmail = bean.getAdminEmail();
	AdminPhoneNum = bean.getAdminPhoneNum();
	
	
	try {
	
		con = ConnectionManager.getConnection();
		
	
		String sql = "UPDATE admin SET AdminName=?, AdminPassword=?, AdminEmail=?, AdminPhoneNum=? WHERE AdminID=?";
		ps = con.prepareStatement(sql);
		ps.setString(1, AdminName);
		ps.setString(2, AdminPassword);
		ps.setString(3, AdminEmail);
		ps.setString(4, AdminPhoneNum);
		ps.setInt(5, AdminID);
	
	
		ps.executeUpdate();
		
	
		con.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}

public void deleteAdmin(String email) {
	try {
	
		con = ConnectionManager.getConnection();
		
		ps=con.prepareStatement("delete from admin where AdminEmail=?");
		ps.setString(1, email);
		
		ps.executeUpdate();

		
		con.close();
	}catch(Exception e) {
		e.printStackTrace();		
	}
}
}
