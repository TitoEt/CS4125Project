package com.castletroymedical.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientUserDto {
    private Long patientId;

    @NotEmpty(message = "Password may not be empty")
    private String password;

    @NotEmpty(message = "PPSN may not be empty")
    @Size(min = 8, max = 9, message = "PPSN should have 7 numbers followed by 1-2 letters") 
    private String ppsn; 
}
