package com.castletroymedical.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.castletroymedical.dto.PatientDto;
import com.castletroymedical.entity.PatientEntity;
import com.castletroymedical.service.PatientService;

@RestController
public class PatientController {
    PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @PostMapping("/add-patient")
    public void addPatient(@RequestBody PatientDto patient){
        patientService.savePatient(patient);
    }
}
