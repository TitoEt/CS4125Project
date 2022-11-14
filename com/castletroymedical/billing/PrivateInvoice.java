package com.castletroymedical.billing;

public class PrivateInvoice extends Invoice {
  // private static PercentageModifier procedureMod = new DefaultModifier();
  // private static PercentageModifier bedMod = new DefaultModifier();
  // private static PercentageModifier monitoringMod = new DefaultModifier();
  // private static PercentageModifier consultationMod = new DefaultModifier();
  
  public PrivateInvoice() {     
    // super(procedureMod, bedMod, monitoringMod, consultationMod);
  }

  public double getCharge(){
    return 0.0;
  }

  

}