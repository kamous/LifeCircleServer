package com.wjw.lifecircle.model;
// default package

import java.sql.Timestamp;


/**
 * Order entity. @author MyEclipse Persistence Tools
 */

public class Order  implements java.io.Serializable {


    // Fields    

     private Integer orderId;
     private Product product;
     private User user;
     private Integer count;
     private double totalPrice;
     private Timestamp date;


    // Constructors

    /** default constructor */
    public Order() {
    }

    
    /** full constructor */
    public Order(Product product, User user, Integer count, double totalPrice, Timestamp date) {
        this.product = product;
        this.user = user;
        this.count = count;
        this.totalPrice = totalPrice;
        this.date = date;
    }

   
    // Property accessors

    public Integer getOrderId() {
        return this.orderId;
    }
    
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    public Integer getCount() {
        return this.count;
    }
    
    public void setCount(Integer count) {
        this.count = count;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }
    
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Timestamp getDate() {
        return this.date;
    }
    
    public void setDate(Timestamp date) {
        this.date = date;
    }
   








}