package com.castletroymedical.gateway;

public class PaymentGatewayDemo {
    public static void main(String[] args) {

        CashPayment cashpay = new CashPayment();
        StripePayment stripepay = new StripePayment();

        PaymentGateway gateway = new PaymentGateway();
        gateway.createPayment(stripepay);
        gateway.createPayment(cashpay);

        gateway.processTransaction();

    }
}
