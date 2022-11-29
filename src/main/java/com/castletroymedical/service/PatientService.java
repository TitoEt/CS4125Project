package com.castletroymedical.service;

import java.util.List;

import com.castletroymedical.dto.PatientDto;
import com.castletroymedical.entity.PatientEntity;

public interface PatientService {
    void savePatient(PatientDto patientDto);
    PatientEntity findPatientByEmail(String email);
    String getPatientType(PatientEntity patient);
    List<PatientDto> findAllPatients();
}
