package com.castletroymedical.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.castletroymedical.service.PatientService;

@Controller
public class MainController {

    private PatientService patientService;

    public MainController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }    
}