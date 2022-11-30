package com.castletroymedical.gateway;

public class CardOnSite implements CardStrategy{
    public void pay(double amount) {
        System.out.println("Sends message to DB");
    }
}