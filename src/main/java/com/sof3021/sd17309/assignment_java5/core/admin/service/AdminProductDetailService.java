package com.sof3021.sd17309.assignment_java5.core.admin.service;

import com.sof3021.sd17309.assignment_java5.core.admin.model.request.AdminFindRequest;
import com.sof3021.sd17309.assignment_java5.core.commom.base.response.ResponsePageableObject;
import com.sof3021.sd17309.assignment_java5.core.admin.model.request.AdminCreateProductDetailRequest;
import com.sof3021.sd17309.assignment_java5.core.admin.model.request.AdminUpdateProductDetailRequest;
import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminProductDetailResponse;
import com.sof3021.sd17309.assignment_java5.entity.ProductDetail;

public interface AdminProductDetailService {

    ResponsePageableObject<AdminProductDetailResponse> getAllProductDetailResponse(AdminFindRequest request);

    AdminProductDetailResponse getProductDetailResponse(String id);

    ProductDetail addProductDetail(AdminCreateProductDetailRequest request);

    ProductDetail updateProductDetail(String id, AdminUpdateProductDetailRequest request);

    ProductDetail getProductDetail(String id);

    void deleteProductDetail(String id);



}
