package com.sof3021.sd17309.assignment_java5.core.user.model.response;

import com.sof3021.sd17309.assignment_java5.entity.Account;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Account.class)
public interface UserAccountResponse {
    @Value("#{target.id}")
    String getId();

    @Value("#{target.username}")
    String getUserName();

    @Value("#{target.role}")
    Integer getRole();

}
