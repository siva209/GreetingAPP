package com.greeting.model;

public class User {
	private String firstName;
	private String lastName;
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
	@Override
	public String toString() {
		String name = (this.firstName != null ? this.firstName : "") + " " + (this.lastName != null ? this.lastName : "");
		return name;
	}
}

