package com.sof3021.sd17309.assignment_java5.core.guest.service.impl;

import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminMaterialResponse;
import com.sof3021.sd17309.assignment_java5.core.admin.repository.AdminMaterialRepository;
import com.sof3021.sd17309.assignment_java5.core.admin.service.AdminMaterialService;
import com.sof3021.sd17309.assignment_java5.core.guest.model.response.GuestMaterialResponse;
import com.sof3021.sd17309.assignment_java5.core.guest.repository.GuestMaterialRepository;
import com.sof3021.sd17309.assignment_java5.core.guest.service.GuestMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestMaterialServiceImpl implements GuestMaterialService {

    @Autowired
    private GuestMaterialRepository guestMaterialRepository;
    @Override
    public List<GuestMaterialResponse> getAllMaterial() {
        return guestMaterialRepository.getAllMaterial();
    }
}
