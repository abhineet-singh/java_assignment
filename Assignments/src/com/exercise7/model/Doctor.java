package com.exercise7.model;

public class Doctor {
	
	private String DoctorId;
	private String DoctorName;
	private String specialisationIn;
	
	public Doctor(String doctorId, String doctorName) {
		DoctorId = doctorId;
		DoctorName = doctorName;
	}

	public Doctor(String doctorId, String doctorName, String specialisationIn) {
		this(doctorId,doctorName);
		this.specialisationIn = specialisationIn;
	}

	public String getDoctorId() {
		return DoctorId;
	}

	public void setDoctorId(String doctorId) {
		DoctorId = doctorId;
	}

	public String getDoctorName() {
		return DoctorName;
	}

	public void setDoctorName(String doctorName) {
		DoctorName = doctorName;
	}

	public String getSpecialisationIn() {
		return specialisationIn;
	}

	public void setSpecialisationIn(String specialisationIn) {
		this.specialisationIn = specialisationIn;
	}

	@Override
	public String toString() {
		return "Doctor [DoctorId=" + DoctorId + ", DoctorName=" + DoctorName + ", specialisationIn=" + specialisationIn
				+ "]";
	}

	
}
