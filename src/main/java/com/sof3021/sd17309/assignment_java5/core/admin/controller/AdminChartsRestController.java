package com.sof3021.sd17309.assignment_java5.core.admin.controller;

import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminChartsExistResponse;
import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminChartsResponse;
import com.sof3021.sd17309.assignment_java5.core.admin.service.AdminChartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Assignment-Java5/admin/")
@CrossOrigin("*")
public class AdminChartsRestController {

    @Autowired
    private AdminChartsService adminChartsService;

    @GetMapping("charts/top-10")
    public List<AdminChartsResponse> getAllChartsResponse(){
      return   adminChartsService.getAllChartsTop10();
    }

    @GetMapping("charts/top-10/exist")
    public List<AdminChartsExistResponse> getAllChartsExistResponse(){
        return adminChartsService.getAllChartsTop10Exist();
    }
}
