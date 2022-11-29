package com.castletroymedical.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.castletroymedical.dto.PatientDto;
import com.castletroymedical.entity.PatientEntity;
import com.castletroymedical.repository.PatientRepository;
import com.castletroymedical.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
    
    private PatientRepository patientRepository; 

    @Override
    public void savePatient(PatientDto patientDto) {
        PatientEntity patient = new PatientEntity(  patientDto.getPpsn(),
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
    public PatientEntity findPatientByEmail(String email) { 
        return patientRepository.findByEmail(email);
    }

    @Override
    public String getPatientType(PatientEntity patient) {
        String type = "private";
        if(patient.isMedicalCardHolder() && !patient.isInsured()) type = "medical card";
        if(!patient.isMedicalCardHolder() && patient.isInsured()) type = "insured";

        return type;
    }

    @Override
    public List<PatientDto> findAllPatients() {
        List<PatientEntity> patients = patientRepository.findAll();
        return patients.stream()
                .map((patient) -> mapToPatientDto(patient))
                .collect(Collectors.toList());
    }

    private PatientDto mapToPatientDto(PatientEntity patient){
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
