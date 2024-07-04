package com.sof3021.sd17309.assignment_java5.core.commom.base.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class PageableProperties {
    private long totalPages;

    private long totalElements;

    private int currentPage;

    private int pageSize;
}
