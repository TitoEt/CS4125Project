package com.castletroymedical.repository;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.castletroymedical.entity.PatientEntity;
import com.castletroymedical.entity.UserEntity;

public interface PatientRepository extends JpaRepository<PatientEntity, String> {
    PatientEntity findByUserEmail(UserEntity userEntity);
    PatientEntity findByNameIgnoreCase(String email);
}
