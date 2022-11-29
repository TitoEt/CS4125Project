package com.castletroymedical.gateway;

import com.castletroymedical.billing.Bill;

public class StripePayment implements Payment {
    private Bill b;

    @Override
    public void execute() {
        b.getCharge();
    }

    public void stripepay(Bill b) {
        this.b = b;
    }

}
