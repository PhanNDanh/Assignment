package com.sof3021.sd17309.assignment_java5.core.user.model.domain;


import java.util.HashMap;
import java.util.Map;
public class Cart {

    private static Map<String, Integer> listProduct
            = new HashMap<>();

    public Map<String, Integer> getListProduct() {
        return listProduct;
    }
}
