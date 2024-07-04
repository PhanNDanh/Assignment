package com.sof3021.sd17309.assignment_java5.core.admin.service;

import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminChartsExistResponse;
import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminChartsResponse;

import java.util.List;

public interface AdminChartsService {

    List<AdminChartsResponse> getAllChartsTop10();

    List<AdminChartsExistResponse> getAllChartsTop10Exist();

}
