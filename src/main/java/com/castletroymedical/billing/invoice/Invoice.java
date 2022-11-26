package com.castletroymedical.billing.invoice;

import com.castletroymedical.billing.Bill;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Invoice implements Bill {
    protected ModifierState state;
    private LocalDate dateIssued;
    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 

    abstract public double getCharge();

    public Invoice(ModifierState state) {
        this.state = state;
        this.dateIssued = LocalDate.now();
    }

    public String toString() {
        return String.format("Invoice generated on %s amounting to %.2f", this.dateIssued.format(dateFormat), getCharge());
    }

}