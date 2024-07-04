package com.sof3021.sd17309.assignment_java5.core.user.controller;

import com.sof3021.sd17309.assignment_java5.core.user.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Assignment-Java5/user/")
@CrossOrigin("*")
public class UserOrderRestController {

    @Autowired
    private UserOrderService userOrderService;

    @PostMapping("create-Bill")
    public void createBill(String idAccount){
        userOrderService.createBIll(idAccount);
    }

}
