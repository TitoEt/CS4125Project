package com.castletroymedical.config;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.castletroymedical.dto.PatientDto;
import com.castletroymedical.dto.UserDto;
import com.castletroymedical.entity.HospitalProcedureEntity;
import com.castletroymedical.repository.HospitalProcedureRepository;
import com.castletroymedical.service.PatientService;
import com.castletroymedical.service.UserService;

@Configuration
public class LoadDatabase { 
    private final String DEFAULTPASSWORD = "asd123qwe";

    @Bean
    CommandLineRunner initDatabase(HospitalProcedureRepository procedureRepository, UserService userService, PatientService patientService){
        return args -> {
            procedureRepository.save(new HospitalProcedureEntity(1L, "Brain Stem Augmentation",8000.0));
            procedureRepository.save(new HospitalProcedureEntity(2L,"Spinal Realignment",2300.0));
            procedureRepository.save(new HospitalProcedureEntity(3L,"Blood Test",45.0));
            procedureRepository.save(new HospitalProcedureEntity(4L,"MRI",125.0));
            procedureRepository.save(new HospitalProcedureEntity(5L,"Cornea Replacement",786.0));
            procedureRepository.save(new HospitalProcedureEntity(6L,"CAT Scan",75.0));
            procedureRepository.save(new HospitalProcedureEntity(7L,"Joint Injection",65.0));
            procedureRepository.save(new HospitalProcedureEntity(8L,"Cryotherapy",60.0));
            procedureRepository.save(new HospitalProcedureEntity(9L,"Cervical Smear",90.0));
            procedureRepository.save(new HospitalProcedureEntity(10L,"Chemotherapy",557.0));
            procedureRepository.save(new HospitalProcedureEntity(11L,"Kidney Function Assessment",811.0));
            procedureRepository.save(new HospitalProcedureEntity(12L,"Vaccinations",40.0));
            procedureRepository.save(new HospitalProcedureEntity(13L,"Thyroid procedure",650.0));
            
            userService.saveAdminUser(new UserDto("admin@castletroymedical.ie", DEFAULTPASSWORD));
            
            UserDto user1 = new UserDto("example@user.com", DEFAULTPASSWORD);
            userService.savePatientUser(user1);
            UserDto user2 = new UserDto("second.example@user.com", DEFAULTPASSWORD);
            userService.savePatientUser(user2);

            PatientDto patient1 = new PatientDto("4256153U", "Example", "Patient", new Date(System.currentTimeMillis()), "First Line, SecondLine, Third", "0854126978", "example@user.com", false, false); 
            patientService.savePatient(patient1);

            PatientDto patient2 = new PatientDto("5426138U", "Second", "Example", new Date(System.currentTimeMillis()), "First Line, SecondLine, Third", "0858452165", "second.example@user.com", false, true);
            patientService.savePatient(patient2);

        };
    }
}
 









