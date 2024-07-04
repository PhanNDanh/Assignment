package com.sof3021.sd17309.assignment_java5.core.user.repository.impl;

import com.sof3021.sd17309.assignment_java5.core.user.model.domain.Cart;
import com.sof3021.sd17309.assignment_java5.core.user.repository.UserCartSessionRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

@Repository
@SessionScope
public class UserCartSessionRepositoryImpl implements UserCartSessionRepository {

    private Cart cart = new Cart();


    @Override
    public void addToCart(String id, Integer extraQuantity) {
        cart.getListProduct().put(id,extraQuantity);
    }

    @Override
    public void updateToCart(String id, Integer changeQuantity) {
        cart.getListProduct().put(id,changeQuantity);
    }

    @Override
    public void deleteFromCart(String id) {
        cart.getListProduct().remove(id);
    }

    @Override
    public Cart viewCart() {
        return cart;
    }

    @Override
    public void deleteAllInCart() {
        cart.getListProduct().clear();
    }
}
