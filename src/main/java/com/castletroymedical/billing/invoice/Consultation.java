package com.castletroymedical.billing.invoice;

public class Consultation extends InvoiceDecorator {
  private static final double CHARGE = 30.0;
  
  public Consultation(Invoice invoice){
    super(invoice, invoice.state);
  }

  @Override
  public double getCharge(){
    return super.getCharge() + this.state.calculateConsultationFee(CHARGE);
  }
}