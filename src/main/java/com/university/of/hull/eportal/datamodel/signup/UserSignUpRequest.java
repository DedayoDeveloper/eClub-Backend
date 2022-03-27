package com.university.of.hull.eportal.datamodel.signup;

import java.util.Date;
import com.university.of.hull.eportal.dataentity.Clubs;
import com.university.of.hull.eportal.extradata.Country;
import com.university.of.hull.eportal.extradata.Roles;
import com.university.of.hull.eportal.extradata.Status;

public class UserSignUpRequest {

    private Roles userRole;
	private Status userStatus;
    private Clubs club;
    private String firstName;
	private String lastName;
	private String preferredName;
	private String gender;
	private Date dateOfBirth;
	private Country country;
	private String password;
	private String state;
	private String zipCode;
	private String emailAddress;
	private String phoneNumber;

	public Roles getUserRole() {
		return userRole;
	}

	public void setUserRole(Roles userRole) {
		this.userRole = userRole;
	}

	public Status getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Status userStatus) {
		this.userStatus = userStatus;
	}

	public Clubs getClub() {
		return club;
	}

	public void setClub(Clubs club) {
		this.club = club;
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

	public String getPreferredName() {
		return preferredName;
	}

	public void setPreferredName(String preferredName) {
		this.preferredName = preferredName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
