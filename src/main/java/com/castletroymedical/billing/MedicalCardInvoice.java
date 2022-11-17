package com.castletroymedical.billing;

public class MedicalCardInvoice extends Invoice {
  
  public MedicalCardInvoice() { 
    super(new MedicalCardState());
  }

  public double getCharge(){
    return 0.0;
  }
}