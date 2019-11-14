/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.xerox;

import com.assignment5.entities.Item;
import com.assignment5.entities.Order;
import com.assignment5.entities.Product;
import static com.assignment5.xerox.DataGenerator.NEW_PROD_CAT_PATH;
import static com.assignment5.xerox.DataGenerator.PROD_CAT_PATH;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lihang
 */
public class GeneralReader {

    private static GeneralReader theReader;
    private DataReader orderReader;
    private DataReader prodReader;
    private DataReader modProReader;
    private Map<Integer, Product> productCatalog;
    private Map<Integer, Product> modifiedProductCatalog;
    private Map<Integer, Item> itemCatalog;
    private ArrayList<Order> orderList;
    private File file;
    private File copyFile;
    private Map<Integer, Integer> productNum;

    public Map<Integer, Integer> getProductNum() {
        return productNum;
    }

    public void setProductNum(Map<Integer, Integer> productNum) {
        this.productNum = productNum;
    }

    public GeneralReader() throws IOException {
        productCatalog = new HashMap<>();
        modifiedProductCatalog = new HashMap<>();
        itemCatalog = new HashMap<>();
        orderList = new ArrayList<>();
        orderReader = new DataReader(DataGenerator.ORDER_FILE_PATH);
        prodReader = new DataReader(DataGenerator.PROD_CAT_PATH);
        try {
            file = new File(PROD_CAT_PATH);
           copyFile = new File(NEW_PROD_CAT_PATH);
           
           if(!copyFile.exists()){
                
                Files.copy(file.toPath(), copyFile.toPath());
            }
        }catch (IOException e) {
                System.out.println("Error ");
                e.printStackTrace();
            
        
    }
        modProReader =  new DataReader(DataGenerator.NEW_PROD_CAT_PATH);
        
        productNum = new HashMap<>();

        parseProductRow();
        parseOrderRow();
        parseModProductRow();
    }

    public static GeneralReader getInstance() throws IOException {
        if (theReader == null) {
            theReader = new GeneralReader();
        }
        return theReader;
    }

    private void parseOrderRow() throws IOException {
        //Order-Id, Item-id, Product-Id, Quantity, Sales-Id, Customer-Id, Sales-Price-Per-Prod, Market-Segment,
        for (;;) {
            String[] line = orderReader.getNextRow();
            if (line == null) {
                System.out.println("Parse Order Over");
                return;
            }
            int orderId = Integer.parseInt(line[0]);
            int itemId = Integer.parseInt(line[1]);
            int prodId = Integer.parseInt(line[2]);
            int qtt = Integer.parseInt(line[3]);
            int salesId = Integer.parseInt(line[4]);
            int custId = Integer.parseInt(line[5]);
            int salPrice = Integer.parseInt(line[6]);

            String mkt = line[7];

            Item item = new Item(prodId, salPrice, qtt);
            itemCatalog.put(itemId, item);

            Order theOrder = new Order(orderId, salesId, custId, item);
            orderList.add(theOrder);
            //System.out.println(theOrder);
        }
    }

    private void parseProductRow() throws IOException {
        //Product-Id, Min-Price, Max-Price, Target-Price, 
        for (;;) {
            String[] line = prodReader.getNextRow();
            if (line == null) {
                System.out.println("Parse Product Over");
                return;
            }
            int prodId = Integer.parseInt(line[0]);
            int min = Integer.parseInt(line[1]);
            int max = Integer.parseInt(line[2]);
            int tar = Integer.parseInt(line[3]);

            Product prod = new Product(min, max, tar);
            productCatalog.put(prodId, prod);
            //System.out.println("productID: "+prodId+"->"+prod.toString());
        }
    }
    private void parseModProductRow() throws IOException {
        //Product-Id, Min-Price, Max-Price, Target-Price, 
        for (;;) {
            String[] line = modProReader.getNextRow();
            if (line == null) {
                System.out.println("Parse New Product Over");
                return;
            }
            int prodId = Integer.parseInt(line[0]);
            int min = Integer.parseInt(line[1]);
            int max = Integer.parseInt(line[2]);
            int tar = Integer.parseInt(line[3]);

            Product prod = new Product(min, max, tar);
            modifiedProductCatalog.put(prodId, prod);
            //System.out.println("productID: "+prodId+"->"+prod.toString());
        }
    }

    public Map<Integer, Product> getProductCatalog() {
        return productCatalog;
    }

    public Map<Integer, Product> getModifiedProductCatalog() {
        return modifiedProductCatalog;
    }
    

    public Map<Integer, Item> getItemCatalog() {
        return itemCatalog;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }
}
