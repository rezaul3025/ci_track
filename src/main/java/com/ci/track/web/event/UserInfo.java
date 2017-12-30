package com.ci.track.web.event;

public class UserInfo {
	
	private Integer id;
	
	private String title;
	
	private String firstName;
	
	private String lastName;
	
	private String designation;
	
	private String drqualifications;
	
	private String userName;
	
	private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDrqualifications() {
		return drqualifications;
	}

	public void setDrqualifications(String drqualifications) {
		this.drqualifications = drqualifications;
	}
	
}
