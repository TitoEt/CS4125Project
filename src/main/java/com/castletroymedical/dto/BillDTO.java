package com.castletroymedical.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillDto {
    private Long billId;
    
    private String patientPpsn;

    Date dateIssued;
    
    Date dueDate;

    Date datePaid;

    boolean instalmentPlan;

    String status;

    double totalCharge;
}