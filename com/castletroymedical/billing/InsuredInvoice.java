package com.castletroymedical.billing;

public class InsuredInvoice extends Invoice {
  // private static PercentageModifier procedureMod = new IncreaseModifier(0.2);
  // private static PercentageModifier bedMod = new IncreaseModifier(0.2);
  // private static PercentageModifier monitoringMod = new IncreaseModifier(0.05);
  // private static PercentageModifier consultationMod = new IncreaseModifier(0.25);
  
  public InsuredInvoice() { 
    //super(procedureMod, bedMod, monitoringMod, consultationMod);
  }

  public double getCharge() {
    return 0.0;
  }

  public double getModifier() {
    return 1.5;
  }
  
}