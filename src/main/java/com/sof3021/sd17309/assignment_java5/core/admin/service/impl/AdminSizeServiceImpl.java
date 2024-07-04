package com.sof3021.sd17309.assignment_java5.core.admin.service.impl;

import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminSizeResponse;
import com.sof3021.sd17309.assignment_java5.core.admin.repository.AdminSizeRepository;
import com.sof3021.sd17309.assignment_java5.core.admin.service.AdminSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminSizeServiceImpl implements AdminSizeService {

    @Autowired
    private AdminSizeRepository adminSizeRepository;
    @Override
    public List<AdminSizeResponse> getAllSize() {
        return adminSizeRepository.getAllSize();
    }
}
