package com.castletroymedical.billing;

public class WardBed extends InvoiceDecorator {
    private int days; 
    private static final double charge = 50.0;

    public WardBed(Invoice invoice){
        super(invoice, invoice.state);
        this.days = 1;
    }

    public WardBed(int days, Invoice invoice) {
        super(invoice, invoice.state);
        this.days = days;
    }

    public double getCharge() {
        return super.getCharge() + this.state.calculateBedRate(charge, days);
    }
}
