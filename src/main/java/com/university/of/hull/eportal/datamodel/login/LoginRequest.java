package com.university.of.hull.eportal.datamodel.login;

import com.university.of.hull.eportal.extradata.Roles;
import com.university.of.hull.eportal.extradata.Status;

public class LoginRequest {

	private String emailAddress;
	private String password;
	private Roles role;

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}
}
