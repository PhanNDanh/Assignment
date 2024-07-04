package com.sof3021.sd17309.assignment_java5.core.guest.service;

import com.sof3021.sd17309.assignment_java5.core.commom.base.response.ResponsePageableObject;
import com.sof3021.sd17309.assignment_java5.core.guest.model.request.GuestFindRequest;
import com.sof3021.sd17309.assignment_java5.core.guest.model.response.GuestProductDetailResponse;
import com.sof3021.sd17309.assignment_java5.entity.ProductDetail;

public interface GuestProductDetailService {

    ResponsePageableObject<GuestProductDetailResponse> getAllProductDetailResponse(GuestFindRequest request);

    GuestProductDetailResponse getProductDetailResponse(String id);

    ProductDetail getProductDetail(String id);


}
