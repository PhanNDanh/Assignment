package com.sof3021.sd17309.assignment_java5.core.guest.service;

import com.sof3021.sd17309.assignment_java5.core.admin.model.response.AdminCategoryResponse;
import com.sof3021.sd17309.assignment_java5.core.guest.model.response.GuestCategoryResponse;

import java.util.List;

public interface GuestCategoryService {

    List<GuestCategoryResponse> getAllCategory();
}
