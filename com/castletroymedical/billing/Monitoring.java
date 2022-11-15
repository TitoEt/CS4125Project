package com.castletroymedical.billing;

public class Monitoring extends InvoiceDecorator {
  private int days; 
  private static final double charge = 50.0;
  
  public Monitoring(Invoice invoice){
    super(invoice, invoice.strategy);
    this.days = 1;
  }

  public Monitoring(int days, Invoice invoice){
    super(invoice, invoice.strategy);
    this.days = days;
  }  

  public double getCharge(){
    return super.getCharge() + this.strategy.calculateMonitoringFee(charge, days);
  }
}