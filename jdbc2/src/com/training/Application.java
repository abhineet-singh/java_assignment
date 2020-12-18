package com.training;

import java.time.LocalDate;
import java.util.*;

import com.training.daos.DoctorDaoImpl;
import com.training.entity.Doctor;
import com.training.ifaces.DataAccess;

public class Application {

	public static void main(String[] args) {
		
		// System.out.println(DBConnectionUtil.getMySqlConnection());
		
		int key = 7;
		DataAccess<Doctor> dao = new DoctorDaoImpl();
		
		switch (key) {
		case 1:
			Doctor doc = new Doctor(1233, "abhishek", 88776644, "heart", LocalDate.of(1998, 10, 29));
			int rowsAdded = dao.add(doc);
			System.out.println(rowsAdded);
			break;

		case 2:
			List <Doctor> list= dao.findAll();			
			list.forEach(System.out::println);
			break;
		case 3:
			System.out.println(dao.remove(1233));
			break;
		case 4:
			Doctor doc1 = new Doctor(1235, "abhineet", 88776633, "heart", LocalDate.of(1998, 10, 29));
			Doctor doc2 = new Doctor(1235, "abhineet", 88776633, "kidney", LocalDate.of(1998, 10, 29));
			System.out.println(dao.update(doc1, doc2));
			break;
		case 5:
			Doctor doc3 = dao.findById(1235);
			System.out.println(doc3);
			break;
		case 6:
			Doctor doc4 = new Doctor(1237, "xyz", 88776633, "heart", LocalDate.of(1998, 10, 29));
			Doctor doc5 = new Doctor(1238, "pqr", 88776633, "kidney", LocalDate.of(1998, 10, 29));
			
			int[] rows = dao.addInBatch(doc4,doc5);
			for(int res : rows) {
				System.out.println(res);
			}
			break;
		case 7:
			dao.usingTransactions();
			break;
		default:
			break;
		}

	}

}


/* create project choose version 1.8 
 * right click on the project -> build path -> configure build path -> then libraries add jar file.
 */
