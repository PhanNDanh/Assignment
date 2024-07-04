package com.sof3021.sd17309.assignment_java5.core.user.controller;

import com.sof3021.sd17309.assignment_java5.core.user.service.UserCartService;
import com.sof3021.sd17309.assignment_java5.core.user.model.response.UserCartResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Assignment-Java5/user/")
@CrossOrigin("*")
public class UserCartRestController {

    @Autowired
    private UserCartService userCartService;

    @GetMapping("getAllProduct-InCart")
    public UserCartResponse getAll() {
        return userCartService.cartView();
    }

    @PostMapping("add-Product/{id}")
    public Boolean add(@PathVariable("id") String productId, Integer quantity) {
        return userCartService.addToCart(productId, quantity);
    }

    @PostMapping("update-Product/{id}")
    public Boolean update(@PathVariable("id") String productId, Integer quantity) {
        return userCartService.updateToCart(productId, quantity);
    }

    @DeleteMapping("delete-Product/{id}")
    public Boolean delete(@PathVariable("id") String productId, @RequestParam(value = "quantity", required = false) Integer quantity) {
        return userCartService.deleteFromCart(productId, quantity);
    }
}
