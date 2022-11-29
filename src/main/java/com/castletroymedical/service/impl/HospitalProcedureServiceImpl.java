package com.castletroymedical.service.impl;

import java.util.List;
// import java.util.stream.Collectors;
import java.util.Optional;

import org.springframework.stereotype.Service;

// import com.castletroymedical.dto.ProcedureDto;
import com.castletroymedical.entity.HospitalProcedure;
import com.castletroymedical.repository.HospitalProcedureRepository;
import com.castletroymedical.service.HospitalProcedureService;

@Service
public class HospitalProcedureServiceImpl implements HospitalProcedureService {

    private HospitalProcedureRepository procedureRepository;

    public HospitalProcedureServiceImpl(HospitalProcedureRepository procedureRepository){
        this.procedureRepository = procedureRepository;
    }
    

    // @Override
    // public List<ProcedureDto> findAllProcedures() {
    //     List<HospitalProcedure> procedures = procedureRepository.findAll();
    //     return procedures.stream().map((procedure) -> convertEntityToDto(procedure))
    //     .collect(Collectors.toList());
    // }

    @Override
    public List<HospitalProcedure> getAllProcedures() {
        return procedureRepository.findAll();
    }

    // private ProcedureDto convertEntityToDto(HospitalProcedure procedure){
    //     ProcedureDto procedureDto = new ProcedureDto();
    //     procedureDto.setProcedureName(procedure.getProcedureName());
    //     procedureDto.setBaseCharge(procedure.getBaseCharge());
    //     return procedureDto;
    // }

    @Override
    public void saveOrUpdateProcedure(HospitalProcedure procedure) {
        procedureRepository.save(procedure);
    }

    @Override
    public Optional<HospitalProcedure> getHospitalProcedure(Long id) {
        return procedureRepository.findById(id);
    }

    @Override
    public double getProcedureCharge(Long id) {
        double charge = -1.0;
        Optional<HospitalProcedure> hp = procedureRepository.findById(id);
        if(hp.isPresent()){
            charge = hp.get().getBaseCharge(); 
        }
        return charge;
    }
    
}
