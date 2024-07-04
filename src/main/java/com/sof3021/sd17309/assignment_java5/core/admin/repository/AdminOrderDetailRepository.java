package com.sof3021.sd17309.assignment_java5.core.admin.repository;

import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminChartsExistResponse;
import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminChartsResponse;
import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminOrderDetailResponse;
import com.sof3021.sd17309.assignment_java5.repository.OrderDetailRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminOrderDetailRepository extends OrderDetailRepository {
    @Query(nativeQuery = true, value = """
            SELECT ac.username,od.code as codeBill,pr.name AS productName, ct.name AS categoryName, cl.name AS colorName, 
            sz.name AS sizeName, mt.name AS materialName,oddt.price,oddt.quantity,
            od.created_date,od.lastModified_date,od.date_of_payment,od.status
            FROM assignment_java5.order od
            left join account ac ON ac.id = od.id_account
            left join order_detail oddt ON od.id = oddt.id_order
            left join product_detail prdt ON prdt.id = oddt.id_product_detail
            left join product pr ON pr.id = prdt.id_product
            LEFT JOIN category ct ON prdt.id_category = ct.id
            LEFT JOIN color cl ON prdt.id_color = cl.id
            LEFT JOIN size sz ON prdt.id_size = sz.id
            LEFT JOIN material mt ON prdt.id_material = mt.id where od.code = :code
            """)
    List<AdminOrderDetailResponse> getAllOrderDetailResponse(@Param("code") String code);

    @Query(nativeQuery = true,value = """
                        SELECT pr.name AS productName,ct.name AS categoryName,mt.name AS materialName,cl.name AS colorName,sz.name AS sizeName,sum(oddt.quantity) as quantityRun
                        FROM assignment_java5.order od
                        left join order_detail oddt ON od.id = oddt.id_order
                        left join product_detail prdt ON prdt.id = oddt.id_product_detail
                        left join product pr ON pr.id = prdt.id_product
                        LEFT JOIN category ct ON prdt.id_category = ct.id
                        LEFT JOIN color cl ON prdt.id_color = cl.id
                        LEFT JOIN size sz ON prdt.id_size = sz.id
                        LEFT JOIN material mt ON prdt.id_material = mt.id
                        GROUP BY prdt.id
                        ORDER BY quantityRun ASC
                        LIMIT 10 """)
    List<AdminChartsResponse> getAllChartsTop10();

    @Query(nativeQuery = true,value = """
            SELECT pr.name AS productName, ct.name AS categoryName, mt.name AS materialName, cl.name AS colorName, sz.name AS sizeName
            FROM product_detail prdt
            LEFT JOIN order_detail oddt ON prdt.id = oddt.id_product_detail
            LEFT JOIN product pr ON pr.id = prdt.id_product
            LEFT JOIN category ct ON prdt.id_category = ct.id
            LEFT JOIN color cl ON prdt.id_color = cl.id
            LEFT JOIN size sz ON prdt.id_size = sz.id
            LEFT JOIN material mt ON prdt.id_material = mt.id
            WHERE oddt.id_product_detail IS NULL
            GROUP BY prdt.id
            LIMIT 10 """)
    List<AdminChartsExistResponse> getAllChartsTop10Exist();



}
