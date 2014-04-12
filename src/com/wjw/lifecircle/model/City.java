package com.wjw.lifecircle.model;
// default package

import java.util.HashSet;
import java.util.Set;


/**
 * City entity. @author MyEclipse Persistence Tools
 */

public class City  implements java.io.Serializable {


    // Fields    

     private Integer cityId;
     private String name;
     private String info;
     private Set stores = new HashSet(0);


    // Constructors

    /** default constructor */
    public City() {
    }

    
    /** full constructor */
    public City(String name, String info, Set stores) {
        this.name = name;
        this.info = info;
        this.stores = stores;
    }

   
    // Property accessors

    public Integer getCityId() {
        return this.cityId;
    }
    
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return this.info;
    }
    
    public void setInfo(String info) {
        this.info = info;
    }

    public Set getStores() {
        return this.stores;
    }
    
    public void setStores(Set stores) {
        this.stores = stores;
    }
   








}