package com.castletroymedical.stripe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Value;

@Controller

public class WebController {
 
    @Value("${stripe.public.key}")
    private Object stripePublicKey;


    @GetMapping("/")
    public String home(Model model){
    
        model.addAttribute("stripePublicKey", stripePublicKey);
        return "stripe";
    }
}