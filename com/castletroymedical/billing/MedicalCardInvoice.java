package com.castletroymedical.billing;

public class MedicalCardInvoice extends Invoice {
  private static PercentageModifier procedureMod = new ReduceModifier(0.5);
  private static PercentageModifier bedMod = new ReduceModifier(0.5);
  private static PercentageModifier monitoringMod = new StandardRate();
  private static PercentageModifier consultationMod = new FreeService();

  public MedicalCardInvoice() { 
    super(procedureMod, bedMod, monitoringMod, consultationMod);
  }

  public double getCharge(){
    return 0.0;
  }
}