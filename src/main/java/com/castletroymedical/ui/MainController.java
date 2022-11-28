package com.castletroymedical.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

import com.castletroymedical.database.entity.Patient;
import com.castletroymedical.dto.PatientDto;
import com.castletroymedical.service.PatientService;

@Controller
public class MainController {

    private PatientService patientService;

    public MainController(PatientService  patientService) {
        this.patientService =  patientService;
    }
    
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        PatientDto patientDto = new PatientDto();
        model.addAttribute("patient", patientDto);
        return "register";
    }

    @PostMapping("/reg")
    public void addPatient(@RequestBody Patient patient){
        patientService.savePatientBody(patient);
    }
}