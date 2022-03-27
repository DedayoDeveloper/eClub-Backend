package com.university.of.hull.eportal.serviceimpl;

import com.university.of.hull.eportal.datamodel.Mail;
import com.university.of.hull.eportal.repository.ClubRepository;
import com.university.of.hull.eportal.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.university.of.hull.eportal.dataentity.Users;
import com.university.of.hull.eportal.datamodel.login.LoginRequest;
import com.university.of.hull.eportal.datamodel.signup.SignUpResponse;
import com.university.of.hull.eportal.datamodel.signup.UserSignUpRequest;
import com.university.of.hull.eportal.extradata.Roles;
import com.university.of.hull.eportal.extradata.Status;
import com.university.of.hull.eportal.repository.UsersRepository;
import com.university.of.hull.eportal.service.UserService;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	ClubRepository clubRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private GeneralService generalService;


	@Override
	public SignUpResponse signUpUser(UserSignUpRequest signUpRequest) {
		SignUpResponse signUpResponse = new SignUpResponse();
		
		Users userSignUp = new Users();
		userSignUp.setFirstName(signUpRequest.getFirstName());
		userSignUp.setLastName(signUpRequest.getLastName());
		userSignUp.setPreferredName(signUpRequest.getPreferredName());
		userSignUp.setGender(signUpRequest.getGender());
		userSignUp.setDateOfBirth(signUpRequest.getDateOfBirth());
		userSignUp.setCountry(signUpRequest.getCountry());
		userSignUp.setState(signUpRequest.getState());
		userSignUp.setZipCode(signUpRequest.getZipCode());
		userSignUp.setEmailAddress(signUpRequest.getEmailAddress());
		userSignUp.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
		userSignUp.setPhoneNumber(signUpRequest.getPhoneNumber());
		userSignUp.setUserRole(Roles.Member);
		userSignUp.setUserStatus(Status.Active);
		if (usersRepository.findByEmailAddress(signUpRequest.getEmailAddress()) == null) {
			Users users = usersRepository.save(userSignUp);
			if (users != null) {
				generalService.sendMailMessage(signUpRequest.getEmailAddress(),"Welcome to eClub", "Thank you for registering with eClub portal");
				signUpResponse.setMessage("User Created Succesfully");
			}
		}else {
			signUpResponse.setMessage("Email registered to an existing user! Please use new email");
			throw new RuntimeException("Email registered to an existing user! Please use new email");

		}
		return signUpResponse;
	}





}
