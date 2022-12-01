package com.castletroymedical.gateway;

public class CardMachine implements CardStrategy{
    public void pay(double amount) {
        System.out.println("Paid by Card");
    }
}