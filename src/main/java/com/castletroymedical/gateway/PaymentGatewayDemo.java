package com.castletroymedical.gateway;

import com.castletroymedical.billing.Bill;
import com.castletroymedical.billing.invoice.MedicalCardInvoice;
import com.castletroymedical.billing.invoice.PrivateInvoice;
import com.castletroymedical.billing.invoice.Procedure;
import com.stripe.model.Invoice;

public class PaymentGatewayDemo {
    public static void main(String[] args) {
        Bill b = new Procedure("Xray", 100, new PrivateInvoice());

        CashPayment cashpay = new CashPayment(b.getCharge());
        CardPayment stripepay = new CardPayment(b.getCharge());

        PaymentGateway gateway = new PaymentGateway();
        gateway.createPayment(stripepay);
        gateway.createPayment(cashpay);

        gateway.processTransaction();
    }
}
