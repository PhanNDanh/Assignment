package com.sof3021.sd17309.assignment_java5.core.admin.model.response;

import com.sof3021.sd17309.assignment_java5.entity.Category;
import com.sof3021.sd17309.assignment_java5.entity.Color;
import com.sof3021.sd17309.assignment_java5.entity.Material;
import com.sof3021.sd17309.assignment_java5.entity.OrderDetail;
import com.sof3021.sd17309.assignment_java5.entity.Product;
import com.sof3021.sd17309.assignment_java5.entity.ProductDetail;
import com.sof3021.sd17309.assignment_java5.entity.Size;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = {OrderDetail.class, ProductDetail.class, Product.class, Category.class, Color.class, Size.class, Material.class})
public interface AdminChartsExistResponse {

    @Value("#{target.productName}")
    String getProductName();

    @Value("#{target.categoryName}")
    String getCategoryName();

    @Value("#{target.colorName}")
    String getColorName();

    @Value("#{target.sizeName}")
    String getSizeName();

    @Value("#{target.materialName}")
    String getMaterialName();

}
