package com.example.demoamigoscode;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;

    public Book(long id, String title, Library library) {
        this.id = id;
        this.title = title;
        this.library = library;
    }

    public Book() {
    }
}
