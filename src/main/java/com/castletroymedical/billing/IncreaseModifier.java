package com.castletroymedical.billing;

public class IncreaseModifier extends PercentageModifier {
   
    public IncreaseModifier(double modifier) {
        super(modifier);
    }

    public double getModifier() {
        return 1 + modifier;
    }
}
