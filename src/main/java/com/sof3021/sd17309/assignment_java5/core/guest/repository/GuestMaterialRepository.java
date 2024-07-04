package com.sof3021.sd17309.assignment_java5.core.guest.repository;

import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminMaterialResponse;
import com.sof3021.sd17309.assignment_java5.core.guest.model.response.GuestMaterialResponse;
import com.sof3021.sd17309.assignment_java5.repository.MaterialRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestMaterialRepository extends MaterialRepository {

    @Query(nativeQuery = true,value = "SELECT mt.name FROM assignment_java5.material mt")
    List<GuestMaterialResponse> getAllMaterial();
}
