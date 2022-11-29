package com.castletroymedical.service;

import java.util.List;

import com.castletroymedical.dto.PatientDto;
import com.castletroymedical.entity.Patient;

public interface PatientService {
    void savePatient(PatientDto patientDto);
    Patient findPatientByEmail(String email);
    String getPatientType(Patient patient);
    List<PatientDto> findAllPatients();
}
