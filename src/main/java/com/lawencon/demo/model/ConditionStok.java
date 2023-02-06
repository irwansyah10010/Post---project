package com.lawencon.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_condition_stok")
public class ConditionStok extends BaseEntity{
    
    @Column(name = "condition_stok_code",nullable = false, length = 5,unique = true)
    private String conditionStokCode;

    @Column(name = "condition_stok_name",nullable = false, length = 20)
    private String conditionStokName;

    public ConditionStok(){

    }

    public ConditionStok(String conditionStokCode, String conditionStokName) {
        this.conditionStokCode = conditionStokCode;
        this.conditionStokName = conditionStokName;
    }

    public String getConditionStokCode() {
        return conditionStokCode;
    }

    public void setConditionStokCode(String conditionStokCode) {
        this.conditionStokCode = conditionStokCode;
    }

    public String getConditionStokName() {
        return conditionStokName;
    }

    public void setConditionStokName(String conditionStokName) {
        this.conditionStokName = conditionStokName;
    }
    
}
