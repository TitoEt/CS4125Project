package com.castletroymedical.entity;

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
@Table(name = "hospital_procedure")
public class HospitalProcedureEntity { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long procedureId;

    @Column(nullable = false)
    private String procedureName;

    @Column(nullable = false)
    private double baseCharge;
} 