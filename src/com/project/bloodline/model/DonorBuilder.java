package com.project.bloodline.model;

import java.util.Date;

public class DonorBuilder {
	private String firstName;
	private String lastName;
	private String dob;
	private String sex;
	private String bloodGroup;
	private String country;
	private String state;
	private String street;
	private String email;
	private String phone;
	private String availability = "YES";

	public DonorBuilder() {
		
	}
	
	public DonorBuilder setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public DonorBuilder setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public DonorBuilder setDob(String dob) {
		this.dob = dob;
		return this;
	}

	public DonorBuilder setSex(String sex) {
		this.sex = sex;
		return this;
	}

	public DonorBuilder setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
		return this;
	}

	public DonorBuilder setCountry(String country) {
		this.country = country;
		return this;
	}

	public DonorBuilder setState(String state) {
		this.state = state;
		return this;
	}

	public DonorBuilder setStreet(String street) {
		this.street = street;
		return this;
	}

	public DonorBuilder setEmail(String email) {
		this.email = email;
		return this;
	}

	public DonorBuilder setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	
	public DonorBuilder setAvailability(String availability) {
		this.availability = availability;
		return this;
	}
	
	public Donor build() {
		return new Donor(firstName, lastName, dob, sex, bloodGroup, country, state, street, email, phone, availability);
	}
}
