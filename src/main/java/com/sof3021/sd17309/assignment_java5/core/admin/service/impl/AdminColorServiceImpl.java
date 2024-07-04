package com.sof3021.sd17309.assignment_java5.core.admin.service.impl;

import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminColorResponse;
import com.sof3021.sd17309.assignment_java5.core.admin.repository.AdminColorRepository;
import com.sof3021.sd17309.assignment_java5.core.admin.service.AdminColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminColorServiceImpl implements AdminColorService {

    @Autowired
    private AdminColorRepository adminColorRepository;
    @Override
    public List<AdminColorResponse> getAllColor() {
        return adminColorRepository.getAllColor();
    }
}
