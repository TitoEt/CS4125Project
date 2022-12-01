package com.castletroymedical.service;

import org.springframework.stereotype.Service;
import com.castletroymedical.billing.Bill;

import com.castletroymedical.paymentGateway.CardMachine;
import com.castletroymedical.paymentGateway.CardPayment;
import com.castletroymedical.paymentGateway.CardStrategy;
import com.castletroymedical.paymentGateway.CashPayment;
import com.castletroymedical.paymentGateway.PaymentGateway;
import com.castletroymedical.paymentGateway.StripePayment;
import com.castletroymedical.billing.invoice.PrivateInvoice;
import com.castletroymedical.billing.invoice.Procedure;

@Service
public class PaymentService {
    payByCash(Bill b) {
        PaymentGateway gateway = new PaymentGateway();
        CashPayment cashpay = new CashPayment(b.getCharge());
        gateway.createPayment(cashpay);
        gateway.processTransaction();
    }
    

    payByCardMachine(Bill b) {
        PaymentGateway gateway = new PaymentGateway();
        CardMachine cardmachine = new CardMachine(b.getCharge());
        gateway.createPayment(cardmachine);
        gateway.processTransaction();
    }

    payByStripe(Bill b) {
        PaymentGateway gateway = new PaymentGateway();
        StripePayment stripepayment = new StripePayment(b.getCharge());
        gateway.createPayment(stripepayment);
        gateway.processTransaction();
    }
    public static void main(String[] args) {
        Bill b = new Procedure("Xray", 100, new PrivateInvoice());

        CashPayment cashpay = new CashPayment(b.getCharge());
        CardStrategy stripeStrat = new StripePayment();
        CardPayment stripepay = new CardPayment(stripeStrat, b.getCharge());
        CardStrategy onSiteStrat = new CardMachine();
        CardPayment sitepay = new CardPayment(onSiteStrat, b.getCharge());

        PaymentGateway gateway = new PaymentGateway();
        gateway.createPayment(stripepayment);
        gateway.createPayment(cashpay);
        gateway.createPayment(cardmachine);

        gateway.processTransaction();
    }
}
