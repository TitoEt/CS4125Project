package hbillsystem.src.main.java.com.castletroymedical.database.data;
import java.sql.Date;

public class PatientDTO {
    private String name;
    private Date dob;
    private String ppsn; 
    private String address;
    private int phoneNumber;
    private String email;
    private boolean medicalCardHolder;
    private boolean insured;

    private PatientDTO(String name,Date dob,String ppsn, String address, int phoneNumber, String email, boolean medicalCardHolder, boolean insured){
        this.name = name;
        this.dob = dob;
        this.ppsn = ppsn;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.medicalCardHolder = medicalCardHolder;
        this.insured = insured;
    }  

    public static PatientDTO createPrivatePatient(String name,Date dob,String ppsn, String address, int phoneNumber, String email) {
        return new PatientDTO(name, dob, ppsn, address, phoneNumber, email, false, false);
    }

    public static PatientDTO createMedicalCardPatient(String name,Date dob,String ppsn, String address, int phoneNumber, String email) {
        return new PatientDTO(name, dob, ppsn, address, phoneNumber, email, true, false);
    }

    public static PatientDTO createInsuredPatient(String name,Date dob,String ppsn, String address, int phoneNumber, String email) {
        return new PatientDTO(name, dob, ppsn, address, phoneNumber, email, false, true);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    } 

    public String getPpsn() {
        return ppsn;
    } 

    public String getAddress() {
        return address;
    } 

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isMedicalCardHolder() {
        return medicalCardHolder;
    }

    public void setMedicalCardHolder(boolean medicalCardHolder) {
        this.medicalCardHolder = medicalCardHolder;
    }

    public boolean isInsured() {
        return insured;
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }
}
