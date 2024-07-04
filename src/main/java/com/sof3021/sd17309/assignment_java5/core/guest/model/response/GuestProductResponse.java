package com.sof3021.sd17309.assignment_java5.core.guest.model.response;

import com.sof3021.sd17309.assignment_java5.entity.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Product.class)
public interface GuestProductResponse {

    @Value("#{target.name}")
    String getProductName();

}
