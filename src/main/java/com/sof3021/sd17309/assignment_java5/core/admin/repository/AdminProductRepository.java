package com.sof3021.sd17309.assignment_java5.core.admin.repository;

import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminProductResponse;
import com.sof3021.sd17309.assignment_java5.repository.ProductRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminProductRepository extends ProductRepository {

    @Query(nativeQuery = true,value = "SELECT pr.id,pr.code,pr.name FROM assignment_java5.product pr")
    List<AdminProductResponse> getAllProduct();
}
