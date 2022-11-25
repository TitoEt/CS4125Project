package com.castletroymedical.billing.invoice;

import com.castletroymedical.billing.Bill;

public abstract class Invoice implements Bill {
    protected ModifierState state;

    abstract public double getCharge();

    public Invoice(ModifierState state) {
        this.state = state;
    }

}