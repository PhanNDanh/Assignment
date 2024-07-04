package com.sof3021.sd17309.assignment_java5.repository;

import com.sof3021.sd17309.assignment_java5.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
