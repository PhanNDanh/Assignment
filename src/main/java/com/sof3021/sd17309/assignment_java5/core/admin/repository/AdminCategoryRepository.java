package com.sof3021.sd17309.assignment_java5.core.admin.repository;

import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminCategoryResponse;
import com.sof3021.sd17309.assignment_java5.repository.CategoryRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminCategoryRepository extends CategoryRepository {

    @Query(nativeQuery = true,value = "SELECT ct.id,ct.code,ct.name FROM assignment_java5.category ct")
    List<AdminCategoryResponse> getAllCategory();

}
