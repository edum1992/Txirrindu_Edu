<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*, helper.db.*" %>
<%
    MySQLdb mySQLdb = new MySQLdb(); 
    
    String username = (String) session.getAttribute("username");
    String email = mySQLdb.getEmail(username);
    
    ArrayList<Object> userInfo = mySQLdb.getInfo(email);
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>perfina eguneratu</title>
<link href="/Txirrindu/css/styleSheet.css" rel="stylesheet" />
</head>
<body>
<header>
			<h1>Zornotzako txirrindulari taldea</h1>
			</header>
<form method="POST" action="/Txirrindu/servlet/PerfilaEguneratuServlet">
	<section>
				<table>
	   				<tr>
	   					<td>Erabiltzailea:</td>
	   					<td><input name="username" value="<%= userInfo.get(8) %>"></td>
	   				</tr>
	   				<tr>
	   					<td>Izena:</td>
	   					<td><input name="name" value="<%= userInfo.get(0) %>"></td>
	   				</tr>
	   				<tr>
	   					<td>Lehenengo abizena:</td>
	   					<td><input name="surname1" value="<%= userInfo.get(1) %>"></td>
	   				</tr>
	   				<tr>
	   					<td>Bigarren Abizena:</td>
	   					<td><input name="surname2" value="<%= userInfo.get(2) %>"></td>
	   				</tr>
	   				<tr>
	   					<td>posta kodea:</td>
	   					<td><input name="postalCode" value="<%= userInfo.get(3) %>"></td>
	   				</tr>
	   				<tr>
	   					<td>Herrialdea:</td>
	   					<td><input name="country" value="<%= userInfo.get(4) %>"></td>
	   				</tr>
	   				<tr>
	   					<td>Hiria:</td>
	   					<td><input name="city" value="<%= userInfo.get(5) %>"></td>
	   				</tr>
	   				<tr>
	   					<td>Telefono zenbakia:</td>
	   					<td><input name="phoneNumber" value="<%= userInfo.get(6) %>"></td>
	   				</tr>
	 			</table>
	 			<button>Aldatu</button>
	 	</section>
	 	<section>
				<a href="/Txirrindu/jsp/nagusia.jsp"
						style="text-decoration: none"> <font color="black">Orrialde nagusira bueltatu</font>
				</a>
		</section>
		
</form>


</body>
<footer>Zornotzako txirrindulari taldea</footer> 
</html>
