package com.training.daos;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

import com.training.entity.Doctor;
import com.training.ifaces.DataAccess;
import com.training.utils.DBConnectionUtil;

public class DoctorDaoImpl implements DataAccess<Doctor> {
	
	private Connection con;
	
	public DoctorDaoImpl() {
		super();
		this.con = DBConnectionUtil.getMySqlConnection();
	}

	@Override
	public int add(Doctor t) {
		
		String sql = "insert into lumen_doctor values(?,?,?,?,?)";
		
		int rowsAdded = 0;
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			
			/*
			 * the order define here should match the 
			 * order in which database is designed in the mysql
			 */
			pstmt.setInt(1, t.getDoctorId());
			pstmt.setString(2, t.getDoctorName());
			pstmt.setString(3, t.getSpecialization());
			pstmt.setLong(4,t.getMobileNumber());
			
			
			pstmt.setDate(5,Date.valueOf(t.getDateOfBirth()));
			
			rowsAdded =  pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return rowsAdded;
	}

	@Override
	public List<Doctor> findAll() {
		
		String sql = "select * from lumen_doctor";
		
		List<Doctor> doctorList = null;
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)){

			ResultSet rs =  pstmt.executeQuery();
			
			doctorList = getResultList(rs);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return doctorList;
	}

	@Override
	public int update(Doctor oldDoc, Doctor newDoc) {
		
		int rowsUpdated = 0;
		
		String sql = "update lumen_doctor set specialization = ? where doctorId = ?";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setString(1, newDoc.getSpecialization());
			pstmt.setInt(2, oldDoc.getDoctorId());
			
			rowsUpdated =  pstmt.executeUpdate();
		} 
		catch (Exception e) {	
			e.printStackTrace();;
		}
		
		return rowsUpdated;
	}

	@Override
	public int remove(int id) {
		
		int rowsDeleted = 0;
		
		String sql = "DELETE FROM lumen_doctor WHERE doctorId = ?";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setInt(1, id);
			
			rowsDeleted =  pstmt.executeUpdate();
		} 
		catch (Exception e) {	
			e.printStackTrace();;
		}
		
		return rowsDeleted;
	}

	@Override
	public Doctor findById(int id) {

		String sql = "select * from lumen_doctor where doctorid = ?";
		
		List<Doctor> doctorList = null;
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setInt(1, id);;
			
			ResultSet rs = pstmt.executeQuery();
			
			doctorList = getResultList(rs);
		} 
		catch (Exception e) {	
			e.printStackTrace();;
		}
		
		return doctorList.get(0);
	}
	
	private List<Doctor> getResultList(ResultSet rs) {
		
		List<Doctor> doctorList = new ArrayList<>();
		
		try {
			while(rs.next()) {
				
				int doctorId = rs.getInt("doctorId");
				String doctorName = rs.getString("doctorName");
				long mobileNumber = rs.getLong("mobileNumber");
				String specialization = rs.getString("specialization");
				LocalDate dob = rs.getDate("dateOfBirth").toLocalDate();
				
				Doctor doc = new Doctor(doctorId, doctorName, mobileNumber, specialization, dob);
				
				doctorList.add(doc);
			}
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return doctorList;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

}
