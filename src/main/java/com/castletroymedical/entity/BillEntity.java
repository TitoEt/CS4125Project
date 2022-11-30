package com.castletroymedical.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
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
    Date dateIssued;
    
    @Column(nullable = false)
    Date duedate;

    Date datePaid;

    boolean instalmentPlan;

    @Column(nullable = false)
    String status;

    @Column(nullable = false)
    double totalCharge;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "bill_charges",
        joinColumns = {
            @JoinColumn(name = "billId", referencedColumnName = "billId")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "chargeId", referencedColumnName = "chargeId")
        }
    )
    private List<ChargeEntity> charges = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "bill_instalment_payments",
        joinColumns = {
            @JoinColumn(name = "billId", referencedColumnName = "billId")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "paymentId", referencedColumnName = "paymentId")
        }
    )
    private List<InstalmentPaymentEntity> instalmentPayments = new ArrayList<>();
}
