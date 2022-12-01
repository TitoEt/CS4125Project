package com.castletroymedical.dto;

public class ChargeDTO {
    private String description;
    private double amount;

    public ChargeDTO() {        
    }

    public ChargeDTO(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String toString() {
        return String.format("Charge for %s amounts to €%.2f", getDescription(), this.amount);
    }
}
