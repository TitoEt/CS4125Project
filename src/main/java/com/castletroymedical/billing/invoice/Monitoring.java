package com.castletroymedical.billing.invoice;

public class Monitoring extends InvoiceDecorator {
  private int days; 
  private static final double CHARGE = 50.0;
  
  public Monitoring(int days, Invoice invoice){
    super(invoice, invoice.state);
    this.days = days;
  }  

  @Override
  public double getCharge(){
    return super.getCharge() + this.state.calculateMonitoringFee(CHARGE, days);
  }
}