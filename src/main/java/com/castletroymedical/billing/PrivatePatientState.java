package com.castletroymedical.billing;

public class PrivatePatientState extends ModifierState{

    public double calculateProcedureCost(double baseCost) {
        return baseCost;
    }

    public double calculateConsultationFee(double baseCost) {
        return baseCost;
    }

    public double calculateMonitoringFee(double baseCost, int days) {
        return baseCost * days ;
    }

    public double calculateBedRate(double baseCost, int days) {
        return baseCost * days;
    }
}
