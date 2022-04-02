package com.project.bloodline.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "donor")
@XmlRootElement()
public class Donor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
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
	private String availability;

	private static final long serialVersionUID = 1L;
	
	public Donor() {
		super();
	}
	
	public Donor(int id, String firstName, String lastName, String dob, String sex, String bloodGroup, String country,
			String state, String street, String availability) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.sex = sex;
		this.bloodGroup = bloodGroup;
		this.country = country;
		this.state = state;
		this.street = street;
		this.availability = availability;
	}
	
	public Donor(String firstName, String lastName, String dob, String sex, String bloodGroup, String country,
			String state, String street, String email, String phone, String availability) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.sex = sex;
		this.bloodGroup = bloodGroup;
		this.country = country;
		this.state = state;
		this.street = street;
		this.email = email;
		this.phone = phone;
		this.availability = availability;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "Donor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", sex="
				+ sex + ", bloodGroup=" + bloodGroup + ", country=" + country + ", state=" + state + ", street="
				+ street + ", email=" + email + ", phone=" + phone + ", availability=" + availability + "]";
	}
}
