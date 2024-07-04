package com.sof3021.sd17309.assignment_java5.core.admin.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sof3021.sd17309.assignment_java5.entity.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Projection(types = Order.class)
public interface AdminOrderResponse {
    @Value("#{target.id}")
    String getId();

    @Value("#{target.code}")
    String getCode();

    @Value("#{target.status}")
    Boolean getStatus();

    @JsonIgnore
    @Value("#{target.date_of_payment}")
    Long getDateOfPayment();

    @Value("#{target.total_money}")
    BigDecimal getTotalMoney();

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
