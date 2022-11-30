package com.castletroymedical.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.castletroymedical.dto.PatientDto;
import com.castletroymedical.entity.PatientEntity;
import com.castletroymedical.entity.UserEntity;
import com.castletroymedical.repository.PatientRepository;
import com.castletroymedical.repository.UserRepository;
import com.castletroymedical.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
    
    private PatientRepository patientRepository; 
    private UserRepository userRepository;

    public PatientServiceImpl(PatientRepository patientRepository, UserRepository userRepository) {
        this.patientRepository = patientRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void savePatient(PatientDto patientDto) {
        PatientEntity patient = new PatientEntity(); 
        patient.setPpsn(patientDto.getPpsn());
        patient.setName(patientDto.getFirstName() + " " + patientDto.getLastName());
        patient.setDob(patientDto.getDob());
        patient.setAddress(patientDto.getAddress());
        patient.setPhoneNumber(patientDto.getPhoneNumber());
        patient.setMedicalCardHolder(patientDto.isMedicalCardHolder());
        patient.setInsured(patientDto.isInsured());

        UserEntity user = userRepository.findByEmail(patientDto.getEmail());
        if(user != null) patient.setUserEmail(user);

        patientRepository.save(patient);
    }

    @Override
    public PatientEntity findPatientByEmail(String email) {
        UserEntity user = userRepository.findById(email).get();
        return patientRepository.findByUserEmail(user);
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
        patientDto.setEmail(patient.getUserEmail().getEmail());
        patientDto.setMedicalCardHolder(patient.isMedicalCardHolder());
        patientDto.setInsured(patient.isInsured());

        return patientDto;
    }

    @Override
    public Optional<PatientEntity> getPatientByPpsn(String ppsn) {
        return patientRepository.findById(ppsn);
    }
}
