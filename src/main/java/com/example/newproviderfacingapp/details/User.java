package com.example.newproviderfacingapp.details;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class User {

    @Id
    private int userId;

    @Column(name = "full_name")
    public String username;
    @Column(name = "email")
    public String email;

    @Column(name = "password")
    public String password;

}

//patient portal app
//login api

//create the page
