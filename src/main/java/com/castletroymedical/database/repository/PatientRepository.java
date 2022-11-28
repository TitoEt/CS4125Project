package com.castletroymedical.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.castletroymedical.database.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {
    Patient findByEmail(String email);
}
