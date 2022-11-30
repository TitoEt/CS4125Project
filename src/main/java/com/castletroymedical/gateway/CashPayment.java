package com.castletroymedical.gateway;

import com.castletroymedical.billing.Bill;

public class CashPayment implements Payment {
    private double amount;

    public CashPayment(double amount) {
        this.amount = amount;
    }

    @Override
    public void execute() {
        // TODO register cash paid in db 
        System.out.printf("Paid by Cash %f", this.amount);
        // System.out.printf("Paid by Cash %f", bill.getCharge());
    }

}