package com.sof3021.sd17309.assignment_java5.core.admin.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sof3021.sd17309.assignment_java5.entity.Category;
import com.sof3021.sd17309.assignment_java5.entity.Color;
import com.sof3021.sd17309.assignment_java5.entity.Material;
import com.sof3021.sd17309.assignment_java5.entity.Product;
import com.sof3021.sd17309.assignment_java5.entity.ProductDetail;
import com.sof3021.sd17309.assignment_java5.entity.Size;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Projection(types = {ProductDetail.class, Product.class, Category.class, Color.class, Size.class, Material.class})
public interface AdminProductDetailResponse {

    @Value("#{target.id}")
    String getId();

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

    @Value("#{target.quantity}")
    Integer getQuantity();

    @Value("#{target.price}")
    BigDecimal getPrice();

    @Value("#{target.description}")
    String getDescription();

    @Value("#{target.is_delete}")
    String getIsDelete();

    @JsonIgnore
    @Value("#{target.created_date}")
    Long getCreatedDate();

    @JsonIgnore
    @Value("#{target.lastModified_date}")
    Long getLastModifiedDate();

    default String get_CreatedDate() {
        Date date = new Date(getCreatedDate().longValue());
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        return dateFormat.format(date);
    }

    default String get_LastModifiedDate() {
        Date date = new Date(getLastModifiedDate().longValue());
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        return dateFormat.format(date);
    }

}
