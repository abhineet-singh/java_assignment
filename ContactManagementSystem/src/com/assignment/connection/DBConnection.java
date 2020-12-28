package com.assignment.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	
	public static Connection getMySqlConnection() {
		
		Connection con = null;

		String fileName = "DbConnection.properties";
		
		try {				
			InputStream inStream = DBConnection.class.getClassLoader().getResourceAsStream(fileName);
			
			Properties props = new Properties();
			
			props.load(inStream);
			
			con = DriverManager.getConnection(props.getProperty("datasource.url"),props.getProperty("datasource.username"),props.getProperty("datasource.password"));
			
		} 
		catch (IOException | SQLException e) {
			
			e.printStackTrace();
		}
		
		return con;
	}

}
