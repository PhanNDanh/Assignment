package com.sof3021.sd17309.assignment_java5.core.admin.repository;

import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminSizeResponse;
import com.sof3021.sd17309.assignment_java5.repository.SizeRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminSizeRepository extends SizeRepository {

    @Query(nativeQuery = true,value = "SELECT sz.id,sz.code,sz.name FROM assignment_java5.size sz")
    List<AdminSizeResponse> getAllSize();
}
