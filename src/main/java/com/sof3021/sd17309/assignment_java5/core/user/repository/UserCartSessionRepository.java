package com.sof3021.sd17309.assignment_java5.core.user.repository;

import com.sof3021.sd17309.assignment_java5.core.user.model.domain.Cart;

public interface UserCartSessionRepository {

    void addToCart(String id, Integer extraQuantity);

    void updateToCart(String id, Integer changeQuantity);

    void deleteFromCart(String id);

    Cart viewCart();

    void deleteAllInCart();
}
