package com.castletroymedical.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.castletroymedical.billing.InvoiceBuilder;
import com.castletroymedical.dto.HospitalProcedureDto;
import com.castletroymedical.service.BillService;
import com.castletroymedical.service.PatientService;
import com.castletroymedical.service.impl.HospitalProcedureServiceImpl;
import com.castletroymedical.dto.BillDTO;
import com.castletroymedical.dto.InstalmentPlanDTO;
import com.castletroymedical.dto.InvoiceDetailsDTO;
import com.castletroymedical.entity.PatientEntity;

@Controller
@RequestMapping(path = "/admin")
public class BillingController {
    @Autowired
    BillService billService;
    @Autowired
    PatientService patientService; 
    @Autowired
    HospitalProcedureServiceImpl procedureService;

    @GetMapping("/generateInvoice/{ppsn}")
    public String invoiceForm(Model model, @PathVariable("ppsn") String ppsn) {
        PatientEntity patient = patientService.getPatientByPpsn(ppsn).get();
        model.addAttribute("invoiceDetails", new InvoiceDetailsDTO(patient.getName(), ppsn, patientService.getPatientType(patient)));
        List<HospitalProcedureDto> procedures = procedureService.findAllProcedures();
        model.addAttribute("procedures", procedures);
        return "invoice-form";
    }

    @PostMapping("/displayInvoice")
    public String displayInvoice(@ModelAttribute InvoiceDetailsDTO invoiceDetails, Model model){ 
        InvoiceBuilder builder = billService.createInvoiceBuilder(invoiceDetails);
        model.addAttribute("invoiceDetails", invoiceDetails);
        model.addAttribute("bill", new BillDTO(billService.calculateInvoice(builder)));
        model.addAttribute("charges", billService.listCharges(builder));
        return "invoice";
        // TODO save invidicual charges - decorators
    }

    // TODO save invoice using service method (need ppsn)
    
    @RequestMapping(value = "/paymentMethod", method = RequestMethod.POST, params = "cash")
    public String cashPayment(@ModelAttribute BillDTO bill, Model model) {
        model.addAttribute("amount", bill.getAmount());
        return "cash-approval";
    }

    @RequestMapping(value = "/paymentMethod", method = RequestMethod.POST, params = "cardPayment")
    public String onlinePayment(@ModelAttribute BillDTO bill, Model model) {
        model.addAttribute("bill", bill);
        return "card-payment";
    }

    @RequestMapping(value = "/paymentMethod", method = RequestMethod.POST, params = "instalment")
    public String instalment(@ModelAttribute BillDTO bill, Model model) {
        model.addAttribute("instalmentPlan", new InstalmentPlanDTO(bill.getAmount()));
        return "instalment-form";
    }

    @PostMapping("/displayInstalmentPlan")
    public String displayInstalmentPlan(@ModelAttribute InstalmentPlanDTO instalmentPlan, Model model){ 
        double total = instalmentPlan.getTotal();
        double numberInstalments = instalmentPlan.getNumberInstalments();
        model.addAttribute("total", total);
        model.addAttribute("instalments", billService.listInstalments(total, numberInstalments, instalmentPlan.getBreakPeriod()));
        model.addAttribute("bill", new BillDTO(billService.calculateInstalment(total, numberInstalments)));
        // TODO save instalment plan
        return "instalment-plan";
    }
    
    @PostMapping("/payInitialInstalment")
    public String payInitialInstalment(@ModelAttribute BillDTO bill, Model model) {
        model.addAttribute("amount", bill.getAmount());
        return "stripe";
    }

}
