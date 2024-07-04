package com.sof3021.sd17309.assignment_java5.core.commom.base.request;

import com.sof3021.sd17309.assignment_java5.infrastructure.constants.PaginationConstant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class PageableRequest {
    private int currentPage;
    private int pageSize = PaginationConstant.DEFAULT_SIZE;

    private int currentPageDefualt = PaginationConstant.DEFAULT_PAGE;


}
