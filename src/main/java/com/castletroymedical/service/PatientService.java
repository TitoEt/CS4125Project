package com.castletroymedical.service;

import java.util.List;
import java.util.Optional;

import com.castletroymedical.dto.PatientDto;
import com.castletroymedical.entity.PatientEntity;

public interface PatientService {
    void savePatient(PatientDto patientDto);

    Optional<PatientEntity> getPatientByPpsn(String ppsn);

    PatientEntity findPatientByEmail(String email);

    String getPatientType(PatientEntity patient);

    List<PatientDto> findAllPatients();
}
