package com.castletroymedical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.castletroymedical.entity.BillEntity;

public interface BillRepository extends JpaRepository<BillEntity, Long>{
    
}
