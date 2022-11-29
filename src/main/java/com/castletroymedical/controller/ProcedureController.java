package com.castletroymedical.controller;
 
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.castletroymedical.entity.HospitalProcedureEntity;
import com.castletroymedical.service.impl.HospitalProcedureServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
 

@RestController
@RequestMapping(path = "/hospital-procedure")
public class ProcedureController {
    private HospitalProcedureServiceImpl procedureService;

    public ProcedureController(HospitalProcedureServiceImpl procedureService){
        this.procedureService = procedureService;
    }

    @GetMapping("/all")
    public List<HospitalProcedureEntity> getAllProcedures(){
        return procedureService.getAllProcedures();
    }

    // @GetMapping("/{procedureName}")
    // public HospitalProcedure findHospitalProcedureNyName(@PathVariable("procedureName") String name){
    //     return procedureService.findProcedureByProcedureName(name);
    // }

    @GetMapping("/{procedureId}")
    public Optional<HospitalProcedureEntity> getHospitalProcedure(@PathVariable("procedureId") Long procedureId){
        return procedureService.getHospitalProcedure(procedureId);
    }

    @PostMapping("/add-procedure")
    public void addProcedure(@RequestBody HospitalProcedureEntity hospitalProcedure) {
         procedureService.saveOrUpdateProcedure(hospitalProcedure);
    }

    @PutMapping("/update-procedure")
    public void updateProcedure(@RequestBody HospitalProcedureEntity hospitalProcedure){
        procedureService.saveOrUpdateProcedure(hospitalProcedure);
    }
    
}
