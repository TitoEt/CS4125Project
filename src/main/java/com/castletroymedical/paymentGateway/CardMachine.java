package com.castletroymedical.paymentGateway;

public class CardMachine implements CardStrategy, Payment{
    private double amount;

    public CardMachine() {
    }

    public CardMachine(double amount) {
        this.amount = amount;
    }

    public void pay(double amount) {
        System.out.println("Paid by Card");
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        
    }
}