package com.sof3021.sd17309.assignment_java5.core.admin.service;

import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminOrderDetailResponse;
import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminOrderResponse;

import java.util.List;

public interface AdminOrderService {

    List<AdminOrderResponse> getAllOrderResponse();

    List<AdminOrderDetailResponse> getAllOrderDetailResponse(String code);
}
