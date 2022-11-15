package com.castletroymedical.billing;

public interface BillingStrategy {
    double calculateProcedureCost(double baseCost);
    double calculateConsultationFee(double baseCost);
    double calculateMonitoringFee(double baseCost, int days);
}
