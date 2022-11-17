package com.castletroymedical.billing;

public abstract class PercentageModifier {
    protected double modifier;

    public PercentageModifier(double modifier) {
        this.modifier = modifier;
    }

    public abstract double getModifier();
  
}