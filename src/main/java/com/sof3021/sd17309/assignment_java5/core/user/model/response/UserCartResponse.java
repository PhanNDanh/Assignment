package com.sof3021.sd17309.assignment_java5.core.user.model.response;

import com.sof3021.sd17309.assignment_java5.core.user.model.domain.ProductsInCart;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;
@ToString
public class UserCartResponse {

    private List<ProductsInCart> productsInCart;
    public BigDecimal getTotalMoney() {
        if(productsInCart !=null){
            return productsInCart.stream()
                    .map(s -> s.getIntoMoney())
                    .reduce(BigDecimal.ZERO, (a,b) -> a.add(b));
        }
        return BigDecimal.valueOf(0);
    }

    public List<ProductsInCart> getProductsInCart() {
        return productsInCart;
    }

    public void setProductsInCart(List<ProductsInCart> productsInCart) {
        this.productsInCart = productsInCart;
    }

}
