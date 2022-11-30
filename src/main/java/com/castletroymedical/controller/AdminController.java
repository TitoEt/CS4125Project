package com.castletroymedical.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.castletroymedical.dto.PatientDto;
import com.castletroymedical.service.PatientService;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {

    PatientService patientService;

    public AdminController(PatientService patientService) {
        this.patientService = patientService;
    }

    // <ISHA> List all patients in a table
    @GetMapping("/all-patients")
    public String listRegisteredUsers(Model model){
        List<PatientDto> patients = patientService.findAllPatients();
        model.addAttribute("patients", patients);
        return "allpatients";
    }
}
