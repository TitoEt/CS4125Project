package com.castletroymedical.repository;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.castletroymedical.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String>{
    
}
