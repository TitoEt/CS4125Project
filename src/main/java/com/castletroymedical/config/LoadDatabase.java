package com.castletroymedical.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration; 

import com.castletroymedical.entity.HospitalProcedure;
import com.castletroymedical.repository.HospitalProcedureRepository;

@Configuration
public class LoadDatabase { 

    @Bean
    CommandLineRunner initDatabase(HospitalProcedureRepository procedureRepository){
        return args -> {
            procedureRepository.save(new HospitalProcedure(1L, "Brain Stem Augmentation",8000.0));
            procedureRepository.save(new HospitalProcedure(2L,"Spinal Realignment",2300.0));
            procedureRepository.save(new HospitalProcedure(3L,"Blood Test",45.0));
            procedureRepository.save(new HospitalProcedure(4L,"MRI",125.0));
            procedureRepository.save(new HospitalProcedure(5L,"Cornea Replacement",786.0));
            procedureRepository.save(new HospitalProcedure(6L,"CAT Scan",75.0));
            procedureRepository.save(new HospitalProcedure(7L,"Joint Injection",65.0));
            procedureRepository.save(new HospitalProcedure(8L,"Cryotherapy",60.0));
            procedureRepository.save(new HospitalProcedure(8L,"Cervical Smear",90.0));
            procedureRepository.save(new HospitalProcedure(10L,"Chemotherapy",557.0));
            procedureRepository.save(new HospitalProcedure(11L,"Kidney Function Assessment",811.0));
            procedureRepository.save(new HospitalProcedure(12L,"Vaccinations",40.0));
            procedureRepository.save(new HospitalProcedure(13L,"Thyroid procedure",650.0));
        };
    }
}
