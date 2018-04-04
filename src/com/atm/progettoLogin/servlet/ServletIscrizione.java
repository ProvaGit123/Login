package com.atm.progettoLogin.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ats.progettoLogin.beans.Utente;
import com.ats.progettoLogin.dao.DaoUtente;
import com.sun.crypto.provider.RSACipher;

/**
 * Servlet implementation class ServletIscrizione
 */
@WebServlet("/ServletIscrizione")
public class ServletIscrizione extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletIscrizione() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoUtente dao= new DaoUtente();
		RequestDispatcher rd=null;
		Utente u= new Utente();
		u.setUser(request.getParameter("user"));
		u.setPassword(request.getParameter("pass"));
		u.setNome(request.getParameter("nome"));
		u.setCognome(request.getParameter("cognome"));
		u.setIndirizzo(request.getParameter("indirizzo"));
		u.setData(request.getParameter("data"));
		request.getSession().setAttribute("utente", u);
		if(dao.addUtente(u)==true) {
			request.getSession().setAttribute("messaggio", "iscrizione dell'utente "+ u.getUser() +" avvenuta con successo");
			rd=request.getRequestDispatcher("IscrizioneEffettuata.jsp");
			rd.forward(request, response);
		}else {
			rd=request.getRequestDispatcher("iscrizione.jsp");
			request.getSession().setAttribute("messaggio", "non è stato possibile effetutare l'iscrizione nickname già presente!!!");
			rd.include(request, response);
		}
		
	}

}
