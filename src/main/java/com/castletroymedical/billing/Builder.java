package com.castletroymedical.billing;

import com.castletroymedical.billing.invoice.Invoice;

public abstract class Builder {
    protected Invoice invoice;
    public abstract void buildConsultation();
    public abstract void buildMonitoring();
    public abstract void buildMonitoring(int days);
    public abstract void buildPrivateRoom();
    public abstract void buildPrivateRoom(int days);
    public abstract void buildProcedure(String name);
    public abstract void buildWardBed();
    public abstract void buildWardBed(int days);
    public abstract Invoice getInvoice();
}
