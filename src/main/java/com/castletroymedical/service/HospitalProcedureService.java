package com.castletroymedical.service;

import java.util.List;
import java.util.Optional;

import com.castletroymedical.dto.HospitalProcedureDto;
// import com.castletroymedical.dto.ProcedureDto;
import com.castletroymedical.entity.HospitalProcedureEntity;

public interface HospitalProcedureService {
    Optional<HospitalProcedureEntity> findByProcedureName(String name);
    Optional<HospitalProcedureEntity> getHospitalProcedure(Long id); 
    List<HospitalProcedureDto> findAllProcedures();
    double getProcedureCharge(Long id);
    void saveOrUpdateProcedure(HospitalProcedureEntity procedure);
}
