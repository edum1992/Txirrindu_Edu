package txirrindu;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helper.db.MySQLdb;

@WebServlet("/PerfilaEguneratuServlet")
public class PerfilaEguneratuServlet extends HttpServlet {

	private MySQLdb mySQLdb;
	
	public void init(final ServletConfig config) {
		System.out.println("---> Entering init() SignupServlet");
		
		mySQLdb = new MySQLdb();
		
		System.out.println("---> Exiting init() SignupServlet");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String email = mySQLdb.getEmail(username);
		
		//String email = request.getParameter("email");
		String username1 = request.getParameter("username");
		String name = request.getParameter("name");
		String surname1 = request.getParameter("surname1");
		String surname2 = request.getParameter("surname2");
		String postalCode = request.getParameter("postalCode");
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		String phoneNumber = request.getParameter("phoneNumber");
		
		mySQLdb.updatePerfil(email, username1, name, surname1, surname2, postalCode, country, city, phoneNumber);
		response.sendRedirect("/Txirrindu/html/nagusiaForm.html");
	}

}
