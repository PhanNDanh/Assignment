package com.sof3021.sd17309.assignment_java5.core.admin.repository;

import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminChartsResponse;
import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminProductDetailResponse;
import com.sof3021.sd17309.assignment_java5.core.guest.model.response.GuestProductDetailResponse;
import com.sof3021.sd17309.assignment_java5.repository.ProductDetailRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AdminProductDetailRepository extends ProductDetailRepository {

    @Query(nativeQuery = true, value = """
            SELECT product_detail.id, product.name AS productName, category.name AS categoryName, color.name AS colorName, size.name AS sizeName, material.name AS materialName, quantity, price, description, product_detail.is_delete, product_detail.created_date, product_detail.lastModified_date
                        FROM product_detail
                        LEFT JOIN product ON product_detail.id_product = product.id
                        LEFT JOIN category ON product_detail.id_category = category.id
                        LEFT JOIN color ON product_detail.id_color = color.id
                        LEFT JOIN size ON product_detail.id_size = size.id
                        LEFT JOIN material ON product_detail.id_material = material.id
                        WHERE (:productName IS NULL OR product.name LIKE CONCAT('%', :productName, '%'))
                        AND (COALESCE(:categoryName, '') = '' OR category.name = :categoryName)
                        AND (COALESCE(:colorName, '') = '' OR color.name = :colorName)
                        AND (COALESCE(:sizeName, '') = '' OR size.name = :sizeName)
                        AND (COALESCE(:materialName, '') = '' OR material.name = :materialName)
                        AND (price BETWEEN COALESCE(:price1, 0) AND COALESCE(:price2, 10000))
                        ORDER BY product.name, category.name, color.name, size.name, material.name, price DESC
            """)
    Page<AdminProductDetailResponse> getAllProductDetailResponse(Pageable pageable, @Param("productName") String productName,
    @Param("categoryName") String categoryName, @Param("colorName") String colorName, @Param("sizeName") String sizeName,
    @Param("materialName") String materialName, @Param("price1") BigDecimal price1, @Param("price2") BigDecimal price2);

    @Query(nativeQuery = true, value = """
            SELECT product_detail.id, product.name AS productName, category.name AS categoryName, color.name AS colorName, size.name AS sizeName, material.name AS materialName, quantity, price, description, product_detail.is_delete, product_detail.created_date, product_detail.lastModified_date
                        FROM product_detail
                        LEFT JOIN product ON product_detail.id_product = product.id
                        LEFT JOIN category ON product_detail.id_category = category.id
                        LEFT JOIN color ON product_detail.id_color = color.id
                        LEFT JOIN size ON product_detail.id_size = size.id
                        LEFT JOIN material ON product_detail.id_material = material.id
                        WHERE product_detail.id = :id """)
    AdminProductDetailResponse getProductDetailResponse(@Param("id") String id);
}
