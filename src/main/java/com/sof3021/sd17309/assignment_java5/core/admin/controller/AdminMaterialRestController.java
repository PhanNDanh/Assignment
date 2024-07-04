package com.sof3021.sd17309.assignment_java5.core.admin.controller;

import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminMaterialResponse;
import com.sof3021.sd17309.assignment_java5.core.admin.service.AdminMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Assignment-Java5/admin/")
@CrossOrigin("*")
public class AdminMaterialRestController {

    @Autowired
    private AdminMaterialService adminMaterialService;

    @GetMapping("getAll-Material")
    public List<AdminMaterialResponse> getAll(){
        return adminMaterialService.getAllMaterial();
    }
}
