package com.castletroymedical.paymentGateway;

import java.util.ArrayList;
import java.util.List;

public class PaymentGateway {
    private List<Payment> paymentList = new ArrayList<Payment>();

    public void createPayment(CashPayment cashpay) {
        paymentList.add(cashpay);
    }
    public void createPayment(CardMachine cardmachine) {
        paymentList.add(cardmachine);
    }
    public void createPayment(StripePayment stripepayment) {
        paymentList.add(stripepayment);
    }

    public void processTransaction() {
        for (Payment p : paymentList) {
            p.execute();
        }
        paymentList.clear();
    }
    
