package com.sof3021.sd17309.assignment_java5.core.guest.repository;

import com.sof3021.sd17309.assignment_java5.core.guest.model.response.GuestColorResponse;
import com.sof3021.sd17309.assignment_java5.repository.ColorRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface GuestColorRepository extends ColorRepository {

    @Query(nativeQuery = true,value = "SELECT cl.name FROM assignment_java5.color cl")
    List<GuestColorResponse> getAllColor();
}
