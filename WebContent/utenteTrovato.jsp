<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.ats.progettoLogin.beans.Utente"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Utente u= (Utente)session.getAttribute("utente"); %>
<div>
			<p>Inserisci i dati per l'iscrzione</p>
			<br> <br>
		</div>
		<div>
			<label>Username  </label> <%=u.getUser() %><br>
			<br>
		</div>
		<div>
			<label>Password  </label> <%="**********" %><br>
			<br>
		</div>
		<div>
			<label>Nome  </label> <%=u.getNome() %><br>
			<br>
		</div>
		<div>
			<label>Cognome  </label> <%= u.getCognome() %><br>
			<br>
		</div>
		<div>
			<label>Indirizzo  </label> <%=u.getIndirizzo() %><br>
			<br>
		</div>
		<div>
			<label>Data di Nascita  </label> <%=u.getData() %><br>
			<br>
		</div>
		
	<input type="reset" name="Reset" value="Reset"><br> <br>
	<br>
	<br>
	<form action="index.jsp" method="post">

		<input type="submit" name="home" value="Home"> <br> <br>
	</form>
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