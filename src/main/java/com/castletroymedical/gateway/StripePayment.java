package com.castletroymedical.gateway;

public class StripePayment implements CardStrategy {
    public void pay(double amount) {
      System.out.println("Call payment controller");
    }   
}