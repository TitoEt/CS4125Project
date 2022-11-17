package com.castletroymedical.billing.instalments;

import com.castletroymedical.billing.Bill;

public class Instalment implements Bill {
    private Bill b;

    public Instalment(Bill b) {
        this.b = b;
    }

    public double getCharge() {
        return 0;
    }

}
