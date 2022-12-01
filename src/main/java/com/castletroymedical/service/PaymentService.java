package com.castletroymedical.service;

import org.springframework.stereotype.Service;
import com.castletroymedical.billing.Bill;

import com.castletroymedical.paymentGateway.CardMachine;
import com.castletroymedical.paymentGateway.CardPayment;
import com.castletroymedical.paymentGateway.CardStrategy;
import com.castletroymedical.paymentGateway.CashPayment;
import com.castletroymedical.paymentGateway.PaymentGateway;
import com.castletroymedical.paymentGateway.StripePayment;

@Service
public class PaymentService {
    public void payByCash(Bill b) {
        PaymentGateway gateway = new PaymentGateway();
        CashPayment cashPayment = new CashPayment(b.getCharge());
        gateway.createPayment(cashPayment);
        gateway.processTransaction();
    }    

    public void payByCardMachine(Bill b) {
        PaymentGateway gateway = new PaymentGateway();
        CardStrategy cardMachineStrategy = new CardMachine();
        CardPayment cardMachinePayment = new CardPayment(cardMachineStrategy, b.getCharge());
        gateway.createPayment(cardMachinePayment);
        gateway.processTransaction();
    }

    public void payByStripe(Bill b) {
        PaymentGateway gateway = new PaymentGateway();
        CardStrategy stripeStrategy = new StripePayment();
        CardPayment stripePayment = new CardPayment(stripeStrategy, b.getCharge());
        gateway.createPayment(stripePayment);
        gateway.processTransaction();
    }

}
