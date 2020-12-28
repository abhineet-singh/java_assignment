package com.assignment.service;

import com.assignment.model.User;
import java.sql.*;

class LoginService {
	
	public static boolean validate(Connection con,User user) {

		boolean isValidUser = false;
		
		String sqlQuery = "select * from user where userName = ? and userPassword = ? ;";
		
		try(PreparedStatement pstmt = con.prepareStatement(sqlQuery)){
			
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserPassword());
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {			
				isValidUser = true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return isValidUser;
	}

}
