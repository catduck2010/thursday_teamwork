/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.xerox;

import com.assignment5.entities.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lihang
 */
public class Helper {

    public static void BestNegotiatedProducts() throws IOException {
        Map<Integer, Product> prodCatalog = GeneralReader.getInstance().getProductCatalog();
        List<Product> productList = new ArrayList<>(prodCatalog.values());

        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (o2.getMax() - o2.getTarget()) - (o1.getMax() - o1.getTarget());
            }
        });
        System.out.println("Best 3 Negotiated Products:");
        int i = 0;
        for (Product p : productList) {
            System.out.println(p);
            if (++i == 3) {
                return;
            }
        }
    }
}
