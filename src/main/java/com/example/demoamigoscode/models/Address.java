package com.example.demoamigoscode.models;

import jakarta.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue

    @Column(nullable = false)
    private String location;

//    @OneToOne(mappedBy = "address")
//    private Library library;

    public Address () {

    }

    public Address (String location) {
        this.location = location;
    }
}
