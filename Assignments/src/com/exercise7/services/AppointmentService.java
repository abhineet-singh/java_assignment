package com.exercise7.services;

import com.exercise7.model.*;
import java.time.LocalDate;
import java.util.*;

public class AppointmentService {

	public Map < LocalDate, HashMap<String,ArrayList<Patient>> > appointmentDateMap;

	public AppointmentService() {
		this.appointmentDateMap = new HashMap<>();
	}
	
	public void addAppointment(Patient patient, Doctor doctor) {
		
		HashMap<String,ArrayList<Patient>> xmap = this.appointmentDateMap.get(patient.getAppointmentDate());
		
		if(xmap == null) {
			
			xmap = new HashMap<>();
			
			ArrayList<Patient> list = new ArrayList<>();
			list.add(patient);
			
			xmap.put(doctor.getDoctorName(), list);
			
			this.appointmentDateMap.put(patient.getAppointmentDate(), xmap);
		}
		else {
			
			if(xmap.containsKey(doctor.getDoctorName())) {
				
				xmap.get(doctor.getDoctorName()).add(patient);
			}
			else {
				
				ArrayList<Patient> list = new ArrayList<>();
				list.add(patient);
				
				xmap.put(doctor.getDoctorName(), list);			
			}
		}
	}
	
	public List<Patient> retrievePatientsAtDateOfDoctor(LocalDate date, Doctor doctor) {
		
		HashMap<String,ArrayList<Patient>> xmap = this.appointmentDateMap.get(date);
		
		if(xmap != null) {
			
			if(xmap.containsKey(doctor.getDoctorName())) {
				
				return xmap.get(doctor.getDoctorName());
			}
		}
		
		return null;
	}
	
}
