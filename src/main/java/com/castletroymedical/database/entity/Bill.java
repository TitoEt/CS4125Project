package com.castletroymedical.database.entity;

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
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bill_id;
    
    @ManyToOne
    @JoinColumn(name = "ppsn")
    private Patient patient;

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
            @JoinColumn(name = "bill_id", referencedColumnName = "bill_id")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "charge_id", referencedColumnName = "charge_id")
        }
    )
    private List<Charge> charges = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "bill_instalment_payments",
        joinColumns = {
            @JoinColumn(name = "bill_id", referencedColumnName = "bill_id")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "payment_id", referencedColumnName = "payment_id")
        }
    )
    private List<InstalmentPayment> instalmentPayments = new ArrayList<>();
}
