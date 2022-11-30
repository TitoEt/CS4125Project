package com.castletroymedical.entity;

import java.sql.Date;

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
@Table(name = "instalment_payment")
public class InstalmentPaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @ManyToOne
    @JoinColumn(name = "billId")
    private BillEntity billId;

    @Column(nullable = false)
    private double instalmentAmount;

    @Column(nullable = false)
    private Date datePaid;
}
