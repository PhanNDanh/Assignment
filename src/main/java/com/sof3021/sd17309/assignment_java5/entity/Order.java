package com.sof3021.sd17309.assignment_java5.entity;

import com.sof3021.sd17309.assignment_java5.entity.base.PrimaryEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "[order]")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order extends PrimaryEntity {

    @Column(name = "id_account")
    private String accountId;

    @Column(name = "code")
    private String code;

    @Column(columnDefinition = "BIT default 0")
    private Boolean status;

    @Column(name = "date_of_payment")
    private Long dateOfPayment;

    @Column(name = "total_money")
    private BigDecimal totalMoney;
}
