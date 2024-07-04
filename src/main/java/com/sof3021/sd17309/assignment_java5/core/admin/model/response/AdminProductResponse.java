package com.sof3021.sd17309.assignment_java5.core.admin.model.response;

import com.sof3021.sd17309.assignment_java5.entity.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Product.class)
public interface AdminProductResponse {

    @Value("#{target.id}")
    String getId();

    @Value("#{target.name}")
    String getProductName();

    @Value("#{target.code}")
    String getProductCode();
}
