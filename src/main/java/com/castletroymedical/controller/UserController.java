package com.castletroymedical.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/patient")
public class UserController {
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
    public String viewBills(){
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
