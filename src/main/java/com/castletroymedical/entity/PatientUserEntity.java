package com.castletroymedical.entity;


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
@Table(name = "patient_user")
public class PatientUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    @Column(nullable = false)
    private String password;

    //<ISHA> FK = ppsn
    @OneToOne
    @JoinColumn(name = "ppsn")
    private PatientEntity patientPpsn;

    //<ISHA> Table for all bills for all patients
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "patient_bill",
        joinColumns = {
            @JoinColumn(name = "patientId", referencedColumnName = "patientId")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "billId", referencedColumnName = "billId")
        }
    )
    private List<BillEntity> bills = new ArrayList<>();
}
