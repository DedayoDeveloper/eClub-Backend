package com.university.of.hull.eportal.datamodel.signup;

import java.util.List;

import com.university.of.hull.eportal.datamodel.Message;

public class FetchClubsResponse extends Message{
	
	List<ClubSignUpRequest> registerdClubs;

	public List<ClubSignUpRequest> getRegisterdClubs() {
		return registerdClubs;
	}

	public void setRegisterdClubs(List<ClubSignUpRequest> registerdClubs) {
		this.registerdClubs = registerdClubs;
	}

}
