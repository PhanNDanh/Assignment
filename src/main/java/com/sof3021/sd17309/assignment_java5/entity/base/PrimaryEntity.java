package com.sof3021.sd17309.assignment_java5.entity.base;

import com.sof3021.sd17309.assignment_java5.infrastructure.constants.EntityProperties;
import com.sof3021.sd17309.assignment_java5.infrastructure.listern.CreatePrimaryEntityListener;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(CreatePrimaryEntityListener.class)
public abstract class PrimaryEntity extends AuditEntity implements IsIdentified {

    @Id
    @Column(length = EntityProperties.LENGTH_ID, updatable = false)
    private String Id;
}
