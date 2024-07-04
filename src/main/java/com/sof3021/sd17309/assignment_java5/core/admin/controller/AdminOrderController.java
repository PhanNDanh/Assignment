package com.sof3021.sd17309.assignment_java5.core.admin.controller;

import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminOrderDetailResponse;
import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminOrderResponse;
import com.sof3021.sd17309.assignment_java5.core.admin.service.AdminOrderService;
import com.sof3021.sd17309.assignment_java5.core.commom.base.response.ResponsePageableObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Assignment-Java5/admin/")
@CrossOrigin("*")
public class AdminOrderController {

    @Autowired
    private AdminOrderService adminOrderService;

    @GetMapping("findAll-Order-response")
    public List<AdminOrderResponse> getAllOrderResponse() {
        return adminOrderService.getAllOrderResponse();
    }

    @GetMapping("findAll-OrderDetail-ByCode-response")
    public List<AdminOrderDetailResponse> getAllOrderDetailResponse(String code) {
        return adminOrderService.getAllOrderDetailResponse(code);
    }
}
