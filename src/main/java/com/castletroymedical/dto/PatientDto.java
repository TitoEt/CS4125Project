package com.castletroymedical.dto; 

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat; 

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {
    private String ppsn;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob; 
 
    @NotEmpty
    private String address;
 
    @NotEmpty
    private String phoneNumber;

    @Email
    private String email;
 
    private boolean medicalCardHolder;
    
    private boolean insured; 
}
