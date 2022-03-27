package com.university.of.hull.eportal.serviceimpl;

import com.university.of.hull.eportal.datamodel.Mail;
import com.university.of.hull.eportal.datamodel.login.LoginRequest;
import com.university.of.hull.eportal.extradata.Roles;
import com.university.of.hull.eportal.extradata.Status;
import com.university.of.hull.eportal.repository.ClubRepository;
import com.university.of.hull.eportal.repository.UsersRepository;
import com.university.of.hull.eportal.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import java.io.UnsupportedEncodingException;
import javax.mail.MessagingException;
import org.springframework.stereotype.Service;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


@Service
public class GeneralServiceImpl implements GeneralService {


    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    ClubRepository clubRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void validateUser(LoginRequest loginData) {
        // verify the user exists in the system and active
        Roles userRole = loginData.getRole();
        String email = loginData.getEmailAddress();

        if(userRole.equals(Roles.Member)){
            Status status = usersRepository.getUserStatus(email);
            if (status.equals(Status.Deactivated)){
                throw new RuntimeException("Account Deactivated! Please contact administrator");
            }
            if (status.equals(Status.Pending)){
                throw new RuntimeException("Your Account is awaiting authorization, please bear with us");
            }

        }

        if (userRole.equals(Roles.Club)){
            Status status = clubRepository.getUserStatus(email);
            if (status.equals(Status.Deactivated)){
                throw new RuntimeException("Account Deactivated! Please contact administrator");
            }
            if (status.equals(Status.Pending)){
                throw new RuntimeException("Your Account is awaiting authorization, please bear with us");
            }
        }

    }



    @Override
    public void sendEmail(Mail mail) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setSubject(mail.getMailSubject());
            mimeMessageHelper.setFrom(new InternetAddress(mail.getMailFrom(), "eClub-Portal"));
            mimeMessageHelper.setTo(mail.getMailTo());
            mimeMessageHelper.setText(mail.getMailContent());

            mailSender.send(mimeMessageHelper.getMimeMessage());

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendMailMessage(String email,String subject,String body){
        Mail mail = new Mail();
        mail.setMailFrom("eClub-Portal");
        mail.setMailTo(email);
        mail.setMailSubject(subject);
        mail.setMailContent(body);
        sendEmail(mail);
    }


}


