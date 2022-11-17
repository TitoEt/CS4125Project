package com.castletroymedical.database;
import com.castletroymedical.database.entity.PatientEntity;

public abstract class User {


    public boolean login(String email, String password){
        // account verification, exception handling
        return true;
    }

    //view details

    public void updatePatientAddress(PatientEntity p, String address){
        p.setAddress(address);

    }

    public void updatePatientName(PatientEntity p, String name){
        p.setName(name);
    }

    public void updatePatientEmail(PatientEntity p, String email){
        p.setEmail(email);
    }

    public void updatePatientNumber(PatientEntity p, int number){
        p.setPhoneNumber(number);
    }
    
    public void updatePatientMedicalCardStatus(PatientEntity p, boolean status){
        p.setMedicalCardHolder(status);
    }

    public void updatePatientInsuranceStatus(PatientEntity p, boolean insurance){
        p.setMedicalCardHolder(insurance);
    } 

}
