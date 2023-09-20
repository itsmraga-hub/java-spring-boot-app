package com.example.demoamigoscode.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Library {
    @Id
    @SequenceGenerator(
            name = "library_id_sequence",
            sequenceName = "library_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "library_id_sequence"
    )
    private Integer id;

    @Column
    private String name;

//    @OneToOne
//    @JoinColumn(name = "address_id")
//    private Address address;

    private String address;

    @OneToMany(mappedBy = "library")
    @JsonManagedReference
    private List<Book> books;

    public Library(String name) {
        this.name = name;
    }

    public Library() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getBooks() {
        return books;
    }

//    public List<Book> findLibraryBooks() {
//        return
//    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
