package com.castletroymedical.billing;

public class InvoiceDecorator extends Invoice {
  private Invoice invoice;
  private final double baseCharge; // Q why have this

  public InvoiceDecorator(Invoice invoice, double baseCharge){
    this.invoice = invoice;
    this.baseCharge = baseCharge;
  }  

  public double getCharge(){
    return invoice.getCharge();
  }

  // public double getModifier(){
  //   return invoice.getModifier();
  // }

  public double getBaseCharge() {
    return baseCharge;
  }
}