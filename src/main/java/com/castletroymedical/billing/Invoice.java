package com.castletroymedical.billing;

public abstract class Invoice implements Bill {
    protected ModifierState state;

    abstract public double getCharge();

    public Invoice(ModifierState state) {
        this.state = state;
    }

}