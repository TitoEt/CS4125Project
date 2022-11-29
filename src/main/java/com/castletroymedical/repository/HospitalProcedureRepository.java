package com.castletroymedical.repository;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.castletroymedical.entity.HospitalProcedure;
 
public interface HospitalProcedureRepository extends JpaRepository<HospitalProcedure,Long>{
    
}
