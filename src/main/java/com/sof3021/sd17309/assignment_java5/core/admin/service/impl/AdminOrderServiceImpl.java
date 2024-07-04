package com.sof3021.sd17309.assignment_java5.core.admin.service.impl;

import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminOrderDetailResponse;
import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminOrderResponse;
import com.sof3021.sd17309.assignment_java5.core.admin.repository.AdminOrderDetailRepository;
import com.sof3021.sd17309.assignment_java5.core.admin.repository.AdminOrderRepository;
import com.sof3021.sd17309.assignment_java5.core.admin.service.AdminOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminOrderServiceImpl implements AdminOrderService {

    @Autowired
    private AdminOrderRepository adminOrderRepository;

    @Autowired
    private AdminOrderDetailRepository adminOrderDetailRepository;

    @Override
    public List<AdminOrderResponse> getAllOrderResponse() {
        return adminOrderRepository.getAllOrderResponse();
    }

    @Override
    public List<AdminOrderDetailResponse> getAllOrderDetailResponse(String code) {
        return adminOrderDetailRepository.getAllOrderDetailResponse(code);
    }
}
