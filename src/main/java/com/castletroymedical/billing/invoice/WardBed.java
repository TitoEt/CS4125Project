package com.castletroymedical.billing.invoice;

public class WardBed extends InvoiceDecorator {
    private int days; 
    private static final double CHARGE = 50.0;

    public WardBed(int days, Invoice invoice) {
        super(invoice, invoice.state);
        this.days = days;
    }

    @Override
    public double getCharge() {
        return super.getCharge() + this.state.calculateBedRate(CHARGE, days);
    }
}
