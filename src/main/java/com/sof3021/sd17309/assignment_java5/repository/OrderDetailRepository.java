package com.sof3021.sd17309.assignment_java5.repository;

import com.sof3021.sd17309.assignment_java5.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
}
