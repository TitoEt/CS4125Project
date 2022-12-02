package com.castletroymedical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.castletroymedical.dto.BillDTO;
import com.castletroymedical.service.PaymentService;


@Controller
@RequestMapping(path = "/admin")
public class PaymentController {
    @Autowired PaymentService paymentService;
    @Value("${stripe.public.key}")
    private Object stripePublicKey;

    @RequestMapping(value = "/cardPayment", method = RequestMethod.POST, params = "stripePayment")
    public String onlinePayment(@ModelAttribute BillDTO bill, Model model) {
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("amount", bill.getAmount());
        return "stripe-admin";
    }
    
    @RequestMapping(value = "/cardPayment", method = RequestMethod.POST, params = "cardOnSite")
    public String cardMachinePayment(@ModelAttribute BillDTO bill, Model model) {
        model.addAttribute("amount", bill.getAmount());
        return "card-approval";
    }   
}
