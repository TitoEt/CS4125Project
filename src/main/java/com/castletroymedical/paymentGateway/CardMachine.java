package com.castletroymedical.paymentGateway;

public class CardMachine implements CardStrategy{
    private double amount;

    public CardMachine() {
    }

    public CardMachine(double amount) {
        this.amount = amount;
    }

    public void pay(double amount) {
        System.out.println("Paid by Card");
    }
}