package com.castletroymedical.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import com.castletroymedical.service.ChargeService;
import com.castletroymedical.service.HospitalProcedureService;
import com.castletroymedical.service.PatientService;
import com.castletroymedical.dto.BillAmountDTO;
import com.castletroymedical.dto.BillDTO;
import com.castletroymedical.dto.ChargeDTO;
import com.castletroymedical.dto.InstalmentPlanDTO;
import com.castletroymedical.dto.InvoiceDetailsDTO;
import com.castletroymedical.dto.PatientDto; 

@Controller
@RequestMapping(path = "/admin")
public class BillingController {
    @Autowired
    BillService billService;
    @Autowired
    PatientService patientService; // service gets patient and type
    @Autowired
    HospitalProcedureService procedureService;
    @Value("${stripe.public.key}")
    private Object stripePublicKey;
    @Autowired
    ChargeService chargeService;

    @GetMapping("/generateInvoice/{ppsn}")
    public String invoiceForm(Model model, @PathVariable("ppsn") String ppsn) {
        PatientDto patient = patientService.getPatientByPpsn(ppsn);
        model.addAttribute("invoiceDetails", new InvoiceDetailsDTO(patient.getFirstName() + " " + patient.getLastName(), ppsn, patientService.getPatientType(patient)));
        
        List<HospitalProcedureDto> procedures = procedureService.findAllProcedures();
        model.addAttribute("procedures", procedures);
        return "invoice-form";
    }

    @PostMapping("/displayInvoice")
    public String displayInvoice(@ModelAttribute InvoiceDetailsDTO invoiceDetails, Model model){
        InvoiceBuilder builder = billService.createInvoiceBuilder(invoiceDetails);
        List<ChargeDTO> charges = builder.getCharges();
        
        Long billID = billService.saveBill(builder.getInvoice().getCharge(), invoiceDetails); 
        chargeService.saveListOfCharges(charges, billID);

        BillAmountDTO bill = new BillAmountDTO(builder.getInvoice().getCharge(), billID);
        model.addAttribute("invoiceDetails", invoiceDetails);
        model.addAttribute("bill", bill);
        model.addAttribute("charges", charges);

        return "invoice";
    }
    
    @RequestMapping(value = "/paymentMethod", method = RequestMethod.POST, params = "cash")
    public String cashPayment(@ModelAttribute BillAmountDTO bill, Model model) {
        model.addAttribute("amount", bill.getAmount());
        return "cash-approval";
    }

    @RequestMapping(value = "/paymentMethod", method = RequestMethod.POST, params = "cardPayment")
    public String onlinePayment(@ModelAttribute BillAmountDTO bill, Model model) {
        model.addAttribute("bill", bill);
        return "card-payment";
    }

    @RequestMapping(value = "/paymentMethod", method = RequestMethod.POST, params = "instalment")
    public String instalment(@ModelAttribute BillAmountDTO bill, Model model) {
        model.addAttribute("instalmentPlan", new InstalmentPlanDTO(bill.getAmount()));
        BillDTO bd = billService.findBill(bill.getBillID());
        bd.setInstalmentPlan(true);
        billService.saveBill(bd);
        return "instalment-form";
    }

    @PostMapping("/displayInstalmentPlan")
    public String displayInstalmentPlan(@ModelAttribute InstalmentPlanDTO instalmentPlan, Model model){ 
        double total = instalmentPlan.getTotal();
        double numberInstalments = instalmentPlan.getNumberInstalments();
        model.addAttribute("total", total);
        model.addAttribute("instalments", billService.listInstalments(total, numberInstalments, instalmentPlan.getBreakPeriod()));
        model.addAttribute("bill", new BillAmountDTO(billService.calculateInstalment(total, numberInstalments)));
        // TODO save instalment plan
        return "instalment-plan";
    }
    
    @PostMapping("/payInitialInstalment")
    public String payInitialInstalment(@ModelAttribute BillAmountDTO bill, Model model) {
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("amount", bill.getAmount());
        return "stripe-admin";
    }

}
