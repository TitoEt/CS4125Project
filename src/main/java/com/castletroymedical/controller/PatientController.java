package com.castletroymedical.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.castletroymedical.database.entity.PatientEntity;
import com.castletroymedical.service.PatientService;

@RestController
@RequestMapping(path= "/emp")
public class PatientController {
    
    @Autowired
    PatientService patientService;

    @GetMapping("/patients")
    public ArrayList<PatientEntity> getAllPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("/patient/{ppsn}")
    public Optional<PatientEntity> getPatient(@PathVariable("ppsn") String ppsn){
        return patientService.getPatientByPpsn(ppsn);
    }

    @DeleteMapping("/patient/{ppsn}")
    public void deletePatient(@PathVariable("ppsn") String ppsn){
        patientService.deletePatientByPpsn(ppsn);
    }

    @PostMapping("/patient")
    public void addPatient(@RequestBody PatientEntity patient){
        patientService.saveOrUpdate(patient);
    }

    @PutMapping("/patient")
    public void updatePatient(@RequestBody PatientEntity patient){
        patientService.saveOrUpdate(patient);
    }
}
