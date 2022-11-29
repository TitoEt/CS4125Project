package com.castletroymedical.dto;

public class InvoiceDetailsDTO {
    private String name;
    private String ppsn;
    private String patientType;
    private String procedure;
    private boolean consultation;  
    private boolean hospitalStay;
    private String bedType;
    private int stayDuration;
    private boolean monitoring;
    private int monitoringDuration;

    public InvoiceDetailsDTO() {
    }

    public InvoiceDetailsDTO(String name, String ppsn, String invoiceType) {
        this.name = name;
        this.ppsn = ppsn;
        this.patientType = invoiceType;
    }    

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPpsn() {
        return this.ppsn;
    }

    public void setPpsn(String ppsn) {
        this.ppsn = ppsn;
    }

    public String getProcedure() {
        return this.procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public boolean getConsultation() {
        return this.consultation;
    }

    public void setConsultation(boolean consultation) {
        this.consultation = consultation;
    }

    public boolean getHospitalStay() {
        return this.hospitalStay;
    }

    public void setHospitalStay(boolean hospitalStay) {
        this.hospitalStay = hospitalStay;
    }

    public String getBedType() {
        return this.bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public int getStayDuration() {
        return this.stayDuration;
    }

    public void setStayDuration(int stayDuration) {
        this.stayDuration = stayDuration;
    }

    public boolean getMonitoring() {
        return this.monitoring;
    }

    public void setMonitoring(boolean monitoring) {
        this.monitoring = monitoring;
    }

    public int getMonitoringDuration() {
        return this.monitoringDuration;
    }

    public void setMonitoringDuration(int monitoringDuration) {
        this.monitoringDuration = monitoringDuration;
    }

    public String getPatientType() {
        return this.patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

}
