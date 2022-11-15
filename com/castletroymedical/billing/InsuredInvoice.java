package com.castletroymedical.billing;

public class InsuredInvoice extends Invoice {

  public InsuredInvoice() {
    super(new InsuredPatientStrategy());
  }

  public double getCharge() {
    return 0.0;
  }

}