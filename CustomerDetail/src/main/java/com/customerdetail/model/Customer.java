package com.customerdetail.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4798786549279089452L;
	
	private String internalCustomerId;

	@Size(min=3, max=30) 
	private String firstName;

	@Size(min=3, max=30) 
	private String lastName;
	
	@Size(min=3, max=30) 
	private String userName = "user name";
	
	/*@DateTimeFormat(pattern="dd/MM/yyyy") 
	@Past @NotNull
	private Date dob;*/
	
	@Email @NotEmpty
	private String email;
	
	@NotEmpty
	private String phoneNumber = "1234567890";

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInternalCustomerId() {
		return internalCustomerId;
	}

	public void setInternalCustomerId(String internalCustomerId) {
		this.internalCustomerId = internalCustomerId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email
				+ "]";
	}
	
	

}

