package com.castletroymedical.service;

import java.util.List;

import com.castletroymedical.database.entity.Patient;
import com.castletroymedical.dto.PatientDto;

public interface PatientService {
    void savePatient(PatientDto patientDto);
    Patient findPatientByEmail(String email);
    String getPatientType(Patient patient);
    List<PatientDto> findAllPatients();
    void savePatientBody(Patient patient);
}
