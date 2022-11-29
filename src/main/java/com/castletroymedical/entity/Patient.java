package com.castletroymedical.entity; 

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

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
@Table(name="patient")
public class Patient {
    @Id 
    private String ppsn;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date dob; 

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private int phoneNumber;

    private String email;
 
    private boolean medicalCardHolder;
     
    private boolean insured; 
}
