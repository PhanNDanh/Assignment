package com.sof3021.sd17309.assignment_java5.core.guest.repository;

import com.sof3021.sd17309.assignment_java5.core.guest.model.response.GuestSizeResponse;
import com.sof3021.sd17309.assignment_java5.repository.SizeRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestSizeRepository extends SizeRepository {

    @Query(nativeQuery = true,value = "SELECT sz.name FROM assignment_java5.size sz")
    List<GuestSizeResponse> getAllSize();
}
