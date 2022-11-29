package com.castletroymedical.service;

import java.util.List;
import java.util.Optional;

// import com.castletroymedical.dto.ProcedureDto;
import com.castletroymedical.entity.HospitalProcedure;

public interface HospitalProcedureService {
    // HospitalProcedure findProcedureByProcedureName(String name);
    Optional<HospitalProcedure> getHospitalProcedure(Long id);
    // List<ProcedureDto> findAllProcedures();
    List<HospitalProcedure> getAllProcedures();
    double getProcedureCharge(Long id);
    void saveOrUpdateProcedure(HospitalProcedure procedure);
}
