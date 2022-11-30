package com.castletroymedical.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.castletroymedical.entity.HospitalProcedureEntity;
 
public interface HospitalProcedureRepository extends JpaRepository<HospitalProcedureEntity,Long>{
    Optional<HospitalProcedureEntity> findByProcedureNameIgnoreCase(String name);
}
