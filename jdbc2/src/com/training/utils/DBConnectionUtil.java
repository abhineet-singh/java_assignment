package com.training.utils;

import java.io.*;
import java.sql.*;
import java.util.*;


public class DBConnectionUtil {
	
	
	public static Connection getMySqlConnection() {
		
		Connection con = null;

		String fileName = "DbConnection.properties";
		
		try {		
			
			InputStream inStream = DBConnectionUtil.class.getClassLoader().getResourceAsStream(fileName);
			
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
