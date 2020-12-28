package com.assignment.model;

import java.time.LocalDate;

public class Contact {
	
	private String contactName;
	private String contactAddress;
	private String contactMobileNumber;
	private String contactProfilePicture;
	private LocalDate contactDateOfBirth;
	private String contactEmail;
	private String contactGroup;
	
	
	public Contact(String contactName, String contactAddress, String contactMobileNumber, String contactProfilePicture,
			LocalDate contactDateOfBirth, String contactEmail, String contactGroup) {
		super();
		this.contactName = contactName;
		this.contactAddress = contactAddress;
		this.contactMobileNumber = contactMobileNumber;
		this.contactProfilePicture = contactProfilePicture;
		this.contactDateOfBirth = contactDateOfBirth;
		this.contactEmail = contactEmail;
		this.contactGroup = contactGroup;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getContactMobileNumber() {
		return contactMobileNumber;
	}

	public void setContactMobileNumber(String contactMobileNumber) {
		this.contactMobileNumber = contactMobileNumber;
	}

	public String getContactProfilePicture() {
		return contactProfilePicture;
	}

	public void setContactProfilePicture(String contactProfilePicture) {
		this.contactProfilePicture = contactProfilePicture;
	}

	public LocalDate getContactDateOfBirth() {
		return contactDateOfBirth;
	}

	public void setContactDateOfBirth(LocalDate contactDateOfBirth) {
		this.contactDateOfBirth = contactDateOfBirth;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactGroup() {
		return contactGroup;
	}

	public void setContactGroup(String contactGroup) {
		this.contactGroup = contactGroup;
	}

	@Override
	public String toString() {
		return "Contact [contactName=" + contactName + ", contactAddress=" + contactAddress + ", contactMobileNumber="
				+ contactMobileNumber + ", contactProfilePicture=" + contactProfilePicture + ", contactDateOfBirth="
				+ contactDateOfBirth + ", contactEmail=" + contactEmail + ", contactGroup=" + contactGroup + "]";
	}

}
