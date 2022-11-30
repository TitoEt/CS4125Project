package com.castletroymedical.billing;

import java.util.ArrayList;
import java.util.List;

import com.castletroymedical.billing.invoice.Consultation;
import com.castletroymedical.billing.invoice.InsuredInvoice;
import com.castletroymedical.billing.invoice.Invoice;
import com.castletroymedical.billing.invoice.MedicalCardInvoice;
import com.castletroymedical.billing.invoice.Monitoring;
import com.castletroymedical.billing.invoice.PrivateInvoice;
import com.castletroymedical.billing.invoice.PrivateRoom;
import com.castletroymedical.billing.invoice.Procedure;
import com.castletroymedical.billing.invoice.WardBed;
import com.castletroymedical.dto.ChargeDTO;

public class InvoiceBuilder {

    private Invoice invoice;
    private List<ChargeDTO> charges;
    
    public InvoiceBuilder(String type){ 
        this.invoice = invoiceFactory(type);
        this.charges = new ArrayList<ChargeDTO>();
    }

    public Invoice invoiceFactory(String type){
        Invoice out = null;
        if(type == null || type.isEmpty())
            return out;
    
        type = type.toLowerCase();
        switch(type) {
            case "insured": out = new InsuredInvoice(); break;
            case "medical card": out = new MedicalCardInvoice(); break;
            case "private": out = new PrivateInvoice(); break;
        }
        return out;
    }
    
    public void buildConsultation() {
        this.invoice = new Consultation(this.invoice);
        this.charges.add(new ChargeDTO("Consultation", calculateChargeAmount()));
    }   
 
    public void buildMonitoring(int days) {
        this.invoice = new Monitoring(days, this.invoice);
        String description = String.format("Monitoring x%d day(s)", days);
        this.charges.add(new ChargeDTO(description, calculateChargeAmount()));
    }
 
    private void buildPrivateRoom(int days) {
        this.invoice = new PrivateRoom(days, this.invoice);
        String description = String.format("Private Room x%d day(s)", days);
        this.charges.add(new ChargeDTO(description, calculateChargeAmount()));
    }

    private void buildWardBed(int days) {
        this.invoice = new WardBed(days, this.invoice);
        String description = String.format("Ward Bed x%d day(s)", days);
        this.charges.add(new ChargeDTO(description, calculateChargeAmount()));
    }
    
    public void buildHospitalStay(String bedType, int days) {
        switch(bedType) {
            case "privateRoom":
                buildPrivateRoom(days);
                break;
            case "wardBed":
                buildWardBed(days);
                break;
        }
    }

    public void buildProcedure(String procedureName, double baseCharge) {
        this.invoice = new Procedure(procedureName, baseCharge, this.invoice);
        this.charges.add(new ChargeDTO(procedureName, calculateChargeAmount()));
    }
 
    public Invoice getInvoice() { 
        return this.invoice;
    }

    public List<ChargeDTO> getCharges() {
        return this.charges;
    }

    private double calculateChargeAmount() {
        if(this.charges.size() == 0) {
            return this.invoice.getCharge();
        }
        else {
            double previousCharges = 0;
            for(int i=0; i<this.charges.size(); i++) {
                previousCharges += charges.get(i).getAmount();
            }
            return this.invoice.getCharge() - previousCharges;
        }

    }

}
