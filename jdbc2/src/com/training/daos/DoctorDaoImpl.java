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


	@Override
	public int[] addInBatch(Doctor ...doctors) {
		
		String sql = "insert into lumen_doctor values(?,?,?,?,?) ";
		int[] rows = null;
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			
			con.setAutoCommit(false);
			
			for(Doctor doc : doctors){
				
				pstmt.setInt(1, doc.getDoctorId());
				pstmt.setString(2, doc.getDoctorName());
				pstmt.setString(3, doc.getSpecialization());
				pstmt.setLong(4,doc.getMobileNumber());
					
				pstmt.setDate(5,Date.valueOf(doc.getDateOfBirth()));
				
				pstmt.addBatch();
				
			}
			
			rows = pstmt.executeBatch();
			
			con.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return rows;

	}
	


	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	@Override
	public void usingTransactions() {
		
		String sql1 = "insert into lumen_doctor(doctorId,doctorName) values(?,?)";
		String sql2 = "inseert into lumen_doctor(doctorId,doctorName) values(?,?)";
		Savepoint p1 = null;
		
		try {
			
			con.setAutoCommit(false);
			PreparedStatement pstmt1 = con.prepareStatement(sql1);
			PreparedStatement pstmt2 = con.prepareStatement(sql2);
			
			pstmt1.setInt(1, 123);
			pstmt1.setString(2, "dummy");
			
			pstmt1.executeUpdate();
			
			p1 = con.setSavepoint("point1");
			
			pstmt2.setInt(1, 123);
			pstmt2.setString(2, "munna");
			
			pstmt2.executeUpdate();
			
			con.commit();
		}
		catch(SQLException e) {
			
			e.printStackTrace();
			
			try {
				con.rollback(p1);
			} 
			catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return;
		
	}
}