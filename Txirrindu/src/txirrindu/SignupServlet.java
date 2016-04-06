package txirrindu;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import helper.db.*;

public class SignupServlet extends HttpServlet{
	
	private MySQLdb mySQLdb;
	
	public void init(final ServletConfig config) {
		System.out.println("---> Entering init() SignupServlet");
		
		mySQLdb = new MySQLdb();
		
		System.out.println("---> Exiting init() SignupServlet");
	}

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	System.out.println("---> Entering doPost() SignupServlet");
    	
    	String email = request.getParameter("email");
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		String surname1 = request.getParameter("surname1");
		String surname2 = request.getParameter("surname2");
		String postalCode = request.getParameter("postalCode");
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		String phoneNumber = request.getParameter("phoneNumber");
		String license = request.getParameter("Lizentzia");
		System.out.println("     Extracting request parameters: " + email + " " + password + " " + username + " " + name + " " + surname1 + " " + surname2 + " " + postalCode + " " + country + " " + city + " " + license);
		
		mySQLdb.setUserInfo(email, password, username, name, surname1, surname2, postalCode, country, city, phoneNumber, license);
		System.out.println("     Updating users table in the database");
		
		System.out.println("     Redirecting the user to loginForm.html");
		//RequestDispatcher rd = request.getRequestDispatcher("/html/loginForm.html");
		//rd.forward(request, response);
		
		response.sendRedirect("/Txirrindu/html/loginForm.html");
		
        System.out.println("---> Exiting doPost() SignupServlet");
    }
}

