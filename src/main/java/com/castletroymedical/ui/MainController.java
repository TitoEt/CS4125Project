package com.castletroymedical.ui;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Value("${stripe.public.key}")
    private Object stripePublicKey;

    @GetMapping("/index")
    public String index() {
    return "index";
    }

    @GetMapping("/payment")
    public String stripe(Model model){    
        model.addAttribute("stripePublicKey", stripePublicKey);
        return "stripe";
    }
    
    @GetMapping("/googlepay")
    public String googlepay() {
    return "googlepay";
    }

}