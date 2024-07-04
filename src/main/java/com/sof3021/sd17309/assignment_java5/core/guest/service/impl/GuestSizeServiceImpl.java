package com.sof3021.sd17309.assignment_java5.core.guest.service.impl;

import com.sof3021.sd17309.assignment_java5.core.guest.model.response.GuestSizeResponse;
import com.sof3021.sd17309.assignment_java5.core.guest.repository.GuestSizeRepository;
import com.sof3021.sd17309.assignment_java5.core.guest.service.GuestSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestSizeServiceImpl implements GuestSizeService {

    @Autowired
    private GuestSizeRepository guestSizeRepository;
    @Override
    public List<GuestSizeResponse> getAllSize() {
        return guestSizeRepository.getAllSize();
    }
}
