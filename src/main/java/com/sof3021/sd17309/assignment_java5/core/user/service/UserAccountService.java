package com.sof3021.sd17309.assignment_java5.core.user.service;

import com.sof3021.sd17309.assignment_java5.core.user.model.request.UserAccountLoginRequest;
import com.sof3021.sd17309.assignment_java5.core.user.model.request.UserAccountUpdatePasswordByEmailRequest;
import com.sof3021.sd17309.assignment_java5.core.user.model.response.UserAccountResponse;

public interface UserAccountService {
    UserAccountResponse checkLogin(UserAccountLoginRequest request);

    Boolean checkEmail(String email);

    void sendMail(String toEmai);

    Boolean checkCode(Integer code);

    Boolean updatePasswordByEmail(UserAccountUpdatePasswordByEmailRequest request);
    

}
