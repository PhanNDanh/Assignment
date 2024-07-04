package com.sof3021.sd17309.assignment_java5.core.admin.repository;

import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminColorResponse;
import com.sof3021.sd17309.assignment_java5.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface AdminColorRepository extends JpaRepository<Color, UUID> {

    @Query(nativeQuery = true,value = "SELECT cl.id,cl.code,cl.name FROM assignment_java5.color cl")
    List<AdminColorResponse> getAllColor();
}
