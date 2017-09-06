package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnect {
	String servername, port, db_name, db_user, db_pass;

	public MyConnect() {
		servername = "localhost";//"localhost"
		port = "1433";
		db_name = "web2";
		db_user = "sa";
		db_pass = "123456";
	}

	public MyConnect(String servername, String port, String db_name, String db_user, String db_pass) {
		this.servername = servername;
		this.port = port;
		this.db_name = db_name;
		this.db_user = db_user;
		this.db_pass = db_pass;
	}
	
	public Connection getcn()
	{
		Connection cn = null;
		try {
			String db_url = "jdbc:sqlserver://"+ servername +":"+ port +";databasename = " + db_name;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			cn = DriverManager.getConnection(db_url, db_user, db_pass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return cn;
	}
}
