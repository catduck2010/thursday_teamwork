/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.xerox;

import com.assignment5.entities.Item;
import com.assignment5.entities.ModifiedData;
import com.assignment5.entities.Order;
import com.assignment5.entities.OriginalData;
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
    public static void topNegotiatedProducts() throws IOException {
        Map<Integer, Product> prodCatalog = GeneralReader.getInstance().getProductCatalog();
        Map<Integer, Double> overPrice = Tools.getNegotiatedPrice();

        //Map<Integer, Integer> prodNum = GeneralReader.getInstance().getProductNum();
        List<Map.Entry<Integer, Double>> ov = new ArrayList<>(overPrice.entrySet());

        Collections.sort(ov, new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }

        });

//        Map<Integer, Double> salesPrice = new HashMap<>();
//        //Map<Integer, Integer> prodNum = new HashMap<>();
//        double[] productNumber = new double[25];
//        double result = 0;
//        int allSalesPrice;
//        for (Order o : GeneralReader.getInstance().getOrderList()) {
//            Item i = o.getItem();
//            Product p = prodCatalog.get(o.getItem().getProductId());
//            if (o.getItem().getSalesPrice() > p.getTarget()) {
//                for (int j = 0; j <= Math.max(0, o.getItem().getProductId()); j++) {
//                    if (o.getItem().getProductId() == j) {
//                        allSalesPrice = o.getItem().getSalesPrice() * o.getItem().getQuantity();
//                        result = result + allSalesPrice;
//                    } else {
//                        productNumber[j] = result;
//                        continue;
//                    }
//                }
//                //System.out.println(result + " -----------------------------------------");
//            } else {
//                continue;
//            }
//
//            salesPrice.put(i.getProductId(), productNumber[i.getProductId()]);
//        }
//
//        int[] numbers1 = new int[salesPrice.keySet().size()];
//        List<Integer> prodIDList = new ArrayList<>(salesPrice.keySet());
//        for (Order o : GeneralReader.getInstance().getOrderList()) {
//            Item i = o.getItem();
//
//            numbers1[prodIDList.indexOf(i.getProductId())] += i.getQuantity();
//        }
//
//        for (int k = 0; k < numbers1.length; k++) {
//
//            int s = prodIDList.get(k);
//            //System.out.println(salesPrice.get(s) + "****************************************salesprice");
//            //System.out.println(numbers1[s] + "nums");
//            salesPrice.put(s, salesPrice.get(s) / numbers1[s]);
//        }
        System.out.println("Best 3 Negotiated Products:");

        for (int i = 0;; i++) {
            if (i >= ov.size()) {
                break;
            }
            if (i == 3) {
                for (;;) {
                    if (i >= ov.size()) {
                        return;
                    }
                    Map.Entry<Integer, Double> c = ov.get(i);
                    if (c.getValue().equals(ov.get(i - 1).getValue())) {
                        System.out.println("ProductID: " + c.getKey()
                                + " --> " + prodCatalog.get(c.getKey())
                                + " Avg Deal Price: "
                                + (c.getValue() + prodCatalog.get(c.getKey()).getTarget()));
                        i++;
                    } else {
                        return;
                    }
                }
            } else {
                Map.Entry<Integer, Double> c = ov.get(i);
                if (c == null) {
                    break;
                }
                System.out.println("ProductID: " + c.getKey()
                        + " --> " + prodCatalog.get(c.getKey()) + " Avg Deal Price: "
                        + (c.getValue() + prodCatalog.get(c.getKey()).getTarget()));

            }

        }
    }

    /*   
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
        int entry = 0;
        String[] hint = {"1st", "2nd", "3rd"};
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            if (entry >= ov.size()) {
                break;
            }
            Map.Entry<Integer, Integer> c = ov.get(entry++);
            if (c == null) {
                System.out.println("No related data.");
                break;
            }
            if (prev != c.getValue()) {
                if (i == 3) {
                    break;
                }
                System.out.println(hint[i] + ": ");
            } else {
                i--;
            }
            Product p = prodCatalog.get(c.getKey());
            System.out.println("productID: " + c.getKey() + " --> " + p);
            prev = c.getValue();
        }
    }
     */
    // 2) Our 3 best customers (customers who buy about target price)
    public static void BestCustomers() throws IOException {
        Map<Integer, Integer> totalSale = Tools.getCustomerTotalSale();
        List<Map.Entry<Integer, Integer>> tsList = new ArrayList<>(totalSale.entrySet());

        Collections.sort(tsList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }

        });
        //System.out.println(totalSale);
        System.out.println("Best 3 Customers:");
        int prev = Integer.MIN_VALUE;
        for (int i = 0;; i++) {
            if (i >= tsList.size()) {
                break;
            }
            if (i == 3) {
                for (;;) {
                    if (i >= tsList.size()) {
                        return;
                    }
                    Map.Entry<Integer, Integer> c = tsList.get(i++);
                    if (c.getValue().equals((Integer) prev)) {
                        System.out.println("Customer: " + c.getKey());
                        prev = c.getValue();
                    } else {
                        return;
                    }
                }
            } else {
                Map.Entry<Integer, Integer> c = tsList.get(i);
                System.out.println("Customer: " + c.getKey());
                prev = c.getValue();
            }
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
        //System.out.println(totalSale);
        System.out.println("Best 3 Sales People:");
        int profit = 0;
        for (int i = 0;; i++) {
            if (i >= tsList.size()) {
                break;
            }
            if (i == 3) {
                for (;;) {
                    if (i >= tsList.size()) {
                        return;
                    }
                    Map.Entry<Integer, Integer> c = tsList.get(i++);
                    if (c.getValue().equals((Integer) profit)) {
                        System.out.println("SalesPerson: " + c.getKey()
                                + " --> Profit: " + c.getValue());
                        profit = c.getValue();
                    } else {
                        return;
                    }
                }
            } else {
                Map.Entry<Integer, Integer> c = tsList.get(i);
                if (c == null) {
                    break;
                }
                System.out.println("SalesPerson: " + c.getKey()
                        + " --> Profit: " + c.getValue());
                profit = c.getValue();
            }

        }
    }

    //4) Our total revenue for the year that is above expected target
    public static void TotalRevenue() throws IOException {
        System.out.println("Total Revenue: " + Tools.getTotalRevenue());
    }

    /*
    5) Determine if the company is pricing its products correctly. 
    Show how to make changes so prices are performing at optimum levels. 
    [As we discussed in class] 
    You need to think about the questions, including but not limited to the 
    following questions: Is the target price too high or too low? Is there 
    enough gap between the target price and ceiling price? Is the ceiling 
    price/targe price/floor price should be adjusted depending on your analysis?
    a. You need to have two copies of the data. The first one includes original 
    prices and the other one includes prices after adjustments.   
    b. You need to explain how and why to make changes in prices. 
    c. You are required to implement a simple program to demonstrate why the 
    original prices need to be adjusted and why the modified prices are 
    performing at optimum levels. 
    The two copies of the data should contain at least 10 products and 
    1000 sales records.

    For original data, you need to print a table which includes 
    1. the average sale price of each product
    2. the targe price of each product
    3. the difference between the average sale price and target price of each product

    For modified data, you need to print a table which includes:
    1. the average sale price of each product
    2. the modified target price of each product
    3. the difference between the average sale price and target price of each product
    4. The error of the modified target price. 
    error = (modified target price - average sale price)/average sale price
    You need to show the modified target price is close to the sale price and 
    the error should be in the range of -5%-5%;

    For both two tables, you need to:
    1. separate the products into two sections: ones have average sale price 
    lower than the target price and ones have average sale price higher than 
    the target price. 
    2. sort the table by the difference between the average sale price and 
    target price of each product, from hight to low.
     */
    public static void Question5() throws IOException {
        // Original Data Table
        System.out.println("");
        System.out.println("Original Data Table");
        System.out.println("Product ID |  Average Sales Price | Target Price| Difference");
        List<OriginalData> originalDataList = new ArrayList<>();
        Map<Integer, Item> itemCatalog = GeneralReader.getInstance().getItemCatalog();
        Map<Integer, Product> prodCatalog = GeneralReader.getInstance().getProductCatalog();
        Map<Integer, Integer> proSalesPrice = new HashMap<>();
        List<ModifiedData> modifiedDataList = new ArrayList<>();
        Map<Integer, Product> modifiedProdCatalog = GeneralReader.getInstance().getModifiedProductCatalog();

        for (Map.Entry<Integer, Item> entry : itemCatalog.entrySet()) {

            int total = proSalesPrice.getOrDefault(entry.getValue().getProductId(), 0);
            proSalesPrice.put(entry.getValue().getProductId(), total + entry.getValue().getSalesPrice());
        }
        for (Map.Entry<Integer, Integer> entry1 : proSalesPrice.entrySet()) {
            int count = 0;
            for (Map.Entry<Integer, Item> entry : itemCatalog.entrySet()) {
                if (entry.getValue().getProductId() == entry1.getKey()) {
                    count += 1;
                }
            }

            double average = entry1.getValue() / (double) count;
            double target = prodCatalog.get(entry1.getKey()).getTarget();
            double difference = average - target;

            double newTarget = modifiedProdCatalog.get(entry1.getKey()).getTarget();
            double newdifference = average - newTarget;

            OriginalData od = new OriginalData(entry1.getKey(), average, target, difference);
            originalDataList.add(od);
            ModifiedData md = new ModifiedData(entry1.getKey(), average, newTarget, newdifference);
            modifiedDataList.add(md);
        }
        Collections.sort(originalDataList, new Comparator<OriginalData>() {
            @Override
            public int compare(OriginalData od1, OriginalData od2) {
                if (Math.abs(od2.getDifference()) > Math.abs(od1.getDifference())) {
                    return 1;
                }
                if (Math.abs(od2.getDifference()) < Math.abs(od1.getDifference())) {
                    return -1;
                }

                return 0;
            }
        });

        System.out.println("Section 1:");
        for (OriginalData od : originalDataList) {
            if (od.getDifference() < 0) {
                System.out.println(od);
            }
        }
        System.out.println("Section 2:");
        for (OriginalData od : originalDataList) {
            if (od.getDifference() > 0) {
                System.out.println(od);
            }
        }
        //Modify suggestion
        System.out.println("");
        System.out.println("Modify Suggestion:");
        Collections.sort(originalDataList, new Comparator<OriginalData>() {
            @Override
            public int compare(OriginalData od1, OriginalData od2) {
                return od1.getProductID() - od2.getProductID();
            }
        });
        for (OriginalData od : originalDataList) {
            double error = (od.getTarget() - od.getAverage()) / od.getAverage();
            if (error > 0.05 || error < -0.05) {
                System.out.println("Product ID:" + od.getProductID());
                System.out.println("Target price need modify, Suggestion range:" + 0.95 * od.getAverage() + "--" + 1.05 * od.getAverage());
            }
            if (error > -0.05 && error < 0.05) {
                System.out.println("Product ID:" + od.getProductID());
                System.out.println("Target Price do not need to modify ");
            }
        }
        // Print Modified Data Table
        System.out.println("");
        System.out.println("Modified Data Table");
        System.out.println("Product ID |  Average Sales Price | Modified Target Price| Difference | Error");
        Collections.sort(modifiedDataList, new Comparator<ModifiedData>() {
            @Override
            public int compare(ModifiedData md1, ModifiedData md2) {
                if (Math.abs(md2.getDifference()) > Math.abs(md1.getDifference())) {
                    return 1;
                }
                if (Math.abs(md2.getDifference()) < Math.abs(md1.getDifference())) {
                    return -1;
                }

                return 0;
            }
        });

        System.out.println("Section 1:");
        for (ModifiedData md : modifiedDataList) {
            if (md.getDifference() < 0) {
                System.out.println(md);
            }
        }
        System.out.println("Section 2:");
        for (ModifiedData md : modifiedDataList) {
            if (md.getDifference() > 0) {
                System.out.println(md);
            }
        }
    }

}
