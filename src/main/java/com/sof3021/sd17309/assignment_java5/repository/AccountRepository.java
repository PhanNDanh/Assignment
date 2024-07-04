package com.sof3021.sd17309.assignment_java5.repository;

import com.sof3021.sd17309.assignment_java5.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {
}
