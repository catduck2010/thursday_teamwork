/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.util;

import com.assignment5.entities.Item;
import com.assignment5.entities.Order;
import com.assignment5.entities.Product;
import com.assignment5.xerox.GeneralReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lihang
 */
public class Tools {

    //Sales quantity of the product sold above the target price
    public static Map<Integer, Integer> getQuantityOfOverSalesPrice() throws IOException {
        Map<Integer, Integer> overSales = new HashMap<>();

        for (Order o : GeneralReader.getInstance().getOrderList()) {
            Item i = o.getItem();
            overSales.put(i.getProductId(), overSales.getOrDefault(i.getProductId(), 0)
                    + i.getQuantity());
        }
//        System.out.println(overSales);
        return overSales;
    }
}
