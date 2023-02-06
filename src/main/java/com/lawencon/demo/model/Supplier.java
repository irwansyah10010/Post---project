package com.lawencon.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_supplier")
public class Supplier extends BaseEntity{
    
    @Column(name = "supplier_name",nullable = false, length = 20)
    private String supplierName;

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    
}
