package com.example.demoamigoscode.models;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.RestController;

@Entity
public class Address {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )

    private Integer id;

    @Column(nullable = false)
    private String location;

    private String street;
    private String city;

//    @OneToOne(mappedBy = "address")
//    private Library library;

    public Address () {

    }

    public Address (String location) {
        this.location = location;
    }
}
