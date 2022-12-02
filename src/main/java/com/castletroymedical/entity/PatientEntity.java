package com.castletroymedical.entity; 

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

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
@Table(name="patient")
public class PatientEntity {
    @Id 
    private String ppsn;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dob; 

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phoneNumber;

    //<ISHA> Email links patient to user
    @OneToOne
    @JoinColumn(name = "email")
    private UserEntity userEmail;
 
    private boolean medicalCardHolder;
     
    private boolean insured; 

}
