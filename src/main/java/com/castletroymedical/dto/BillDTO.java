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
public class BillDTO {
    private Long billId;
    
    private String patientPpsn;

    private Date dateIssued;
    
    private Date dueDate;

    private Date datePaid;

    private boolean instalmentPlan;

    private String status;

    double totalCharge;
}