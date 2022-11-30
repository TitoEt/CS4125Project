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
import com.castletroymedical.dto.BillDTO;
import com.castletroymedical.dto.InstalmentPlanDTO;
import com.castletroymedical.dto.InvoiceDetailsDTO;

@Controller
public class BillingController {
    @Autowired
    BillService billService;
    @Autowired
    PatientService patientService; // TODO service gets patient and type

    @GetMapping("/admin/generateInvoice/{ppsn}")
    public String invoiceForm(Model model, @PathVariable("ppsn") String ppsn) {
        model.addAttribute("invoiceDetails", new InvoiceDetailsDTO("name", ppsn, "private"));
        
        List<HospitalProcedureDto> procedures = new ArrayList<HospitalProcedureDto>(); // TODO get procedure list
        procedures.add(new HospitalProcedureDto("Xray", 100));
        procedures.add(new HospitalProcedureDto("Hip Surgery", 350));
        procedures.add(new HospitalProcedureDto("Transplant", 480));
        model.addAttribute("procedures", procedures);
        return "invoice-form";
    }

    @PostMapping("/admin/displayInvoice")
    public String displayInvoice(@ModelAttribute InvoiceDetailsDTO invoiceDetails, Model model){ 
        InvoiceBuilder builder = billService.createInvoiceBuilder(invoiceDetails);
        model.addAttribute("invoiceDetails", invoiceDetails);
        model.addAttribute("bill", new BillDTO(billService.calculateInvoice(builder)));
        model.addAttribute("charges", billService.listCharges(builder));
        return "invoice";
        // TODO save invidicual charges - decorators
    }

    // TODO save invoice using service method (need ppsn)
    
    @RequestMapping(value = "/admin/paymentMethod", method = RequestMethod.POST, params = "cash")
    public String cashPayment(@ModelAttribute BillDTO bill, Model model) {
        model.addAttribute("amount", bill.getAmount());
        return "cash-approval";
    }

    // TODO Potential strategy??
    @RequestMapping(value = "/admin/paymentMethod", method = RequestMethod.POST, params = "cardPayment")
    public String onlinePayment(@ModelAttribute BillDTO bill) {
        return "card-payment";
    }

    @RequestMapping(value = "/admin/paymentMethod", method = RequestMethod.POST, params = "instalment")
    public String instalment(@ModelAttribute BillDTO bill, Model model) {
        model.addAttribute("instalmentPlan", new InstalmentPlanDTO(bill.getAmount()));
        return "instalment-form";
    }

    @PostMapping("/admin/displayInstalmentPlan")
    public String displayInstalmentPlan(@ModelAttribute InstalmentPlanDTO instalmentPlan, Model model){ 
        double total = instalmentPlan.getTotal();
        model.addAttribute("total", total);
        model.addAttribute("instalments", billService.calculateInstalments(total, instalmentPlan.getNumberInstalments(), instalmentPlan.getBreakPeriod()));
        // TODO save instalment plan
        return "instalment-plan";
    }

}
