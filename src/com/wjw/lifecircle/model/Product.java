package com.wjw.lifecircle.model;
// default package

import java.util.HashSet;
import java.util.Set;


/**
 * Product entity. @author MyEclipse Persistence Tools
 */

public class Product  implements java.io.Serializable {


    // Fields    

     private Integer productId;
     private Store store;
     //private Type type;
     private String name;
     private double price;
     private String info;
     private String description;
     private String pics;
     private Set orders = new HashSet(0);


    // Constructors

    /** default constructor */
    public Product() {
    }

    
    /** full constructor */
    public Product(Store store,  String name, double price, String info, String description, String pics, Set orders) {
        this.store = store;
       // this.type = type;
        this.name = name;
        this.price = price;
        this.info = info;
        this.description = description;
        this.pics = pics;
        this.orders = orders;
    }

   
    // Property accessors

    public Integer getProductId() {
        return this.productId;
    }
    
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Store getStore() {
        return this.store;
    }
    
    public void setStore(Store store) {
        this.store = store;
    }


    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }

    public String getInfo() {
        return this.info;
    }
    
    public void setInfo(String info) {
        this.info = info;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getPics() {
        return this.pics;
    }
    
    public void setPics(String pics) {
        this.pics = pics;
    }

    public Set getOrders() {
        return this.orders;
    }
    
    public void setOrders(Set orders) {
        this.orders = orders;
    }
   








}