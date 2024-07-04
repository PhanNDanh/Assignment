package com.sof3021.sd17309.assignment_java5.core.guest.model.response;

import com.sof3021.sd17309.assignment_java5.entity.Category;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Category.class)
public interface GuestCategoryResponse {
    @Value("#{target.name}")
    String getCategoryName();
}
