package com.castletroymedical.gateway;

public class CardPayment implements Payment{
    private double amount;
    private CardStrategy strategy;

    public CardPayment(CardStrategy strategy, double amount) {
      this.strategy = strategy;  
      this.amount = amount;
    }
    @Override
    public void execute() {
        // TODO Auto-generated method stub
        System.out.printf("Choose card payment amount %s", this.amount);
        strategy.pay(this.amount);      
    }    
}
