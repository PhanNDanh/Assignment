package com.sof3021.sd17309.assignment_java5.core.user.controller;

import com.sof3021.sd17309.assignment_java5.core.commom.base.response.ResponseObject;
import com.sof3021.sd17309.assignment_java5.core.user.model.request.UserAccountLoginRequest;
import com.sof3021.sd17309.assignment_java5.core.user.model.request.UserAccountUpdatePasswordByEmailRequest;
import com.sof3021.sd17309.assignment_java5.core.user.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Assignment-Java5/user/")
@CrossOrigin("*")
public class UserAcountRestController {
    @Autowired
    private UserAccountService userAccountService;


    @PostMapping("checkAccount-response")
    public ResponseObject getAccountResponse(@RequestBody UserAccountLoginRequest request) {
        return new ResponseObject(userAccountService.checkLogin(request));
    }

    @PostMapping("checkEmail")
    public Boolean checkEmail(@RequestBody String email) {
        return userAccountService.checkEmail(email);
    }

    @PostMapping("sendMail")
    public void sendMail(@RequestBody String toEmail) {
        userAccountService.sendMail(toEmail);
    }

    @PostMapping("checkCode")
    public Boolean checkCode(@RequestBody Integer code) {
       return userAccountService.checkCode(code);
    }

    @PutMapping("update-paswordByEmail")
    public Boolean updatePasswordbyEmail(@RequestBody UserAccountUpdatePasswordByEmailRequest request) {
        return userAccountService.updatePasswordByEmail(request);
    }


}
