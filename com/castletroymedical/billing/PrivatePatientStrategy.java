package com.castletroymedical.billing;

public class PrivatePatientStrategy implements BillingStrategy{
    private PercentageModifier procedureMod = new DefaultModifier();
    private PercentageModifier bedMod = new DefaultModifier();
    private PercentageModifier monitoringMod = new DefaultModifier();
    private PercentageModifier consultationMod = new DefaultModifier();

    public double calculateProcedureCost(double baseCost) {
        return baseCost * this.procedureMod.getModifier();
    }

    public double calculateConsultationFee(double baseCost) {
        return baseCost * this.consultationMod.getModifier();
    }

    public double calculateMonitoringFee(double baseCost, int days) {
        return baseCost * days * this.monitoringMod.getModifier();
    } 
    
}
