package com.wjw.lifecircle.model;
// default package

import java.util.HashSet;
import java.util.Set;


/**
 * Type entity. @author MyEclipse Persistence Tools
 */

public class Type  implements java.io.Serializable {


    // Fields    

     private Integer typeId;
     private String name;
     private Set stores = new HashSet(0);


    // Constructors

    /** default constructor */
    public Type() {
    }

    
    /** full constructor */
    public Type(String name, Set stores) {
        this.name = name;
        this.stores = stores;
    }

   
    // Property accessors

    public Integer getTypeId() {
        return this.typeId;
    }
    
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Set getStores() {
        return this.stores;
    }
    
    public void setStores(Set stores) {
        this.stores = stores;
    }
   








}