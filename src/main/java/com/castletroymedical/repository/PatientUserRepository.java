package com.castletroymedical.repository;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.castletroymedical.entity.PatientUser;

public interface PatientUserRepository extends JpaRepository<PatientUser, Long>{
    
}
