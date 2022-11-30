package com.castletroymedical.dto;

import jakarta.validation.constraints.NotEmpty;
 
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HospitalProcedureDto {
    private Long procedureId;
    @NotEmpty
    private String procedureName;
    @NotEmpty
    private double baseCharge;
}
