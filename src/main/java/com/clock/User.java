package com.clock;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class User {
	private long id, clockID;
	private String firstName, lastName, email, password;
	
	public User(long id, String firstName, String lastName, String email, String password, long clockID){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.clockID = clockID;
	}
	
	@Override
	public String toString() {
		return String.format(
				"User[id=%d, firstName='%s', lastName='%s', email='%s', password = '%s', clockID=%d]",
				id, firstName, lastName, email, password, clockID );
	}
	public String getFirstName() {
		return firstName;
	}
	public long getId() {
		return id;
	}
	public String getLastName() {
		return lastName;
	}
	public long getClockID() {
		return clockID;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setClockID(long clockID) {
		this.clockID = clockID;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
