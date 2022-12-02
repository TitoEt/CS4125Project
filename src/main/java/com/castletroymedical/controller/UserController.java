package com.castletroymedical.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.castletroymedical.dto.BillDTO;
import com.castletroymedical.service.BillService;
import com.castletroymedical.service.PatientService;

@Controller
@RequestMapping(path = "/patient")
public class UserController {

    @Autowired
    private BillService billService;
    @Autowired
    private PatientService patientService;

    @Value("${stripe.public.key}")
    private Object stripePublicKey;

    @RequestMapping("/dashboard")
    public String dashbaord(){ 
        return "patient-dashboard";
    }

    @RequestMapping("/editProfile")
    public String editProfile(){
        return "editprofile";
    }

    @RequestMapping("/viewBills")
    public String viewBills(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        String ppsn = patientService.findPatientByEmail(email).getPpsn();
        List<BillDTO> bills = billService.findAllPatientBills(ppsn);
        model.addAttribute("bills", bills);
        return "viewbills";
    }

    @RequestMapping("/outstandingBills")
    public String outstandingBills(){
        return "outstandingbills";
    }

    @RequestMapping("/payBill")
    public String payBill(Model model){
        model.addAttribute("stripePublicKey", stripePublicKey);
        return "stripe-patient";
    }

    @RequestMapping("/requestPlan")
    public String requestPlan(){
        return "request-instalment";
    }

    @RequestMapping("/viewPlan")
    public String viewPlan(){
        return "view-instalment";
    }
}
