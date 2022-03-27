package com.university.of.hull.eportal.datamodel.signup;

import com.university.of.hull.eportal.extradata.Country;
import com.university.of.hull.eportal.extradata.Status;

public class ClubSignUpRequest {

	private String clubName;
	private String clubAddress;
	private String clubEmail;
	private String clubId;
	private String password;
	private Country country;
	private String clubContactNumber;
	private Status clubStatus;


	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String getClubAddress() {
		return clubAddress;
	}

	public void setClubAddress(String clubAddress) {
		this.clubAddress = clubAddress;
	}

	public String getClubEmail() {
		return clubEmail;
	}

	public void setClubEmail(String clubEmail) {
		this.clubEmail = clubEmail;
	}

	public String getClubId() {
		return clubId;
	}

	public void setClubId(String clubId) {
		this.clubId = clubId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getClubContactNumber() {
		return clubContactNumber;
	}

	public void setClubContactNumber(String clubContactNumber) {
		this.clubContactNumber = clubContactNumber;
	}

	public Status getClubStatus() {
		return clubStatus;
	}

	public void setClubStatus(Status clubStatus) {
		this.clubStatus = clubStatus;
	}
}
