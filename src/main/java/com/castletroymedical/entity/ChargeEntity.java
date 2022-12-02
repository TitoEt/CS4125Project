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
@Table(name = "charge")
public class ChargeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chargeId;

    @ManyToOne
    @JoinColumn(name = "billId")
    private BillEntity billId;

    @Column(nullable = false)
    private String chargeType;

    @Column(nullable = false)
    private double chargeAmount;

}
