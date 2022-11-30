package com.castletroymedical.billing.invoice;

public class InvoiceDecorator extends Invoice {
  private Invoice invoice;

  public InvoiceDecorator(Invoice invoice, ModifierState state) {
    super(state);
    this.invoice = invoice;
  }

  public double getCharge(){
    return invoice.getCharge();
  }

}