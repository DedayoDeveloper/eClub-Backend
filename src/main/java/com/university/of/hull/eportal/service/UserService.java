package com.university.of.hull.eportal.service;

import com.university.of.hull.eportal.datamodel.login.LoginRequest;
import com.university.of.hull.eportal.datamodel.signup.SignUpResponse;
import com.university.of.hull.eportal.datamodel.signup.UserSignUpRequest;

public interface UserService {


	SignUpResponse signUpUser(UserSignUpRequest signUpRequest);

}
