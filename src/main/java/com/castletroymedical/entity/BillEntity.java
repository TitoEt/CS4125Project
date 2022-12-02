package com.castletroymedical.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bill")
public class BillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;
    
    @ManyToOne
    @JoinColumn(name = "ppsn")
    private PatientEntity patientPpsn;

    @Column(nullable = false)
    private Date dateIssued;
    
    @Column(nullable = false)
    private Date dueDate;

    private Date datePaid;

    private boolean instalmentPlan;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private double totalAmount;

    @Transient
    private List<ChargeEntity> charges;

}