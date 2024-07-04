package com.sof3021.sd17309.assignment_java5.core.guest.model.response;

import com.sof3021.sd17309.assignment_java5.entity.Material;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Material.class)
public interface GuestMaterialResponse {

    @Value("#{target.name}")
    String getMaterialName();
}
