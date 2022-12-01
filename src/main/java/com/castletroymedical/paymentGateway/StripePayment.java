package com.castletroymedical.paymentGateway;

public class StripePayment implements CardStrategy {
  private double amount;

  public StripePayment() {
  }
  
  public StripePayment(double amount) {
    this.amount = amount;
  }  
  
  public void pay(double amount) {
    System.out.println("Paid through Stripe");
  }
     
}