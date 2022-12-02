package com.castletroymedical.controller; 

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.castletroymedical.dto.PatientDto;
import com.castletroymedical.service.PatientService;

@RestController
public class PatientController {
    PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/ppsn/{ppsn}")
    public PatientDto getPatientByPpsn(@PathVariable("ppsn") String ppsn){
        return patientService.getPatientByPpsn(ppsn);
    }

    @PostMapping("/add-patient")
    public void addPatient(@RequestBody PatientDto patient) {
        patientService.savePatient(patient);
    }
}
