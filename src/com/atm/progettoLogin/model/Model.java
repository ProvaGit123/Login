package com.atm.progettoLogin.model;

import java.util.LinkedList;

import com.ats.progettoLogin.beans.Utente;
import com.ats.progettoLogin.dao.DaoUtente;

public class Model {
	private DaoUtente dao= new DaoUtente();
	
	public LinkedList<Utente> getUtenti(){
		return dao.getAllUtenti();
	}

	public Utente trovaUtente(String user) {
		// TODO Auto-generated method stub
		return dao.getUtenteByUser(user);
	}
	
	public Utente scacciaUtente() {
		
	}
	
}
