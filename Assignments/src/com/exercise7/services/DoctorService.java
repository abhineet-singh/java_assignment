package com.exercise7.services;

import com.exercise7.model.*;
import java.util.*;

public class DoctorService {
	
	public List <Doctor> doctorsList;	
	public Map < String,ArrayList<Patient> > doctorToPatientsMap;
	
	public DoctorService() {	
		this.doctorsList = new ArrayList<>();
		this.doctorToPatientsMap = new HashMap<>();
	}

	public void addDoctor(Doctor ...doctors) {
		
		for(Doctor doc : doctors) {
		
			if(!this.doctorsList.contains(doc)) {

				this.doctorsList.add(doc);
			}
		}
		
		return ;
	}
	
	public List<Doctor> retrieveAllDoctors(){
		
		return this.doctorsList;
	}
	
	public boolean addPatientToDoctor(Patient patient,Doctor doctor) {
		
		boolean isAddedSuccessfully = false;
		
		if(this.doctorsList.contains(doctor)) {
			
			ArrayList<Patient> patientsList = this.doctorToPatientsMap.get(doctor.getDoctorName());
			
			if(patientsList == null) {
				
				patientsList = new ArrayList<>();
				
				patientsList.add(patient);
				
				this.doctorToPatientsMap.put(doctor.getDoctorName(), patientsList);
			}
			else {
				if(!patientsList.contains(patient)) {
					
					patientsList.add(patient);
				}
			}
			
			isAddedSuccessfully = true;
		}

		return isAddedSuccessfully;
	}

	public List<Patient> retrieveAllPatients(Doctor doctor){
		
		return this.doctorToPatientsMap.get(doctor.getDoctorName());

	}
	
	public boolean deleteAppointment(Patient patient, Doctor doctor) {
		
		boolean isRemovedSuccessfully = false;
		
		if(this.doctorsList.contains(doctor)) {
			
			List <Patient> patientsList = this.doctorToPatientsMap.get(doctor.getDoctorName());
			
			if(patientsList != null && patientsList.contains(patient)) {

				patientsList.remove(patient);
					
				isRemovedSuccessfully = true;
			}
		}
		
		return isRemovedSuccessfully;
	}
	
	
}
