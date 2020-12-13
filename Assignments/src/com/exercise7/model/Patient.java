package com.exercise7.model;

import java.time.LocalDate;

public class Patient {
	
	private String patientName;
	private LocalDate appointmentDate;
	
	public Patient(String patientName, LocalDate appointmentDate) {
		this.patientName = patientName;
		this.appointmentDate = appointmentDate;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	@Override
	public String toString() {
		return "Patient [patientName=" + patientName + ", appointmentDate=" + appointmentDate + "]";
	}
	
	
}
