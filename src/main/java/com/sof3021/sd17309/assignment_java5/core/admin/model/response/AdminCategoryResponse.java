package com.sof3021.sd17309.assignment_java5.core.admin.model.response;

import com.sof3021.sd17309.assignment_java5.entity.Category;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Category.class)
public interface AdminCategoryResponse {

    @Value("#{target.id}")
    String getId();

    @Value("#{target.code}")
    String getCategoryCode();
    @Value("#{target.name}")
    String getCategoryName();
}
