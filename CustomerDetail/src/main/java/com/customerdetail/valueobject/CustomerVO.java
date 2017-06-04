package com.customerdetail.valueobject;

import java.util.Date;

public class CustomerVO {
	
	public CustomerVO() {

	}
	
	public CustomerVO(String internalCustomerId, String firstName, 
			String lastName, String userName, String email, 
			String phoneNumber) {

		this.internalCustomerId = internalCustomerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	//	this.createdDateTime = createdDateTime;
		
	}
	
	private String internalCustomerId;

	//@Size(min=3, max=30) 
	private String firstName;

	//@Size(min=3, max=30) 
	private String lastName;
	
	//@Size(min=3, max=30) 
	private String userName = "user name";
	
	/*@DateTimeFormat(pattern="dd/MM/yyyy") 
	@Past @NotNull
	private Date dob;*/
	
//	@Email @NotEmpty
	private String email;
	
//	@NotEmpty
	private String phoneNumber = "1234567890";
	
//	private Date createdDateTime;
	
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
