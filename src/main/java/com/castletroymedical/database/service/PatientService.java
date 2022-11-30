package com.castletroymedical.database.service;

import java.util.ArrayList; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castletroymedical.database.entity.PatientEntity;
import com.castletroymedical.database.repository.PatientRepository;

@Service
public class PatientService {

    // @Autowired Temporarily removing until find resolution
    PatientRepository repository;

    // <ISHA> Going to read more about Optional later
    public Optional<PatientEntity> getPatientByPpsn(String ppsn){
        return repository.findById(ppsn);   
    }

    public ArrayList<PatientEntity> getAllPatients(){
        ArrayList<PatientEntity> patients = new ArrayList<PatientEntity>();
        repository.findAll().forEach(patient -> patients.add(patient));
        return patients;
    }

    public void saveOrUpdate(PatientEntity patient){
        repository.save(patient);
    }

    public void deletePatientByPpsn(String ppsn){
        repository.deleteById(ppsn);
    }
    
}
