package com.castletroymedical.billing;

public class StandardRate extends PercentageModifier {

    public StandardRate() {
        super(1);
    }
    
    public double getModifier() {
        return modifier;
    }
}
