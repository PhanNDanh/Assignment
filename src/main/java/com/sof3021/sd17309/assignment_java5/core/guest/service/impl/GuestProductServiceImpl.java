package com.sof3021.sd17309.assignment_java5.core.guest.service.impl;

import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminProductResponse;
import com.sof3021.sd17309.assignment_java5.core.admin.repository.AdminProductRepository;
import com.sof3021.sd17309.assignment_java5.core.admin.service.AdminProductService;
import com.sof3021.sd17309.assignment_java5.core.guest.model.response.GuestProductResponse;
import com.sof3021.sd17309.assignment_java5.core.guest.repository.GuestProductRepository;
import com.sof3021.sd17309.assignment_java5.core.guest.service.GuestProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestProductServiceImpl implements GuestProductService {

    @Autowired
    private GuestProductRepository guestProductRepository;


    @Override
    public List<GuestProductResponse> getAllProduct() {
        return guestProductRepository.getAllProduct();
    }
}
