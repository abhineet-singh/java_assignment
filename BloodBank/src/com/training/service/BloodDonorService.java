package com.training.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	
	
	public List<BloodDonor> findAll(Connection con) {
		
		String sql = "select * from donor";
		
		List<BloodDonor> donorList = null;
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)){

			ResultSet rs =  pstmt.executeQuery();
			
			donorList = getResultList(rs);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return donorList;
	}
	
	private List<BloodDonor> getResultList(ResultSet rs) {
		
		List<BloodDonor> doctorList = new ArrayList<>();
		
		try {
			while(rs.next()) {
				
				String name = rs.getString("name");
				
				int age = rs.getInt("age");
				
				String gender = rs.getString("gender");
				String bloodGroup = rs.getString("bloodGroup");
				String phoneNumber = rs.getString("phoneNumber");
				String email = rs.getString("email");
				
				LocalDate dateOfBirth = rs.getDate("dateOfBirth").toLocalDate();

				BloodDonor donor = new BloodDonor(name, age, gender, bloodGroup, phoneNumber, email, dateOfBirth);
				
				doctorList.add(donor);
				
				System.out.println(donor);
			}
		} 
		catch (SQLException e) {			
			System.out.println(e.getMessage());
		}
		
		return doctorList;
	}

}
