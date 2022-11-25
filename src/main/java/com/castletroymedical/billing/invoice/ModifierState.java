package com.castletroymedical.billing.invoice;

public abstract class ModifierState {
    public abstract double calculateProcedureCost(double baseCost);
    public abstract double calculateConsultationFee(double baseCost);
    public abstract double calculateMonitoringFee(double baseCost, int days);
    public abstract double calculateBedRate(double baseCost, int days);

}