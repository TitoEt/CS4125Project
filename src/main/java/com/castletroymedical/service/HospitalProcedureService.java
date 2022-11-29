package com.castletroymedical.service;

import java.util.List;
import java.util.Optional;

// import com.castletroymedical.dto.ProcedureDto;
import com.castletroymedical.entity.HospitalProcedureEntity;

public interface HospitalProcedureService {
    // HospitalProcedure findProcedureByProcedureName(String name);
    Optional<HospitalProcedureEntity> getHospitalProcedure(Long id);
    // List<ProcedureDto> findAllProcedures();
    List<HospitalProcedureEntity> getAllProcedures();
    double getProcedureCharge(Long id);
    void saveOrUpdateProcedure(HospitalProcedureEntity procedure);
}
