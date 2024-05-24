package com.crud.crudwithpostgres.model;


import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
//import lombok.NonNull;
import lombok.Setter;



@Setter
@Getter
@Entity
public class StoreName {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO )
    private int id;
    @Column(nullable = false)
    private String storeName;
    private String storeAddress;
    private String storeCity;
    private String storeState;
    private String storeCountry;
    private String storePincode;


    public StoreName() {
    }




}
