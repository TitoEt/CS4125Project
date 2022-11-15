package com.castletroymedical.billing;

public class InsuredPatientStrategy implements BillingStrategy{
    private PercentageModifier procedureMod = new IncreaseModifier(0.2);
    private PercentageModifier bedMod = new IncreaseModifier(0.2);
    private PercentageModifier monitoringMod = new IncreaseModifier(0.05);
    private PercentageModifier consultationMod = new IncreaseModifier(0.25);

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
