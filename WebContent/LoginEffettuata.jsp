<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>
		Benvenuto
		<%=session.getAttribute("user")%></p>
	<br>
	<br>
	<form action="index.jsp" method="post">

		<input type="submit" name="home" value="Home"> <br> <br>
	</form>
	<form action="Logout.jsp" method="post">

		<input type="submit" name="Logout" value="Logout"> <br> <br>
	</form>
	<form action="visualizzaUtenti.jsp" method="post">

		<input type="submit" name="Lista" value="Lista Utenti"> <br> <br>
	</form>
</body>
</html>