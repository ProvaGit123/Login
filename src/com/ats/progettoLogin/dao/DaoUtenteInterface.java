package com.ats.progettoLogin.dao;

import java.util.*;


import com.ats.progettoLogin.beans.Utente;

public interface DaoUtenteInterface {

	public boolean addUtente(Utente u);
	public Utente getUtenteByUser(String u);
	public boolean deleteByUser(String u);
	public boolean aggiornaUtente(Utente u);

	public LinkedList<Utente> getAllUtenti();
	public boolean removeAll();


}
