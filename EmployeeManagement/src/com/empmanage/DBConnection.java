package com.empmanage;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
	
	static Connection con;
	public static Connection createDBConnection(){
		
		try {
				// 1. Load and Register Driver
				Class.forName("com.mysql.cj.jdbc.Driver");

				// 2.create Connection
				
				String url = "jdbc:mysql://localhost:3308/employeeDB";
				String user = "root";
				String pass = "root";
				
				con = DriverManager.getConnection(url,user,pass);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return con;
				
	}
}
