package com.sof3021.sd17309.assignment_java5.core.admin.service.impl;

import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminChartsExistResponse;
import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminChartsResponse;
import com.sof3021.sd17309.assignment_java5.core.admin.repository.AdminOrderDetailRepository;
import com.sof3021.sd17309.assignment_java5.core.admin.service.AdminChartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminChartServiceImpl implements AdminChartsService {

    @Autowired
    private AdminOrderDetailRepository adminOrderDetailRepository;

    @Override
    public List<AdminChartsResponse> getAllChartsTop10() {
        return adminOrderDetailRepository.getAllChartsTop10();
    }

    @Override
    public List<AdminChartsExistResponse> getAllChartsTop10Exist() {
        return adminOrderDetailRepository.getAllChartsTop10Exist();
    }
}
