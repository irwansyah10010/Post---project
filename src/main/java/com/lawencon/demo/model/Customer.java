package com.lawencon.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_customer")
public class Customer extends BaseEntity{
    
    @Column(name = "customer_name",nullable = false, length = 20)
    private String customerName;

    public Customer(){

    }

    public Customer(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

}
