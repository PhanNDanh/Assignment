package com.sof3021.sd17309.assignment_java5.entity;

import com.sof3021.sd17309.assignment_java5.entity.base.PrimaryEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends PrimaryEntity {

    @Column(name = "code")
    private String productCode;

    @Column(name = "name")
    private String productName;

}
