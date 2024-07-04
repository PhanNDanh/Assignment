package com.sof3021.sd17309.assignment_java5.core.admin.repository;

import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminMaterialResponse;
import com.sof3021.sd17309.assignment_java5.repository.MaterialRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMaterialRepository extends MaterialRepository {

    @Query(nativeQuery = true,value = "SELECT mt.id,mt.code,mt.name FROM assignment_java5.material mt")
    List<AdminMaterialResponse> getAllMaterial();
}
