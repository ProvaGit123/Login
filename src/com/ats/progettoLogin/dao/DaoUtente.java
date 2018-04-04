package com.ats.progettoLogin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.atm.progettoLogin.utils.ConnectionFactory;
import com.ats.progettoLogin.beans.Utente;

public class DaoUtente implements DaoUtenteInterface {
	
	
	Connection con=null;
	PreparedStatement ps=null;
	
	public void setConnection() {
		con= ConnectionFactory.getIstance().getConnection();
	}
	
	@Override
	public boolean addUtente(Utente u) {
		if(getUtenteByUser(u.getUser())==null) {
		setConnection();
		String query="INSERT INTO Utenti values(?,?,?,?,?,?)";
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, u.getUser());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getNome());
			ps.setString(4, u.getCognome());
			ps.setString(5, u.getIndirizzo());
			ps.setString(6, u.getData());

			
			if(ps.executeUpdate()>0) {
				return true;
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		return false;
	}

	@Override
	public Utente getUtenteByUser(String u) {
		setConnection();
		

		try {
			String string="select * from Utenti where username=?";
			ps= con.prepareStatement(string);
			ps.setString(1, u);
			ResultSet rs=ps.executeQuery();
			Utente utente= new Utente();
			if(rs.next()){
				
				utente.setUser(rs.getString("username"));
				utente.setPassword(rs.getString("password"));
				utente.setNome(rs.getString("nome"));
				utente.setCognome(rs.getString("cognome"));
				utente.setIndirizzo(rs.getString("indirizzo"));
				utente.setData(rs.getString("dataNascita"));
			}
			rs.close();
			ps.close();
			con.close();
			return utente;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	return null;
	}

	@Override
	public boolean deleteByUser(String u) {
		if(getUtenteByUser(u)!=null) {
			setConnection();
			try {
				String query="delete from Utenti where username=?";
				ps=con.prepareStatement(query);
				ps.setString(1, u);
				
				if(ps.executeUpdate()>0) {
					return true;
				}
				
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			return false;
	}

	@Override
	public boolean aggiornaUtente(Utente u) {
		if(getUtenteByUser(u.getUser())!=null) {
		setConnection();
		try {
			String query="update Utenti set username=?,password=?,"
					+ "nome=?,cognome=?,indirizzo=?,dataNascita=?"
					+ "where username=?";
			ps=con.prepareStatement(query);
			ps.setString(1, u.getUser());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getNome());
			ps.setString(4, u.getCognome());
			ps.setString(5, u.getIndirizzo());
			ps.setString(6, u.getData());
			ps.setString(7, u.getUser());
			if(ps.executeUpdate()>0) {
				return true;
			}
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		return false;
	}

	@Override
	public LinkedList<Utente> getAllUtenti() {
		setConnection();
		LinkedList<Utente> utenti= new LinkedList<Utente>();
		try {
			String query= "Select * from Utenti";
			ps= con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Utente u= new Utente();
				u.setUser(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setNome(rs.getString("nome"));
				u.setCognome(rs.getString("cognome"));
				u.setIndirizzo(rs.getString("indirizzo"));
				u.setData(rs.getString("dataNascita"));
				utenti.add(u);
			}
			
			
			
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return utenti;
	}

	@Override
	public boolean removeAll() {
		setConnection();
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
