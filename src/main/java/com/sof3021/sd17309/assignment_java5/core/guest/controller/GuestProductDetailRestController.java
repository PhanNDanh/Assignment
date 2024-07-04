package com.sof3021.sd17309.assignment_java5.core.guest.controller;

import com.sof3021.sd17309.assignment_java5.core.commom.base.response.ResponseObject;
import com.sof3021.sd17309.assignment_java5.core.commom.base.response.ResponsePageableObject;
import com.sof3021.sd17309.assignment_java5.core.guest.model.request.GuestFindRequest;
import com.sof3021.sd17309.assignment_java5.core.guest.model.response.GuestProductDetailResponse;
import com.sof3021.sd17309.assignment_java5.core.guest.service.GuestProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/Assignment-Java5/guest/")
@CrossOrigin("*")
public class GuestProductDetailRestController {

    @Autowired
    private GuestProductDetailService guestProductDetailService;

    @GetMapping("findAll-ProductDetail-response")
    public ResponsePageableObject<GuestProductDetailResponse> getAllProductDetailResponse(
            @RequestParam(value = "currentPage", required = false,defaultValue = "1") Integer currentPage,
            @RequestParam(value = "productName", required = false) String productName,
            @RequestParam(value = "categoryName", required = false) String categoryName,
            @RequestParam(value = "colorName", required = false) String colorName,
            @RequestParam(value = "sizeName", required = false) String sizeName,
            @RequestParam(value = "materialName",required = false) String materialName,
            @RequestParam(value = "price1",required = false) BigDecimal price1,
            @RequestParam(value = "price2",required = false) BigDecimal price2) {
        GuestFindRequest request = new GuestFindRequest();
        request.setPageSize(8);
        request.setCurrentPage(currentPage);
        request.setProductName(productName);
        request.setCategoryName(categoryName);
        request.setColorName(colorName);
        request.setSizeName(sizeName);
        request.setMaterialName(materialName);
        request.setPrice1(price1);
        request.setPrice2(price2);
        return guestProductDetailService.getAllProductDetailResponse(request);
    }

    @GetMapping("getProductDetail-response/{id}")
    public ResponseObject getProductDetailResponse(@PathVariable("id") String id) {
        return new ResponseObject(guestProductDetailService.getProductDetailResponse(id));
    }

}
