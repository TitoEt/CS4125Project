package com.castletroymedical;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import com.castletroymedical.billing.InstalmentCalculator;

public class TestInstalment {

    @ParameterizedTest
    @MethodSource("generateValues")
    public void testInstalmentCalculation(double total, int numberInstalments, double expected) {
        assertEquals(expected, InstalmentCalculator.calculateInstalment(total, numberInstalments), 0.00001);
    }   

    private static Stream<Arguments> generateValues() {
        return Stream.of(
            Arguments.of(1000, 2, 500),
            Arguments.of(750, 3, 250),
            Arguments.of(1599.45, 15, 106.63)
        );
    }

}