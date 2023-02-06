package com.lawencon.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_product_type")
public class ProductType extends BaseEntity{
    
    @Column(name = "product_type_code",nullable = false, length = 5,unique = true)
    private String productTypeCode;

    @Column(name = "product_type_name",nullable = false, length = 20)
    private String productTypeName;

    public String getProductTypeCode() {
        return productTypeCode;
    }

    public void setProductTypeCode(String productTypeCode) {
        this.productTypeCode = productTypeCode;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }


    
}
