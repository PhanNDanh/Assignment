package com.sof3021.sd17309.assignment_java5.core.admin.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AdminUpdateProductDetailRequest {

    private String productId;

    private String categoryId;

    private String colorId;

    private String sizeId;

    private String materialId;

    private Integer quantity;

    private BigDecimal price;

    private String description;
}
