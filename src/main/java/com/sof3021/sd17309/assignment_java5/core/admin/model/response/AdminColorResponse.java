package com.sof3021.sd17309.assignment_java5.core.admin.model.response;

import com.sof3021.sd17309.assignment_java5.entity.Color;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Color.class)
public interface AdminColorResponse {

    @Value("#{target.id}")
    String getId();

    @Value("#{target.name}")
    String getColorName();

    @Value("#{target.code}")
    String getColorCode();
}
