package com.castletroymedical.billing;

public class PrivateInvoice extends Invoice {
 
  public PrivateInvoice() {     
    super(new PrivatePatientStrategy());
  }

  public double getCharge(){
    return 0.0;
  }

  

}