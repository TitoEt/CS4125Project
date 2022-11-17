package com.castletroymedical.database;
import com.castletroymedical.database.data.PatientDTO;

public abstract class User {


    public boolean login(String email, String password){
        // account verification, exception handling
        return true;
    }

    //view details

    public void updatePatientAddress(PatientDTO p, String address){
        p.setAddress(address);

    }

    public void updatePatientName(PatientDTO p, String name){
        p.setName(name);
    }

    public void updatePatientEmail(PatientDTO p, String email){
        p.setEmail(email);
    }

    public void updatePatientNumber(PatientDTO p, int number){
        p.setPhoneNumber(number);
    }
    
    public void updatePatientMedicalCardStatus(PatientDTO p, boolean status){
        p.setMedicalCardHolder(status);
    }

    public void updatePatientInsuranceStatus(PatientDTO p, boolean insurance){
        p.setMedicalCardHolder(insurance);
    } 

}
