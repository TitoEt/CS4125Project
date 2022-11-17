package com.castletroymedical.billing;

public class InsuredPatientState extends ModifierState{

    public double calculateProcedureCost(double baseCost) {
        return baseCost * 1.2;
    }

    public double calculateConsultationFee(double baseCost) {
        return baseCost * 1.25;
    }

    public double calculateMonitoringFee(double baseCost, int days) {
        return (baseCost * 1.05) * days ;
    }

    public double calculateBedRate(double baseCost, int days) {
        return (baseCost * 1.2) * days;
    }
 
}
