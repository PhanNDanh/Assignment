package com.sof3021.sd17309.assignment_java5.core.guest.model.response;

import com.sof3021.sd17309.assignment_java5.entity.Color;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Color.class)
public interface GuestColorResponse {

    @Value("#{target.name}")
    String getColorName();

}
