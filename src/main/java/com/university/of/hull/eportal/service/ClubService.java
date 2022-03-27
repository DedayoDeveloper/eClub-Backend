package com.university.of.hull.eportal.service;

import com.university.of.hull.eportal.datamodel.events.CreateEventRequest;
import com.university.of.hull.eportal.datamodel.events.CreateEventResponse;
import com.university.of.hull.eportal.datamodel.events.FetchEventResponse;
import com.university.of.hull.eportal.datamodel.events.JoinEventRequest;
import com.university.of.hull.eportal.datamodel.events.JoinEventResonse;
import com.university.of.hull.eportal.datamodel.signup.ClubSignUpRequest;
import com.university.of.hull.eportal.datamodel.signup.FetchClubsResponse;
import com.university.of.hull.eportal.datamodel.signup.SignUpResponse;

public interface ClubService {

	SignUpResponse clubSignUp(ClubSignUpRequest clubSignUpRequest);

	CreateEventResponse createEvent(CreateEventRequest createEventRequest);

	FetchEventResponse fetchEventByEventId(Long eventId);

	FetchEventResponse fetchEventByClubId(String clubId);

	FetchClubsResponse fetchClubs();

	JoinEventResonse joinEvent(JoinEventRequest joinEventRequest);

}
