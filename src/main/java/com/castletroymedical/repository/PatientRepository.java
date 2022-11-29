package com.castletroymedical.repository;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.castletroymedical.entity.PatientEntity;

public interface PatientRepository extends JpaRepository<PatientEntity, String> {
    PatientEntity findByEmail(String email);
}
