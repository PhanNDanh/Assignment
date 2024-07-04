package com.sof3021.sd17309.assignment_java5.core.admin.service.impl;

import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminProductResponse;
import com.sof3021.sd17309.assignment_java5.core.admin.repository.AdminProductRepository;
import com.sof3021.sd17309.assignment_java5.core.admin.service.AdminProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminProductServiceImpl implements AdminProductService {

    @Autowired
    private AdminProductRepository adminProductRepository;


    @Override
    public List<AdminProductResponse> getAllProduct() {
        return adminProductRepository.getAllProduct();
    }
}
