/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.xerox;

import com.assignment5.entities.Item;
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
            System.out.println("SalesPerson: " + c.getKey()
                    + " --> Profit: " + c.getValue());
        }
    }

    //4) Our total revenue for the year that is above expected target
    public static void TotalRevenue() throws IOException {
        System.out.println("Total Revenue: " + Tools.getTotalRevenue());
    }

    //https://docs.google.com/document/d/1g82__eFobYWOTr-w8vRB_T_XBgJUjLhyHJnqN_yy0b4/
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
    
    
    // Original Data Table
    public static void PrintOriDataTable() throws IOException{
        System.out.println("Product ID |  Average Salses Price | Target Price| Difference");
        List<OriginalData> originalDataList = new ArrayList<>();
        Map<Integer, Item> itemCatalog = GeneralReader.getInstance().getItemCatalog();
        Map<Integer, Product> prodCatalog = GeneralReader.getInstance().getProductCatalog();
        /*List<Map.Entry<Integer,Item>> itemList = new ArrayList<>(itemCatalog.entrySet());
        Collections.sort(itemList,new Comparator<Map.Entry<Integer, Item>>(){
            @Override
            public int compare(Map.Entry<Integer,Item> i1,Map.Entry<Integer,Item> i2 ){
                return i1.getValue().getProductId() - i2.getValue().getProductId();
            }
        });*/
        Map<Integer, Integer> proSalesPrice = new HashMap<>();
        
        for(Map.Entry<Integer,Item> entry : itemCatalog.entrySet()){
            
            int total = proSalesPrice.getOrDefault(entry.getValue().getProductId(),0) ;
            proSalesPrice.put(entry.getValue().getProductId(),  total + entry.getValue().getSalesPrice());
        }
        for(Map.Entry<Integer,Integer> entry1 : proSalesPrice.entrySet()){
            int count = 0;
            for(Map.Entry<Integer,Item> entry : itemCatalog.entrySet()){
           if(entry.getValue().getProductId() == entry1.getKey())
               count+=1;
        }
            
            double average = entry1.getValue()/(double)count;
            double target = prodCatalog.get(entry1.getKey()).getTarget();
            double difference = average - target;
            
            OriginalData od =new OriginalData(entry1.getKey(), average, target, difference);
            originalDataList.add(od);  
        }
        Collections.sort(originalDataList,new Comparator<OriginalData>(){
            @Override
            public int compare(OriginalData od1,OriginalData od2 ){
                if(Math.abs(od2.getDifference()) > Math.abs(od1.getDifference()))
                    return  1;
                if(Math.abs(od2.getDifference()) < Math.abs(od1.getDifference()))
                {
                    return -1;
                }
                
                return 0;
            }
        });
        
        System.out.println("Section 1:");
        for(OriginalData od: originalDataList){
            if(od.getDifference()<0)
                System.out.println(od);
        }
        System.out.println("Section 2:");
        for(OriginalData od: originalDataList){
            if(od.getDifference()>0)
                System.out.println(od);
        }
    }
    
}
