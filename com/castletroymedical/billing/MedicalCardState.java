package com.castletroymedical.billing;

public class MedicalCardState extends ModifierState{
   
    public double calculateProcedureCost(double baseCost) {
        return baseCost - (baseCost * 0.5);
    }

    public double calculateConsultationFee(double baseCost) {
        return 0.0;
    }

    public double calculateMonitoringFee(double baseCost, int days) {
        return baseCost * days ;
    }

    public double calculateBedRate(double baseCost, int days) {
        return baseCost - (baseCost * 0.45);
    }
}
