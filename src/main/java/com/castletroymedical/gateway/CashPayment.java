package com.castletroymedical.gateway;

import com.castletroymedical.billing.Bill;

public class CashPayment implements Payment {
    private Bill b;

    @Override
    public void execute() {
        b.getCharge();
    }

    public void cashpay(Bill b) {
        this.b = b;
    }

}
