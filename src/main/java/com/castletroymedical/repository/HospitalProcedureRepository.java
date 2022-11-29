package com.castletroymedical.repository;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.castletroymedical.entity.HospitalProcedureEntity;
 
public interface HospitalProcedureRepository extends JpaRepository<HospitalProcedureEntity,Long>{
    
}
