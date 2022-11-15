package com.castletroymedical.billing;

public class MedicalCardInvoice extends Invoice {
  
  public MedicalCardInvoice() { 
    super(new MedicalCardStrategy());
  }

  public double getCharge(){
    return 0.0;
  }
}