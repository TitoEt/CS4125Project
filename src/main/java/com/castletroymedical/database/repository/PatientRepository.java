package com.castletroymedical.database.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.castletroymedical.database.entity.PatientEntity;

@Repository
public interface PatientRepository extends CrudRepository<PatientEntity,String>{
    
}
