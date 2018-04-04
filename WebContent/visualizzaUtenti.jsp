<%@page import="com.atm.progettoLogin.model.Model"%>
<%@page import="java.util.LinkedList"%>
<%@page import="com.ats.progettoLogin.dao.DaoUtente"%>
<%@page import="com.ats.progettoLogin.beans.Utente"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<p>Ecco l'elenco degli utenti registrati al nostro sito:</p>
	</div>
	<% Model model= new Model();
	LinkedList<Utente> lista= model.getUtenti();%>
	<table style="width: 100%">
		<tr>
			<th>Username</th>
			<th>Nome</th>
			<th>Cognome</th>
			<th>Indirizzo</th>
			<th>Data di Nascita</th>

		</tr>
	<% for(Utente u:lista){ %>
		<tr>
			<th><%=u.getUser()%></th>
			<th><%=u.getNome() %></th>
			<th><%=u.getCognome()%></th>
			<th><%=u.getIndirizzo()%></th>
			<th><%=u.getData() %></th>

		</tr>
	<%} %>	
	</table>
	<form action="index.jsp" method="post">

		<input type="submit" name="home" value="Home"> <br> <br>
	</form>
	<form action="Logout.jsp" method="post">

		<input type="submit" name="Logout" value="Logout"> <br> <br>
	</form>
</body>
</html>