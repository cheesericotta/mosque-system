package Mosque.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mosque.DAO.AdminDAO;
import Mosque.Model.Admin;

/**
 * Servlet implementation class UpdateAdminController
 */
@WebServlet("/UpdateAdminController")
public class UpdateAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdminDAO dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdminController() {
        super();
        dao = new AdminDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int AdminID = Integer.parseInt(request.getParameter("AdminID"));
		request.setAttribute("admin", AdminDAO.getAdmin(AdminID));
		RequestDispatcher view = request.getRequestDispatcher("UpdateAdminProfile.jsp");
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin admin = new Admin();
		
		admin.setAdminID(Integer.parseInt(request.getParameter("AdminID")));
		admin.setAdminName(request.getParameter("AdminName"));
		admin.setAdminPassword(request.getParameter("AdminPassword"));
		admin.setAdminEmail(request.getParameter("AdminEmail"));
		admin.setAdminPhoneNum(request.getParameter("AdminPhoneNum"));
	
	
		
		dao.updateAdmin(admin);
		
		//forward quest
		int AdminID = Integer.parseInt(request.getParameter("AdminID"));
		request.setAttribute("admin", AdminDAO.getAdmin(AdminID));
		RequestDispatcher view = request.getRequestDispatcher("AdminProfile.jsp");
		view.forward(request, response);	}

}
