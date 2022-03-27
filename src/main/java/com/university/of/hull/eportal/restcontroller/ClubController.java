package com.university.of.hull.eportal.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.university.of.hull.eportal.datamodel.ApiResponse;
import com.university.of.hull.eportal.datamodel.events.CreateEventRequest;
import com.university.of.hull.eportal.datamodel.events.CreateEventResponse;
import com.university.of.hull.eportal.datamodel.events.FetchEventResponse;
import com.university.of.hull.eportal.datamodel.events.JoinEventRequest;
import com.university.of.hull.eportal.datamodel.events.JoinEventResonse;
import com.university.of.hull.eportal.datamodel.signup.ClubSignUpRequest;
import com.university.of.hull.eportal.datamodel.signup.FetchClubsResponse;
import com.university.of.hull.eportal.datamodel.signup.SignUpResponse;
import com.university.of.hull.eportal.service.ClubService;
import com.university.of.hull.eportal.service.UserService;
import com.university.of.hull.eportal.serviceimpl.EclubUserDetailsServiceImpl;
import com.university.of.hull.eportal.webtoken.JwtUtil;

@RestController
@RequestMapping(value = "/e-portal")
public class ClubController {
	
	@Autowired
	ClubService clubService;

	@Autowired
	private AuthenticationManager authenticationmanager;

	@Autowired
	private EclubUserDetailsServiceImpl userDetailsService;

	@Autowired
	UserService userService;

	@Autowired
	private JwtUtil jwttokenutil;

	private static final Logger logger = LoggerFactory.getLogger(ClubController.class);

	
	@PostMapping(value = "/clubsignup")
	public ApiResponse<String> clubSignUp(@RequestBody ClubSignUpRequest clubSignUpRequest){
		ApiResponse<String> apiResponse = new ApiResponse<>();
		SignUpResponse signUpResponse = clubService.clubSignUp(clubSignUpRequest);
		apiResponse.setMessage("Success");
		apiResponse.setResponsecode("00");
		apiResponse.setStatus(HttpStatus.OK);
		apiResponse.setResponse(signUpResponse.getMessage());
		return apiResponse;
	}
	
	@PostMapping(value = "/createevent")
	public ApiResponse<String> createEvent(@RequestBody CreateEventRequest createEventRequest){
		ApiResponse<String> apiResponse = new ApiResponse<>();
		CreateEventResponse createEventResponse = clubService.createEvent(createEventRequest);
		apiResponse.setMessage("Success");
		apiResponse.setResponsecode("00");
		apiResponse.setStatus(HttpStatus.OK);
		apiResponse.setResponse(createEventResponse.getMessage());
		return apiResponse;
	}
	
	@GetMapping(value = "/fetcheventbyeventid")
	public ApiResponse<FetchEventResponse> fetchEventByEventId(@RequestParam(name = "eventId") Long eventId){
		ApiResponse<FetchEventResponse> apiResponse = new ApiResponse<>();
		FetchEventResponse fetchEventResponse = clubService.fetchEventByEventId(eventId);
		apiResponse.setMessage("Success");
		apiResponse.setResponsecode("00");
		apiResponse.setStatus(HttpStatus.OK);
		apiResponse.setResponse(fetchEventResponse);
		return apiResponse;
	}

	@GetMapping(value = "/fetcheventbyclubid")
	public ApiResponse<FetchEventResponse> fetchEventByClubId(@RequestParam(name = "clubId") String clubId){
		ApiResponse<FetchEventResponse> apiResponse = new ApiResponse<>();
		FetchEventResponse fetchEventResponse = clubService.fetchEventByClubId(clubId);
		apiResponse.setMessage("Success");
		apiResponse.setResponsecode("00");
		apiResponse.setStatus(HttpStatus.OK);
		apiResponse.setResponse(fetchEventResponse);
		return apiResponse;
	}
	
	@GetMapping(value = "/fetchclubs")
	public ApiResponse<FetchClubsResponse> fetchClubs(){
		ApiResponse<FetchClubsResponse> apiResponse = new ApiResponse<>();
		FetchClubsResponse fetchClubsResponse = clubService.fetchClubs();
		apiResponse.setMessage("Success");
		apiResponse.setResponsecode("00");
		apiResponse.setStatus(HttpStatus.OK);
		apiResponse.setResponse(fetchClubsResponse);
		return apiResponse;
	}
	

	
}
