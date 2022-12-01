package com.castletroymedical.paymentGateway;

public class StripePayment implements CardStrategy, Payment {
  
  private double amount;
  
  public StripePayment(double amount) {
    this.amount = amount;
}
    public StripePayment() {
  }
    public void pay(double amount) {
      System.out.println("Paid through Stripe");
    }
    @Override
    public void execute() {
      // TODO Auto-generated method stub
      
    }   
}