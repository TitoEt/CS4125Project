package com.castletroymedical.paymentGateway;

import java.util.ArrayList;
import java.util.List;

public class PaymentGateway {
    private List<Payment> paymentList = new ArrayList<Payment>();

    public void createPayment(Payment payment) {
        paymentList.add(payment);
    }

    public void processTransaction() {
        for (Payment p : paymentList) {
            p.execute();
        }
        paymentList.clear();
    }

}
