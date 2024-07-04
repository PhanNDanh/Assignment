package com.sof3021.sd17309.assignment_java5.core.admin.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sof3021.sd17309.assignment_java5.entity.Account;
import com.sof3021.sd17309.assignment_java5.entity.Category;
import com.sof3021.sd17309.assignment_java5.entity.Color;
import com.sof3021.sd17309.assignment_java5.entity.Material;
import com.sof3021.sd17309.assignment_java5.entity.Order;
import com.sof3021.sd17309.assignment_java5.entity.OrderDetail;
import com.sof3021.sd17309.assignment_java5.entity.Product;
import com.sof3021.sd17309.assignment_java5.entity.ProductDetail;
import com.sof3021.sd17309.assignment_java5.entity.Size;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Projection(types = {Order.class, OrderDetail.class, Account.class, ProductDetail.class, Product.class, Category.class, Color.class, Size.class, Material.class})
public interface AdminOrderDetailResponse {
    @Value("#{target.username}")
    String getUserName();

    @Value("#{target.codeBill}")
    String getCode();

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

    @JsonIgnore
    @Value("#{target.date_of_payment}")
    Long getDateOfPayment();

    @Value("#{target.status}")
    Boolean getStatus();

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

    default String get_DateOfPayment() {
        Date date = new Date(getDateOfPayment().longValue());
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        return dateFormat.format(date);
    }

    default String get_LastModifiedDate() {
        Date date = new Date(getLastModifiedDate().longValue());
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        return dateFormat.format(date);
    }
}
