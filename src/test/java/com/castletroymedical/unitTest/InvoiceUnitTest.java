package com.castletroymedical.unitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.castletroymedical.billing.invoice.*;

public class InvoiceUnitTest {
    double expected = 150;

    @Test
    public void invoiceTest() {
       assertEquals(expected, new Procedure("Xray", 150, new PrivateInvoice()).getCharge(), 0.0001);
    }
}