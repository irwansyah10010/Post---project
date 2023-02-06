package com.lawencon.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_product")
public class Product extends BaseEntity{

    @Column(name = "product_code",nullable = false, length = 5,unique=true)
    private String productCode;

    @Column(name = "product_name",nullable = false, length = 20)
    private String productName;

    public Product(){
        
    }    

    public Product(String productCode, String productName) {
        this.productCode = productCode;
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    
}
