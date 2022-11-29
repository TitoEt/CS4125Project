package com.castletroymedical.entity;

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
@Table(name = "charge")
public class Charge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chargeId;

    @ManyToOne
    @JoinColumn(name = "billId")
    private Bill billId;

    @Column(nullable = false)
    private String chargeType;

    @Column(nullable = false)
    private double chargeAmount;

}
