package com.castletroymedical.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.castletroymedical.dto.HospitalProcedureDto;
import com.castletroymedical.dto.PatientDto;
import com.castletroymedical.dto.UserDto;
import com.castletroymedical.entity.UserEntity;
import com.castletroymedical.service.HospitalProcedureService;
import com.castletroymedical.service.PatientService;
import com.castletroymedical.service.UserService;


@Controller
@RequestMapping(path = "/admin")
public class AdminController {

    PatientService patientService;
    HospitalProcedureService hospitalProcedureService;
    UserService userService;

    public AdminController(PatientService patientService, HospitalProcedureService hospitalProcedureService,
            UserService userService) {
        this.patientService = patientService;
        this.hospitalProcedureService = hospitalProcedureService;
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){ 
        PatientDto patientDto = new PatientDto();
        model.addAttribute("patient", patientDto);
        return "register"; 
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("patient") PatientDto patient,
                               BindingResult result,
                               Model model){
        UserEntity existing = userService.findByEmail(patient.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            model.addAttribute("patient", patient);
            return "register";
        }
        // <ISHA> Newly registered patients will have their password set as their ppsn
        UserDto user = new UserDto(patient.getEmail(), patient.getPpsn());
        userService.savePatientUser(user);
        patientService.savePatient(patient);
        return "successfulregister";
    }

    // <ISHA> List all patients in a table
    @GetMapping("/allPatients")
    public String listRegisteredUsers(Model model){
        List<PatientDto> patients = patientService.findAllPatients();
        model.addAttribute("patients", patients);
        return "allpatients";
    }

    @GetMapping("/allProcedures")
    public String listHospitalProcedures(Model model){
        List<HospitalProcedureDto> procedures = hospitalProcedureService.findAllProcedures();
        model.addAttribute("procedures", procedures);
        return "allprocedures";
    }

    @RequestMapping("/dashboard")
    public String dashbaord(){
        return "admin-dashboard";
    }
}