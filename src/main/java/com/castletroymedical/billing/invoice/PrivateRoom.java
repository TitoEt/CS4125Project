package com.castletroymedical.billing.invoice;

public class PrivateRoom extends InvoiceDecorator { 
    private int days; 
    private static final double charge = 150.0; 

    public PrivateRoom(Invoice invoice) {
        super(invoice, invoice.state);
        this.days = 1;
    }

    public PrivateRoom(int days, Invoice invoice) {
        super(invoice, invoice.state);
        this.days = days;
    }

    public double getCharge() {
        return super.getCharge() + this.state.calculateBedRate(charge, days);
    }
}
