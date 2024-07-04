package com.sof3021.sd17309.assignment_java5.core.user.model.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class UserAccountUpdatePasswordByEmailRequest {

    private String email;

    private String password1;

    private String password2;

}
