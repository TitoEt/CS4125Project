package com.castletroymedical.ui.forms;

public class InvoiceForm {
    private String name;
    private String ppsn;
    private String procedure;
    private boolean consultation;  
    private String bedType;
    private int stayDuration;
    private int monitoringDuration;

    public InvoiceForm() {
    }

    public InvoiceForm(String name, String ppsn) {
        this.name = name;
        this.ppsn = ppsn;
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

    public String getBedType() {
        return bedType;
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

    public int getMonitoringDuration() {
        return this.monitoringDuration;
    }

    public void setMonitoringDuration(int monitoringDuration) {
        this.monitoringDuration = monitoringDuration;
    }

}
