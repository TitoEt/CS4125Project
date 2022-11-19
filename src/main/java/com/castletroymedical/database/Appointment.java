package com.castletroymedical.database;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Appointment {
    private int patientID;
    private String procedure;
    private LocalDateTime time;
    private final DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm"); 
    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 

    public Appointment() {
        this.time = LocalDateTime.now(); 
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setTime(int year, int month, int dayOfMonth, int hour, int minute) {
        this.time = LocalDateTime.of(year, month, dayOfMonth, hour, minute, minute);
    }

    public String toString() {
        return String.format("Upcoming appointment at %s on %s", this.time.format(timeFormat), this.time.format(dateFormat));
    }
}

