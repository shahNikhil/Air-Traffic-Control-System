package com.DualCore.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DualCore.Boundary.AuthImpl;
import com.DualCore.Entity.Admin;
import com.DualCore.Entity.LoginToken;

/**
 * Servlet for implementing the Aircraft with the help of Entity Classes and the DAO
 */
@WebServlet("/AdminService")
public class AdminService extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminService() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		PrintWriter pW = response.getWriter();
		
		//creating a user to check and login
		Admin userToCheck = new Admin(username, password);
		
		//getting the user login token
		LoginToken user = new LoginToken();
		
		//make a dao class and check password match using query  
		AuthImpl authDAO = new AuthImpl();
		
		user = authDAO.getAdmin(1);
		
		if(userToCheck.get_username().contentEquals(user.get_username())) {
			if(userToCheck.get_password().contentEquals(user.get_password())) {
				//redirecting the user to admin panel if the credentials are correct
				response.sendRedirect("adminPanel.jsp");
			}	
			else {
				//displaying the error when the password is wrong
				pW.println("Your password is wrong.");
			}
		}
		else {
			//displaying the error when the username is wrong
			pW.println("Your username is wrong.");
		}
		
		doGet(request, response);
	}

}