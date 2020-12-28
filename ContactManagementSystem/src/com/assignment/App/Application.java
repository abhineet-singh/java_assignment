package com.assignment.App;

import java.time.LocalDate;

import com.assignment.connection.DBConnection;
import com.assignment.model.Contact;
import com.assignment.service.ContactService;


import java.util.*;
import java.sql.Date;


public class Application {
	
	public static void main(String[] args) {
		
		ContactService contactServ = new ContactService(DBConnection.getMySqlConnection());
		
		Scanner sc = new Scanner(System.in);
		
		int mainOpt = 0;
		do {
			String menu = "\nMenu\n" + "1.Create contact\n" + "2.Update contact\n" + "3.Delete contact\n"
							  + "4.Add Contacts from File\n" + "5.Generate Report\n";
			
			System.out.println(menu);
			
			System.out.print("Choose option : ");   
			mainOpt = sc.nextInt();
			
			switch (mainOpt) {
			
			
			case 1:
				System.out.print("Enter Details");
				System.out.print("Name : ");       		  String name = sc.next();
				System.out.print("Address : ");       	  String address = sc.next();
				System.out.print("Mobile Number : ");       String mobileNumber = sc.next();
				System.out.print("Profile Picture : ");     String profilePicture = sc.next();
				System.out.print("Date Of Birth : ");       String dob = sc.next();
				System.out.print("Email : ");       		  String email = sc.next();
				System.out.print("Group : ");      		  String group = sc.next();
				
				LocalDate dateOfBirth = Date.valueOf(dob).toLocalDate();
				Contact newContact = new Contact(name, address, mobileNumber, profilePicture, dateOfBirth, email, group);
				
				int addRes = contactServ.addContact(newContact);				
				System.out.println(addRes + " contact added");
				break;
				
				
			case 2:
				System.out.println("Enter Details");
				System.out.print("Name : ");       		  String uName = sc.next();
				System.out.print("Mobile Number : ");       String uMobileNumber = sc.next();
				
				System.out.println("Select Field that needs to be Updated : ");
				
				String fieldMenu = "1.Contact Name\n" +  "2.Contact Address\n" +"3.Contact Mobile Number\n" +
						            "4.Contact Profile Picture\n" + "5.Contact Date of Birth\n" + "6.Contact Email\n" +
						            "7.Contact Group\n";
				System.out.println(fieldMenu);
				
				String uField = "";
				
				int opt = sc.nextInt();
				switch (opt) {
				case 1: uField = "contactName";	break;		
				case 2: uField = "contactAddress";	break;
				case 3: uField = "contactMobileNumber";	break;
				case 4: uField = "contactProfilePicture";	break;
				case 5: uField = "contactDateOfBirth";	break;
				case 6: uField = "contactEmail";	break;
				case 7: uField = "contactGroup";	break;
				default:	break;
				}
				
				System.out.print("Enter new value for the updation of " + uField + " : ");
				String newValue = sc.next();
				
				int updateRes = contactServ.updateContact(uName, uMobileNumber, uField, newValue);
				System.out.println(updateRes + " contact updated");
				break;
			
			
			case 3:
				System.out.println("Enter Details");
				System.out.print("Name : ");       		  String dName = sc.next();
				System.out.print("Mobile Number : ");       String dMobileNumber = sc.next();
				
				int deleteRes = contactServ.deleteContact(dName, dMobileNumber);
				System.out.println(deleteRes + " contact deleted");
				break;
				
				
			case 4:
				System.out.print("Enter FilePath : ");
				String filePath = sc.next();
				
				int contactsAdded = contactServ.addContactFromFile(filePath);
				System.out.println(contactsAdded + " contacts added");
				break;
				
			case 5:
				
				
				String reportMenu = "\nReport Menu\n" + 
									"1.List of the Birthday on a Given Month\n" +  
									"2.List of Contact by Group\n" +
									"3.List of Contacts with name and email Id\n"+ 
			            			"4.List of Contact with name and mobile Number\n" + 
									"5.List of Contact by Group Size\n";			
				System.out.println(reportMenu);
				
				System.out.print("Choose the Report Type : ");
				int rOpt = sc.nextInt();
				
				switch (rOpt) {
				case 1: 
					System.out.print("Enter Month Value : ");
					int month = sc.nextInt();
					
					System.out.print("Enter Print type [Console or File] : ");
					String printType1 = sc.next();
					
					contactServ.getBirthDateByMonth(printType1, month);				
					break;		
				
				case 2: 
					
					System.out.print("Enter Print type [Console or File] : ");
					String printType2 = sc.next();
					
					contactServ.getContactsByGroup(printType2);
					break;
					
				case 3: 
					
					System.out.print("Enter Print type [Console or File] : ");
					String printType3 = sc.next();
				
					contactServ.getContactsNameAndEmailId(printType3);
					break;
					
				case 4:  
					
					System.out.print("Enter Print type [Console or File] : ");
					String printType4 = sc.next();
				
					contactServ.getContactsNameAndMobileNumber(printType4);
					break;
					
				case 5:  
					
					System.out.print("Enter Print type [Console or File] : ");
					String printType5 = sc.next();
				
					contactServ.getContactsByAscOrder(printType5);
					break;

				default : break;
				}
				break;
				
				
			default:	
				break;
			}	
			
		}while(mainOpt <= 5);
		
		sc.close();
	}

}
