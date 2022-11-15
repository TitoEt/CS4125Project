package com.castletroymedical.billing;

public class MedicalCardStrategy implements BillingStrategy{
    private PercentageModifier procedureMod = new ReduceModifier(0.5);
    private PercentageModifier bedMod = new ReduceModifier(0.5);
    private PercentageModifier monitoringMod = new StandardRate();
    private PercentageModifier consultationMod = new FreeService();
    
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
