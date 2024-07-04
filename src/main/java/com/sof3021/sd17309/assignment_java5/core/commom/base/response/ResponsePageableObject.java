package com.sof3021.sd17309.assignment_java5.core.commom.base.response;

import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class ResponsePageableObject<T> extends PageableProperties {

    private List<T> list;

    private int startIndex;

    private int endIndex;

    public ResponsePageableObject(Page<T> page) {
        this.list = page.getContent();
        this.setTotalPages(page.getTotalPages());
        this.setCurrentPage(page.getNumber() + 1);
        this.setPageSize(page.getSize());
        this.setTotalElements(page.getTotalElements());
        this.startIndex = (page.getNumber() * page.getSize()) + 1;
        this.endIndex = (int) Math.min((page.getNumber() + 1) * page.getSize(), page.getTotalElements());
    }
}
