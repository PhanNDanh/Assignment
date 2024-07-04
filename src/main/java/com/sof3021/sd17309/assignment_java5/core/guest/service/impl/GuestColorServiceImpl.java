package com.sof3021.sd17309.assignment_java5.core.guest.service.impl;

import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminColorResponse;
import com.sof3021.sd17309.assignment_java5.core.admin.repository.AdminColorRepository;
import com.sof3021.sd17309.assignment_java5.core.admin.service.AdminColorService;
import com.sof3021.sd17309.assignment_java5.core.guest.model.response.GuestColorResponse;
import com.sof3021.sd17309.assignment_java5.core.guest.repository.GuestColorRepository;
import com.sof3021.sd17309.assignment_java5.core.guest.service.GuestColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestColorServiceImpl implements GuestColorService {

    @Autowired
    private GuestColorRepository guestColorRepository;
    @Override
    public List<GuestColorResponse> getAllColor() {
        return guestColorRepository.getAllColor();
    }
}
