package com.castletroymedical.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.castletroymedical.dto.HospitalProcedureDto; 
import com.castletroymedical.entity.HospitalProcedureEntity;
import com.castletroymedical.repository.HospitalProcedureRepository;

@Service
public class HospitalProcedureService {

    private HospitalProcedureRepository procedureRepository;

    public HospitalProcedureService(HospitalProcedureRepository procedureRepository){
        this.procedureRepository = procedureRepository;
    }
 
    public List<HospitalProcedureDto> findAllProcedures() {
        List<HospitalProcedureEntity> procedures = procedureRepository.findAll();
        return procedures.stream()
                        .map((procedure) -> convertEntityToDto(procedure))
                        .collect(Collectors.toList());
    }

    private HospitalProcedureDto convertEntityToDto(HospitalProcedureEntity procedure){
        HospitalProcedureDto procedureDto = new HospitalProcedureDto();
        procedureDto.setProcedureId(procedure.getProcedureId());
        procedureDto.setProcedureName(procedure.getProcedureName());
        procedureDto.setBaseCharge(procedure.getBaseCharge());
        return procedureDto;
    }
 
    public void saveOrUpdateProcedure(HospitalProcedureEntity procedure) {
        procedureRepository.save(procedure);
    }
 
    public Optional<HospitalProcedureEntity> getHospitalProcedure(Long id) {
        return procedureRepository.findById(id);
    }
 
    public double getProcedureCharge(Long id) {
        double charge = -1.0;
        Optional<HospitalProcedureEntity> hp = procedureRepository.findById(id);
        if(hp.isPresent()){
            charge = hp.get().getBaseCharge(); 
        }
        return charge;
    }
 
    public Optional<HospitalProcedureEntity> findByProcedureName(String name) {
        return procedureRepository.findByProcedureNameIgnoreCase(name);
    }
    
}
