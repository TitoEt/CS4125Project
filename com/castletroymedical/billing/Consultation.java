package com.castletroymedical.billing;

public class Consultation extends InvoiceDecorator {
  private static final double charge = 30.0;
  
  public Consultation(Invoice invoice){
    super(invoice, invoice.strategy);
  }

  public double getCharge(){
    return super.getCharge() + this.strategy.calculateConsultationFee(charge);
  }
}