package com.exercise.App;

import com.exercise7.model.*;
import com.exercise7.services.*;
import java.time.LocalDate;
import java.util.*;

public class Application {
	
	public static void main(String[] args) {
		
		Doctor d1 = new Doctor("1234", "XYZ","Heart");
		Doctor d2 = new Doctor("2345", "PQR","Kidney");
		
		Patient p1 = new Patient("QWERTY",LocalDate.of(2020, 12, 13));
		Patient p2 = new Patient("ZXCVBN",LocalDate.of(2020, 12, 14));
		Patient p3 = new Patient("YUIOP",LocalDate.of(2020, 12, 13));
		Patient p4 = new Patient("GHJKL",LocalDate.of(2020, 12, 14));
		Patient p5 = new Patient("ASDFG",LocalDate.of(2020, 12, 15));

		
		DoctorService docSer = new DoctorService();
		AppointmentService appSer = new AppointmentService();

		// adding doctors to the list
		docSer.addDoctor(d1,d2);
		
		// retrieving all doctors present
		List<Doctor> doctors = docSer.retrieveAllDoctors();
		
		for(Doctor doctor : doctors) {		
			System.out.println(doctor);
		}
		
		System.out.println("===============================================================");
		
		// adding 2 (p1,p2) patients to Doctor d1 
		docSer.addPatientToDoctor(p1, d1);
		appSer.addAppointment(p1, d1);
		docSer.addPatientToDoctor(p2, d1);
		appSer.addAppointment(p2, d1);
		
		// adding 3 (p3,p4,p5) patients to Doctor d2
		docSer.addPatientToDoctor(p3, d2);
		appSer.addAppointment(p3, d2);
		
		docSer.addPatientToDoctor(p4, d2);
		appSer.addAppointment(p4, d2);
		
		docSer.addPatientToDoctor(p5, d2);
		appSer.addAppointment(p5, d2);
		
		// printing patients of doctor d2
		List<Patient> patients = docSer.retrieveAllPatients(d2);
		
		for(Patient patient : patients) {
			System.out.println(patient);
		}
		
		System.out.println("===============================================================");
		
		// deleting the appointment of Patient p4 from Doctor d2
		docSer.deleteAppointment(p4, d2);
		
		// printing patients of doctor d2
		List<Patient> patients1 = docSer.retrieveAllPatients(d2);

		for(Patient patient : patients1) {
			System.out.println(patient);
		}
		
		System.out.println("===============================================================");
		
		List<Patient> patients3 = appSer.retrievePatientsAtDateOfDoctor(LocalDate.of(2020, 12, 14), d2);
		
		for(Patient patient : patients3) {
			System.out.println(patient);
		}
	}
		
}
