<%@page import="org.apache.catalina.SessionEvent"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.ats.progettoLogin.beans.Utente"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LOGIN</title>
</head>
<body>
	<%
		if (session.getAttribute("user") == null) {
			session.setAttribute("user", "");
		}
	%>
	<%
		if (session.getAttribute("utente") == null) {
			Utente u = new Utente();
			session.setAttribute("utente", u);
		}
	%>
	<%
		if (session.getAttribute("messaggio") == null) {
			session.setAttribute("messaggio", "");
		}
	%>
	<%=session.getAttribute("messaggio")%>
	<form action="ServletLogin" method="post">
		<div>
			<p>Inserisci i dati per il login</p>
			<br> <br>
		</div>
		<div>
			<label>Username</label> <input type="text" name="user" required><br>
			<br>
		</div>
		<div>
			<label>Password</label> <input type="password" name="pass" required><br>
			<br>
		</div>
		<input type="submit" name="Login" value="Login"> <br> <br>
	</form>
	<input type="reset" name="Reset" value="Reset">
	<br>
	<br>
	<a href="iscrizione.jsp"> Se non sei ancora iscritto clicca qui!</a>
	<br>
	<br>
	<form action="Logout.jsp" method="post">

		<input type="submit" name="Logout" value="Logout">
	</form>
	<form action="visualizzaUtenti.jsp" method="post">

		<input type="submit" name="Lista" value="Lista Utenti">
	</form>
	<form action="trovaUtente.jsp" method="post">

		<input type="submit" name="trova" value="Trova Utente"> <br>
		<br>
	</form>
	<form action="aggiornaUtente.jsp" method="post">

		<input type="submit" name="aggiorna" value="Aggiorna Utente">
	</form>
	<form action="cancellaUtente.jsp" method="post">

		<input type="submit" name="cancella" value="Cancella Utente">
	</form>
	<form action="cancellaUtenti.jsp" method="post">

		<input type="submit" name="cancella" value="Cancella Utenti">
		<br> <br>
	</form>
</body>
</html>