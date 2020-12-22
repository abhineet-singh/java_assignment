package com.training.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import com.training.model.BloodDonor;

public class BloodDonorService {
	
	public BloodDonorService() {
		super();
	}

	
	public int add(Connection con,BloodDonor donor) {
		
		String sql = "insert into donor values(?,?,?,?,?,?,?)";
		
		int rowsAdded = 0;

		try(PreparedStatement pstmt = con.prepareStatement(sql)){

			pstmt.setString(1, donor.getName());
			pstmt.setInt(2, donor.getAge());
			pstmt.setString(3, donor.getGender());
			pstmt.setString(4,donor.getBloodGroup());
			pstmt.setString(5,donor.getPhoneNumber());
			pstmt.setString(6,donor.getEmail());
			pstmt.setDate(7,Date.valueOf(donor.getDateOfBirth()));

			
			rowsAdded =  pstmt.executeUpdate();	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return rowsAdded;
	}

}
