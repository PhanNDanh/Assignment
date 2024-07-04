package com.sof3021.sd17309.assignment_java5.core.admin.repository;

import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminOrderResponse;
import com.sof3021.sd17309.assignment_java5.repository.OrderRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminOrderRepository extends OrderRepository {

    @Query(nativeQuery = true, value = """
            SELECT od.id,od.code,od.status,od.created_date,od.lastModified_date,od.date_of_payment,od.total_money 
            FROM assignment_java5.order od order by od.code asc """)
    List<AdminOrderResponse> getAllOrderResponse();
}
