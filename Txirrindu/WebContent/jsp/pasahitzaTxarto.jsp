<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>pasahitza aldatu</title>
<link href="/Txirrindu/css/styleSheet.css" rel="stylesheet" />
</head>
<body>

	<header>
	<h1>Zornotzako txirrindulari taldea</h1>
	</header>
	<%
		if ((boolean) request.getAttribute("pasahitza_txarto")) {
	%>
	<section>
	<h1>Pasahitza txarto sartu dozu, saiatu berriro:</h1>
	<h2> Gogoratu pasahitz berria ezin duzula hutsik utzi</h2>
	</section> <%
 	}
 %>
	<form method="POST" action="/Txirrindu/servlet/pasahitzaAldatuServlet">
		<section> <font color="white">Pasahitz zaharra sartu</font>
		<td><input type="password" name="password1" /></td>

		<font color="white">Pasahitz berria sartu</font>
		<td><input type="password" name="password2" /></td>
		<button>Aldatu</button>
		</section>
		
	</form>
	<section>
				<a href="/Txirrindu/jsp/nagusia.jsp"
						style="text-decoration: none"> <font color="black">Orrialde nagusira bueltatu</font>
				</a>
		</section>
</body>
<footer>Zornotzako txirrindulari taldea</footer> 
</html>