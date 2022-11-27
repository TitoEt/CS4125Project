package com.castletroymedical.billing.invoice;

public class InsuredInvoice extends Invoice {

  public InsuredInvoice() {
    super(new InsuredPatientState());
  }

  public double getCharge() {
    return 0.0;
  }

}