package com.castletroymedical.paymentGateway;

public class CardMachine implements CardStrategy{
    public void pay(double amount) {
        System.out.println("Paid by Card");
    }
}