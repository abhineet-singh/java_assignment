package com.training.model;

import java.time.LocalDate;

public class BloodDonor {
	
		private String name;
		private int age;
		private String gender;
		private String bloodGroup;
		private String phoneNumber;
		private String email;
		private LocalDate dateOfBirth;
		
		@Override
		public String toString() {
			return "BloodDonor [name=" + name + ", age=" + age + ", gender=" + gender + ", bloodGroup=" + bloodGroup
					+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", dateOfBirth=" + dateOfBirth + "]";
		}

		public BloodDonor(String name, int age, String gender, String bloodGroup, String phoneNumber, String email,
				LocalDate dateOfBirth) {
			super();
			this.name = name;
			this.age = age;
			this.gender = gender;
			this.bloodGroup = bloodGroup;
			this.phoneNumber = phoneNumber;
			this.email = email;
			this.dateOfBirth = dateOfBirth;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getBloodGroup() {
			return bloodGroup;
		}

		public void setBloodGroup(String bloodGroup) {
			this.bloodGroup = bloodGroup;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public LocalDate getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		
}
