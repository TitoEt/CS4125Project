package com.castletroymedical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.castletroymedical.entity.ChargeEntity;

public interface ChargeRepository extends JpaRepository<ChargeEntity, Long>{
    
}
