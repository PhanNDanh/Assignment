package com.sof3021.sd17309.assignment_java5.core.user.service.impl;

import com.sof3021.sd17309.assignment_java5.core.user.model.domain.Cart;
import com.sof3021.sd17309.assignment_java5.core.user.model.response.UserCartResponse;
import com.sof3021.sd17309.assignment_java5.core.user.model.domain.ProductsInCart;
import com.sof3021.sd17309.assignment_java5.core.user.repository.UserCartSessionRepository;
import com.sof3021.sd17309.assignment_java5.core.user.service.UserCartService;
import com.sof3021.sd17309.assignment_java5.entity.ProductDetail;
import com.sof3021.sd17309.assignment_java5.repository.ProductDetailRepository;
import com.sof3021.sd17309.assignment_java5.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserCartServiceImpl implements UserCartService {


    @Autowired
    private UserCartSessionRepository userCartSessionRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Boolean addToCart(String id, Integer quantity) {
        Cart cart = new Cart();
        Integer quantityOrigin = productDetailRepository.findById(id).get().getQuantity();
        if (cart.getListProduct().containsKey(id)) {
            Integer currentQuantity = cart.getListProduct().get(id);
            if (quantity == 1) {
                Integer newQuantity = currentQuantity + 1;
                if (newQuantity > quantityOrigin) {
                    System.out.println("Stop");
                    return false;
                } else {
                    System.out.println("Add 1");
                    userCartSessionRepository.updateToCart(id, newQuantity);
                    return true;
                }
            } else {
                if (quantity + currentQuantity > quantityOrigin) {
                    return false;
                }
                Integer newQuantity = currentQuantity + quantity;
                System.out.println("update, plus");
                userCartSessionRepository.updateToCart(id, newQuantity);
                return true;
            }
        } else {
            if (quantity > quantityOrigin) {
                System.out.println("Stop");
                return false;
            }
            System.out.println("add");
            userCartSessionRepository.addToCart(id, quantity);
            return true;
        }
    }

    @Override
    public Boolean deleteFromCart(String id, Integer quantity) {
        if (quantity == null) {
            System.out.println("delete");
            userCartSessionRepository.deleteFromCart(id);
            return true;
        } else {
            Cart cart = new Cart();
            Integer currentQuantity = cart.getListProduct().get(id);
            if (currentQuantity == 1) {
                System.out.println("Stop");
                return false;
            }
            if (quantity == 1) {
                System.out.println("delete 1");
                Integer newQuantity = currentQuantity - 1;
                userCartSessionRepository.updateToCart(id, newQuantity);
                return true;
            }
            return true;
        }
    }

    @Override
    public Boolean updateToCart(String id, Integer quantity) {
        Integer quantityOrigin = productDetailRepository.findById(id).get().getQuantity();
        if (quantity > quantityOrigin) {
            System.out.println("Stop");
            return false;
        } else {
            System.out.println("Update");
            userCartSessionRepository.updateToCart(id, quantity);
            return true;
        }
    }

    @Override
    public UserCartResponse cartView() {
        UserCartResponse userCartResponse = new UserCartResponse();

        Cart cart = userCartSessionRepository.viewCart();

        for (Map.Entry<String, Integer> entry : cart.getListProduct().entrySet()) {
            String productId = entry.getKey();
            Integer quantity = entry.getValue();

            ProductDetail productDetail = productDetailRepository.findById(productId).get();
            String productName = productRepository.findById(productDetail.getProductId()).get().getProductName();
            ProductsInCart productsInCart = new ProductsInCart();

            productsInCart.setProductId(productId);
            productsInCart.setQuantity(quantity);
            productsInCart.setName(productName);
            productsInCart.setPrice(productDetail.getPrice());

            List<ProductsInCart> productsInCarts = userCartResponse.getProductsInCart();
            if (productsInCarts == null) {
                productsInCarts = new ArrayList<>();
                userCartResponse.setProductsInCart(productsInCarts);
            }
            productsInCarts.add(productsInCart);
        }
        return userCartResponse;
    }
}
