package com.university.of.hull.eportal.service;

import com.university.of.hull.eportal.datamodel.Mail;
import com.university.of.hull.eportal.datamodel.login.LoginRequest;

public interface GeneralService {

    void validateUser(LoginRequest loginData);

     void sendEmail(Mail mail);

    void sendMailMessage(String email,String subject,String body);
}
