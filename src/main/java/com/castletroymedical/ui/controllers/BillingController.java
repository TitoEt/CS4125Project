package com.castletroymedical.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.castletroymedical.database.entity.ProcedureEntity;
import com.castletroymedical.database.service.BillService;
import com.castletroymedical.database.service.PatientService;

@Controller
public class BillingController {
    @Autowired
    BillService billService;
    @Autowired
    PatientService patientService;

    @GetMapping("/generateInvoice/{ppsn}")
    public String invoiceForm(Model model, @PathVariable("ppsn") String ppsn) {
        model.addAttribute("ppsn", ppsn);
        model.addAttribute("name", "name"); // TODO get name
        List<ProcedureEntity> procedures = new ArrayList<ProcedureEntity>(); // TODO get procedure list
        procedures.add(new ProcedureEntity("Xray", 100));
        procedures.add(new ProcedureEntity("Hip Surgery", 350));
        procedures.add(new ProcedureEntity("Transplant", 480));
        model.addAttribute("procedures", procedures);
        return "invoice-form";
    }

    @RequestMapping(value = "/displayInvoice", method = RequestMethod.POST)
    public String displayInvoice(Model model) {
        model.addAttribute("invoiceAmount", billService.formatCharge(billService.getCharge()));
        return "invoice";
    }

    // TODO instalments
}
