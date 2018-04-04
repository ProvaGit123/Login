package com.atm.progettoLogin.utils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	String driver="oracle.jdbc.driver.OracleDriver";
	String connectionUrl="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	String dbUser="marco";
	String dbPassword="password";
	private static ConnectionFactory connectionFactory=null;

	
	
	private ConnectionFactory(){

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public Connection getConnection(){
		Connection con=null;
		try {
			con= DriverManager.getConnection(connectionUrl,dbUser,dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	//get instance istanzia automaticamente l'oggetto connectionFactory richiamando 
	// il costruttore
	public static ConnectionFactory getIstance(){

		if(connectionFactory==null){
			connectionFactory= new ConnectionFactory();
		}

		return connectionFactory;
}
}
