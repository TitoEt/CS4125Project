package com.castletroymedical.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.castletroymedical.dto.PatientDto;
import com.castletroymedical.entity.Patient;
import com.castletroymedical.repository.PatientRepository;
import com.castletroymedical.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
    
    private PatientRepository patientRepository; 

    @Override
    public void savePatient(PatientDto patientDto) {
        Patient patient = new Patient(  patientDto.getPpsn(),
                                        patientDto.getFirstName() + " " + patientDto.getLastName(),
                                        patientDto.getDob(),
                                        patientDto.getAddress(),
                                        patientDto.getPhoneNumber(),
                                        patientDto.getEmail(),
                                        patientDto.isMedicalCardHolder(),
                                        patientDto.isInsured()
        );

        patientRepository.save(patient);
    }

    @Override
    public Patient findPatientByEmail(String email) { 
        return patientRepository.findByEmail(email);
    }

    @Override
    public String getPatientType(Patient patient) {
        String type = "private";
        if(patient.isMedicalCardHolder() && !patient.isInsured()) type = "medical card";
        if(!patient.isMedicalCardHolder() && patient.isInsured()) type = "insured";

        return type;
    }

    @Override
    public List<PatientDto> findAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map((patient) -> mapToPatientDto(patient))
                .collect(Collectors.toList());
    }

    private PatientDto mapToPatientDto(Patient patient){
        PatientDto patientDto = new PatientDto();
        
        String[] nameSplit = patient.getName().split(" ");
        patientDto.setFirstName(nameSplit[0]);
        //<ISHA> In case of multiple last names - OR have the last name filled with no spaces
        String lastName = "";
        for(int i = 1; i < nameSplit.length; i++)
            lastName += nameSplit[i];
        patientDto.setLastName(lastName);
        
        patientDto.setPpsn(patient.getPpsn());
        patientDto.setDob(patient.getDob());
        patientDto.setAddress(patient.getAddress());
        patientDto.setPhoneNumber(patient.getPhoneNumber());
        patientDto.setEmail(patient.getEmail());
        patientDto.setMedicalCardHolder(patient.isMedicalCardHolder());
        patientDto.setInsured(patient.isInsured());

        return patientDto;
    }
}
