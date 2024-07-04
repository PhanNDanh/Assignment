package com.sof3021.sd17309.assignment_java5.entity.base;

import com.sof3021.sd17309.assignment_java5.infrastructure.listern.AuditEntityListener;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditEntityListener.class)
public abstract class AuditEntity {
    @Column(name = "created_date",updatable = false)
    private Long createdDate;

    @Column(name = "lastmodified_date")
    private Long lastModifiedDate;

}
