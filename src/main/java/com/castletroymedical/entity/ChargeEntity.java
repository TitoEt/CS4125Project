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
    private BillEntity billID;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private double amount;

}
