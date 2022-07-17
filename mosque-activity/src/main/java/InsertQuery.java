import java.sql.Connection;
import java.sql.Statement;

public class InsertQuery {
	static Connection con = null;
	static Statement stmt = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();
			
			//3. create statement
			stmt = con.createStatement();
			String sql = "INSERT INTO users(firstname,lastname,age,email,phonenumber)VALUES('Ahmad','Abu',21,'ahmad@gmail.com','0123456788')";
			
			//4. execute query
			stmt.executeUpdate(sql);
			
			//5.close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
