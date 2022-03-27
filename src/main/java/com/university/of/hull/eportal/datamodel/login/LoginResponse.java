package com.university.of.hull.eportal.datamodel.login;

public class LoginResponse {

	public LoginResponse(String message,String token) {
		this.message = message;
		this.token = token;
	}

	private String token;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
