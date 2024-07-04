package com.sof3021.sd17309.assignment_java5.entity;

import com.sof3021.sd17309.assignment_java5.entity.base.PrimaryEntity;
import com.sof3021.sd17309.assignment_java5.infrastructure.constants.EntityProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_detail")
public class ProductDetail extends PrimaryEntity {

    @Column(name = "id_product",length = EntityProperties.LENGTH_ID)
    private String productId;

    @Column(name = "id_category",length = EntityProperties.LENGTH_ID)
    private String categoryId;

    @Column(name = "id_color",length = EntityProperties.LENGTH_ID)
    private String colorId;

    @Column(name = "id_size",length = EntityProperties.LENGTH_ID)
    private String sizeId;

    @Column(name = "id_material",length = EntityProperties.LENGTH_ID)
    private String materialId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "description")
    private String description;

    @Column(columnDefinition = "BIT default 0")
    private boolean isDelete;

}
