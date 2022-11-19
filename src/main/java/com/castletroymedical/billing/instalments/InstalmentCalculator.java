package com.castletroymedical.billing.instalments;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InstalmentCalculator {

    public static List<Instalment> calculateInstalments(double total, int numberInstalments, int breakPeriod) {
        List<Instalment> instalments = new ArrayList<Instalment>();
        double instalment = total / numberInstalments;
        LocalDate date = LocalDate.now();
        for(int i=0; i < numberInstalments; i++) {            
            instalments.add(new Instalment(instalment, date));
            date = date.plusDays(breakPeriod);
        }
        return instalments;
    }
}
