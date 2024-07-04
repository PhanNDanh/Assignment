package com.sof3021.sd17309.assignment_java5.core.guest.controller;

import com.sof3021.sd17309.assignment_java5.core.guest.model.response.GuestSizeResponse;
import com.sof3021.sd17309.assignment_java5.core.guest.service.GuestSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Assignment-Java5/guest/")
@CrossOrigin("*")
public class GuestSizeRestController {

    @Autowired
    private GuestSizeService guestSizeService;

    @GetMapping("getAll-Size")
    public List<GuestSizeResponse> getAll(){
       return guestSizeService.getAllSize();
    }
}
