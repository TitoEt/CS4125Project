package com.castletroymedical.billing;

public abstract class Invoice {
    protected BillingStrategy strategy;
    abstract public double getCharge();

    public Invoice(BillingStrategy strategy) {
        this.strategy = strategy;
    }

}