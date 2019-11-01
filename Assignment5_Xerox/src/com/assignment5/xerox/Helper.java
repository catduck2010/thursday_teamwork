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
        List<Product> productList = new ArrayList<>(prodCatalog.values());
        Map<Integer, Integer> overPrice = Tools.getOverSalesPrice();
        Map<Product, Integer> proToOP = new HashMap<>();
        for (Integer i : prodCatalog.keySet()) {
            proToOP.put(prodCatalog.get(i), overPrice.get(i));
        }
        System.out.println("Best 3 Negotiated Products:");
        int i = 0;
        for (int c = 0; c < 3; c++) {
            Product max=null;
            for (Product p : productList) {
                if(max!=null&&proToOP.get(max)<proToOP.get(p)){
                    max=p;
                }
            }
            System.out.println(max);
            productList.remove(max);
        }
    }
}
