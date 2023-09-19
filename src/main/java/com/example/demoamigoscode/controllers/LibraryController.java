package com.example.demoamigoscode.controllers;

import com.example.demoamigoscode.LibraryRepository;
import com.example.demoamigoscode.models.Library;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/libraries")
public class LibraryController {
    private final LibraryRepository libraryRepository;

    public LibraryController(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public record NewLibraryRequest(String name, String address) {

    }
    @GetMapping
    public List<Library> getLibraries() {
        return libraryRepository.findAll();
    }

    @PostMapping
    public void addLibrary(@RequestBody NewLibraryRequest request) {
        Library library = new Library();
        library.setAddress(request.address());
        library.setName(request.name());
        libraryRepository.save(library);
    }
}
