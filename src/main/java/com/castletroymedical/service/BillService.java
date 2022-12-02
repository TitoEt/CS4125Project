package com.castletroymedical.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castletroymedical.billing.InstalmentCalculator;
import com.castletroymedical.billing.InvoiceBuilder;
import com.castletroymedical.dto.BillDTO; 
import com.castletroymedical.dto.InstalmentDTO;
import com.castletroymedical.dto.InvoiceDetailsDTO;
import com.castletroymedical.entity.BillEntity;
import com.castletroymedical.repository.BillRepository;
import com.castletroymedical.repository.ChargeRepository;
import com.castletroymedical.repository.HospitalProcedureRepository;
import com.castletroymedical.repository.PatientRepository;

@Service
public class BillService {
    @Autowired
    HospitalProcedureRepository procedureRepository;
    @Autowired
    BillRepository billRepository;
    @Autowired 
    PatientRepository patientRepository;
    @Autowired
    ChargeRepository chargeRepository;

    public double getProcedureCharge(String name) {
       return procedureRepository.findByProcedureNameIgnoreCase(name).get().getBaseCharge();
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

    public List<InstalmentDTO> listInstalments(double total, double numberInstalments, int breakPeriod) {
        return InstalmentCalculator.listInstalments(total, numberInstalments, breakPeriod);
    }

    public double calculateInstalment(double total, double numberInstalments) {
        return InstalmentCalculator.calculateInstalment(total, numberInstalments);
    }

    public BillDTO findBill(Long id){
        BillEntity bill = billRepository.findById(id).orElse(null);
        return mapBillEntityToDto(bill);
    }

    private BillDTO mapBillEntityToDto(BillEntity billEntity){
        return new BillDTO(billEntity.getBillId(), billEntity.getPatientPpsn().getPpsn(), billEntity.getDateIssued(), billEntity.getDueDate(), billEntity.getDatePaid(), billEntity.isInstalmentPlan(), billEntity.getStatus(), billEntity.getTotalAmount());
    }

    public void saveBill(BillDTO billDto){
        billRepository.save(mapBillDtoToEntity(billDto));
    }

    private BillEntity mapBillDtoToEntity(BillDTO billDto){
        BillEntity billEntity = new BillEntity();
        billEntity.setBillId(billDto.getBillId());
        billEntity.setDateIssued(billDto.getDateIssued());
        billEntity.setDatePaid(billDto.getDatePaid());
        billEntity.setDueDate(billDto.getDueDate());
        billEntity.setInstalmentPlan(billDto.isInstalmentPlan());
        billEntity.setPatientPpsn(patientRepository.findById(billDto.getPatientPpsn()).orElse(null));
        billEntity.setStatus(billDto.getStatus());
        billEntity.setTotalAmount(billDto.getTotalCharge());
        return billEntity;
    }

    // <ISHA> Saving bill from post form 
    public Long saveBill(double amount, InvoiceDetailsDTO invoiceDetails){
        Date currDate = new Date(System.currentTimeMillis());
        Date dueDate = new Date(System.currentTimeMillis() + 604800000L); //One Week Later
        BillEntity bill = new BillEntity();
        bill.setDateIssued(currDate);
        bill.setDueDate(dueDate);
        bill.setPatientPpsn(patientRepository.findById(invoiceDetails.getPpsn()).orElse(null));
        bill.setStatus("Pending");
        bill.setTotalAmount(amount);

        BillEntity b = billRepository.save(bill); 
        return b.getBillId();
    }
}
