package com.example.demoamigoscode.controllers;

import com.example.demoamigoscode.BookRepository;
import com.example.demoamigoscode.LibraryRepository;
import com.example.demoamigoscode.models.Book;
import com.example.demoamigoscode.models.Library;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class BookController {

    private final BookRepository bookRepository;
    private final LibraryRepository libraryRepository;

    public BookController(BookRepository bookRepository, LibraryRepository libraryRepository) {
        this.bookRepository = bookRepository;
        this.libraryRepository = libraryRepository;
    }

    @GetMapping("library/{libraryId}")
    public List<Book> getBooksByLibrary(@PathVariable("libraryId") long id) {
//        libraryRepository.findById(id);
        return bookRepository.findByLibraryId(id);
    }

    public record NewBookRequest(String title, Library library) {

    }

    @PostMapping("library/{libraryId}")
    public void addBook(@PathVariable("libraryId") long id, @RequestBody NewBookRequest request) {
        Optional<Library> OptionalLibrary = libraryRepository.findById(id);
        Library library = OptionalLibrary.get();
        Book book = new Book();
        System.out.println("New book");
        book.setTitle(request.title());
        book.setLibrary(library);
        bookRepository.save(book);
    }


}
