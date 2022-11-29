package com.castletroymedical.repository;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.castletroymedical.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, String> {
    Patient findByEmail(String email);
}
