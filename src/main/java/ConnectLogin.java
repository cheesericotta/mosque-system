

import java.io.IOException
;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConnectLogin
 */
@WebServlet("/ConnectLogin")
public class ConnectLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 PrintWriter out = response.getWriter();
		
		doGet(request, response);
		String name=request.getParameter("username");
		String pass=request.getParameter("pass");
		
		String jdbcURL ="jdbc:postgresql:// ec2-3-211-221-185.compute-1.amazonaws.com:5432/ dd283fabsjbk3c";
	    String username="roudqjprncsaet";
	    String password="f77b9dae0ee6b371ee0855996a822412bd842ed5fa9e492df8795c2c9632a1d6";
	    
	    try {
	    	 Class.forName("org.postgresql.Driver");
	    	 Connection connection=DriverManager.getConnection(jdbcURL,username,password);
	    	 System.out.print("connected");
	    	 
	            // String sql="(Select id,username,password from student where name='"+name+"' and '"+pass+"')";
	             PreparedStatement pst = connection
	            	     .prepareStatement("Select username,userpassword from users where username=? and userpassword=?");
	            	   pst.setString(1, name);
	            	   pst.setString(2, pass);
	            	   ResultSet rs = pst.executeQuery();
	            	   if (rs.next()) {
	            	 	   out.print("You are successfully loggedin...");
	            		   response.sendRedirect("../Admin/Home/index.html");
	            	   }else {
	            		    out.println("Username or Password incorrect");
	            		    response.sendRedirect("Sign In/index.html");
	            		   
	            	   }
	 	    

	            // Statement stat=connection.createStatement();
	            // int row=stat.executeUpdate(sql);
	 	       /*  connection.close();
	 	     if (row>0) {
	 	    	 
	 	    	 response.sendRedirect("Admin/Home/index.html");
	 	    	 
	 	     }*/
	 	     
	 	     }
	    catch(Exception e){
	    	e.printStackTrace();
	    	System.out.print("not connected");
	    	}
	    
	    
	    
		
	}

}
