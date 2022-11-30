package com.castletroymedical.gateway;

import com.castletroymedical.billing.Bill;

public class CardPayment implements Payment{
    private double amount;

    public CardPayment(double amount) {
        this.amount = amount;
    }
    @Override
    public void execute() {
        // TODO Auto-generated method stub
        System.out.printf("Choose card payment amount %s", this.amount);
    }
    
}
