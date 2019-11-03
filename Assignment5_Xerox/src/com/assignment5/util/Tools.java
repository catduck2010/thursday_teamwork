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

    public static Map<Integer, Integer> getOverSalesPrice() throws IOException {
        Map<Integer, Integer> overSales = new HashMap<>();
        Map<Integer, Product> prodCatalog = GeneralReader.getInstance().getProductCatalog();

        for (Order o : GeneralReader.getInstance().getOrderList()) {
            try {
                Item i = o.getItem();
                //System.out.println(i);
                Product pr = prodCatalog.get(i.getProductId());
                int target = pr.getTarget();
                //System.out.println(target);
                overSales.put(i.getProductId(), overSales.getOrDefault(i.getProductId(), 0)
                        + i.getSalesPrice() - target);
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                continue;
            }
        }
        System.out.println(overSales);
        return overSales;
    }
}
