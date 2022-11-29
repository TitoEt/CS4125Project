package com.castletroymedical.gateway;

import java.util.ArrayList;
import java.util.List;
import com.castletroymedical.billing.Bill;

public class PaymentGateway {
    private List<Payment> paymentList = new ArrayList<Payment>();

    public void createPayment(Payment p) {
        paymentList.add(p);
    }

    public void processTransaction() {
        for (Payment p : paymentList) {
            p.execute();
        }
        paymentList.clear();
    }
}
