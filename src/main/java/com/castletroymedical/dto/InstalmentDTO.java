package com.castletroymedical.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.castletroymedical.billing.Bill;

public class InstalmentDTO implements Bill {
    private double instalmentAmount;
    private LocalDate dateDue;
    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 

    public InstalmentDTO(double instalmentAmount) {
        this.instalmentAmount = instalmentAmount;
        this.dateDue = LocalDate.now();
    }

    public InstalmentDTO(double instalmentAmount, LocalDate dateDue) {
        this.instalmentAmount = instalmentAmount;
        this.dateDue = dateDue;
    }

    public double getCharge() {
        return this.instalmentAmount;
    }

    public double getInstalmentAmount() {
        return this.instalmentAmount;
    }

    public void setInstalmentAmount(double instalmentAmount) {
        this.instalmentAmount = instalmentAmount;
    }

    public LocalDate getDateDue() {
        return this.dateDue;
    }

    public void setDateDue(LocalDate dateDue) {
        this.dateDue = dateDue;
    }   

    private String formatAmount() {
        return String.format("€%.2f", this.instalmentAmount);
    }

    private String formatDate() {
        return this.dateDue.format(dateFormat);
    }

    public String toString() {
        return String.format("Instalment amount of %s due on %s", formatAmount(), formatDate());
    }
}
