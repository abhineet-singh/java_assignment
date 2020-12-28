package com.assignment.service;

import com.assignment.model.Contact;

import static java.util.stream.Collectors.*;

import java.io.*;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;

import java.util.*;
import java.util.Map.Entry;



public class ContactService {
	
	private Connection con;

	
	public ContactService(Connection con) {
		super();
		
		/*
		boolean isValidUser = LoginService.validate(con,user);
		
		if(isValidUser) {			
			this.con = con;
			System.out.println("user present");
		}
		else {
			this.con = null;
		}
		*/
		
		this.con = con;
	}
	
	
	public int addContact(Contact contact) {
		
		int rowsAdded = 0;
		
		if(con != null) {
			
			String sqlQuery = "insert into contact values(?,?,?,?,?,?,?)";

			try(PreparedStatement pstmt = con.prepareStatement(sqlQuery)){
				
				pstmt.setString(1, contact.getContactName());
				pstmt.setString(2, contact.getContactAddress());
				pstmt.setString(3, contact.getContactMobileNumber());
				pstmt.setString(4,contact.getContactProfilePicture());

				pstmt.setDate(5,Date.valueOf(contact.getContactDateOfBirth()));

				pstmt.setString(6, contact.getContactEmail());
				pstmt.setString(7, contact.getContactGroup());
				
				rowsAdded =  pstmt.executeUpdate();
				
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		return rowsAdded;
	}
	
	
	public int addContactFromFile(String file) {
		
		int contactsAdded = 0;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(file))){
			
			String line = reader.readLine();
			
			do {		
				String[] values = line.split(",");
				
				String contactName = values[0];
				String contactAddress = values[1];
				String contactMobileNumber = values[2];
				String contactProfilePicture = values[3];
				
				LocalDate contactDateOfBirth = Date.valueOf(values[4]).toLocalDate();
				
				String contactEmail = values[5];
				String contactGroup = values[6];
				
				Contact contact = new Contact(contactName, contactAddress, contactMobileNumber, 
										contactProfilePicture, contactDateOfBirth, contactEmail, contactGroup);
				
				contactsAdded += this.addContact(contact);
				
				line = reader.readLine();
				
			}while(line != null);
			
		}
		catch(IOException e) {		
			System.out.println(e.getMessage());
		}
			
		return contactsAdded;
	}

	
	public int updateContact(String userName,String mobileNumber,String updateField, String newValue) {
		
		int rowsUpdated = 0;

		if(con != null) {
			
			String sqlQuery = "update contact set "+ updateField + " = ? where contactName = ? "
								+ "and contactMobileNumber = ?";

			try(PreparedStatement pstmt = con.prepareStatement(sqlQuery)){
				
				if(updateField.equalsIgnoreCase("contactDateOfBirth")) {				
					pstmt.setDate(1, Date.valueOf(newValue));
				}
				else {
					pstmt.setString(1, newValue);
				}
				pstmt.setString(2, userName);
				pstmt.setString(3, mobileNumber);
				
				rowsUpdated =  pstmt.executeUpdate();	
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}

		return rowsUpdated;
	}
	

	public int deleteContact(String userName, String mobileNumber) {
		
		int rowsDeleted = 0;
		
		if(con != null) {
			
			String sqlQuery = "delete from contact where contactName = ? "
								+ "and contactMobileNumber = ?";

			try(PreparedStatement pstmt = con.prepareStatement(sqlQuery)){
				
				pstmt.setString(1, userName);
				pstmt.setString(2, mobileNumber);
				
				rowsDeleted =  pstmt.executeUpdate();	
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		return rowsDeleted;
	}
		
	
	public void getBirthDateByMonth(String output, int monthVal){
		
		List<Contact> contactList = getContactsAsList();

		Map<String, ? super Object> res = contactList.stream().
								 filter(elem -> elem.getContactDateOfBirth().getMonthValue()== monthVal).
								 collect(toMap(Contact::getContactName,Contact::getContactDateOfBirth));
		
		if(output.equalsIgnoreCase("Console")) {		
			printToConsole(res);
		}
		else {			
			printToFile(res,"contacts_name_dateOfBirth.txt");
		}
		return ;
	}
	
	
	public void getContactsNameAndEmailId(String output){
		
		List<Contact> contactList = getContactsAsList();
		
		Map<String, ? super Object> res =  contactList.stream().
							  			   collect(toMap(Contact::getContactName,Contact::getContactEmail));
		
		if(output.equalsIgnoreCase("Console")) {		
			printToConsole(res);
		}
		else {			
			printToFile(res,"contacts_name_emailId.txt");
		}
		
		return ;
	}
	
	
	public void getContactsNameAndMobileNumber(String output){
		
		List<Contact> contactList = getContactsAsList();
		
		Map<String, ? super Object> res = contactList.stream().
								 collect(toMap(Contact::getContactName,Contact::getContactMobileNumber));
		
		if(output.equalsIgnoreCase("Console")) {		
			printToConsole(res);
		}
		else {			
			printToFile(res,"contacts_name_mobileNumber.txt");
		}
		
		return ;
	}
	
	
	public void getContactsByGroup(String output) {
		
		List<Contact> contactList = getContactsAsList();
		
		HashMap<String, ArrayList<String>> hMap = new HashMap<String,ArrayList<String>>();
		
		for(Contact contact : contactList) {
			
			if(hMap.containsKey(contact.getContactGroup())) {
				
				hMap.get(contact.getContactGroup()).add(contact.getContactName());
			}
			else {
				ArrayList<String> newContactGroup = new ArrayList<>();
				newContactGroup.add(contact.getContactName());
				
				hMap.put(contact.getContactGroup(), newContactGroup);
			}
		}
		
		if(output.equalsIgnoreCase("Console")) {

			hMap.entrySet().stream().
			forEach(elem -> System.out.println(elem.getKey() + "\t" + elem.getValue()));
		}
		else {
			
			try(FileWriter writer = new FileWriter("contacts_byGroup.txt", true)){
				
				for(Map.Entry<String, ArrayList<String>> eachGroup : hMap.entrySet()) {
					
					String line = eachGroup.getKey() + "\t" + eachGroup.getValue() + "\n";
					
					writer.write(line);
				}
				
			}
			catch (IOException e) {
				System.out.println(e.getMessage());
			}			
		}

		return ;
	}
	
		
	public void getContactsByAscOrder(String output) {
		
		List<Contact> contactList = getContactsAsList();
		
		HashMap<String, ArrayList<Contact>> hMap = new HashMap<String,ArrayList<Contact>>();
		
		for(Contact contact : contactList) {
			
			if(hMap.containsKey(contact.getContactGroup())) {
				
				hMap.get(contact.getContactGroup()).add(contact);
			}
			else {
				ArrayList<Contact> newContactGroup = new ArrayList<>();
				newContactGroup.add(contact);
				
				hMap.put(contact.getContactGroup(), newContactGroup);
			}
		}
		
		List<Map.Entry<String, ArrayList<Contact>> > listSortedByGroupSize = 
	               new ArrayList<Map.Entry<String, ArrayList<Contact>> >(hMap.entrySet()); 

		Collections.sort(listSortedByGroupSize, new Comparator<Map.Entry<String, ArrayList<Contact>> >() { 
            
			public int compare(Map.Entry<String, ArrayList<Contact>> o1,  
                               Map.Entry<String, ArrayList<Contact>> o2) { 
                return ( o1.getValue().size()  -  o2.getValue().size() ); 
            } 
        });
		
		
		if(output.equalsIgnoreCase("Console")) {

			for(Map.Entry<String, ArrayList<Contact>> eachGroup : listSortedByGroupSize) {
			
				System.out.println("\n" + eachGroup.getKey() + "\t" + eachGroup.getValue().size());
				
				eachGroup.getValue().stream().
				forEach(elem -> System.out.println(elem.getContactName() + "\t" + elem.getContactMobileNumber()));
			}
		}
		else {
			
			try(FileWriter writer = new FileWriter("contacts_byAscOrderGroupSize.txt", true)){
				
				for(Map.Entry<String, ArrayList<Contact>> eachGroup : listSortedByGroupSize) {
					
					writer.write("\n" + eachGroup.getKey() + "\t" + eachGroup.getValue().size() + "\n");
					
					for(Contact contact : eachGroup.getValue()) {
						
						writer.write(contact.getContactName() + "\t" + contact.getContactMobileNumber()+ "\n");
					}
				}
				
			}
			catch (IOException e) {
				System.out.println(e.getMessage());
			}			
		}
				
		return ;	
	}
	
		
	private void printToFile(Map<String,? super Object> res, String fileName) {
		
		try(FileWriter writer = new FileWriter(fileName, true)){
			
			for(Entry<String, Object> eachRes : res.entrySet()) {
				
				String line = eachRes.getKey() + "\t" + eachRes.getValue() + "\n";
				
				writer.write(line);
			}
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		return ;
	}
	
	
	private void printToConsole(Map<String,? super Object> res) {
		
		for(Entry<String, Object> eachRes : res.entrySet()) {
			System.out.println(eachRes.getKey() + "\t" + eachRes.getValue());
		}
		
		return ;
	}
	
	
	private List<Contact> getContactsAsList(){
		
		List<Contact> contactList = new ArrayList<>();

		if(con != null) {
			String sqlQuery = "select * from contact";
			
			try(PreparedStatement pstmt = con.prepareStatement(sqlQuery)){
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					String contactName = rs.getString("contactName");
					String contactAddress = rs.getString("contactAddress");
					String contactMobileNumber = rs.getString("contactMobileNumber");
					String contactProfilePicture = rs.getString("contactProfilePicture");
					LocalDate contactDateOfBirth = rs.getDate("contactDateOfBirth").toLocalDate();
					String contactEmail = rs.getString("contactEmail");
					String contactGroup = rs.getString("contactGroup");
					
					Contact contact = new Contact(contactName, contactAddress, contactMobileNumber, 
							contactProfilePicture, contactDateOfBirth, contactEmail, contactGroup);
					
					contactList.add(contact);
				}
				
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return contactList;
	}
}
