package com.sof3021.sd17309.assignment_java5.core.guest.service.impl;

import com.sof3021.sd17309.assignment_java5.core.commom.base.response.ResponseObject;
import com.sof3021.sd17309.assignment_java5.core.commom.base.response.ResponsePageableObject;
import com.sof3021.sd17309.assignment_java5.core.guest.model.request.GuestFindRequest;
import com.sof3021.sd17309.assignment_java5.core.guest.model.response.GuestProductDetailResponse;
import com.sof3021.sd17309.assignment_java5.core.guest.repository.GuestProductDetailRepository;
import com.sof3021.sd17309.assignment_java5.core.guest.service.GuestProductDetailService;
import com.sof3021.sd17309.assignment_java5.entity.ProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GuestProductDetailServiceImpl implements GuestProductDetailService {

    @Autowired
    private GuestProductDetailRepository guestProductDetailRepository;

    @Override
    public ResponsePageableObject<GuestProductDetailResponse> getAllProductDetailResponse(GuestFindRequest request) {
        Pageable pageable = PageRequest.of(request.getCurrentPage()-1, request.getPageSize());
       return new ResponsePageableObject<>(guestProductDetailRepository.getAllProductDetailResponse(pageable, request.getProductName(),
       request.getCategoryName(),request.getColorName(), request.getSizeName(), request.getMaterialName(),request.getPrice1(),request.getPrice2()));
    }

    @Override
    public GuestProductDetailResponse getProductDetailResponse(String id) {
        return guestProductDetailRepository.getProductDetailResponse(id);
    }


    @Override
    public ProductDetail getProductDetail(String id) {
        Optional<ProductDetail> productDetailOptional = guestProductDetailRepository.findById(id);
        return productDetailOptional.get();
    }
}
