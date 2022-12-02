package com.castletroymedical.dto;

public class BillAmountDTO { 
    private double amount;
    private Long billID;

    public BillAmountDTO() {        
    }

    public BillAmountDTO(double amount) {
        this.amount = amount;
    }

    public BillAmountDTO(double amount, Long billID) {
        this.amount = amount;
        this.billID = billID;
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

    public Long getBillID() {
        return billID;
    }

    public void setBillID(Long billID) {
        this.billID = billID;
    }
}  
