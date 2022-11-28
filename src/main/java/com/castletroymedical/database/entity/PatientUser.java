package com.castletroymedical.database.entity;


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
public class PatientUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patient_id;

    @Column(nullable = false)
    private String password;

    //<ISHA> FK = ppsn
    @OneToOne
    @JoinColumn(name = "ppsn")
    private Patient patient;

    //<ISHA> Table for all bills for all patients
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "patient_bill",
        joinColumns = {
            @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "bill_id", referencedColumnName = "bill_id")
        }
    )
    private List<Bill> bills = new ArrayList<>();
}
