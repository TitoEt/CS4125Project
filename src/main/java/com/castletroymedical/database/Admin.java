package com.castletroymedical.database;

import java.sql.Date;

import com.castletroymedical.database.entity.AdminEntity;
import com.castletroymedical.database.entity.PatientEntity;


public class Admin extends User {
    AdminEntity a;

    public boolean login(String email, String password) {
        // account verification, exception handling
        // SQL query call, find patient then attach patientDTO to this P
        return true;
    }

    //registration patient factory 
    public void registerNewPatient(String patientType, String name, Date dob,String ppsn, String address, int phoneNumber, String email){
        patientType.toLowerCase();
        switch (patientType) {
            case "private": PatientEntity.createPrivatePatient(name, dob, ppsn, address, phoneNumber, email); break;
            case "medical card": PatientEntity.createMedicalCardPatient(name, dob, ppsn, address, phoneNumber, email); break;
            case "insured": PatientEntity.createInsuredPatient(name, dob, ppsn, address, phoneNumber, email); break;
            // default: throws an exception;
        }
    }

}
