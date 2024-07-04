package com.sof3021.sd17309.assignment_java5.core.admin.model.request;

import com.sof3021.sd17309.assignment_java5.core.commom.base.request.PageableRequest;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class AdminFindRequest extends PageableRequest {

    private String productName;
    private String categoryName;
    private String colorName;
    private String sizeName;
    private String materialName;
    private BigDecimal price1;
    private BigDecimal price2;

}
