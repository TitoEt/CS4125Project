package com.castletroymedical.database.service;

import org.springframework.stereotype.Service;

@Service
public class BillService {
    public double getCharge() {
        return 150; // TODO use repository
    }

    public String formatCharge(double charge) {
        return String.format("%.2f", charge);
    }
}
