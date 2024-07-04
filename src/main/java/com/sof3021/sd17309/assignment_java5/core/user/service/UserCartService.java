package com.sof3021.sd17309.assignment_java5.core.user.service;

import com.sof3021.sd17309.assignment_java5.core.user.model.response.UserCartResponse;

public interface UserCartService {

    Boolean addToCart(String id, Integer quantity);

    Boolean deleteFromCart(String id, Integer quantity);

    Boolean updateToCart(String id, Integer quantity);

    UserCartResponse cartView();
}
