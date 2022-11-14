package com.castletroymedical.billing;

public abstract class Invoice {
  // private PercentageModifier bedModifier;
  // private PercentageModifier monitoringModifier;
  // private PercentageModifier consultationModifier;
  // private PercentageModifier procedureModifier;

  abstract public double getCharge();

  // TODO public double getInsuredCharge() {
  //   return getCharge();
  // };

  // abstract void setMonitoringModifier(PercentageModifier monitoringModifier);

  
  public Invoice(){}

  public Invoice(PercentageModifier procedureModifier, PercentageModifier bedMod, PercentageModifier monitoringMod, PercentageModifier consultationMod) {
  }

  // public double getProcedureModifier() {
  //   return procedureModifier.getModifier();
  // }

  // public double getBedModifier() {
  //   return bedModifier.getModifier();
  // }

  // public double getMonitoringModifier() {
  //   return monitoringModifier.getModifier();
  // } 

  // public double getConsultationModifier() {
  //   return consultationModifier.getModifier();
  // }

  // public void setBedModifier(PercentageModifier bedModifier){
  //   this.bedModifier = bedModifier;
  // }

  // public void setMonitoringModifier(PercentageModifier monitoringModifier){
  //   this.monitoringModifier = monitoringModifier;
  // }

  // public void setConsultationModifier(PercentageModifier consultationModifier){
  //   this.consultationModifier = consultationModifier;
  // }

  // public void setProcedureModifier(PercentageModifier consultationModifier){
  //   this.consultationModifier = consultationModifier;
  // }
  
}