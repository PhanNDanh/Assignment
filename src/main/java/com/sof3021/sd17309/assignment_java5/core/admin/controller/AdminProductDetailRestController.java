package com.sof3021.sd17309.assignment_java5.core.admin.controller;

import com.sof3021.sd17309.assignment_java5.core.admin.model.request.AdminFindRequest;
import com.sof3021.sd17309.assignment_java5.core.commom.base.response.ResponsePageableObject;
import com.sof3021.sd17309.assignment_java5.core.commom.base.response.ResponseObject;
import com.sof3021.sd17309.assignment_java5.core.admin.model.request.AdminCreateProductDetailRequest;
import com.sof3021.sd17309.assignment_java5.core.admin.model.request.AdminUpdateProductDetailRequest;
import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminProductDetailResponse;
import com.sof3021.sd17309.assignment_java5.core.admin.service.AdminProductDetailService;
import com.sof3021.sd17309.assignment_java5.core.guest.model.request.GuestFindRequest;
import com.sof3021.sd17309.assignment_java5.entity.ProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/Assignment-Java5/admin/")
@CrossOrigin("*")
public class AdminProductDetailRestController {

    @Autowired
    private AdminProductDetailService adminProductDetailService;

    @GetMapping("findAll-ProductDetail-response")
    public ResponsePageableObject<AdminProductDetailResponse> getAllProductDetailResponse(@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage, @RequestParam(value = "productName", required = false) String productName, @RequestParam(value = "categoryName", required = false) String categoryName, @RequestParam(value = "colorName", required = false) String colorName, @RequestParam(value = "sizeName", required = false) String sizeName, @RequestParam(value = "materialName", required = false) String materialName, @RequestParam(value = "price1", required = false) BigDecimal price1, @RequestParam(value = "price2", required = false) BigDecimal price2) {
        AdminFindRequest request = new AdminFindRequest();
        request.setPageSize(5);
        request.setCurrentPage(currentPage);
        request.setProductName(productName);
        request.setCategoryName(categoryName);
        request.setColorName(colorName);
        request.setSizeName(sizeName);
        request.setMaterialName(materialName);
        request.setPrice1(price1);
        request.setPrice2(price2);
        return adminProductDetailService.getAllProductDetailResponse(request);
    }

    @GetMapping("getProductDetail-response/{id}")
    public ResponseObject getProductDetailResponse(@PathVariable("id") String id) {
        return new ResponseObject(adminProductDetailService.getProductDetailResponse(id));
    }

    @GetMapping("getProductDetail/{id}")
    public ResponseObject getProductDetail(@PathVariable("id") String id) {
        return new ResponseObject(adminProductDetailService.getProductDetail(id));
    }

    @PostMapping("add-ProductDetail")
    public ResponseObject addProductDetail(@RequestBody AdminCreateProductDetailRequest request) {
        return new ResponseObject(adminProductDetailService.addProductDetail(request));
    }

    @PutMapping("update-ProductDetail/{id}")
    public ResponseObject updateProductDetail(@PathVariable("id") String id, @RequestBody AdminUpdateProductDetailRequest request) {
        return new ResponseObject(adminProductDetailService.updateProductDetail(id, request));
    }

    @DeleteMapping("delete-ProductDetail/{id}")
    public void deleteProductDetail(@PathVariable("id") String id) {
        adminProductDetailService.deleteProductDetail(id);
    }

}
