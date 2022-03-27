package com.university.of.hull.eportal.restcontroller;


import com.university.of.hull.eportal.datamodel.events.JoinEventRequest;
import com.university.of.hull.eportal.datamodel.events.JoinEventResonse;
import com.university.of.hull.eportal.service.ClubService;
import com.university.of.hull.eportal.service.GeneralService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.university.of.hull.eportal.datamodel.ApiResponse;
import com.university.of.hull.eportal.datamodel.login.LoginRequest;
import com.university.of.hull.eportal.datamodel.login.LoginResponse;
import com.university.of.hull.eportal.datamodel.signup.SignUpResponse;
import com.university.of.hull.eportal.datamodel.signup.UserSignUpRequest;
import com.university.of.hull.eportal.service.UserService;
import com.university.of.hull.eportal.serviceimpl.EclubUserDetailsServiceImpl;
import com.university.of.hull.eportal.webtoken.JwtUtil;

@RestController
@RequestMapping(value = "/e-portal")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	GeneralService generalService;

	@Autowired
	ClubService clubService;

	@Autowired
	private EclubUserDetailsServiceImpl userDetailsService;

	@Autowired
	private AuthenticationManager authenticationmanager;


	@Autowired
	private JwtUtil jwttokenutil;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest) throws Exception {
		try {
			authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmailAddress(),  authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new RuntimeException("Wrong credentials");
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmailAddress());
		generalService.validateUser(authenticationRequest);
		if (userDetails == null) {
			throw new RuntimeException("User does not exist.");
		}

		try{
			ObjectMapper mapper = new ObjectMapper();
			logger.info(mapper.writeValueAsString(userDetails));
		}catch (Exception e){

		}
		final String jwt = jwttokenutil.generateToken(userDetails);
		return ResponseEntity.ok(new LoginResponse("User Successfully Logged in",jwt));
	}



	@PostMapping(value = "/usersignup")
	public ApiResponse<String> signUp(@RequestBody UserSignUpRequest signUpRequest){
		ApiResponse<String> u = new ApiResponse<>();
		SignUpResponse signUpResponse = userService.signUpUser(signUpRequest);
		u.setMessage("Success");
		u.setResponsecode("00");
		u.setStatus(HttpStatus.OK);
		u.setResponse(signUpResponse.getMessage());
		return u;
	}


	@PostMapping(value = "/joinevent")
	public ApiResponse<String> joinevent(@RequestBody JoinEventRequest joinEventRequest){
		ApiResponse<String> apiResponse = new ApiResponse<>();
		JoinEventResonse joinEventResonse = clubService.joinEvent(joinEventRequest);
		apiResponse.setMessage("Success");
		apiResponse.setResponsecode("00");
		apiResponse.setStatus(HttpStatus.OK);
		apiResponse.setResponse(joinEventResonse.getMessage());
		return apiResponse;
	}

}
