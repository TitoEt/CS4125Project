package com.castletroymedical.dto; 

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
 
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
    
    @NotEmpty
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
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
