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

    // 1) Our top 3 best negotiated products (meaning products that sell above target)
    public static void BestNegotiatedProducts() throws IOException {
        Map<Integer, Product> prodCatalog = GeneralReader.getInstance().getProductCatalog();
        Map<Integer, Integer> overPrice = Tools.getQuantityOfOverSalesPrice();

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
            if (c == null) {
                break;
            }
            Product p = prodCatalog.get(c.getKey());
            System.out.println("productID: " + c.getKey() + "-->" + p);
        }
    }
    // 2) Our 3 best customers (customers who buy about target price)

    public static void BestCustomers() throws IOException {
        Map<Integer, Integer> totalSale = Tools.getCustomerTotalSale();
        List<Map.Entry<Integer, Integer>> tsList = new ArrayList<>(totalSale.entrySet());

        Collections.sort(tsList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }

        });
        System.out.println("Best 3 Customers:");
        for (int i = 0; i < 3; i++) {
            Map.Entry<Integer, Integer> c = tsList.get(i);
            if (c == null) {
                break;
            }
            System.out.println("Customer: " + c.getKey());
        }

    }

    //3) Our top 3 best sales people (sell higher that target) 
    public static void BestSalesPeople() throws IOException {
        Map<Integer, Integer> totalSale = Tools.getSalePeopleProfits();
        List<Map.Entry<Integer, Integer>> tsList = new ArrayList<>(totalSale.entrySet());

        Collections.sort(tsList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }

        });

        System.out.println("Best 3 Sales People:");
        for (int i = 0; i < 3; i++) {
            Map.Entry<Integer, Integer> c = tsList.get(i);
            if (c == null) {
                break;
            }
            System.out.println("SalesPerson: " + c.getKey());
        }
    }

    //4) Our total revenue for the year that is above expected target
    public static void TotalRevenue() throws IOException {
        Map<Integer, Integer> totalSale = Tools.getSalePeopleProfits();
        int revenue = 0;
        for (Integer i : totalSale.values()) {
            revenue += i;
        }
        System.out.println("Total Revenue: " + revenue);
    }
}
