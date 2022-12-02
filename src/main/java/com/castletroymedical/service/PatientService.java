package com.castletroymedical.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.castletroymedical.dto.PatientDto;
import com.castletroymedical.entity.PatientEntity;
import com.castletroymedical.entity.UserEntity;
import com.castletroymedical.repository.PatientRepository;
import com.castletroymedical.repository.UserRepository;

@Service
public class PatientService {
    
    private PatientRepository patientRepository; 
    private UserRepository userRepository;

    public PatientService(PatientRepository patientRepository, UserRepository userRepository) {
        this.patientRepository = patientRepository;
        this.userRepository = userRepository;
    }
 
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
 
    public PatientEntity findPatientByEmail(String email) {
        UserEntity user = userRepository.findById(email).get();
        return patientRepository.findByUserEmail(user);
    }
 
    public String getPatientType(PatientDto patient) {
        String type = "private";
        if(patient.isMedicalCardHolder() && !patient.isInsured()) type = "medical card";
        if(!patient.isMedicalCardHolder() && patient.isInsured()) type = "insured";

        return type;
    }
 
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
 
    public PatientDto getPatientByPpsn(String ppsn) {
        return mapToPatientDto(patientRepository.findById(ppsn).orElseThrow());
    }

    public void updatePatientDetails(PatientDto patientDto){
        PatientEntity patient = patientRepository.findById(patientDto.getPpsn()).orElse(null);
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
}
