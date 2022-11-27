package com.castletroymedical.database.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="procedure")
public class ProcedureEntity {
    @Id
    private int id;
    private String name;
    private double baseCharge;

    public ProcedureEntity(String name, double baseCharge) {
        this.name = name;
        this.baseCharge = baseCharge;
    }

    public int getId() {
        return id;
    }
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseCharge() {
        return baseCharge;
    }
    
    public void setBaseCharge(double baseCharge) {
        this.baseCharge = baseCharge;
    }
}
