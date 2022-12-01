package com.castletroymedical.billing;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.castletroymedical.dto.InstalmentDTO;

public class InstalmentCalculator {
    public static List<InstalmentDTO> listInstalments(double total, double numberInstalments, int breakPeriod) {
        List<InstalmentDTO> instalments = new ArrayList<InstalmentDTO>();
        double instalment = total / numberInstalments;
        LocalDate date = LocalDate.now();
        for(int i=0; i < numberInstalments; i++) {            
            instalments.add(new InstalmentDTO(instalment, date));
            date = date.plusDays(breakPeriod);
        }
        return instalments;
    }

    public static double calculateInstalment(double total, double numberInstalments) {
        return total / numberInstalments;
    }
}
