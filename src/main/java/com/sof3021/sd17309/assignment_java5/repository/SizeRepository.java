package com.sof3021.sd17309.assignment_java5.repository;

import com.sof3021.sd17309.assignment_java5.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface SizeRepository extends JpaRepository<Size, String> {
}
