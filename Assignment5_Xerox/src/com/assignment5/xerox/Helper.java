/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.xerox;

import com.assignment5.entities.Order;
import com.assignment5.entities.Product;
import com.assignment5.util.Tools;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author lihang
 */
public class Helper {

    public static void BestNegotiatedProducts() throws IOException {
        Map<Integer, Product> prodCatalog = GeneralReader.getInstance().getProductCatalog();
        Map<Integer, Integer> overPrice = Tools.getOverSalesPrice();

        List<Map.Entry<Integer, Integer>> ov = new ArrayList<>(overPrice.entrySet());

        Collections.sort(ov, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }

        });
        System.out.println("Best 3 Negotiated Products:");
        for (int i = 0; i < 3; i++) {
            Map.Entry<Integer, Integer> c = ov.get(i);

            Product p = prodCatalog.get(c.getKey());
            System.out.println("productID: " + c.getKey() + "-->" + p);
        }
    }
}
