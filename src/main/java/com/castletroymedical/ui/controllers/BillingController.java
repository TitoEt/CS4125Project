package com.castletroymedical.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.castletroymedical.database.entity.ProcedureEntity;
import com.castletroymedical.database.service.BillService;
import com.castletroymedical.database.service.PatientService;
import com.castletroymedical.ui.forms.InvoiceForm;

@Controller
public class BillingController {
    @Autowired
    BillService billService;
    @Autowired
    PatientService patientService; // TODO service gets patient and type

    @GetMapping("/generateInvoice/{ppsn}")
    public String invoiceForm(Model model, @PathVariable("ppsn") String ppsn) {
        model.addAttribute("invoiceForm", new InvoiceForm("name", ppsn));
        
        List<ProcedureEntity> procedures = new ArrayList<ProcedureEntity>(); // TODO get procedure list
        procedures.add(new ProcedureEntity("Xray", 100));
        procedures.add(new ProcedureEntity("Hip Surgery", 350));
        procedures.add(new ProcedureEntity("Transplant", 480));
        model.addAttribute("procedures", procedures);
        return "invoice-form";
    }

    @PostMapping("/displayInvoice")
    public String displayInvoice(@ModelAttribute InvoiceForm invoiceForm, Model model){ 
        model.addAttribute("total", billService.getCharge());
        return "invoice";
        // TODO save invoice using service method (need ppsn)
    }

    // TODO instalments
}
