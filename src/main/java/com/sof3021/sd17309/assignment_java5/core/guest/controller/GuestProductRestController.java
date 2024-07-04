package com.sof3021.sd17309.assignment_java5.core.guest.controller;

import com.sof3021.sd17309.assignment_java5.core.guest.model.response.GuestProductResponse;
import com.sof3021.sd17309.assignment_java5.core.guest.service.GuestProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Assignment-Java5/guest/")
@CrossOrigin("*")
public class GuestProductRestController {

    @Autowired
    private GuestProductService guestProductService;

    @GetMapping("getAll-Product")
    public List<GuestProductResponse> getAll(){
        return guestProductService.getAllProduct();
    }
}
