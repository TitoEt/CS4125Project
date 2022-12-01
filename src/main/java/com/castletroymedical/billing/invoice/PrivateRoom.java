package com.castletroymedical.billing.invoice;

public class PrivateRoom extends InvoiceDecorator { 
    private int days; 
    private static final double CHARGE = 150.0; 

    public PrivateRoom(int days, Invoice invoice) {
        super(invoice, invoice.state);
        this.days = days;
    }

    @Override
    public double getCharge() {
        return super.getCharge() + this.state.calculateBedRate(CHARGE, days);
    }
}
