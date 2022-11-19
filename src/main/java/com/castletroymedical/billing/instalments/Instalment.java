package com.castletroymedical.billing.instalments;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.castletroymedical.billing.Bill;

public class Instalment implements Bill {
    private double instalmentAmount;
    private LocalDate dateDue;
    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 

    public Instalment(double instalmentAmount) {
        this.instalmentAmount = instalmentAmount;
        this.dateDue = LocalDate.now();
    }

    public Instalment(double instalmentAmount, LocalDate dateDue) {
        this.instalmentAmount = instalmentAmount;
        this.dateDue = dateDue;
    }

    public double getCharge() {
        return this.instalmentAmount;
    }

    public LocalDate getDateDue() {
        return this.dateDue;
    }

    public String toString() {
        return String.format("Instalment amount of %.2f due on %s", this.instalmentAmount, this.dateDue.format(dateFormat));
    }
}
