package com.sof3021.sd17309.assignment_java5.core.guest.service.impl;

import com.sof3021.sd17309.assignment_java5.core.guest.model.response.GuestCategoryResponse;
import com.sof3021.sd17309.assignment_java5.core.guest.repository.GuestCategoryRepository;
import com.sof3021.sd17309.assignment_java5.core.guest.service.GuestCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestCategoryServiceImpl implements GuestCategoryService {

    @Autowired
    private GuestCategoryRepository guestCategoryRepository;

    @Override
    public List<GuestCategoryResponse> getAllCategory() {
        return guestCategoryRepository.getAllCategory();
    }
}
