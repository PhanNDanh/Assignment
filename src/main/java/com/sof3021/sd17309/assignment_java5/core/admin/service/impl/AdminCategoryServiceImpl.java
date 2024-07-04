package com.sof3021.sd17309.assignment_java5.core.admin.service.impl;

import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminCategoryResponse;
import com.sof3021.sd17309.assignment_java5.core.admin.repository.AdminCategoryRepository;
import com.sof3021.sd17309.assignment_java5.core.admin.service.AdminCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminCategoryServiceImpl implements AdminCategoryService {

    @Autowired
    private AdminCategoryRepository adminCategoryRepository;

    @Override
    public List<AdminCategoryResponse> getAllCategory() {
        return adminCategoryRepository.getAllCategory();
    }
}
