package com.sof3021.sd17309.assignment_java5.core.admin.service.impl;

import com.sof3021.sd17309.assignment_java5.core.admin.model.request.AdminFindRequest;
import com.sof3021.sd17309.assignment_java5.core.commom.base.response.ResponsePageableObject;
import com.sof3021.sd17309.assignment_java5.core.admin.model.request.AdminCreateProductDetailRequest;
import com.sof3021.sd17309.assignment_java5.core.admin.model.request.AdminUpdateProductDetailRequest;
import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminProductDetailResponse;
import com.sof3021.sd17309.assignment_java5.core.admin.repository.AdminProductDetailRepository;
import com.sof3021.sd17309.assignment_java5.core.admin.service.AdminProductDetailService;
import com.sof3021.sd17309.assignment_java5.entity.ProductDetail;
import com.sof3021.sd17309.assignment_java5.util.FormUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminProductDetailServiceImpl implements AdminProductDetailService {

    @Autowired
    private AdminProductDetailRepository adminProductDetailRepository;

    private FormUtil formUtil = new FormUtil();

    @Override
    public ResponsePageableObject<AdminProductDetailResponse> getAllProductDetailResponse(AdminFindRequest request) {
        Pageable pageable = PageRequest.of(request.getCurrentPage()-1, request.getPageSize());
        return new ResponsePageableObject<>(adminProductDetailRepository.getAllProductDetailResponse(pageable, request.getProductName(),
        request.getCategoryName(),request.getColorName(), request.getSizeName(), request.getMaterialName(),request.getPrice1(),request.getPrice2()));
    }

    @Override
    public AdminProductDetailResponse getProductDetailResponse(String id) {
        return adminProductDetailRepository.getProductDetailResponse(id);
    }

    @Override
    public ProductDetail addProductDetail(AdminCreateProductDetailRequest request) {
        ProductDetail productDetail = formUtil.convertToObject(ProductDetail.class, request);
        return adminProductDetailRepository.save(productDetail);
    }

    @Override
    public ProductDetail updateProductDetail(String id, AdminUpdateProductDetailRequest request) {
        Optional<ProductDetail> productDetailOptional = adminProductDetailRepository.findById(id);
        if (!productDetailOptional.isPresent()) {
            throw new RuntimeException();
        }
        productDetailOptional.get().setProductId(request.getProductId());
        productDetailOptional.get().setCategoryId(request.getCategoryId());
        productDetailOptional.get().setMaterialId(request.getMaterialId());
        productDetailOptional.get().setColorId(request.getColorId());
        productDetailOptional.get().setSizeId(request.getSizeId());
        productDetailOptional.get().setPrice(request.getPrice());
        productDetailOptional.get().setQuantity(request.getQuantity());
        productDetailOptional.get().setDescription(request.getDescription());
        return adminProductDetailRepository.save(productDetailOptional.get());
    }

    @Override
    public ProductDetail getProductDetail(String id) {
        Optional<ProductDetail> productDetailOptional = adminProductDetailRepository.findById(id);
        return productDetailOptional.get();
    }

    @Override
    public void deleteProductDetail(String id) {
        Optional<ProductDetail> productDetailOptional = adminProductDetailRepository.findById(id);
        adminProductDetailRepository.delete(productDetailOptional.get());
    }

}
