package com.sof3021.sd17309.assignment_java5.core.guest.controller;

import com.sof3021.sd17309.assignment_java5.core.guest.model.response.GuestColorResponse;
import com.sof3021.sd17309.assignment_java5.core.guest.service.GuestColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Assignment-Java5/guest/")
@CrossOrigin("*")
public class GuestColorRestController {

    @Autowired
    private GuestColorService guestColorService;

    @GetMapping("getAll-Color")
    public List<GuestColorResponse> getAll(){
       return guestColorService.getAllColor();
    }
}
