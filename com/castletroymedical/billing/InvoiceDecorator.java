package com.castletroymedical.billing;

public class InvoiceDecorator extends Invoice {
  private Invoice invoice;

  public InvoiceDecorator(Invoice invoice, BillingStrategy strategy) {
    super(strategy);
    this.invoice = invoice;
  }

  public double getCharge(){
    return invoice.getCharge();
  }

}