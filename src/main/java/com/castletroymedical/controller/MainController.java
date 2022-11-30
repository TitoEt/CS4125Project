package com.castletroymedical.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/admin/registerpatient")
    public String register() {
        return "register";
    }

    @GetMapping("/viewpatient-pt")
    public String viewpt() {
        return "viewpatient-pt";
    }

    @GetMapping("/editProfile")
    public String editProfile() {
        return "editprofile";
    }

    @GetMapping("/stripe")
    public String stripe() {
        return "stripe";
    }

    @GetMapping("/admin/dashboard")
    public String dashboard() {
        return "admin-dashboard";
    }
}