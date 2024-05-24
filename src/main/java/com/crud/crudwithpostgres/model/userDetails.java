package com.crud.crudwithpostgres.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity



public class userDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private int id;
    private String name;
    private String email;
    private String password;
    private String mobile;
    private String address;
    private String city;
    private String state;
    private String country;
    private String pincode;

    public userDetails() {
    }

}