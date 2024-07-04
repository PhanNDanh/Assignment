package com.sof3021.sd17309.assignment_java5.core.guest.repository;

import com.sof3021.sd17309.assignment_java5.core.guest.model.response.GuestProductResponse;
import com.sof3021.sd17309.assignment_java5.repository.ProductRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestProductRepository extends ProductRepository {

    @Query(nativeQuery = true,value = "SELECT pr.name FROM assignment_java5.product pr")
    List<GuestProductResponse> getAllProduct();
}
