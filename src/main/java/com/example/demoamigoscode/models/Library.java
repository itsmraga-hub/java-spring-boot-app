package com.example.demoamigoscode;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Library {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @OneToOne
    @JoinColumn(name = "address_id")
//    @RestResource(pa)
    private Address address;

    @OneToMany(mappedBy = "library")
    private List<Book> books;

    public Library(String name) {
        this.name = name;
    }

    public Library() {

    }
}
