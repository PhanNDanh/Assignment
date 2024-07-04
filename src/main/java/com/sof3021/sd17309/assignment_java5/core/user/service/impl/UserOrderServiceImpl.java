package com.sof3021.sd17309.assignment_java5.core.user.service.impl;

import com.sof3021.sd17309.assignment_java5.core.user.model.domain.Cart;
import com.sof3021.sd17309.assignment_java5.core.user.repository.UserCartSessionRepository;
import com.sof3021.sd17309.assignment_java5.core.user.repository.UserOrderDetailRepository;
import com.sof3021.sd17309.assignment_java5.core.user.repository.UserOrderRepository;
import com.sof3021.sd17309.assignment_java5.core.user.repository.UserProductDetailRepository;
import com.sof3021.sd17309.assignment_java5.core.user.service.UserOrderService;
import com.sof3021.sd17309.assignment_java5.entity.Order;
import com.sof3021.sd17309.assignment_java5.entity.OrderDetail;
import com.sof3021.sd17309.assignment_java5.entity.ProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    private UserOrderRepository userOrderRepository;

    @Autowired
    private UserProductDetailRepository userProductDetailRepository;

    @Autowired
    UserOrderDetailRepository userOrderDetailRepository;

    @Autowired
    private UserCartSessionRepository userCartSessionRepository;

    @Override
    public void createBIll(String idAcount) {
        Cart cart = userCartSessionRepository.viewCart();

        int code = userOrderRepository.findAll().size() + 1;
        Order order = new Order();
        order.setAccountId(idAcount);
        order.setCode("HD" + code);
        order.setDateOfPayment(Long.valueOf(0));
        order.setStatus(true);
        BigDecimal total = BigDecimal.valueOf(0);

        String orderId = userOrderRepository.save(order).getId();
        for (Map.Entry<String, Integer> entry : cart.getListProduct().entrySet()) {
            String productId = entry.getKey();
            Integer quantity = entry.getValue();
            ProductDetail productDetail = userProductDetailRepository.findById(productId).get();
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(orderId);
            orderDetail.setProductDetailId(productDetail.getId());
            orderDetail.setQuantity(quantity);
            orderDetail.setPrice(productDetail.getPrice());

            userOrderDetailRepository.save(orderDetail);
            BigDecimal totalInCart = BigDecimal.valueOf(quantity).multiply(productDetail.getPrice());
            total = total.add(totalInCart);

            productDetail.setQuantity(productDetail.getQuantity()-quantity);
            userProductDetailRepository.save(productDetail);

        }

        order.setTotalMoney(total);
        userOrderRepository.save(order);
        userCartSessionRepository.deleteAllInCart();
    }
}
