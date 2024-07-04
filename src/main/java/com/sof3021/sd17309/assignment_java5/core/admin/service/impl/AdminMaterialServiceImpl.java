package com.sof3021.sd17309.assignment_java5.core.admin.service.impl;

import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminMaterialResponse;
import com.sof3021.sd17309.assignment_java5.core.admin.repository.AdminMaterialRepository;
import com.sof3021.sd17309.assignment_java5.core.admin.service.AdminMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminMaterialServiceImpl implements AdminMaterialService {

    @Autowired
    private AdminMaterialRepository adminMaterialRepository;
    @Override
    public List<AdminMaterialResponse> getAllMaterial() {
        return adminMaterialRepository.getAllMaterial();
    }
}
