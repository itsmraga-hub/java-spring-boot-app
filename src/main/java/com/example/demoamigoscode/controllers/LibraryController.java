package com.example.demoamigoscode.controllers;

import com.example.demoamigoscode.dto.requests.NewLibraryRequest;
import com.example.demoamigoscode.models.Book;
import com.example.demoamigoscode.repositories.BookRepository;
import com.example.demoamigoscode.repositories.LibraryRepository;
import com.example.demoamigoscode.models.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/libraries")
public class LibraryController {
    private final LibraryRepository libraryRepository;

    @Autowired
    private BookRepository bookRepository;

    public LibraryController(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }


    @GetMapping("{libraryId}")
    public Optional<Library> getLibrary(@PathVariable("libraryId") Integer id) {
        return libraryRepository.findById(id);
    }

    @GetMapping("{libraryId}/books")
    public List<Book> getLibraryBooks(@PathVariable("libraryId") Integer id) {
        System.out.println("Libra");
        return bookRepository.findBooksByLibrary_Id(id);
    }

    @GetMapping
    public List<Library> getLibraries() {
        return libraryRepository.findAll();
    }

    @PostMapping
    public void createLibrary(@RequestBody NewLibraryRequest request) {
        Library library = new Library();
        library.setAddress(request.address());
        library.setName(request.name());
        libraryRepository.save(library);
    }
}
