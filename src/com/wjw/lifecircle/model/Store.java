package com.wjw.lifecircle.model;
// default package

import java.util.HashSet;
import java.util.Set;


/**
 * Store entity. @author MyEclipse Persistence Tools
 */

public class Store  implements java.io.Serializable {


    // Fields    

     private Integer storeId;
     private City city;
     private String name;
     private String phone;
     private String locationStr;
     private double lon;
     private double lat;
     private String info;
     private Type type;
     private Set products = new HashSet(0);


    // Constructors

    public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	/** default constructor */
    public Store() {
    }

    
    /** full constructor */
    public Store(City city, String name, Type type, String phone, String locationStr, double lon, double lat, String info, Set products) {
        this.type = type;
    	this.city = city;
        this.name = name;
        this.phone = phone;
        this.locationStr = locationStr;
        this.lon = lon;
        this.lat = lat;
        this.info = info;
        this.products = products;
    }

   
    // Property accessors

    public Integer getStoreId() {
        return this.storeId;
    }
    
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public City getCity() {
        return this.city;
    }
    
    public void setCity(City city) {
        this.city = city;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocationStr() {
        return this.locationStr;
    }
    
    public void setLocationStr(String locationStr) {
        this.locationStr = locationStr;
    }

    public double getLon() {
        return this.lon;
    }
    
    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return this.lat;
    }
    
    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getInfo() {
        return this.info;
    }
    
    public void setInfo(String info) {
        this.info = info;
    }

    public Set getProducts() {
        return this.products;
    }
    
    public void setProducts(Set products) {
        this.products = products;
    }
   








}