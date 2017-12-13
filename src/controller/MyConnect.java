package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnect {
	String servername;
	String port;
	String db_name;
	String db_user;
	String db_pass;

	public MyConnect(String servername, String port, String db_name, String db_user, String db_pass) {
		this.servername = servername;
		this.port = port;
		this.db_name = db_name;
		this.db_user = db_user;
		this.db_pass = db_pass;
	}

	public MyConnect() {
		servername = "localhost";
		port = "3306";
		db_name = "laptrinhweb";
		db_user = "root";
		db_pass = "";
	}

	public Connection getcn() {
		Connection cn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String db_url = "jdbc:mysql://localhost/laptrinhweb?useSSL=false";
			cn = DriverManager.getConnection(db_url, db_user, db_pass);
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		return cn;
	}
}
