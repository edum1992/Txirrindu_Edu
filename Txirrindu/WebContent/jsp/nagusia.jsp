<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*,helper.info.*" %>
<% 

   String username = (String) session.getAttribute("username");
   ServletContext context = request.getServletContext();
   HashMap<String, String> loggedinUsers = (HashMap) context.getAttribute("loggedin_users"); 
 
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="/Txirrindu/css/styleSheet.css" rel="stylesheet" />
</head>
<body>
	<header>
		<h1>Zornotzako txirrindulari taldea</h1>
	</header>
	<form method="POST" action="/Txirrindu/servlet/MainServlet">
	<section>
	<font color="white">Erabiltzen ari zaren erabiltzailea: </font>
			<%= username %>
	</section>
	<section>
		    <font color="white">Une honetan konektatuta dauden erabiltzaileak: </font>
			<% for(Map.Entry<String, String> entry : loggedinUsers.entrySet()) { %>
	            <%= entry.getKey() %>
	        <% } %>
		</section>
		<section>
			<table>
				<th>hautatu egin nahi duzun eragiketa</th>
				<tr>
					<td><a href="/Txirrindu/html/pasahitzaAldatuForm.html"
						style="text-decoration: none"> <font color="black">pasahitza
								aldatu</font>
					</a></td>
				</tr>
				<tr>
					<td><a href="/Txirrindu/jsp/NewPerfilaEguneratuForm.jsp"
						style="text-decoration: none"> <font color="black">Perfila
								eguneratu</font>
					</a></td>
				</tr>
				<tr>
					<td><a href="/Txirrindu/html/lizentziaEguneratuForm.html"
						style="text-decoration: none"> <font color="black">Lizentzia
								eguneratu</font>
					</a></td>
				</tr>
				<tr>
					<td><a href="/Txirrindu/servlet/PDFServlet"
						style="text-decoration: none"> <font color="black">Lizentziaren
								ziurtagiria eskuratu</font>
					</a></td>
				</tr>
				

			</table>
			<section>
				<a href="/Txirrindu/html/loginForm.html"
						style="text-decoration: none"> <font color="black">Login
								orrialdera bueltatu</font></section>
			</section>
	</form>


</body>

</body>
</html>