package com.castletroymedical.billing;

public class PrivateInvoice extends Invoice {
 
  public PrivateInvoice() {     
    super(new PrivatePatientState());
  }

  public double getCharge(){
    return 0.0;
  }
}