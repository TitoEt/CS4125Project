package com.castletroymedical.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.castletroymedical.billing.InvoiceBuilder;
import com.castletroymedical.dto.ChargeDTO;
import com.castletroymedical.dto.InstalmentDTO;
import com.castletroymedical.dto.InvoiceDetailsDTO;

@Service
public class BillService {
    public double getProcedureCharge(String name) {
        return 150; // TODO use repository
    }

    private String formatCharge(double charge) {
        return String.format("%.2f", charge);
    }

    public InvoiceBuilder createInvoiceBuilder(InvoiceDetailsDTO invoiceForm) {
        InvoiceBuilder builder = new InvoiceBuilder(invoiceForm.getPatientType());
        String procedure = invoiceForm.getProcedure();
        double procedureCost = getProcedureCharge(procedure);
        builder.buildProcedure(procedure, procedureCost);

        if(invoiceForm.getConsultation()) {
            builder.buildConsultation();
        }

        if(invoiceForm.getHospitalStay()) {
            builder.buildHospitalStay(invoiceForm.getBedType(), invoiceForm.getStayDuration());
        }

        if(invoiceForm.getMonitoring()) {
            builder.buildMonitoring(invoiceForm.getMonitoringDuration());
        }    

        return builder;
    }

    public double calculateInvoice(InvoiceBuilder builder) {
        return builder.getInvoice().getCharge();
    }

    public List<ChargeDTO> listCharges(InvoiceBuilder builder) {
        return builder.getCharges();
    }

    public List<InstalmentDTO> calculateInstalments(double total, int numberInstalments, int breakPeriod) {
        List<InstalmentDTO> instalments = new ArrayList<InstalmentDTO>();
        double instalment = total / numberInstalments;
        LocalDate date = LocalDate.now();
        for(int i=0; i < numberInstalments; i++) {            
            instalments.add(new InstalmentDTO(instalment, date));
            date = date.plusDays(breakPeriod);
        }
        return instalments;
    }

}
