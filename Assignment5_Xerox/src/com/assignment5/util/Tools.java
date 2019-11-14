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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lihang
 */
public class Tools {
    public static Map<Integer, Double> getNegotiatedPrice() throws IOException {
      Map<Integer, Double> negotiatedPrice = new HashMap<>();

        Map<Integer, Product> prodCatalog = GeneralReader.getInstance().getProductCatalog();
        Map<Integer, Integer> prodQuantity = new HashMap<>();

        for (Order o : GeneralReader.getInstance().getOrderList()) {
            Item i = o.getItem();
            int negotiated;
            Product p = prodCatalog.get(o.getItem().getProductId());
            if (o.getItem().getSalesPrice() > p.getTarget()) {
                negotiated = (o.getItem().getSalesPrice() - p.getTarget()) * o.getItem().getQuantity();
                negotiatedPrice.put(i.getProductId(), negotiatedPrice.getOrDefault(i.getProductId(), 0.0) + negotiated);
                prodQuantity.put(i.getProductId(), prodQuantity.getOrDefault(i.getProductId(), 0) + i.getQuantity());
                //System.out.println(i.getProductId() + ": Price: " + negotiated + " Quantity:" + i.getQuantity());
            }
        }

//        int[] numbers = new int[negotiatedPrice.keySet().size()];
//        List<Integer> prodIDList = new ArrayList<>(negotiatedPrice.keySet());
//        for (Order o : GeneralReader.getInstance().getOrderList()) {
//            Item i = o.getItem();
//            Product p = prodCatalog.get(o.getItem().getProductId());
//            if (o.getItem().getSalesPrice() > p.getTarget()) {
//                numbers[prodIDList.indexOf(i.getProductId())] += i.getQuantity();
//            }
//        }
//        System.out.println(negotiatedPrice);
//        System.out.println(prodQuantity);
        for (int s : negotiatedPrice.keySet()) {
            double price = negotiatedPrice.get(s) / prodQuantity.get(s);
//            System.out.println(s + ": NP:" + negotiatedPrice.get(s) + " NUM: " + prodQuantity.get(s) + " AVG:" + price);
            negotiatedPrice.put(s, price);
        }

        return negotiatedPrice;

    }
    
     /*  
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
     */
    //Sum of absolute value of the difference between the sale price and target price of the products this customer bought.
    public static Map<Integer, Integer> getCustomerTotalSale() throws IOException {
        Map<Integer, Integer> totalSale = new HashMap<>();
        Map<Integer, Product> prodCatalog = GeneralReader.getInstance().getProductCatalog();
        for (Order o : GeneralReader.getInstance().getOrderList()) {
            Product p = prodCatalog.get(o.getItem().getProductId());
            int total = Math.abs(o.getItem().getSalesPrice() - p.getTarget());

            totalSale.put(o.getCustomerId(), totalSale.getOrDefault(o.getCustomerId(), 0) + total);
        }
        return totalSale;
    }

    //sales people who have the most profit
    //Profit of a product = (sale price - target price) * sale quantity
    public static Map<Integer, Integer> getSalePeopleProfits() throws IOException {
        Map<Integer, Integer> totalProfits = new HashMap<>();
        Map<Integer, Product> prodCatalog = GeneralReader.getInstance().getProductCatalog();
        for (Order o : GeneralReader.getInstance().getOrderList()) {
            Product p = prodCatalog.get(o.getItem().getProductId());
            int profit = (o.getItem().getSalesPrice() - p.getTarget()) * o.getItem().getQuantity();

            totalProfits.put(o.getSupplierId(), totalProfits.getOrDefault(o.getSupplierId(), 0) + profit);
        }
        return totalProfits;
    }

    public static int getTotalRevenue() throws IOException {
        Map<Integer, Integer> totalSale = Tools.getSalePeopleProfits();
        int revenue = 0;
        for (Integer i : totalSale.values()) {
            revenue += i;
        }
        return revenue;
    }
}