<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%=session.getAttribute("messaggio") %>
<form action="ServletCerca" method="post">
		<div>
			<p>Inserisci l'username dell'utente da cercare</p>
			<br> <br>
		</div>
		<div>
			<label>Username</label> <input type="text" name="user" required><br>
			<br>
		</div>
		
		<input type="submit" name="cerca" value="Cerca"> <br> <br>
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