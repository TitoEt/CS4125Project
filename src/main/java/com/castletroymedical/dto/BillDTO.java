package com.castletroymedical.dto;

public class BillDTO { 
    private double amount;

    public BillDTO(double amount) {
        this.amount = amount;
    }   

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String toString() {
        return String.format("€%.2f", this.amount);
    }
}  
