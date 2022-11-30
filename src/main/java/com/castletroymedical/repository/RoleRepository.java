package com.castletroymedical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.castletroymedical.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByNameIgnoreCase(String name);
}
