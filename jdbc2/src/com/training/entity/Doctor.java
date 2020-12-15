package com.training.entity;

import java.time.LocalDate;

public class Doctor {
	
	private int doctorId;
	private String doctorName;
	private long mobileNumber;
	private String specialization;
	private LocalDate dateOfBirth;
	
	public Doctor() {
		super();
	}

	public Doctor(int doctorId, String doctorName, long mobileNumber, String specialization, LocalDate dateOfBirth) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.mobileNumber = mobileNumber;
		this.specialization = specialization;
		this.dateOfBirth = dateOfBirth;
	}



	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", mobileNumber=" + mobileNumber
				+ ", specialization=" + specialization + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	
	
	
}
