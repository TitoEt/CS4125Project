package com.castletroymedical.controller;
 
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.castletroymedical.dto.HospitalProcedureDto;
import com.castletroymedical.entity.HospitalProcedureEntity;
import com.castletroymedical.service.HospitalProcedureService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
 

@RestController
@RequestMapping(path = "/hospital-procedure")
public class ProcedureController {
    private HospitalProcedureService procedureService;

    public ProcedureController(HospitalProcedureService procedureService){
        this.procedureService = procedureService;
    }

    @GetMapping("/all")
    public List<HospitalProcedureDto> getAllProcedures(){
        return procedureService.findAllProcedures();
    }

    @GetMapping("/id/{procedureId}")
    public Optional<HospitalProcedureEntity> getHospitalProcedure(@PathVariable("procedureId") Long procedureId){
        return procedureService.getHospitalProcedure(procedureId);
    }

    @GetMapping("/{procedureName}")
    public Optional<HospitalProcedureEntity> findProcedureByName(@PathVariable("procedureName") String name){
        return procedureService.findByProcedureName(name);
    }

    @PostMapping("/add-procedure")
    public void addProcedure(@RequestBody HospitalProcedureEntity hospitalProcedure) {
         procedureService.saveOrUpdateProcedure(hospitalProcedure);
    }

    @PutMapping("/update-procedure")
    public void updateProcedure(@RequestBody HospitalProcedureEntity hospitalProcedure){
        procedureService.saveOrUpdateProcedure(hospitalProcedure);
    }
    
    @GetMapping("/{procedureId}/charge")
    public double getChargeQithProcedureId(@PathVariable("procedureId") Long procedureId){
        return procedureService.getProcedureCharge(procedureId);
    }
}
