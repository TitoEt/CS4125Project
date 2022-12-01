package com.castletroymedical;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import com.castletroymedical.billing.invoice.*;

public class TestInvoice {

    @ParameterizedTest
    @MethodSource("generateInvoices")
    public void testInvoice(Invoice invoice, double expected) {
        assertEquals(expected, invoice.getCharge());
    }

    private static Stream<Arguments> generateInvoices() {
        return Stream.of(
            Arguments.of(new Procedure("MRI", 150, new PrivateInvoice()), 150),
            Arguments.of(new Procedure("Vaccinations", 40, new MedicalCardInvoice()), 20),
            Arguments.of(new Procedure("CAT Scan", 75, new InsuredInvoice()), 90),
            Arguments.of(new Procedure("Thyroid procedure", 650, new Consultation(new PrivateInvoice())), 680),
            Arguments.of(new Procedure("Cryotherapy", 60, new Consultation(new MedicalCardInvoice())), 30),
            Arguments.of(new Procedure("Brain Stem Augmentation", 8000, new Consultation(new PrivateRoom(5, new Monitoring(3, new InsuredInvoice())))), 10695),
            Arguments.of(new Procedure("Chemotherapy", 150, new WardBed(2, new Monitoring(2, new MedicalCardInvoice()))), 220)
        );
    }

}