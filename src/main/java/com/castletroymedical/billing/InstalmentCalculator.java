package com.castletroymedical.billing;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.castletroymedical.dto.InstalmentDTO;

public class InstalmentCalculator {

    private InstalmentCalculator(){
    }

    public static List<InstalmentDTO> listInstalments(double total, double numberInstalments, int breakPeriod) {
        return listInstalments(total, numberInstalments, breakPeriod, LocalDate.now());
    }

    public static List<InstalmentDTO> listInstalments(double total, double numberInstalments, int breakPeriod, LocalDate startDate) {
        List<InstalmentDTO> instalments = new ArrayList<InstalmentDTO>();
        double instalment = total / numberInstalments;
        LocalDate date = startDate;
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
