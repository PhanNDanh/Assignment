package com.sof3021.sd17309.assignment_java5.core.user.service.impl;

import com.sof3021.sd17309.assignment_java5.core.user.model.request.UserAccountLoginRequest;
import com.sof3021.sd17309.assignment_java5.core.user.model.request.UserAccountUpdatePasswordByEmailRequest;
import com.sof3021.sd17309.assignment_java5.core.user.model.response.UserAccountResponse;
import com.sof3021.sd17309.assignment_java5.core.user.repository.UserAccountRepository;
import com.sof3021.sd17309.assignment_java5.core.user.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private JavaMailSender mailSender;

    private int codeTemp = 0;

    @Override
    public UserAccountResponse checkLogin(UserAccountLoginRequest request) {
        UserAccountResponse userAccountResponse = userAccountRepository.checkLoginResponse(request.getUsername(), request.getPassword());
        return userAccountResponse;
    }

    @Override
    public Boolean checkEmail(String emmail) {
        if (userAccountRepository.checkEmail(emmail) != null) {
            return true;
        }
        return false;
    }

    @Override
    public void sendMail(String toEmai) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("danhpnph26382@fpt.edu.vn");
        int min = 1000;
        int max = 9999;
        Random random = new Random();
        int code = random.nextInt(max - min + 1) + min;
        codeTemp = code;
        message.setTo(toEmai);
        message.setText("Your verification code is " + code);
        message.setSubject("Confirm Email");
        mailSender.send(message);
    }

    @Override
    public Boolean checkCode(Integer code) {
        if (code == codeTemp) {
            codeTemp = 0;
            return true;
        }
        return false;
    }

    @Override
    public Boolean updatePasswordByEmail(UserAccountUpdatePasswordByEmailRequest request) {
        if(request.getPassword1().equals(request.getPassword2())){
            userAccountRepository.updatePassword(request.getEmail(), request.getPassword1());
            return true;
        }
        return false;
    }
}
