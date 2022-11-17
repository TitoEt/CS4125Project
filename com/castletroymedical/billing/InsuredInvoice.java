package com.castletroymedical.billing;

public class InsuredInvoice extends Invoice {

  public InsuredInvoice() {
    super(new InsuredPatientState());
  }

  public double getCharge() {
    return 0.0;
  }

}