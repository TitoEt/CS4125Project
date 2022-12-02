package com.castletroymedical.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castletroymedical.billing.InstalmentCalculator;
import com.castletroymedical.billing.InvoiceBuilder;
import com.castletroymedical.dto.ChargeDTO;
import com.castletroymedical.dto.InstalmentDTO;
import com.castletroymedical.dto.InvoiceDetailsDTO;
import com.castletroymedical.service.impl.HospitalProcedureServiceImpl;

@Service
public class BillService {
    @Autowired HospitalProcedureServiceImpl procedureService;
    
    public double getProcedureCharge(String name) {
        return procedureService.findByProcedureName(name).get().getBaseCharge();
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

    public List<InstalmentDTO> listInstalments(double total, double numberInstalments, int breakPeriod) {
        return InstalmentCalculator.listInstalments(total, numberInstalments, breakPeriod);
    }

    public double calculateInstalment(double total, double numberInstalments) {
        return InstalmentCalculator.calculateInstalment(total, numberInstalments);
    }

}
