package txirrindu;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import com.itextpdf.text.Document;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;



import helper.db.MySQLdb;

/**
 * Servlet implementation class PDFServlet
 */
@WebServlet("/PDFServlet")
public class PDFServlet extends HttpServlet {
	
	private MySQLdb mySQLdb;
	
	public void init(ServletConfig config) {
		System.out.println("---> Entering init() MainServlet");
		
		mySQLdb = new MySQLdb();
		
		System.out.println("---> Exiting init() MainServlet");
	}
	
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        System.out.println("---> Entering doGet() MainServlet");
    		
        doPost(request, response);
        	
        System.out.println("---> Exiting doGet() MainServlet");
    }
    
 
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	System.out.println("---> Entering doPost() MainServlet");
    	
    	response.setHeader("Cache-Control", "no-cache");
		
    	if(request.getSession(false) == null) {
    		System.out.println("     User is not logged in");
    		
    		System.out.println("     Redirecting the user to loginForm.html");
			RequestDispatcher rd = request.getRequestDispatcher("/html/loginForm.html");
			rd.forward(request, response);
    	} else {
    		
    		HttpSession session = request.getSession();
    		String username = (String) session.getAttribute("username");
    		String email = mySQLdb.getEmail(username);
    		ArrayList<Object> userInfo = mySQLdb.getInfo(email);
			OutputStream out = response.getOutputStream();
    		response.setContentType("application/pdf");

			try { 
			Document document = new Document();
			PdfWriter.getInstance(document, out );
			document.open();
			document.add(new Paragraph("LIZENTZIAREN ZIURTAGIRIA"));
			//document.add(new Paragraph("email: " + userInfo.get(0)));
			//document.add(new Paragraph("Erabiltzaile izena: " + userInfo.get(0)));
			document.add(new Paragraph("Izena: " + userInfo.get(0)));
			document.add(new Paragraph("Abizena: " + userInfo.get(1)));
			document.add(new Paragraph("Abizena: " + userInfo.get(2)));
			document.add(new Paragraph("Posta kodea: " + userInfo.get(3)));
			document.add(new Paragraph("Herrialdea: " + userInfo.get(4)));
			document.add(new Paragraph("Hiria: " + userInfo.get(5)));
			document.add(new Paragraph("Telefono zenbakia: " + userInfo.get(6)));
			document.add(new Paragraph("Lizentzia: " + userInfo.get(7)));
			document.close();
			} catch (Exception e) {
			System.out.println(e);
			}
			out.flush();
			out.close();
		}
    }
}

