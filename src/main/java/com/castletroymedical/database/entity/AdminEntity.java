package com.castletroymedical.database.entity;

import javax.persistence.Entity;  
import javax.persistence.Id;

@Entity 
public class AdminEntity {
    @Id
    private String email;
    private String password;

    protected AdminEntity(){}
    
    public AdminEntity(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
}