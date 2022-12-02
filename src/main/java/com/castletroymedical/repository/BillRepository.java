package com.castletroymedical.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.castletroymedical.entity.BillEntity;

public interface BillRepository extends JpaRepository<BillEntity, Long>{
    List<BillEntity> findByPatientPpsn(String Ppsn);
}
