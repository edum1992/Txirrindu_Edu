package txirrindu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helper.db.MySQLdb;

/**
 * Servlet implementation class pasahitzaAldatuServlet
 */
@WebServlet("/pasahitzaAldatuServlet")
public class pasahitzaAldatuServlet extends HttpServlet {

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
		String pasahitza = mySQLdb.getPasahitza(username);
		
		String pasahitzZaharra = request.getParameter("password1");
		String pasahitzBerria = request.getParameter("password2");
		if (pasahitzZaharra.equals(pasahitza) && (!pasahitzBerria.equals(""))){
			mySQLdb.updatePassword(email, pasahitzZaharra, pasahitzBerria);
			response.sendRedirect("/Txirrindu/html/loginForm.html");
			session.invalidate();
		}
		else {
			System.out.println("     pasahitza txarto: redirecting the user to pasahitzaAldatuForm.html");
			boolean pasahitzaTxarto = true;
			request.setAttribute("pasahitza_txarto", pasahitzaTxarto);
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/pasahitzaTxarto.jsp");
			rd.forward(request, response);
		}
	}

}
