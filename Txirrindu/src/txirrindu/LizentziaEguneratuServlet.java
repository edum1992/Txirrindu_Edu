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

/**
 * Servlet implementation class LizentziaEguneratuServlet
 */
@WebServlet("/LizentziaEguneratuServlet")
public class LizentziaEguneratuServlet extends HttpServlet {
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
		
		String lizentzia = request.getParameter("lizentzia");
		
		mySQLdb.updateLizentzia(email, lizentzia);
		response.sendRedirect("/Txirrindu/jsp/nagusia.jsp");
	}

}
