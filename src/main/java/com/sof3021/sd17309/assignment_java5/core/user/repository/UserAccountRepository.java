package com.sof3021.sd17309.assignment_java5.core.user.repository;

import com.sof3021.sd17309.assignment_java5.core.user.model.response.UserAccountResponse;
import com.sof3021.sd17309.assignment_java5.repository.AccountRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserAccountRepository extends AccountRepository {

    @Query(nativeQuery = true, value = """
            SELECT id,username,role FROM account where username = :username and password = :password """)
    UserAccountResponse checkLoginResponse(@Param("username") String username, @Param("password") String password);

    @Query(nativeQuery = true, value = """
            SELECT email FROM account where email = :email""")
    String checkEmail(@Param("email") String email);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Account SET passWord = :password WHERE email = :email")
    void updatePassword(@Param("email") String email, @Param("password") String password);

}
