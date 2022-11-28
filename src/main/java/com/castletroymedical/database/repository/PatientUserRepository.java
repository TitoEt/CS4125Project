package com.castletroymedical.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.castletroymedical.database.entity.PatientUser;

public interface PatientUserRepository extends JpaRepository<PatientUser, Long>{
    
}
