package com.castletroymedical.paymentGateway;

public class CashPayment implements Payment {
    private double amount;

    public CashPayment(double amount) {
        this.amount = amount;
    }

    @Override
    public void execute() {
        // TODO register cash paid in db 
        System.out.printf("Paid by Cash %f", this.amount);
    }

}