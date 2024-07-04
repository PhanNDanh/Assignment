package com.sof3021.sd17309.assignment_java5.core.guest.model.request;

import com.sof3021.sd17309.assignment_java5.core.commom.base.request.PageableRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class GuestFindRequest extends PageableRequest {
    private String productName;
    private String categoryName;
    private String colorName;
    private String sizeName;
    private String materialName;
    private BigDecimal price1;
    private BigDecimal price2;
}
