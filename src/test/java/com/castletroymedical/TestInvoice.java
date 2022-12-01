package com.castletroymedical;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.castletroymedical.billing.invoice.*;

public class TestInvoice {
    double expected = 100;

    @Test
    public void invoiceTest() {
       assertEquals(expected, new Procedure("Xray", 150, new PrivateInvoice()).getCharge(), 0.0001);
    }
}