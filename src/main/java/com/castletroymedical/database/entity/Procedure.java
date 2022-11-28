package com.castletroymedical.database.entity;

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
public class Procedure {
    @Id 
    private String procedureName;

    @Column(nullable = false)
    private double baseCharge;
}
